package hooks;

import base.DriverFactory;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.login.LoginPage;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

/*
 * Hooks class – runs before and after each scenario
 */
public class Hooks {

    public static WebDriver driver;
    public static Properties prop;

    // ✅ Shared page objects
    public static LoginPage loginPage;

    @Before//to run before each scenario to set up the browser and open the URL
    public void setUp() {

        // Read config
        ConfigReader reader = new ConfigReader();//to read the configuration properties from the config file
        prop = reader.readConfig();

        // Launch browser
        DriverFactory factory = new DriverFactory();
        driver = factory.startBrowser(prop.getProperty("browser"));//
        

        // Open URL
        driver.get(prop.getProperty("url"));

        // ✅ Create page object AFTER browser opens
        loginPage = new LoginPage(driver);
    }

    @After//to run after each scenario to close the browser
    public void tearDown() throws InterruptedException {
    	Thread.sleep(60000); // Just to see the result before browser closes
        driver.quit();
    }
    
  //  @Aftersteps//to run after each step to take a screenshot if the step fails
  //  @Beforestep//to run before each step to take a screenshot if the step fails
}
