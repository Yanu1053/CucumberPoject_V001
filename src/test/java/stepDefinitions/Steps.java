package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.WaitHelper;

public class Steps extends BaseClass {

	public WaitHelper hp;

	@Before
	public void seup() throws IOException {

		configprop = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		configprop.load(configfile);

		// logger=Logger.getLogger("CucumberFramework1") // add logger
		// propertyConfigurator.configure("log4j.properties")

		String br = configprop.getProperty("browser");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.Chrome.driver", configprop.getProperty("chromepath"));
			driver = new ChromeDriver();
		} 
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} 
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configprop.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// logger.info("*******Launching Browser********");

	}

	@Given("User Lunch Chrome Browser")
	public void user_lunch_chrome_browser() throws Throwable {
		lp = new LoginPage(driver);

	}

	@When("User Open URL {string}")
	public void user_open_url(String URL) {
		driver.get(URL);

	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);

	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		lp.clicklogin();
		Thread.sleep(3000);

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String Title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(Title, driver.getTitle());

			Thread.sleep(3000);

		}
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() {
		lp.logout();

	}

	@Then("Close Browser")
	public void close_browser() {
		driver.quit();

	}

	@When("User Enters Email as <email> and Password as <password>")
	public void user_enters_email_as_email_and_password_as_password(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

}
