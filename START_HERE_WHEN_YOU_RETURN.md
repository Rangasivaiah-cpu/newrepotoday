# Start here when you return – everything is in this project

**Project folder:** `c:\My Copy\automation-project-v2`  
**Nothing is lost when you close Cursor.** All code, scenarios, and scripts are saved here.

---

## Run tests (one command)

From this folder in **PowerShell**:

```powershell
.\run-daily.ps1
```

Or double-click **run-daily.cmd**.

This runs: TestNG tests + Cucumber scenarios → generates Allure & Cucumber reports → opens them in the browser.

---

## What’s in this project

### Pro Food Order automation (your main tests)

| What | Path |
|------|------|
| Base (launch browser) | `src/test/java/profoodorderbasepackage/profoodorderbaseclass.java` |
| Config (URL, credentials) | `src/test/java/profoodorderbasepackage/ProFoodOrderConfig.java` |
| POM (pages/locators) | `src/test/java/profoodorderpompagepackage/profoodorderpompageclass.java` |
| TestNG tests | `src/test/java/testngpackage/testngclass.java` |
| Cucumber runner | `src/test/java/profoodorderrunnerpackage/profoodorderrunnerclass.java` |
| Cucumber step definitions | `src/test/java/profoodorderstepdefinationspackage/profoodorderstepdefinationclass.java` |
| Cucumber hooks (close browser) | `src/test/java/profoodorderstepdefinationspackage/ProFoodOrderHooks.java` |
| Cucumber feature (scenarios) | `src/test/resources/features/food_order_login.feature` |
| TestNG suite (Pro Food Order) | `src/test/resources/testng-profoodorder.xml` |

### Scripts (project root)

| Script | Use |
|--------|-----|
| **run-daily.ps1** / **run-daily.cmd** | Run tests + open Allure & Cucumber reports |
| **run-tests.ps1** | Run tests only (use `-ProFoodOnly` for Pro Food Order only) |
| **open-cucumber-report.cmd** | Open Cucumber report in browser |
| **open-3-classes.cmd** | Open the 3 main Java files in the editor |

### Config (optional, for credentials)

- **profoodorder.properties.example** → copy to **profoodorder.properties** and set email/password/URL (see SAFE_USAGE.md).
- Without it, defaults in code are used; scenarios run the same.

### Reports after run

- **Cucumber:** `target/cucumber-reports.html` (or run **open-cucumber-report.cmd**)
- **Allure:** `target/site/allure-maven-plugin/index.html` or http://localhost:8080 when run-daily serves it
- **TestNG:** `target/surefire-reports/index.html`

---

## Scenarios that run

1. **TestNG:** `testBrowseMenuAndLogin` (pass), `testlogin` (full flow, may fail on invalid-address step).
2. **Cucumber:**  
   - “Successful food order category clicking” (full flow).  
   - “Login with invalid credentials” (Scenario Outline with 4 examples).

All of the above run when you execute **run-daily.ps1** or **run-tests.ps1 -ProFoodOnly**.

---

## Other useful files

- **OPEN_ME_FOR_CHANGES.md** – Quick links to edit base, POM, tests, feature, step defs.
- **RUN_DAILY.md** – How to run every day and schedule.
- **SAFE_USAGE.md** – Credentials, config, safe usage.
- **RUN_IN_ECLIPSE.md** – Open and run in Eclipse.

---

## If something doesn’t run

1. Open project in Cursor: **File → Open Folder** → `c:\My Copy\automation-project-v2`.
2. In terminal: `mvn test-compile` (checks compilation).
3. Run: `.\run-daily.ps1`.

Everything is in this folder; closing Cursor does not remove any of it.
