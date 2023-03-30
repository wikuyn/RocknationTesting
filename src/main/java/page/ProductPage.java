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

        /* Hover element
        WebElement ele = driver.findElement(By.xpath("<xpath>"));

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
         */





        /* Upload file
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\newhtml.html");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
         */




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
