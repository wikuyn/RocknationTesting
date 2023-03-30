package testing;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.KeranjangSidePage;
import page.ProductDetailPage;
import page.ProductPage;

public class CheckoutWithoutLoginTest extends BaseSetup {
    private ProductPage productPage;
    private ProductDetailPage detailPage;
    private KeranjangSidePage keranjangSidePage;

    @Test
    public void checkOutProductWithoutLogin(){
        productPage = indexPage.clickProdukTerbaru();
        detailPage = productPage.selectProductByArtisAndProductName("The Strokes","Distressed OG Magna White");
        detailPage.selectProductSize("L");
        keranjangSidePage = detailPage.clickButtonBeli();
        keranjangSidePage.clickCheckoutButton();

    }
}
