package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

/*
 * This class is responsible for starting browser
 */
public class DriverFactory {

    /*
     * This method starts browser based on browser name
     */
    public WebDriver startBrowser(String browserName) {

        WebDriver driver = null;

        // If browser is chrome
        if (browserName.equalsIgnoreCase("chrome")) {

            // Automatically download and setup ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Open Chrome browser
            driver = new ChromeDriver();
        }

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
