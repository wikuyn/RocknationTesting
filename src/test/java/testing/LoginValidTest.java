package testing;

import base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AccountPage;
import page.IndexPage;
import page.LoginPage;

public class LoginValidTest extends BaseSetup {
    private LoginPage loginPage;
    private IndexPage index;
    private AccountPage accountPage;

    @Test
    public void testLoginWithValidCredential(){
        loginPage = indexPage.clickButtonMasuk();
        index = loginPage.inputLoginForm("ucokbeler81@gmail.com","Jakarta123.");
        accountPage = index.clickAkunSaya();
        Assert.assertEquals(accountPage.getEmailUserAccount(), "ucokbeler81@gmail.com");
    }
}
