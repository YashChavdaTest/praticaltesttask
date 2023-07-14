package practical.pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();
    static WebDriverWait wait;

    public static void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        options.addArguments("--incognito");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public static void tearDownDriver(){
       driver.quit();
    }
}
