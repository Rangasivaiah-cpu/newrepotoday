# Cucumber report – open in browser from Eclipse

Report is generated at: **target/cucumber-reports.html**

To have **Open with Web Browser** in Eclipse open the report in Chrome/Edge (not Cursor):

1. **Eclipse:** **Window** → **Preferences** → **General** → **Web Browser** → **Use external web browser** → **New...** → Name: `Chrome`, Location: `C:\Program Files\Google\Chrome\Application\chrome.exe` → **OK** → **Apply and Close**.
2. **Windows (if still opens in Cursor):** **Settings** → **Apps** → **Default apps** → **Choose default apps by file type** → **.html** → select **Chrome** or **Edge**.

Then: refresh **target**, right‑click **cucumber-reports.html** → **Open With** → **Web Browser**.
