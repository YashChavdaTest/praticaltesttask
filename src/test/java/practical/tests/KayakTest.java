package practical.tests;

import org.testng.annotations.Test;
import practical.pages.KayakPage;

public class KayakTest extends BaseTest{
    KayakPage kayakPage=new KayakPage();

    @Test
    public void getCostliestAndCheapestFlightBetweenLAXJFK() throws Exception{
        kayakPage.visitHomepage();
        kayakPage.removePreselectedData();
        kayakPage.switchToOneWay();
        kayakPage.enterFlightOrigin("LAX","Los Angeles");
        kayakPage.enterFlightDestination("JFK","New York");
        kayakPage.clickDatePicker();
        kayakPage.getDate();
        kayakPage.selectFirstFriday();
        kayakPage.clickSearch();
        kayakPage.switchTab();
        kayakPage.sortHighestPrice();
        kayakPage.getCostliestFlightDetails();
        kayakPage.visitHomepage();
        kayakPage.swapDestinations();
        kayakPage.clickDatePicker();
        kayakPage.getDate();
        kayakPage.selectThirdMonday();
        kayakPage.clickSearch();
        kayakPage.sortCheapestPrice();
        kayakPage.getCheapestFlightDetails();
        kayakPage.printFlightDetails();
    }
}
