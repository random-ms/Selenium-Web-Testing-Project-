package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebDriverFactory {
    protected static final Path browserType = Paths.get("resources/config/config.properties");
    protected static WebDriver driver;

    public static WebDriver getWebDriver() throws IOException {
        Files.lines(browserType).forEach(line -> {
            String[] words = line.split("=");
            if (words[0].equals("browser.type")) {
                switch (words[1]) {
                    case "chrome": driver = new ChromeDriver(); break;
                    case "firefox": driver = new FirefoxDriver(); break;
                    case "edge": driver = new EdgeDriver(); break;
                    case "safari": driver = new SafariDriver(); break;
                    default: throw new IllegalArgumentException("Invalid browser name: " + words[1]);
                }
            }
        });
        return driver;
    }
}