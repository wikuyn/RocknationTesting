package testing;

import base.BaseSetup;
import org.testng.annotations.Test;
import page.IndexPage;
import page.LoginPage;

public class LoginValidTest extends BaseSetup {
    private LoginPage loginPage;
    private IndexPage index;

    @Test
    public void testLoginWithInvalidCredential(){
        loginPage = indexPage.clickButtonMasuk();
        index = loginPage.inputLoginForm("ucokbeler81@gmail.com","Jakarta123.");
        index.scrollToContainer();
    }
}
