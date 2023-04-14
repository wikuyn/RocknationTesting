package testing;

import base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import page.ProductPage;

public class SelectSizeProductTest extends BaseSetup {
    private ProductPage productPage;
    private ProductDetailPage productDetailPage;

    @Test
    public void selectValidProductSize(){
        productPage = indexPage.clickProdukTerbaru();
        productDetailPage = productPage.selectProductByArtisAndProductName("Neck Deep", "Making Hits");
        productDetailPage.selectProductSize("M");
        Assert.assertEquals(productDetailPage.getProductStockStatus(),"Tersedia 3 produk");
    }

    @Test
    public void selectInvalidProductSize(){
        productPage = indexPage.clickProdukTerbaru();
        productDetailPage = productPage.selectProductByArtisAndProductName("Neck Deep", "Making Hits");
        productDetailPage.selectProductSize("2XL");
        Assert.assertEquals(productDetailPage.getProductStockStatus(),"Stock habis (Konfirmasi lewat email jika stoknya kembali tersedia)");
    }
}
