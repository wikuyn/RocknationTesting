package testing;

import base.BaseSetup;
import org.testng.annotations.Test;

public class SearchValidProductTest extends BaseSetup {

    @Test()
    public void searchProductValidTest(){
        indexPage.searchProductByBandName("The Rolling Stones");
    }
}
