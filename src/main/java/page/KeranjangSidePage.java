package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeranjangSidePage {

    private WebDriver driver;
    private By buttonKeranjangBelanja = By.xpath("//*[@id=\"box_view_cart\"]/div[2]/a[1]");
    private By buttonCheckout = By.xpath("//*[@id=\"box_view_cart\"]/div[2]/a[2]");

    public KeranjangSidePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        driver.findElement(buttonCheckout).click();
    }

    public void clickKeranjangBelanjaButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(buttonKeranjangBelanja));
        driver.findElement(buttonKeranjangBelanja).click();
    }
}
