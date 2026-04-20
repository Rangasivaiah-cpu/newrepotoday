package testngpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import profoodorderbasepackage.profoodorderbaseclass;
import profoodorderpompagepackage.profoodorderpompageclass;

public class testngclass {

    @BeforeMethod
    public void setup() throws InterruptedException {
        profoodorderbaseclass.launchbrowser();
    }

    @Test
    public void testlogin() throws InterruptedException {
        profoodorderpompageclass login = new profoodorderpompageclass(profoodorderbaseclass.driver);
        login.clickBrowseMenu();
        login.loginBtn();
        login.enterEmail("arepatiranga@gmail.com");
        login.enterPassword("12345678");
        login.clickLoginButton();
        login.clickcategoryBtn();
        login.clickitem();
        login.clickaddbutton();
        login.clickpaybutton();
        Thread.sleep(3000);
        login.checkitemprise();
        login.clickcheckoutbutton();
        Thread.sleep(3000);
        login.clickfinalPaybutton();
        login.clickbacktohomebutton();
        login.validateLoginErrorDisplayed();
        login.clickdeliveryservice();
        login.enterposcode("EH6 6AX");
        login.clickproceedbutton();
        login.clicksujetionlocation();
        login.clickproceedbutton2();
        Thread.sleep(4000);
        login.clickcollectionservice();
        login.clickdeliveryservice2();
        login.clicklocatmeoption();
        login.enteraddress("Uppal, Hyderabad, Telangana, India");
        login.clickconfirmadress();
        login.clickproceed3();
        login.invalidadressorpostcodeshouldnotaccept();
        Thread.sleep(4000);
        login.clickgposcat();
        login.clickprotonsitem();
        login.clickcontinuebuttonfor2item();
        login.clickmodifier();
        login.clickaddtocartbutton();
        login.clickpaybutton2();
        login.clickcheckoutbutton2();
        login.incresethaitemquantity();
        login.clickpromocode();
        login.validateLoginErrorDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        profoodorderbaseclass.quitBrowser();
    }
}
