# Your Eclipse project is never touched

- **We only copy into Cursor.** All changes happen in this folder: `c:\My Copy\automation-project-v2`.
- **Eclipse stays as is.** Your Eclipse workspace, project, code, and files are **never modified or deleted**.
- **Copy script is read-only for Eclipse.** `scripts\Copy-FromEclipse.ps1` only **reads** from your Eclipse project and **writes** into this Cursor project. It does not change anything in Eclipse.
- **pom.xml:** We do not copy Eclipse’s pom over. Cursor’s pom already uses your versions (Java 17, Cucumber 7.13, TestNG, Selenium, WebDriverManager) and adds the TestNG suite so `mvn test` runs here.

You can keep using Eclipse as before. Cursor is a separate copy for editing and running.
