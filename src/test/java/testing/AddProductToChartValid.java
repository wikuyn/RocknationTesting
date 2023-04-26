package testing;

import base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.IndexPage;
import page.LoginPage;
import page.ProductDetailPage;
import page.ProductPage;

public class AddProductToChartValid extends BaseSetup {
    private LoginPage loginPage;
    private IndexPage index;
    private ProductPage productPage;
    private ProductDetailPage productDetailPage;

    @Test
    public void addProductToChartInvalid(){
        loginPage = indexPage.clickButtonMasuk();
        index = loginPage.inputLoginForm("ucokbeler81@gmail.com","Jakarta123.");
        productPage = index.clickProdukTerbaru();
        productDetailPage = productPage.selectProductByArtisAndProductName("Wiz Khalifa", "Smookey Smiley");
        productDetailPage.selectProductSize("XL");
        productDetailPage.clickButtonBeli();
    }
}
