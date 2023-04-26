package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By textEmail = By.xpath("//*[@id=\"account-detail\"]/table/tbody/tr[8]/td[2]");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmailUserAccount(){
        return driver.findElement(textEmail).getText();
    }
}
