package pages.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Handles Announcement popup (optional)
 */
public class AnnouncementPage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log =
            LoggerFactory.getLogger(AnnouncementPage.class);

    public AnnouncementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Close announcement button
    By closeAnnouncement =
            By.xpath("//div[@class='row1 bor-b']//img[@class='img-vsmall']");

    /*
     * Close announcement if present
     */
    public void handleAnnouncementIfPresent() {

        try {
            WebElement closeBtn =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(closeAnnouncement));

            log.info("Announcement popup displayed");
            closeBtn.click();
            log.info("Announcement popup closed");

        } catch (Exception e) {
            log.info("No announcement popup displayed");
        }
    }
}
