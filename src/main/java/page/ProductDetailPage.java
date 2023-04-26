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
    private By statusBox = By.id("product-stock-status");
    private By buttonBeli = By.name("submit");
    private By buttonPlus = By.className("add-qty");
    private By buttonMinus = By.className("min-qty");
    private By radioSizeL = By.xpath("//*[@id=\"pro_option1\"]/div/label[3]/span");
    private By dialogBox = By.id("cc-dialog-box");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductSize(String size){ 
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

    public void clickButtonPlus(){
        driver.findElement(buttonPlus).click();
    }

    public void clickButtonMinus(){
        driver.findElement(buttonMinus).click();
    }

    public String getProductName(){
        return driver.findElement(textProductName).getText();
    }

    public String getBandName(){
        return driver.findElement(textBandName).getText();
    }

    public String getProductStockStatus(){
        System.out.println(driver.findElement(statusBox).getText());
        return driver.findElement(statusBox).getText();
    }

    public Boolean isDialogShow(){
        return driver.findElement(dialogBox).isDisplayed();
    }

}
