package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By inputUsername = By.id("input_username");
    private By inputPassword = By.id("input_password");
    private By errorMessage = By.id("landing-error-message");
    private By akunSaya = By.id("account-dd-link");
    private By buttonLogin = By.linkText("Login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public IndexPage inputLoginForm(String email, String password){
        driver.findElement(inputUsername).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password, Keys.ENTER);
        return new IndexPage(driver);
    }
}
