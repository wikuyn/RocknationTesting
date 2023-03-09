package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class IndexPage {
    private WebDriver driver;
    private By buttonAcceptCookie = By.id("hs-eu-confirmation-button");
    private By inputSearch = By.name("filter_artist");
    private By buttonProductTerbaru = By.xpath("//*[@id=\"navigation\"]/div/ul/li[1]/a");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProductByBandName(String bandName){
        acceptCookie();
        driver.findElement(inputSearch).sendKeys(bandName, Keys.ENTER);
    }

    public ProductPage clickProdukTerbaru(){
        acceptCookie();
        driver.findElement(buttonProductTerbaru).click();
        return new ProductPage(driver);
    }

    private void acceptCookie(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAcceptCookie));
        driver.findElement(buttonAcceptCookie).click();
    }
}
