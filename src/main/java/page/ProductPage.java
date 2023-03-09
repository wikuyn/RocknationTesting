package page;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.sql.Driver;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private By textArtisName = By.className("artist-name");
    private By  textProductName= By.className("product-name");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailPage selectProductByArtisAndProductName(String artisName, String productName){
        String nama, product;
        List<WebElement> listProductName = driver.findElements(textProductName);
        List<WebElement> listArtisName = driver.findElements(textArtisName);
        try {
            for (int i = 0; i < listProductName.size(); i++) {
                nama = listArtisName.get(i).getText();
                product = listProductName.get(i).getText();
                if (nama.equals(artisName) && product.equals(productName)) {
                    System.out.println("Product di temukan");
                    System.out.println("Product yang ada : " + product + " search product name : " + productName);
                    System.out.println("artis yang ada : " + nama + " artis name : " + artisName);
                    listProductName.get(i).click();
                } else {
                    System.out.println("Tidak di temukan");
                    System.out.println("Product yang ada : " + product + " search product name : " + productName);
                    System.out.println("artis yang ada : " + nama + " artis name : " + artisName);
                }
            }
        }catch (StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }
        return new ProductDetailPage(driver);
        /*
        String getArtisName = driver.findElement(textArtisName).getText();
        String getProductName = driver.findElement(textProductName).getText();
        System.out.println(getArtisName);
        System.out.println(getProductName);
        System.out.println("param artis"+artisName+" param product "+productName);
        if (getArtisName.equals(artisName) && getProductName.equals(productName)){
            driver.findElement(textProductName).click();
        }else {
            System.out.println("product tidak di temukan");
        }
         */
    }
}
