package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class IndexPage {
    private WebDriver driver;
    private By buttonMasuk = By.id("login-link");
    private By container = By.xpath("//*[@id=\"content\"]/div[2]");
    private By buttonAcceptCookie = By.id("hs-eu-confirmation-button");
    private By inputSearch = By.name("filter_artist");
    private By buttonAkunSaya = By.id("account-dd-link");
    private By buttonProductTerbaru = By.xpath("//*[@id=\"navigation\"]/div/ul/li[1]/a");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        acceptCookie();
    }

    public void searchProductByBandName(String bandName){
        driver.findElement(inputSearch).sendKeys(bandName, Keys.ENTER);
    }

    public ProductPage clickProdukTerbaru(){
        //Refresing the page
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(buttonProductTerbaru));
        driver.findElement(buttonProductTerbaru).click();
        return new ProductPage(driver);
    }

    public void acceptCookie(){
        if (driver.findElement(buttonAcceptCookie).isDisplayed()){
            driver.findElement(buttonAcceptCookie).click();
        }

    }

    public LoginPage clickButtonMasuk(){
        driver.findElement(buttonMasuk).click();
        return new LoginPage(driver);
    }

    public AccountPage clickButtonAkunSaya(){
        driver.findElement(buttonAkunSaya).click();
        return new AccountPage(driver);
    }

    public void scrollToContainer(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(container));

    }
}
