package practical.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import static practical.pages.BasePage.initializeDriver;
import static practical.pages.BasePage.tearDownDriver;

public class BaseTest {

    @BeforeTest
    public void startDriver() throws MalformedURLException {
        initializeDriver();
    }

    @AfterTest
    public void quitDriver(){
        tearDownDriver();
    }

}
