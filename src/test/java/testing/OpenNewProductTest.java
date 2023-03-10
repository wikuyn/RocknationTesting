package testing;

import base.BaseSetup;
import org.testng.annotations.Test;

public class OpenNewProductTest extends BaseSetup {

    @Test
    public void nevigateToProdukTerbaru(){
        indexPage.clickProdukTerbaru();
    }
}
