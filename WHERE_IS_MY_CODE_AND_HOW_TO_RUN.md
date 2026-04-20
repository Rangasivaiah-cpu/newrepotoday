# Where Is My Code? How to Run with TestNG

---

## 1. Where is my code? (Exact paths)

Your project root is:

**`c:\My Copy\automation-project-v2`**

All code and config live under this folder.

---

## 2. Packages and classes (Java)

| Package | Class | Full path in your project |
|--------|--------|---------------------------|
| **base** | TestBase | `src\test\java\shiva\automation_project_v2\base\TestBase.java` |
| **hooks** | Hooks | `src\test\java\shiva\automation_project_v2\hooks\Hooks.java` |
| **runner** | TestRunner | `src\test\java\shiva\automation_project_v2\runner\TestRunner.java` |
| **stepdefinitions** | StepDefinitions | `src\test\java\shiva\automation_project_v2\stepdefinitions\StepDefinitions.java` |
| (root test) | AppTest | `src\test\java\shiva\automation_project_v2\AppTest.java` |
| (main) | App | `src\main\java\shiva\automation_project_v2\App.java` |

So:

- **Base class:** `src\test\java\shiva\automation_project_v2\base\TestBase.java`
- **Hooks:** `src\test\java\shiva\automation_project_v2\hooks\Hooks.java`
- **TestNG/Cucumber runner:** `src\test\java\shiva\automation_project_v2\runner\TestRunner.java`
- **Step definitions:** `src\test\java\shiva\automation_project_v2\stepdefinitions\StepDefinitions.java`

---

## 3. Feature files and TestNG config

| What | Path |
|------|------|
| Feature files | `src\test\resources\features\sample.feature` |
| TestNG suite (what runs) | `src\test\resources\testng.xml` |
| Cucumber config | `src\test\resources\cucumber.properties` |

---

## 4. How to run with TestNG

Your tests are run by **TestNG** using the suite defined in **testng.xml**.

**Step 1:** Open Cursor’s terminal (bottom panel).  
**Step 2:** Go to project folder and run Maven:

```powershell
cd "c:\My Copy\automation-project-v2"
mvn clean test
```

**What happens:**

- Maven uses **pom.xml** (dependencies, Surefire plugin).
- Surefire runs the TestNG suite from **testng.xml**.
- **testng.xml** runs the class: **TestRunner** (`shiva.automation_project_v2.runner.TestRunner`).
- **TestRunner** runs all Cucumber scenarios in **features** using **stepdefinitions** and **hooks**.

So: **Run TestNG** = run `mvn clean test` in the terminal. No need to run testng.xml by hand; Maven does it.

---

## 5. Quick summary

| Question | Answer |
|----------|--------|
| Where is my code? | Under `c:\My Copy\automation-project-v2\src`. Java in `src\test\java\shiva\automation_project_v2\` (packages: base, hooks, runner, stepdefinitions). |
| Where are packages/classes? | See the table in section 2 above (exact paths). |
| How do I run with TestNG? | In Cursor terminal: `cd "c:\My Copy\automation-project-v2"` then `mvn clean test`. |
| What does TestNG run? | The suite in **testng.xml**, which runs **TestRunner**, which runs your Cucumber features. |

You manage code by editing those Java files and feature files; you run everything via **TestNG** by running **`mvn clean test`** in the project folder.
