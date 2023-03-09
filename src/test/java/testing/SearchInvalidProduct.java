package testing;

import base.BaseSetup;
import org.testng.annotations.Test;

public class SearchInvalidProduct extends BaseSetup {

    @Test()
    public void searchProductInvalidTest(){
        indexPage.searchProductByBandName("Invalid Band Name");
    }

}
