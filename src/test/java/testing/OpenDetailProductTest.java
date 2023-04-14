package testing;

import base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import page.ProductPage;

public class OpenDetailProductTest extends BaseSetup {
    private ProductPage productPage;
    private ProductDetailPage productDetailPage;

    @Test
    public void openDetailProduct(){
        productPage = indexPage.clickProdukTerbaru();
        productDetailPage = productPage.selectProductByArtisAndProductName("Neck Deep", "Making Hits");
        Assert.assertEquals(productDetailPage.getBandName(),"Neck Deep");
        Assert.assertEquals(productDetailPage.getProductName(),"Making Hits");
    }
}
