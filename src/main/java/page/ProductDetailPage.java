package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage {
    private WebDriver driver;
    private By textBandName = By.className("large-hd");
    private By textProductName = By.className("medium-hd");
    private By optionRadioSize = By.className("option-row");
    private By radioSizeM = By.linkText(" M ");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductSize(String size){
        checkAvailableSize(size);
    }

    private void checkAvailableSize(String sizeSearch){
        List<WebElement> listSize = driver.findElements(optionRadioSize);
        for (WebElement size : listSize){
            System.out.println("Size avail "+size.getText());
            if (sizeSearch.equals(size.getText())){
                size.click();
            }else {
                System.out.println("Size Tidak Tersedia");
            }
        }
    }
}
