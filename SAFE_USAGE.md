# Safe usage – keep everything safe

## 1. Credentials and URLs

- **Do not** put real passwords or production URLs in code you commit.
- **Use config:** Copy `src/test/resources/profoodorder.properties.example` to `src/test/resources/profoodorder.properties` and set:
  - `app.url` – food order app URL  
  - `test.login.email` / `test.login.password` – test account only  
- **profoodorder.properties** is in `.gitignore` and will not be committed.
- **Optional:** Set env vars instead: `PROFOODORDER_APP_URL`, `PROFOODORDER_TEST_EMAIL`, `PROFOODORDER_TEST_PASSWORD`.

If you don’t create `profoodorder.properties`, the project uses built-in defaults (same as before) so it still runs.

---

## 2. Running scripts safely

- **Always run from the project folder:** `c:\My Copy\automation-project-v2`
- **run-daily.ps1** – runs tests, then opens reports; safe to run multiple times.
- **open-cucumber-report.cmd** – only opens the report file in a browser; no tests run.
- Scripts use your project path; they don’t delete source code or format drives.

---

## 3. Driver and cleanup

- The base class closes the browser in `quitBrowser()` and in `@After` / `@AfterMethod`.
- If a test fails, the driver is still closed so you don’t leave browsers or processes hanging.

---

## 4. What is ignored by Git

- `target/` – build and reports  
- `src/test/resources/profoodorder.properties` – your local credentials  
- `*.local.properties`, `.env`, `.env.local` – local secrets  

---

## 5. Quick checklist

- [ ] Copy `profoodorder.properties.example` → `profoodorder.properties` and set test-only credentials.
- [ ] Don’t commit `profoodorder.properties` or any file with real passwords.
- [ ] Run scripts from the project folder only.
- [ ] Use a test account for automation, not a personal or production account.
