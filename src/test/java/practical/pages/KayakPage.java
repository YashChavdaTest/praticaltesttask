package practical.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import practical.utils.DateHelper;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class KayakPage extends BasePage{
    String costliestFlightName;
    String costliestFlightTimings;
    String costliestFlightPrice;
    String cheapestFlightame;
    String cheapestFlightTimings;
    String cheapestFlightPrice;

    LocalDate firstFriday;
    LocalDate thirdMonday;
    Date firstFridayDate;
    Date thirdMondayDate;

    public void visitHomepage(){
        driver.get("https://www.kayak.com/flights");
    }

    public void removePreselectedData(){
        driver.findElement(By.xpath("//div[@aria-label='Remove']")).click();
    }

    public void switchToOneWay(){
        driver.findElement(By.xpath("//span[contains(text(),'Round-trip')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'One-way')]")).click();
    }

    public void enterFlightOrigin(String origin,String city){
        driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys(origin);
        driver.findElement(By.xpath("//li[contains(@aria-label,'"+ city +"')]")).click();
    }

    public void enterFlightDestination(String destination,String city){
        driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys(destination);
        driver.findElement(By.xpath("//li[contains(@aria-label,'"+ city +"')]")).click();
    }

    public void clickDatePicker(){
        driver.findElement(By.xpath("//span[contains(@aria-label,'Start date calendar input')]")).click();
    }

    public void getDate(){
        firstFriday= DateHelper.firstOfMonth(Year.now(), Month.AUGUST, DayOfWeek.FRIDAY);
        thirdMonday= DateHelper.thirdOfMonth(Year.now(), Month.AUGUST, DayOfWeek.MONDAY);
        firstFridayDate = Date.from(firstFriday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        thirdMondayDate = Date.from(thirdMonday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void selectFirstFriday(){
        driver.findElement(By.xpath("//div[contains(text(),'"+firstFridayDate.getDate()+"') and contains(@aria-label,'Aug')]")).click();
    }

    public void selectThirdMonday(){
        driver.findElement(By.xpath("//div[contains(text(),'"+thirdMondayDate.getDate()+"') and contains(@aria-label,'Aug')]")).click();
    }

    public  void clickSearch(){
        driver.findElement(By.xpath("//button[contains(@aria-label,'Search')]")).click();
    }

    public void switchTab() throws Exception{
        Thread.sleep(5000);
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToThirdTab() throws Exception{
        Thread.sleep(5000);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(2));
    }

    public void sortHighestPrice(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'Other sort')]")));
        driver.findElement(By.xpath("//div[contains(@aria-label,'Other sort')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Highest price')]")).click();
    }

    public void sortCheapestPrice(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Cheapest')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Cheapest')]")).click();
    }

    public void swapDestinations(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'Swap departure airport and destination airport')]")));
        driver.findElement(By.xpath("//div[contains(@aria-label,'Swap departure airport and destination airport')]")).click();
    }
    public void getCostliestFlightDetails(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'operator-text')])[2]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'vmXl vmXl-mod-variant-default')])[2]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'price-text')])[2]")));
        costliestFlightName=driver.findElement(By.xpath("(//div[contains(@class,'operator-text')])[2]")).getText();
        costliestFlightTimings=driver.findElement(By.xpath("(//div[contains(@class,'vmXl vmXl-mod-variant-default')])[2]")).getText();
        costliestFlightPrice=driver.findElement(By.xpath("(//div[contains(@class,'price-text')])[2]")).getText();
    }
    public void getCheapestFlightDetails(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'operator-text')])[2]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'vmXl vmXl-mod-variant-default')])[2]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'price-text')])[2]")));
        cheapestFlightame=driver.findElement(By.xpath("(//div[contains(@class,'operator-text')])[2]")).getText();
        cheapestFlightTimings=driver.findElement(By.xpath("(//div[contains(@class,'vmXl vmXl-mod-variant-default')])[2]")).getText();
        cheapestFlightPrice=driver.findElement(By.xpath("(//div[contains(@class,'price-text')])[2]")).getText();
    }

    public void printFlightDetails(){
        System.out.println("Costliest flight from LAX to JFK for Friday");
        System.out.println(costliestFlightName);
        System.out.println(costliestFlightTimings);
        System.out.println(costliestFlightPrice);
        System.out.println("Cheapest flight from JFK to LAX for Monday");
        System.out.println(cheapestFlightame);
        System.out.println(costliestFlightTimings);
        System.out.println(cheapestFlightPrice);
    }
}
