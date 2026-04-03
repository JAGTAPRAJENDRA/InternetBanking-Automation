package pages.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger log =
            LoggerFactory.getLogger(OtpPage.class);

    public OtpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // OTP boxes
    private By otp1 = By.id("otppassword1");
    private By otp2 = By.id("otppassword2");
    private By otp3 = By.id("otppassword3");
    private By otp4 = By.id("otppassword4");
    private By otp5 = By.id("otppassword5");
    private By otp6 = By.id("otppassword6");

    private By submitBtn =
            By.xpath("//button[contains(text(),'Submit')]");

    private By invalidOtpError =
            By.xpath("//*[contains(text(),'Invalid OTP')]");

    /* ================= VALID OTP ================= */

    public void enterOtp(String otp) {

        log.info("Entering OTP one by one");

        wait.until(ExpectedConditions.visibilityOfElementLocated(otp1));

        driver.findElement(otp1).sendKeys(String.valueOf(otp.charAt(0)));
        driver.findElement(otp2).sendKeys(String.valueOf(otp.charAt(1)));
        driver.findElement(otp3).sendKeys(String.valueOf(otp.charAt(2)));
        driver.findElement(otp4).sendKeys(String.valueOf(otp.charAt(3)));
        driver.findElement(otp5).sendKeys(String.valueOf(otp.charAt(4)));
        driver.findElement(otp6).sendKeys(String.valueOf(otp.charAt(5)));

        log.info("OTP entry completed");
    }

    /* ================= INVALID OTP (FIXED) ================= */

    public void enterInvalidOtp(String invalidOtp) {

        log.info("Entering INVALID OTP one by one");

        wait.until(ExpectedConditions.visibilityOfElementLocated(otp1));

        driver.findElement(otp1).sendKeys(String.valueOf(invalidOtp.charAt(0)));
        driver.findElement(otp2).sendKeys(String.valueOf(invalidOtp.charAt(1)));
        driver.findElement(otp3).sendKeys(String.valueOf(invalidOtp.charAt(2)));
        driver.findElement(otp4).sendKeys(String.valueOf(invalidOtp.charAt(3)));
        driver.findElement(otp5).sendKeys(String.valueOf(invalidOtp.charAt(4)));
        driver.findElement(otp6).sendKeys(String.valueOf(invalidOtp.charAt(5)));

        log.info("Invalid OTP entered in all 6 fields");
    }

    public void submitOtp() {

        log.info("Waiting for Submit button to enable");

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        log.info("Submit OTP clicked");
    }

    public boolean isInvalidOtpErrorDisplayed() {

        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(invalidOtpError)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
