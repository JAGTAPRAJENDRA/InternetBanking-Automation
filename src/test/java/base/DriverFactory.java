package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // ✅ Detect CI environment (GitHub Actions)
            String ci = System.getenv("CI");

            if (ci != null) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            // Open Chrome browser
            driver = new ChromeDriver(options);
        }

        // Maximize browser (only if not headless)
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            // Ignore for headless
        }

        // Implicit wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
