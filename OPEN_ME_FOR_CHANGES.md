# All code – open these, then highlight & tell me what to change

**When you return after closing Cursor:** open [START_HERE_WHEN_YOU_RETURN.md](START_HERE_WHEN_YOU_RETURN.md) – full checklist and run instructions.

**Structure (everything under src/test):**  
- **Runner** → runs **features** and **step definitions**. Change a `.feature` or a step-def method and re-run; the runner picks it up.
- **Java:** `src/test/java` — runner, stepdefinitions, base, POM, test class.  
- **Features:** `src/test/resources/features` — `.feature` files.

**To get the 3 classes in your tab bar:**  
Double-click **open-3-classes.cmd**. Then run `.\run-daily.ps1`.

---

**Click a path below to open:**

**Runner (Cucumber)**  
[profoodorderrunnerclass.java](src/test/java/profoodorderrunnerpackage/profoodorderrunnerclass.java)

**1. Base (browser)**  
[profoodorderbaseclass.java](src/test/java/profoodorderbasepackage/profoodorderbaseclass.java)

**2. Pages / locators**  
[profoodorderpompageclass.java](src/test/java/profoodorderpompagepackage/profoodorderpompageclass.java)

**3. Tests (TestNG)**  
[testngclass.java](src/test/java/testngpackage/testngclass.java)

**Cucumber features (scenarios – edit here, runner runs these)**  
[food_order_login.feature](src/test/resources/features/food_order_login.feature)

**Cucumber step definitions (glue – must match feature steps)**  
[profoodorderstepdefinationclass.java](src/test/java/profoodorderstepdefinationspackage/profoodorderstepdefinationclass.java)

**Test suite**  
[testng-profoodorder.xml](src/test/resources/testng-profoodorder.xml)

**Daily run script**  
[run-daily.ps1](run-daily.ps1)

---

**Run tests & report:** In this folder run `.\run-daily.ps1`
