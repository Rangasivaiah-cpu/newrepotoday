# Open Cucumber report in browser from Cursor

## After every run – automatic
- **run-daily.ps1** now opens both Allure and **Cucumber report** in the browser at the end.

## From the editor (open with web)

### Option 1: Run Task (no extension)
1. **Ctrl+Shift+P** → type **Run Task** → Enter.
2. Choose **Open Cucumber Report in Browser**.
3. The report opens in your default browser.

### Option 2: Right‑click → Open in Browser (recommended)
1. Install the recommended extension: **Open in Browser** (Cursor will suggest it, or install from Extensions: `techer.open-in-browser`).
2. In the Explorer, go to **target** → right‑click **cucumber-reports.html**.
3. Click **Open in Default Browser** (or **Open in Browser**).
4. The report opens in Chrome/Edge.

You can use this after every run: run tests, then right‑click the HTML file → Open in Default Browser.
