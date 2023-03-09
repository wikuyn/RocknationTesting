package testing;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import page.ProductPage;

public class ProductPageTest extends BaseSetup {
    private ProductPage productPage;
    private ProductDetailPage detailPage;

    @Test
    public void openProductTerbaru(){
        productPage = indexPage.clickProdukTerbaru();
        detailPage = productPage.selectProductByArtisAndProductName("Megadeth","Super Collider");
        detailPage.selectProductSize("L");
    }
}
