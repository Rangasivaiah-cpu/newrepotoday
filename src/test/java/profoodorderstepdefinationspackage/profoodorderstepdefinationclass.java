package profoodorderstepdefinationspackage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import profoodorderbasepackage.profoodorderbaseclass;
import profoodorderpompagepackage.profoodorderpompageclass;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class profoodorderstepdefinationclass {

    private static final String INVALID_ADDRESS_SCREENSHOT_DIR = "target/screenshots";
    /** For Cucumber report: screenshot of invalid address screen, attached in @AfterStep. */
    public static byte[] invalidAddressScreenshotForCucumber = null;
    public static boolean attachInvalidAddressToCucumberNextAfterStep = false;
    /** For Cucumber report: screenshot of invalid coupon (cart amount < 25) for bug report. */
    public static byte[] invalidCouponScreenshotForCucumber = null;
    public static boolean attachInvalidCouponToCucumberNextAfterStep = false;

    profoodorderpompageclass login;
    /** Screenshot of invalid postcode/address screen (Choose my location) for report. */
    private byte[] invalidAddressScreenForReport;


    @Given("user launches the food order application")
    public void user_launches_the_food_order_application() throws InterruptedException {
        profoodorderbaseclass.launchbrowser();
        login = new profoodorderpompageclass(profoodorderbaseclass.driver);
    }

    @When("user clicks on browse menu")
    public void user_clicks_on_browsemenu() {
        login.clickBrowseMenu();
    }

    @And("user clicks on login")
    public void user_clicks_on_login() {
        login.loginBtn();
    }

    @And("user enters email {string}")
    public void user_enters_email(String email) {
        login.enterEmail(email);
    }

    @And("user enters password {string}")
    public void user_enters_password(String password) {
        login.enterPassword(password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        login.clickLoginButton();
    }

    @And("user clicks on login button and expects error")
    public void user_clicks_on_login_button_and_expects_error() throws InterruptedException {
        login.clickLoginButtonExpectingError();
    }

    @And("user clicks on category")
    public void user_clicks_on_category() {
        login.clickcategoryBtn();
    }

    @And("user clicks on clickitem")
    public void user_clicks_on_clickitem() {
        login.clickitem();
    }

    @And("user clicks on additem")
    public void user_clicks_on_additem() {
        login.clickaddbutton();
    }

    @And("user clicks on paybutton")
    public void user_clicks_on_paybutton() {
        login.clickpaybutton();
    }

    @Then("itemprice should be display correctly")
    public void itemprice_should_be_display_correctly() {
        login.checkitemprise();
    }

    @And("user clicks on checkout")
    public void user_clicks_on_checkout() {
        login.clickcheckoutbutton();
    }

    @And("user clicks on finalpay")
    public void user_clicks_on_finalpay() {
        login.clickfinalPaybutton();
    }

    @And("user clicks on backtohome")
    public void user_clicks_on_backtohome() {
        login.clickbacktohomebutton();
    }

    @And("user clicks on backtohome2")
    public void user_clicks_on_backtohome2() {
        login.clickbacktohomebutton2();
    }

    @And("user clicks on deliveryservice")
    public void user_clicks_on_deliveryservice() {
        login.clickdeliveryservice();
    }

    @And("user enters postcode {string}")
    public void user_enters_postcode(String postcode) {
        login.enterposcode(postcode);
    }

    @And("user clicks on proceedbutton")
    public void user_clicks_on_proceedbutton() {
        login.clickproceedbutton();
        login.completeAddressModalIfPresent();
    }

    /** After selecting suggestion, auto-fill "Complete your address" if it appears; then next step (proceedbutton2) continues the flow. */
    @And("user clicks on clicksujetionlocation")
    public void user_clicks_on_clicksujetionlocation() {
        login.clicksujetionlocation();
        login.completeAddressModalIfPresent();
    }

    @And("user enters building no {string}")
    public void user_enters_building_no(String building) {
        login.enterAddressBuilding(building);
    }

    @And("user enters street {string}")
    public void user_enters_street(String street) {
        login.enterAddressStreet(street);
    }

    @And("user enters city {string}")
    public void user_enters_city(String city) {
        login.enterAddressCity(city);
    }

    @And("user clicks on address continue")
    public void user_clicks_on_address_continue() {
        login.clickAddressContinue();
    }

    @And("user clicks on proceedbutton2")
    public void user_clicks_on_proceedbutton2() throws InterruptedException {
        login.clickproceedbutton2();
        Thread.sleep(4000);
        login.ensurePastAddressScreen("EH6 6AX");
    }

    @And("user clicks on clickcollectionservice")
    public void user_clicks_on_clickcollectionservice() {
        login.clickcollectionservice();
    }

    @And("user clicks on clickdeliveryservice2")
    public void user_clicks_on_clickdeliveryservice2() throws InterruptedException {
        login.clickdeliveryservice2();
        Thread.sleep(4000);
    }

    @And("user clicks on clicklocatmeoption")
    public void user_clicks_on_clicklocatmeoption() {
        login.clicklocatmeoption();
    }

    @And("user enters address {string}")
    public void user_enters_address(String adress) {
        login.enteraddress(adress);
    }

    @And("user clicks on clickconfirmadress")
    public void user_clicks_on_clickconfirmadress() {
        login.clickconfirmadress();
    }

    @And("user clicks on clickproceed3")
    public void user_clicks_on_clickproceed3() throws InterruptedException {
        // Capture "Choose my location" screen with invalid address before clicking proceed (for manager in report)
        if (profoodorderbaseclass.driver != null && profoodorderbaseclass.driver instanceof TakesScreenshot) {
            byte[] shot = ((TakesScreenshot) profoodorderbaseclass.driver).getScreenshotAs(OutputType.BYTES);
            if (shot != null && shot.length > 0) {
                invalidAddressScreenForReport = shot;
            }
        }
        login.clickproceed3();
    }

    @Then("invalid credentials error message should be displayed")
    public void invalid_credentials_error_message_should_be_displayed() {
        login.validateLoginErrorDisplayed();
    }

    @Then("minimum order amount validation error should be displayed")
    public void minimum_order_amount_validation_error_should_be_displayed() {
        login.validateMinimumOrderErrorDisplayed();
    }

    /** Captures invalid address screen for report only; flow continues to gposcat. */
    @And("invalid address screen is captured for report")
    public void invalid_address_screen_is_captured_for_report() throws InterruptedException {
        String attachmentName = "Invalid postcode and address entered (for manager review)";
        if (invalidAddressScreenForReport != null && invalidAddressScreenForReport.length > 0) {
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(invalidAddressScreenForReport), "png");
            invalidAddressScreenshotForCucumber = invalidAddressScreenForReport;
            attachInvalidAddressToCucumberNextAfterStep = true;
            try {
                Path dir = Paths.get(INVALID_ADDRESS_SCREENSHOT_DIR);
                Files.createDirectories(dir);
                Files.write(dir.resolve("invalid_postcode_address_screen.png"), invalidAddressScreenForReport);
            } catch (Exception ignored) { }
            invalidAddressScreenForReport = null;
        }
    }

    @Then("invalid postcode and address validation error should be displayed")
    @Then("error message should display invalid postcode and adress")
    public void error_message_should_display_invalid_postcode_and_adress() throws InterruptedException {
        String attachmentName = "Invalid postcode and address entered (for manager review)";
        if (invalidAddressScreenForReport != null && invalidAddressScreenForReport.length > 0) {
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(invalidAddressScreenForReport), "png");
            invalidAddressScreenshotForCucumber = invalidAddressScreenForReport;
            attachInvalidAddressToCucumberNextAfterStep = true;
            try {
                Path dir = Paths.get(INVALID_ADDRESS_SCREENSHOT_DIR);
                Files.createDirectories(dir);
                Files.write(dir.resolve("invalid_postcode_address_screen.png"), invalidAddressScreenForReport);
            } catch (Exception ignored) { }
            invalidAddressScreenForReport = null;
        }
        login.invalidadressorpostcodeshouldnotaccept();
    }

    @And("user clicks on gposcat")
    public void user_clicks_on_gposcat() {
        login.clickgposcat();
    }

    @And("user clicks on clickprotonsitem")
    public void user_clicks_on_clickprotonsitem() {
        login.clickprotonsitem();
    }

    @And("user clicks on clickcontinuebuttonfor2item")
    public void user_clicks_on_clickcontinuebuttonfor2item() {
        login.clickcontinuebuttonfor2item();
    }

    @And("user clicks on clickmodifier")
    public void user_clicks_on_clickmodifier() {
        login.clickmodifier();
    }

    @And("user clicks on clickaddtocartbutton")
    public void user_clicks_on_clickaddtocartbutton() {
        login.clickaddtocartbutton();
    }

    @And("user clicks on clickpaybutton2")
    public void user_clicks_on_clickpaybutton2() {
        login.clickpaybutton2();
    }

    @And("user clicks on finalpay2")
    public void user_clicks_on_finalpay2() {
        login.clickfinalPaybutton2();
    }

    @And("user clicks on clickcheckoutbutton2")
    public void user_clicks_on_clickcheckoutbutton2() {
        login.clickcheckoutbutton2();
    }

    @And("user clicks on incresethaitemquantity")
    public void user_clicks_on_incresethaitemquantity() {
        login.incresethaitemquantity();
    }

    @And("user opens promocode section")
    public void user_opens_promocode_section() {
        login.clickPromocodeSection();
    }

    @And("user clicks on last coupon code")
    public void user_clicks_on_last_coupon_code() {
        login.clickLastCouponCode();
    }

    @Then("invalid coupon code due to cart amount less than 25 should be displayed")
    public void invalid_coupon_due_to_cart_amount_less_than_25_should_be_displayed() {
        login.validateInvalidCouponDueToCartAmountLessThan25();
        String attachmentName = "Invalid coupon code - cart amount less than 25 (bug report)";
        if (profoodorderbaseclass.driver != null && profoodorderbaseclass.driver instanceof TakesScreenshot) {
            byte[] shot = ((TakesScreenshot) profoodorderbaseclass.driver).getScreenshotAs(OutputType.BYTES);
            if (shot != null && shot.length > 0) {
                Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(shot), "png");
                invalidCouponScreenshotForCucumber = shot;
                attachInvalidCouponToCucumberNextAfterStep = true;
                try {
                    Path dir = Paths.get(INVALID_ADDRESS_SCREENSHOT_DIR);
                    Files.createDirectories(dir);
                    Files.write(dir.resolve("invalid_coupon_cart_amount_25.png"), shot);
                } catch (Exception ignored) { }
            }
        }
    }

    @And("user clicks on clickpromocode")
    public void user_clicks_on_clickpromocode() {
        login.clickpromocode();
    }
}
