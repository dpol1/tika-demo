# Recorded run

`manifest.txt` records the commits, versions, system and file hashes of the run.
`results.jsonl` contains one result per document, `access.log` the HTTP requests, and
`verify.txt` the checker output.

The run was recorded with `ARCHIVE=1 ./run.sh`, which refuses to start when the demo
checkout or the Tika checkout has uncommitted changes or untracked files. The four files
were then copied from `out/`.
