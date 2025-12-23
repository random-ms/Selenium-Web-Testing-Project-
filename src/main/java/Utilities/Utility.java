package Utilities;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Utility {
    public static WebDriver driver;

    public static void setUtilityDriver() throws IOException {
        driver = BasePage.driver;
    }
}
