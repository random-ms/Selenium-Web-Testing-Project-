package part2.com.saucedemo.base;

import Utilities.WebDriverFactory;
import com.base.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;


public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private final String url = "https://www.saucedemo.com";


    @BeforeClass
    public void setUp() throws InterruptedException {
        try {
            this.driver = WebDriverFactory.getWebDriver();
        } catch (IOException e) {
            log.error("e: ", e);
        }

        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
        loginPage.setDriver(driver);
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }
}