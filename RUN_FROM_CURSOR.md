# Run tests from Cursor (terminal)

Run these in the project root: `c:\My Copy\automation-project-v2`

---

## 1. Pro Food Order suite (Cucumber only, with Allure)

```bash
mvn clean test -Ppro-food-order
```

- Runs: Cucumber scenarios from `food_order_login.feature` only (no TestNG class; single run for manager duration).
- Failed scenarios are reported in Cucumber/Allure; execution continues with the next scenario.
- Cucumber HTML: `target\cucumber-reports.html`
- Allure results: `target\allure-results`
- Screenshots on failure: `target\screenshots\` and embedded in Cucumber + Allure.

---

## 2. Generate and open Allure report

After tests have run:

```bash
mvn allure:serve
```

Opens the Allure report in your default browser.

---

## 3. Optional: only Cucumber report (no Allure)

Same run as above; then open the Cucumber report in browser:

```bash
start target\cucumber-reports.html
```

---

## 4. Optional: default suite (includes other tests if present)

```bash
mvn clean test
```

Uses `testng.xml` (may include other runners).

---

## Config (optional)

- URL/credentials use defaults from code if `src/test/resources/profoodorder.properties` is missing.
- To override: copy `profoodorder.properties.example` to `profoodorder.properties` and set `app.url`, etc.
