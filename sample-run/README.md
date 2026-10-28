# Recorded run

`manifest.txt` records the commits, versions, system and file hashes of the run.
`results.jsonl` contains one result per document, `access.log` the HTTP requests, and
`verify.txt` the checker output, and `index.log` the indexer lines the checker reads.

The run was recorded with `ARCHIVE=1 ./run.sh`, which refuses to start when the demo
checkout or the Tika checkout has uncommitted changes or untracked files. The five files
were then copied from `out/`.
