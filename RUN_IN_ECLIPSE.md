# Open and run in Eclipse

## 1. Import the project

1. Open **Eclipse**.
2. **File** → **Import**.
3. Choose **Maven** → **Existing Maven Projects** → Next.
4. **Root Directory:** click **Browse** and select:
   ```
   c:\My Copy\automation-project-v2
   ```
5. Ensure the project is checked → **Finish**.
6. Wait for Maven to load (bottom-right progress). The project appears in **Package Explorer**.

---

## 2. Run tests in Eclipse

### Run TestNG (testngclass + Cucumber runner)

1. In Package Explorer go to: **src/test/resources**.
2. **Right‑click** `testng-profoodorder.xml` (or `testng.xml`) → **Run As** → **TestNG Suite**.

### Run only the Cucumber runner

1. In Package Explorer go to: **src/test/java** → **profoodorderrunnerpackage**.
2. **Right‑click** `profoodorderrunnerclass.java` → **Run As** → **TestNG Test**.

### Run only the TestNG test class

1. **Right‑click** `testngclass.java` (under **testngpackage**) → **Run As** → **TestNG Test**.

---

## 3. Open Cucumber report in Eclipse

After the run, Cucumber creates: **target/cucumber-reports.html**.

**Option A – from Eclipse**

1. In **Project Explorer**, expand **target**.
2. **Right‑click** `cucumber-reports.html` → **Open With** → **Web Browser** (or **System Editor**).

**Option B – from Windows**

1. In Project Explorer, **right‑click** `target/cucumber-reports.html` → **Show In** → **System Explorer** (or **Properties** and copy path).
2. Double‑click **cucumber-reports.html** in File Explorer to open in Chrome/Edge.

---

## 4. Open Allure report in Eclipse

Allure report is generated under **target/site/allure-maven-plugin/**.

**From Eclipse**

1. In Project Explorer, expand **target** → **site** → **allure-maven-plugin**.
2. **Right‑click** `index.html` → **Open With** → **Web Browser**.

**Or generate + open from terminal in Eclipse**

1. **Window** → **Show View** → **Terminal**.
2. In project folder run:
   ```
   mvn allure:report
   ```
3. Then open **target/site/allure-maven-plugin/index.html** as above.

---

## 5. If "Run As TestNG" is missing

1. **Help** → **Eclipse Marketplace**.
2. Search for **TestNG** → install **TestNG for Eclipse**.
3. Restart Eclipse and run again.

---

**Project path:** `c:\My Copy\automation-project-v2`
