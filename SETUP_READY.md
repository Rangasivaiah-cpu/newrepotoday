# Setup ready – copy everything and run

Everything is prepared so you can copy your Eclipse code into Cursor and run here. **Your Eclipse project is never modified**—we only copy into this Cursor folder.

---

## What’s already done

| Item | Description |
|------|-------------|
| **Folders** | `src/main/resources`, `src/test/resources` created (with `.gitkeep`) so Maven won’t warn. |
| **pom.xml** | Cucumber 7.18, TestNG 7.10, Selenium 4.25, JUnit 4.13; Java 21; Surefire plugin ready. |
| **AppTest** | Updated to JUnit 4 so current `mvn test` passes. |
| **Copy script** | `scripts\Copy-FromEclipse.ps1` copies your Eclipse project into this one. |
| **TestNG example** | `src/test/resources/testng.xml.example` – rename to `testng.xml` and add your runner class when you use a suite. |

---

## Your steps (no Git)

### 1. Set your Eclipse project path

Open **`scripts\Copy-FromEclipse.ps1`** and change the default path on the line that says:

```powershell
[string]$EclipsePath = "C:\Users\tvams\eclipse-workspace\automation-project-v2"
```

Set it to your real Eclipse project folder (e.g. `C:\Users\tvams\eclipse-workspace\YourAutomationProject`).

### 2. Run the copy script

In **Cursor’s terminal** (where `mvn` works), run:

```powershell
cd "c:\My Copy\automation-project-v2"
.\scripts\Copy-FromEclipse.ps1
```

Or with path in one go:

```powershell
.\scripts\Copy-FromEclipse.ps1 -EclipsePath "C:\path\to\your\eclipse-project"
```

The script copies:

- All of **`src`** (main/java, test/java, main/resources, test/resources)
- **`pom.xml`** (your current Cursor `pom.xml` is backed up as `pom.xml.backup`)
- **`testng.xml`** from Eclipse root → `src/test/resources/testng.xml`
- Any **`*.feature`** files from Eclipse root → `src/test/resources/`

### 3. Restore Java 21 in pom if needed

If the copied Eclipse `pom.xml` uses an older Java version, add or keep in **`<properties>`**:

```xml
<maven.compiler.source>21</maven.compiler.source>
<maven.compiler.target>21</maven.compiler.target>
```

### 4. Run tests in Cursor

In the same terminal:

```powershell
mvn clean test
```

Or use **Terminal → Run Task → Maven: clean test**.

---

## If you use a TestNG suite (testng.xml)

1. Copy your `testng.xml` into `src/test/resources/testng.xml` (the script does this if it’s in your Eclipse project root).
2. To run only the suite, uncomment in **`pom.xml`** the Surefire block:

```xml
<suiteXmlFiles>
  <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
</suiteXmlFiles>
```

---

## Managing changes from here

- Edit code in Cursor; run with **`mvn test`** or **Run Task → Maven: test**.
- Keep a backup of your Eclipse project folder until you’re happy running everything from Cursor.
- When you’re ready, you can install Git and use it for version control.

Your code is only overwritten in this Cursor project by what you copy from Eclipse; the script does not delete your Eclipse project.
