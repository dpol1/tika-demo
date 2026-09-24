# Archived run

`manifest.txt` records commits, versions and file hashes. `results.jsonl` contains one result
per document, `access.log` the HTTP requests, and `verify.txt` the checker output.

Observations:

- ASCII HTML without a declared charset returns as `text/html; charset=windows-1252`.
  `ParseBytesRequest` has no field for a declared charset.
- For `testPDF_childAttachments.pdf`, `parsers_used` includes `OfficeParser` for the embedded
  Office documents. `Document` has no field for embedded documents.
