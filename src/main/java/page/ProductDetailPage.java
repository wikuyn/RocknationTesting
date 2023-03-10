package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage {
    private WebDriver driver;
    private By textBandName = By.className("large-hd");
    private By textProductName = By.className("medium-hd");
    private By optionRadioSize = By.className("option-row");
    private By buttonBeli = By.name("submit");
    private By radioSizeL = By.xpath("//*[@id=\"pro_option1\"]/div/label/span");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductSize(String size){
        checkAvailableSize(size);
    }

    private void checkAvailableSize(String sizeSearch){
        List<WebElement> listSize = driver.findElements(optionRadioSize);
        for (int i = 0; i < listSize.size(); i++){
            String size = listSize.get(i).getText();
            if (sizeSearch.equals(size)){
                System.out.println("Ditemukan "+size);
                driver.findElement(radioSizeL).click();
            }else {
                System.out.println("Tidak di temukan");
            }
        }
    }

    public KeranjangSidePage clickButtonBeli(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(buttonBeli));
        driver.findElement(buttonBeli).click();
        return new KeranjangSidePage(driver);
    }
}
