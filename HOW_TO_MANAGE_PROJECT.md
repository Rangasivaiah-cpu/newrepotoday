# How to Manage Your Project from Cursor

A simple guide: where everything is, how to edit, and how to run.

---

## 1. Open your project in Cursor

- **File → Open Folder** → choose: `c:\My Copy\automation-project-v2`
- Your project is now the “root” in Cursor. All your code is inside this folder.

---

## 2. Where is my code? (Explorer)

Use the **Explorer** on the left (folder icon or **Ctrl+Shift+E**). Your project looks like this:

```
automation-project-v2
├── pom.xml                    ← Maven: dependencies, Java version
├── src
│   ├── main
│   │   └── java/...           ← Main/helper code (if you add any)
│   └── test
│       ├── java
│       │   └── shiva/automation_project_v2/
│       │       ├── base/
│       │       │   └── TestBase.java       ← EDIT: browser, driver setup
│       │       ├── hooks/
│       │       │   └── Hooks.java          ← EDIT: before/after scenario
│       │       ├── runner/
│       │       │   └── TestRunner.java     ← EDIT: which features, tags
│       │       └── stepdefinitions/
│       │           └── StepDefinitions.java ← EDIT: step definitions
│       └── resources
│           ├── features/                  ← EDIT: .feature files
│           │   └── sample.feature
│           ├── testng.xml                 ← EDIT: TestNG suite
│           └── cucumber.properties        ← EDIT: Cucumber options
```

- **To change something:** click the file in Explorer → it opens in the editor → edit → **Ctrl+S** to save.

---

## 3. How do I modify code?

| What you want to change | Open this file |
|-------------------------|----------------|
| Browser (Chrome/Firefox/Edge), timeouts | `src/test/java/.../base/TestBase.java` |
| Before/after each scenario, screenshots | `src/test/java/.../hooks/Hooks.java` |
| Which features run, tags, reports | `src/test/java/.../runner/TestRunner.java` |
| Step definitions (Given/When/Then) | `src/test/java/.../stepdefinitions/StepDefinitions.java` |
| Scenarios (Gherkin) | `src/test/resources/features/*.feature` |
| TestNG suite (what runs when you run tests) | `src/test/resources/testng.xml` |
| Dependencies, Java version | `pom.xml` |

**Steps:**  
1. Click the file in the left Explorer.  
2. Edit in the center editor.  
3. Save (**Ctrl+S**).

---

## 4. How do I run the code?

**One place only: the Terminal in Cursor.**

1. Open the terminal: press **Ctrl+`** (backtick). A panel opens at the bottom.
2. In that terminal, type:

   ```powershell
   mvn clean test
   ```

3. Press **Enter**. Maven will compile and run your TestNG/Cucumber tests.
4. Results appear in the same terminal. If something fails, the error message is there.

**Optional (same result):**  
- **Ctrl+Shift+P** → type **Run Task** → choose **Maven: clean test**.  
- This also runs `mvn clean test` in the terminal for you.

---

## 5. Daily workflow in one place

| Step | What you do in Cursor |
|------|------------------------|
| 1. Open project | File → Open Folder → `c:\My Copy\automation-project-v2` |
| 2. Edit code | Explorer (left) → click file → edit in center → Ctrl+S |
| 3. Run tests | Terminal (bottom) → type `mvn clean test` → Enter |
| 4. See results | Same terminal: BUILD SUCCESS or error messages |
| 5. Fix errors | Read the error in terminal → open the file it mentions → fix → save → run again |

You **manage** the project by editing files in Cursor and **run** it from the terminal with `mvn clean test`. Everything stays in this one folder and one app (Cursor).

---

## 6. Quick reference

- **Open a file:** Click it in Explorer (left) or **Ctrl+P** and type the file name.
- **Save:** **Ctrl+S**
- **Open terminal:** **Ctrl+`**
- **Run tests:** In terminal: `mvn clean test`
- **Reports after run:** `target/cucumber-reports/` (HTML) and `target/surefire-reports/`

You don’t need to run code from outside Cursor. Open the project in Cursor, edit here, and run in Cursor’s terminal—that’s how you manage and run everything from here.
