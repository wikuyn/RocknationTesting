package testing;

import base.BaseSetup;
import org.testng.annotations.Test;
import page.KeranjangSidePage;
import page.LoginPage;
import page.ProductDetailPage;
import page.ProductPage;

public class CheckoutWithLoginTest extends BaseSetup {
    private LoginPage loginPage;
    private ProductPage productPage;
    private ProductDetailPage detailPage;
    private KeranjangSidePage keranjangSidePage;

    @Test()
    public void checkoutWithLoginTest(){
        loginPage = indexPage.clickButtonMasuk();
        loginPage.inputLoginForm("ucokbeler81@gmail.com", "Jakarta123.");
        productPage = indexPage.clickProdukTerbaru();
        detailPage = productPage.selectProductByArtisAndProductName("Megadeth","Super Collider");
        detailPage.selectProductSize("L");
        keranjangSidePage = detailPage.clickButtonBeli();
        keranjangSidePage.clickKeranjangBelanjaButton();

    }
}
