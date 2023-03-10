package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeranjangSidePage {

    private WebDriver driver;
    private By buttonKeranjangBelanja = By.xpath("//*[@id=\"box_view_cart\"]/div[2]/a[1]");
    private By buttonCheckout = By.xpath("//*[@id=\"box_view_cart\"]/div[2]/a[2]");

    public KeranjangSidePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton(){
        driver.findElement(buttonCheckout).click();
    }

    public void clickKeranjangBelanjaButton(){
        driver.findElement(buttonKeranjangBelanja).click();
    }
}
