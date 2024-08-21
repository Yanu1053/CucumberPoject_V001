package pageObjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LoginPage {

	public WebDriver ldriver;
	WaitHelper WaiteHepler;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		WaiteHepler = new WaitHelper(ldriver);
	}

	By Email =By.xpath("//input[@id='Email']");
	By Password = By.xpath("//input[@id='Password']");
	By LoginButton = By.xpath("//button[@class='button-1 login-button']");
	By LogOutmentButton = By.xpath("//*[contains(@href,'logout')]");

	// @FindBy(id = "Email")
	// WebElement Email;

	public void setUserName(String username) {
		//Email.clear();
		//Email.sendKeys(username);
		ldriver.findElement(Email).clear();
		ldriver.findElement(Email).sendKeys(username);
	}

	public void setPassword(String UserPassword) {
		//Password.clear();
		//Password.sendKeys(UserPassword);
		ldriver.findElement(Password).clear();
		ldriver.findElement(Password).sendKeys(UserPassword);

	}

	public void clicklogin() {
		//LoginButton.click();
		ldriver.findElement(LoginButton).click();
		
	}

	public void logout() {
		//LogOutButton.click();
		ldriver.findElement(LogOutmentButton);

	}
	
	
}
