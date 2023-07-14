package practical.tests;

import org.testng.annotations.Test;
import practical.pages.AmazonPage;

public class AmazonTest extends BaseTest{
    AmazonPage amazonPage=new AmazonPage();

    @Test
    public void searchProductAndListDetails() {
        amazonPage.visitHomePage();
        amazonPage.searchProduct("Iphone");
        amazonPage.clickSubmit();
        amazonPage.getProductList();
        amazonPage.printProductList();
    }
}
