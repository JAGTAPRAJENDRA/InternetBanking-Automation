package pages.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Validates Dashboard page
 */
public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log =
            LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Dashboard logo
    By dashboardLogo =
            By.xpath("//img[@class='normal d-none d-md-block d-lg-block d-xl-block']");

    /*
     * Check dashboard visibility
     */
    public boolean isDashboardDisplayed() {

        log.info("Checking dashboard visibility");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLogo));
            log.info("Dashboard displayed successfully");
            return true;
        } catch (Exception e) {
            log.error("Dashboard not displayed");
            return false;
        }
    }
}
