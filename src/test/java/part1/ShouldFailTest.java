package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShouldFailTest {
    Path browserType = Paths.get("src/main/resources/config.properties");
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        try {
            setBrowserConfig();
        } catch (IOException e) {
            System.out.println(e);
        }
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void TestLoginApplication() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";

        Assert.assertNotEquals(result, expectedResult);
    }

    public void setBrowserConfig() throws IOException {
        Files.lines(browserType).forEach(line -> {
            String[] words = line.split("=");
            if (words[0].equals("browser.type")) {
                switch (words[1]) {
                    case "firefox": driver = new FirefoxDriver(); break;
                    case "edge": driver = new EdgeDriver(); break;
                    case "safari": driver = new SafariDriver(); break;
                    default: driver = new ChromeDriver();
                }
            }
        });
    }
}