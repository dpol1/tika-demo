#!/usr/bin/env python3
"""Breaks the sample run one field at a time; the named check has to fail and name the document.

    python3 test_verify.py
"""

import json
import subprocess
import sys
import tempfile
from pathlib import Path
from urllib.parse import urlparse

ROWS = [json.loads(line) for line in Path("sample-run/results.jsonl").read_text().splitlines()]
LOG = Path("sample-run/access.log").read_text().splitlines(keepends=True)
P5 = "http://parsebytes.127.0.0.1.nip.io:8099/p5"


def run(rows, log=LOG):
    with tempfile.TemporaryDirectory() as tmp:
        results, access = Path(tmp, "results.jsonl"), Path(tmp, "access.log")
        results.write_text("".join(json.dumps(r) + "\n" for r in rows))
        access.write_text("".join(log))
        return subprocess.run([sys.executable, "verify.py", results, access, "testserver/seeds.txt"],
                              capture_output=True, text=True).stdout


def broken(path, **fields):
    return [dict(r, **fields) if urlparse(r["url"]).path == path else r for r in ROWS]


def failed(out, name, path=""):
    return any(line.startswith(f"FAIL  {name}: ") and path in line for line in out.splitlines())


REFACTORED = ["correlation id echoed", "source url echoed", "byte size echoed", "same sha256",
              "one GET per URL"]
CASES = [
    ("correlation id echoed", "/p5", run(broken("/p5", doc_id="crawl:other"))),
    ("correlation id echoed", "/p5", run(broken("/p5", correlation_id=P5, doc_id=P5, reply_correlation_id=P5))),
    ("source url echoed", "/p6", run(broken("/p6", origin_source_uri="http://elsewhere/p6"))),
    ("byte size echoed", "/p7", run(broken("/p7", origin_byte_size=1))),
    ("same sha256", "/p8", run(broken("/p8", origin_sha256="0" * 64))),
    ("same sha256", "/p1", run(broken("/p1", origin_sha256="", client_sha256=""))),
    ("one GET per URL", "/p2", run(ROWS, LOG + [line for line in LOG if line.split()[2] == "/p2"])),
]

assert run(ROWS) == Path("sample-run/verify.txt").read_text(), "sample run output changed"
empty = run([])
assert all(failed(empty, name) for name in REFACTORED), "a check passed with no results"
for name, path, out in CASES:
    assert failed(out, name, path), f"{name} did not fail naming {path}"
print(f"ok: sample run unchanged, empty run fails, {len(CASES)} broken runs fail")
