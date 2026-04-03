package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import hooks.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Login step definitions with logging
 */
public class LoginSteps {

    // Logger object
    private static final Logger log =
            LoggerFactory.getLogger(LoginSteps.class);

    @Given("user opens PSB application")
    public void user_opens_psb_application() {
        log.info("STEP STARTED: user opens PSB application");
        log.info("Current URL: {}", Hooks.driver.getCurrentUrl());
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

        log.info("STEP STARTED: user enters valid username and password");

        String username = Hooks.prop.getProperty("username");
        String password = Hooks.prop.getProperty("password");

        log.info("Username from config: {}", username);
        log.info("Password from config: {}", password);

        Hooks.loginPage.enterUsername(username);
        log.info("Username entered");

        Hooks.loginPage.enterPassword(password);
        log.info("Password entered");
    }

    @When("user enters captcha manually")
    public void user_enters_captcha_manually() {

        log.info("STEP STARTED: user enters captcha manually");

        int wait = Integer.parseInt(Hooks.prop.getProperty("captcha.wait"));
        log.info("Waiting {} seconds for captcha", wait);

        Hooks.loginPage.waitForCaptcha(wait);
        log.info("Captcha wait completed");
    }

    @When("user clicks login")
    public void user_clicks_login() {

        log.info("STEP STARTED: user clicks login");

        Hooks.loginPage.clickLogin();
        log.info("Login button clicked");
    }

    @Then("otp page should be displayed")
    public void otp_page_should_be_displayed() {
        log.info("OTP page should be displayed");
    }
}
