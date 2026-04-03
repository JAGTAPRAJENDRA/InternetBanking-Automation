package pages.fundtransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstaPayPage {
	

	    WebDriver driver;

	    public InstaPayPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By accountNo = By.id("account");
	    By confirmAccount = By.id("confirmAccount");
	    By amount = By.id("amount");
	    By remarks = By.id("remarks");
	    By submit = By.id("submit");

	    public void enterPaymentDetails(String acc, String amt) {
	        driver.findElement(accountNo).sendKeys(acc);
	        driver.findElement(confirmAccount).sendKeys(acc);
	        driver.findElement(amount).sendKeys(amt);
	        driver.findElement(remarks).sendKeys("TEST");
	    }

	    public void submitPayment() {
	        driver.findElement(submit).click();
	    }
	}

