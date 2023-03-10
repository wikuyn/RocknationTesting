package testing;

import base.BaseSetup;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginInvalidTest extends BaseSetup {
    private LoginPage loginPage;

    @Test
    public void testLoginInvalidUnregis(){
        loginPage = indexPage.clickButtonMasuk();
        loginPage.inputLoginForm("invalidemail@gmail.com", "invalid");
    }

    @Test
    public void testLoginInvalidWrongPassword(){
        loginPage.inputLoginForm("ucokbeler81@gmail.com", "invalid");
    }

}
