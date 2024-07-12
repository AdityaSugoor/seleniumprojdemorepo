package stepdefinationf;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

      

public class Login extends Base {
	
	 WebDriver driver;
	 LandingPage landingPage;
	 LoginPage loginPage;
	
	@Given("^Open any Browser$")
	public void Open_any_Browser() throws IOException {
		
		driver = intializeDriver();
	}
	
	
	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() {
		
		driver.get(prop.getProperty("url"));
	    landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
	}
	
	
	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password) {
	    loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		
		
	}
	
	@And("^User clicks on the login button$")
	public void User_clicks_on_the_login_button() {
		
		loginPage.loginButton().click();
		
		
	}
	
	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
		
	}
	
	@After
	public void closeBrowser() {
		
		driver.close();
	}
	

}
