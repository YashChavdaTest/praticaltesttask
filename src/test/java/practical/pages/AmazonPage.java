package practical.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonPage extends BasePage {
    List<WebElement> productNameList;
    List<WebElement> productPriceList;
    public void visitHomePage(){
        driver.get("http://amazon.com/");
    }

    public void searchProduct(String productName) {
        driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys(productName);
    }
    public void clickSubmit() {
        driver.findElement(By.xpath("//input[@type='submit' and @id='nav-search-submit-button']")).click();
    }

    public void getProductList() {
        productNameList=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        productPriceList=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    }

    public String getProductColor(String productName){
        String regexPattern = "(?i)\\b(black|white|red|blue|green|yellow|purple|pink|orange|gray)\\b";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(productName);

        if (matcher.find()) {
            String color = matcher.group(0);
            return color;
        } else {
            return "Color not found";
        }
    }

    public void printProductList(){
        for(int a=0;a<3;a++) {
            System.out.println("Product Name: " + productNameList.get(a).getText()+"\n");
            System.out.println(getProductColor("Product Color: " + productNameList.get(a).getText())+"\n");
            System.out.println("Product Price: " + "$"+productPriceList.get(a).getText()+"\n");
        }
    }
}
