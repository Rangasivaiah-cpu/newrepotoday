# Running Pro Food Order Automation (Eclipse-style from Cursor)

**To run every day from this folder (no agent):** see **[RUN_DAILY.md](RUN_DAILY.md)**. Use `.\run-daily.ps1` or double-click `run-daily.cmd`.

## Allure Report

Allure is integrated for rich test reports.

1. **Run tests** (as below).
2. **Generate and open Allure report:**
   ```powershell
   .\allure-report.ps1
   ```
   This runs `mvn allure:serve`: it generates the report from `target/allure-results` and opens it in your browser. Press Ctrl+C to stop the server.

To only generate the report (no browser): `mvn allure:report`. The report is in `target/site/allure-maven-plugin/` (open `index.html`).

This project runs your Selenium + TestNG automation from the workspace (no Eclipse needed).

## Quick run

**All tests (Cucumber + Pro Food Order):**
```powershell
.\run-tests.ps1
```

**Only Pro Food Order scenario (faster):**
```powershell
.\run-tests.ps1 -ProFoodOnly
```

Or with Maven directly:
```powershell
mvn clean test                    # full suite
mvn clean test -Ppro-food-order   # only Pro Food Order tests
```

## What was set up

| Item | Location |
|------|----------|
| Base class | `src/test/java/profoodorderbasepackage/profoodorderbaseclass.java` |
| POM page class | `src/test/java/profoodorderpompagepackage/profoodorderpompageclass.java` |
| TestNG test | `src/test/java/testngpackage/testngclass.java` |
| Full suite | `src/test/resources/testng.xml` |
| Pro Food Order only | `src/test/resources/testng-profoodorder.xml` |

## Changes from your original code

1. **Base class** – Uses WebDriverManager for Chrome (no manual chromedriver path). Added `quitBrowser()` for cleanup.
2. **POM** – Fixed `clickcategoryBtn` XPath (removed stray `"\r\n" + ""`).
3. **Test** – `@AfterMethod tearDown()` now calls `profoodorderbaseclass.quitBrowser()` so the driver is closed after each test.
4. **testng.xml** – Pro Food Order test class is included in the main suite.

## Test reports

**Allure Report (recommended)**  
After running tests, generate and open the Allure report in your browser:
```powershell
.\allure-report.ps1
```
This runs `mvn allure:serve` (generates from `target/allure-results` and opens the report). A small server runs until you press Ctrl+C.

**Surefire (TestNG)**  
- `target\surefire-reports\index.html` (TestNG report)
- `target\surefire-reports\emailable-report.html` (summary)

## Note on the last step (invalid address)

The step `invalidadressorpostcodeshouldnotaccept()` asserts that an invalid address is **not** accepted (address input stays visible). If the application now accepts the address "Uppal, Hyderabad, Telangana, India" and closes the popup, this assertion will fail. Adjust the test data or the assertion if the app behavior has changed.
