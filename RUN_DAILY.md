# Run automation every day from this folder (no agent needed)

Everything is saved in this project. You can run it anytime, change code, and re-run. Use this guide after the agent is gone.

---

## One-command run (recommended)

Open **PowerShell** in this project folder and run:

```powershell
.\run-daily.ps1
```

This will:

1. Run Pro Food Order tests (2 scenarios: 1 passed, 1 failed).
2. Generate the Allure report.
3. Start a small web server for the report.
4. Open the report in **Chrome** or **Edge** at http://localhost:8080.

You can run it **multiple times a day** after you change code. Each run overwrites the previous report.

---

## From Windows Explorer (double-click)

1. Double-click **run-daily.cmd** in this folder.  
2. A console window will open, run the tests, then open the report in your browser.

If you see “script execution disabled”, run this once in PowerShell **as Administrator**:

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

---

## Step-by-step (if you prefer)

| Step | Command | What it does |
|------|---------|----------------|
| 1 | `.\run-tests.ps1 -ProFoodOnly` | Run only Pro Food Order tests |
| 2 | `mvn allure:report -q` | Generate Allure report |
| 3 | Open **target\site\allure-maven-plugin\index.html** in Chrome/Edge | View report (or use `.\allure-report.ps1` to serve and open) |

---

## Run every day automatically (Task Scheduler)

1. Press **Win + R**, type `taskschd.msc`, press Enter.
2. **Create Basic Task** → Name: `Pro Food Order Automation` → Trigger: **Daily** (choose time) → Action: **Start a program**.
3. Program: `powershell.exe`  
   Arguments: `-NoProfile -ExecutionPolicy Bypass -File "C:\My Copy\automation-project-v2\run-daily.ps1"`  
   (Change the path if your project is elsewhere.)
4. Finish. The task will run tests daily and generate the report. To view the report, open **target\site\allure-maven-plugin\index.html** or run `.\run-daily.ps1` once to open it in the browser.

---

## Where everything is saved

| What | Where |
|------|--------|
| Base class | `src\test\java\profoodorderbasepackage\profoodorderbaseclass.java` |
| POM (pages) | `src\test\java\profoodorderpompagepackage\profoodorderpompageclass.java` |
| Tests | `src\test\java\testngpackage\testngclass.java` |
| Test suite (Pro Food Order only) | `src\test\resources\testng-profoodorder.xml` |
| Run scripts | `run-daily.ps1`, `run-tests.ps1`, `allure-report.ps1` |
| Reports after run | `target\site\allure-maven-plugin\` and `target\surefire-reports\` |

Edit the Java files in Cursor/VS Code, then run `.\run-daily.ps1` again to see results.

---

## Requirements (already in the project)

- **Java 17** (for Maven and tests)
- **Maven** – either on PATH or at:  
  `C:\Users\tvams\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd`  
  (Change `$mvnPath` in `run-daily.ps1` and `run-tests.ps1` if you use another path.)
- **Python 3** (for serving the Allure report in the browser)  
  If Python is missing, after tests run open **target\site\allure-maven-plugin\index.html** directly in Chrome/Edge.
- **Chrome** (for test execution; WebDriverManager downloads the driver)

---

## Stopping the report server

After `run-daily.ps1`, a Python process serves the report. To stop it:

- Open **Task Manager** → find **Python** → End task, or  
- Close the PowerShell window that ran the script (if it’s still open).

Then the next run can use port 8080 again.
