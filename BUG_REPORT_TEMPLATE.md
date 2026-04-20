# Bug Report Template (with Screenshot)

Use this when you find a bug during test runs so you can report **which page** and **where** the issue is, with a screenshot.

---

## 1. Where failure screenshots are saved

When a Cucumber scenario fails, screenshots are saved automatically:

| Location | Description |
|----------|--------------|
| **target/screenshots/** | PNG files named like `Scenario_Name_20250220_143022.png` |
| **Cucumber HTML report** | Failed steps show an attached screenshot in the report (open `target/cucumber-reports.html`) |
| **Allure report** | If you use Allure, failure attachments include the screenshot |

---

## 2. Bug report fields (fill these for each bug)

| Field | Example |
|-------|--------|
| **Title** | One-line summary (e.g. "Proceed button not clickable on cart page") |
| **Page (URL or name)** | Which page: e.g. "Cart page", "https://www.foodorder.info/.../cart", "Login modal" |
| **Where on page** | Exact location: e.g. "Below the cart items, the orange 'Proceed' button" or "Top-right login icon" |
| **Steps to reproduce** | 1. Open food order site 2. Add item to cart 3. Click cart 4. Click Proceed |
| **Expected** | Proceed should open checkout or next step |
| **Actual** | Click is intercepted by overlay / button does nothing / error message shown |
| **Screenshot** | Attach the file from `target/screenshots/` or from the Cucumber/Allure report |
| **Environment** | Browser (Chrome 145), OS (Windows 11), test run date |

---

## 3. Example bug entry

**Title:** Element click intercepted on Cart page – Proceed button not clickable  

**Page:** Cart page (after adding item and opening cart)  

**Where:** The "Proceed" or "Proceed to checkout" button at the bottom of the cart.  

**Steps to reproduce:**
1. Launch food order application (foodorder.info uk).
2. Browse menu → Login → Add item to cart → Open cart.
3. Click the "Proceed" button.

**Expected:** Checkout or next step loads.  

**Actual:** Click is intercepted by another element (e.g. overlay `div.loada-body`). Error: `element click intercepted: Element <button class="one" ...> is not clickable at point (648, 470). Other element would receive the click`.  

**Screenshot:** `target/screenshots/Open_cart_from_food_order_site_20250220_143022.png`  

**Environment:** Chrome 145, Windows 11, run 20 Feb 2025.

---

## 4. How to get a screenshot for a bug

1. **From test run:** After a failed scenario, check `target/screenshots/` for a new PNG.
2. **From Cucumber report:** Open `target/cucumber-reports.html` → find the failed scenario → expand the failed step → use the attached image.
3. **From Allure:** Open the Allure report → open the failed test → Attachments → download the screenshot.

Using this template and the screenshot locations above will make it clear **which page** and **where** the bug is for developers.

---

## 5. If tests fail with "element not found"

The step definitions use **FoodOrderPage** (e.g. search box, product names, Add to cart). If your site (foodorder.info uk) has a different layout, update the selectors in `src/test/java/shiva/automation_project_v2/pages/FoodOrderPage.java` to match your pages. The screenshot will show exactly which page was open when the step failed.
