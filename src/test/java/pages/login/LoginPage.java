package pages.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Handles Login Page actions
 */
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log =
            LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== Login Page XPaths =====
    By username = By.xpath("//input[@id='userNameTxt']");
    By password = By.xpath("//input[@id='pwdTxt']");
    By loginBtn = By.xpath("//button[text()='Login']");

    // OTP page heading (for validation)
    By otpPageHeader = By.xpath("//h2[contains(text(),'OTP')]");

    /*
     * Enter username
     */
    public void enterUsername(String user) {
        log.info("Entering username");
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }

    /*
     * Enter password
     */
    public void enterPassword(String pass) {
        log.info("Entering password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }

    /*
     * Click Login button
     */
    public void clickLogin() {
        log.info("Clicking Login button");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    /*
     * Manual captcha wait
     */
    public void waitForCaptcha(int seconds) {
        log.info("Waiting {} seconds for captcha entry", seconds);
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
     * Verify OTP page is displayed
     */
    public boolean isOtpPageDisplayed() {
        log.info("Verifying OTP page display");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpPageHeader));
            log.info("OTP page displayed successfully");
            return true;
        } catch (Exception e) {
            log.error("OTP page NOT displayed");
            return false;
        }
    }
}
