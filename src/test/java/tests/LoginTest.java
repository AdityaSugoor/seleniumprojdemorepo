package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData") 
	public void login(String email, String password, String expectedResult) throws IOException {
		
	    
		

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on myAccountDropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email address got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on login button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
		
		try {
			if(accountPage.editAccountInformationOption().isDisplayed()) {
			actualResult="Successfull";
			log.debug("user got logged in");
			}
		}catch(Exception e) {
			
			log.debug("user did not logged in");
			actualResult="Failure";
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got passed");
		
	}
	
	@BeforeMethod
	public void openApplicatoin() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		 driver = intializeDriver();
		 log.debug("Browser got launched");
		 driver.get(prop.getProperty("url"));
		 log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		log.debug("browser got closed");
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"aditya.123@gmail.com", "@Pass01word", "Successfull"}, {"dummy@test.com", "@password", "Failure"}};
		
		return data;


	}

}
