package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;

	@Test
	public void fourTest() throws IOException, InterruptedException {
		
	    System.out.println("bipin has updated this code with this statement");
	    
		System.out.println("TestFour");
	    driver = intializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(3000);
        Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void closingBrowser() {
		
        driver.close();
	}
}
