# Automation Project (Pro-Level)

Cucumber + TestNG + Selenium framework with config, Page Object Model, and stable waits.

---

## Stack

- **Java 17** · **Maven**
- **Cucumber 7** (BDD)
- **TestNG** (test runner)
- **Selenium 4** + **WebDriverManager**
- **Config** via `config.properties`
- **Page Object Model** (BasePage + page classes)
- **Explicit waits** (WaitUtils)
- **Screenshots** on failure + saved to `target/screenshots/`

---

## Project structure

```
src/test/
├── java/.../shiva/automation_project_v2/
│   ├── base/          TestBase.java          # Driver init, config-based
│   ├── config/        TestConfig.java       # config.properties loader
│   ├── hooks/         Hooks.java            # @Before / @After, screenshots
│   ├── pages/         BasePage, GooglePage  # Page Object Model
│   ├── runner/        TestRunner.java       # Cucumber + TestNG entry
│   ├── stepdefinitions/  StepDefinitions.java
│   └── utils/         WaitUtils, DriverUtils
└── resources/
    ├── config.properties   # browser, timeouts, baseUrl, headless
    ├── features/           # *.feature files
    ├── testng.xml          # TestNG suite
    └── cucumber.properties
```

---

## Run tests

**From project folder:**

```powershell
.\run-tests.ps1
```

or, if `mvn` is in PATH:

```powershell
mvn clean test
```

Chrome (or browser set in config) will open and scenarios will run.

**Food order flow:** By default the suite runs **food order** scenarios for **foodorder.info uk** (open site, search, add to cart). To run all features (including sample Google/Bing), remove the `tags = "@foodorder"` line from `TestRunner.java`.

---

## Reports (TestNG + Cucumber)

After `mvn test` or `.\run-tests.ps1`:

| Report | Location |
|--------|----------|
| **Cucumber HTML (main)** | `target/cucumber-reports.html` — food order scenarios (foodorder.info uk) |
| **Cucumber HTML (folder)** | `target/cucumber-reports/cucumber.html` |
| **Cucumber (login flow)** | `target/cucumber-reports-login.html` — when using `-Ppro-food-order` |
| **Cucumber JSON** | `target/cucumber-reports/cucumber.json` |
| **TestNG / Surefire** | `target/surefire-reports/` (index.html, emailable-report.html) |
| **Screenshots (on failure)** | `target/screenshots/` — see **BUG_REPORT_TEMPLATE.md** for how to report bugs with screenshots |

Open `target/cucumber-reports.html` in a browser to see food order scenario results.

---

## Configuration

Edit **`src/test/resources/config.properties`**:

| Property | Description | Example |
|----------|-------------|---------|
| `browser` | chrome, firefox, edge | `chrome` |
| `implicit.wait` | Implicit wait (seconds) | `10` |
| `page.load.timeout` | Page load timeout (seconds) | `30` |
| `explicit.wait` | Explicit wait for WaitUtils (seconds) | `15` |
| `base.url` | Food order site URL (foodorder.info uk) | `https://www.foodorder.info` |
| `screenshot.on.failure` | Attach screenshot on failure | `true` |
| `headless` | Run browser headless | `false` |

Override from command line:  
`mvn test -Dbrowser=firefox -Dheadless=true`

---

## Reports

- **Cucumber HTML (main):** `target/cucumber-reports.html` (food order scenarios – foodorder.info uk)
- **Cucumber HTML (login):** `target/cucumber-reports-login.html` (when using `-Ppro-food-order`)
- **Cucumber JSON:** `target/cucumber-reports/cucumber.json`
- **Cucumber JUnit XML:** `target/cucumber-reports/cucumber.xml`
- **Screenshots (failures):** `target/screenshots/` — use **BUG_REPORT_TEMPLATE.md** for bug reports with screenshots
- **Surefire:** `target/surefire-reports/`

---

## Adding new tests

1. **New scenario:** Add or edit `.feature` in `src/test/resources/features/`.
2. **New steps:** Add methods in `StepDefinitions.java` or new step definition class in `stepdefinitions` package.
3. **New page:** Create a class in `pages/` extending `BasePage`, add locators and actions; use in step definitions.
4. **Tags:** Use `@smoke`, `@regression` in features and in `TestRunner`: `tags = "@smoke"` to run only tagged scenarios.

---

## Requirements

- **JDK 17**
- **Maven** (or use `run-tests.ps1` which uses a local Maven path)
- **Chrome** (or Firefox/Edge per config)
