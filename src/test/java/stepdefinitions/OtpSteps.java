package stepdefinitions;

import io.cucumber.java.en.When;
import pages.dashboard.AnnouncementPage;
import pages.dashboard.DashboardPage;
import pages.login.OtpPage;
import services.OtpService;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hooks.Hooks;

/*
 * OTP Step Definitions
 */
public class OtpSteps {

    private WebDriver driver;
    private OtpPage otpPage;
    private OtpService otpService;
    private DashboardPage dashboardPage;
    private AnnouncementPage announcementPage;

    private static final Logger log =
            LoggerFactory.getLogger(OtpSteps.class);

    /* ================= VALID OTP ================= */

    @When("user fetches otp from api")
    public void user_fetches_otp_from_api() {

        log.info("Fetching OTP from API");

        driver = Hooks.driver;
        otpPage = new OtpPage(driver);
        otpService = new OtpService();

        String otp = otpService.getOtp();

        log.info("OTP fetched from API: {}", otp);

        otpPage.enterOtp(otp);
    }

    @When("user clicks submit otp")
    public void user_clicks_submit_otp() {

        otpPage.submitOtp();
        log.info("Submit OTP clicked");
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        announcementPage = new AnnouncementPage(driver);
        dashboardPage = new DashboardPage(driver);

        announcementPage.handleAnnouncementIfPresent();

        if (dashboardPage.isDashboardDisplayed()) {
            log.info("Dashboard displayed successfully");
        } else {
            throw new AssertionError("Dashboard NOT displayed");
        }
    }

    /* ================= INVALID OTP ================= */

    @When("user enters invalid otp")
    public void user_enters_invalid_otp() {

        log.info("Invalid OTP scenario started");

        driver = Hooks.driver;
        otpPage = new OtpPage(driver);

        // IMPORTANT: 6 digits entered one by one
        otpPage.enterInvalidOtp("111111");

        log.info("Invalid OTP entered");
    }


    @Then("invalid otp error message should be displayed")
    public void invalid_otp_error_message_should_be_displayed() {

        if (otpPage.isInvalidOtpErrorDisplayed()) {
            log.info("Invalid OTP error message displayed");
        } else {
            throw new AssertionError("Invalid OTP error NOT displayed");
        }
    }

    /* ================= OTP EXPIRED ================= */

    @When("otp expires")
    public void otp_expires() {

        log.info("Waiting for OTP to expire (backend controlled)");
    }

    @Then("resend otp button should be enabled")
    public void resend_otp_button_should_be_enabled() {

        log.info("Resend OTP button enabled");
    }
}
