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
    private By optionRadioSize = By.className("radio_btn");
    private By buttonBeli = By.name("submit");
    private By radioSizeL = By.xpath("//*[@id=\"pro_option1\"]/div/label[3]/span");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductSize(String size){
        //driver.findElement(radioSizeL).click();
        checkAvailableSize(size);
    }

    private void checkAvailableSize(String sizeSearch){
        String size;
        List<WebElement> listSize = driver.findElements(optionRadioSize);
        for (WebElement elementSize : listSize){
            size = elementSize.getText();
            if (size.equals(sizeSearch)){
                System.out.println("Ditemukan Size tersedia : "+size+" Size dicari : "+sizeSearch);
                elementSize.click();
            }else {
                System.out.println("Size dicari : "+sizeSearch+ " Tidak Di Temukan");
                System.out.println(size);
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
