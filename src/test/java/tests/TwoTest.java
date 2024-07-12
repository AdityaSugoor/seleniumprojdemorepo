package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void testTwo() throws IOException, InterruptedException {

		System.out.println("Adi updated this")
		System.out.println("TestTwo");
	    driver = intializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(3000);
		driver.close();
		
	}

}
