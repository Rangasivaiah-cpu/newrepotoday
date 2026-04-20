# Project structure – packages and files

All packages and classes you need to run and modify tests from here.

---

## Packages and classes

| Package | Class / file | Purpose |
|--------|---------------|---------|
| **base** | `TestBase.java` | Shared WebDriver: `initDriver()`, `getDriver()`, `quitDriver()`. Switch browser (chrome/firefox/edge) here. |
| **hooks** | `Hooks.java` | `@Before` / `@After` scenario: start driver, take screenshot on failure, quit driver. |
| **runner** | `TestRunner.java` | Cucumber + TestNG entry. Defines `features`, `glue` (stepdefs + hooks), report output. |
| **stepdefinitions** | `StepDefinitions.java` | Step defs for feature files. Add new steps here or new classes in this package. |

---

## Resources

| Path | Purpose |
|------|---------|
| **src/test/resources/features/** | `.feature` files. Add or edit scenarios here. |
| **src/test/resources/testng.xml** | TestNG suite – runs `TestRunner`. Add more test classes here if needed. |
| **src/test/resources/cucumber.properties** | Cucumber options (e.g. `cucumber.publish.quiet=true`). |

---

## Config

| File | Purpose |
|------|---------|
| **pom.xml** | Dependencies (Selenium, TestNG, Cucumber), Java 21, Surefire runs `testng.xml`. |

---

## How to run

- **From Cursor terminal:**  
  `mvn clean test`  
  (runs TestNG suite → TestRunner → all features)

- **Run Task:**  
  **Terminal → Run Task → Maven: clean test**

- **Only TestRunner (no suite):**  
  `mvn test -Dtest=TestRunner`

---

## Where to change what

- **Browser / driver:** `TestBase.java` → `initDriver()` (default chrome; change to firefox/edge or add options).
- **Before/after each scenario:** `Hooks.java` (e.g. login, screenshots).
- **Which features/tags run:** `TestRunner.java` → `@CucumberOptions` (e.g. `tags = "@smoke"`).
- **New steps:** Add methods in `StepDefinitions.java` or new classes in `stepdefinitions` package.
- **New scenarios:** Add or edit `.feature` files in `src/test/resources/features/`.
- **TestNG suite:** Edit `testng.xml` to add more runners or parallel tests.

Reports: `target/cucumber-reports/` (HTML/JSON) and `target/surefire-reports/`.
