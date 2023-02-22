package steps;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestBase;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackgroundStepDefs extends TestBase {
    public WebDriver driver;
    public String url = "https://techfios.com/test/101/";

    @Given("Set SkyBlue Background button exists")
    public void set_skyblue_background_button_exists() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\simou\\eclipse-workspace\\Cucumber Nassim\\CucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Check that the "Set SkyBlue Background" button exists
        WebElement button = driver.findElement(By.cssSelector("button[onclick='myFunctionSky()']"));
        Assert.assertTrue(button.isDisplayed());
    }

    @When("I click on the button")
    public void i_click_on_the_button() throws InterruptedException {
        // Click the "Set SkyBlue Background" button
        WebElement button = driver.findElement(By.cssSelector("button[onclick='myFunctionSky()']"));
//        Thread.sleep(500);
        button.click();
    }

    @Then("the background color will change to sky blue")
    public void the_background_color_will_change_to_sky_blue() throws Exception {
        // Check that the background color has changed to sky blue
        String bgColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
        System.out.println(bgColor);
        Assert.assertEquals("rgba(135, 206, 235, 1)", bgColor);
        System.out.println("background turned skyblue");
//        Thread.sleep(2000);
        takeScreenshot(driver);
        
    }

    @Given("Set SkyWhite Background button exists")
    public void set_skywhite_background_button_exists() {
        // Set up the WebDriver and navigate to the test page
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\simou\\eclipse-workspace\\Cucumber Nassim\\CucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Check that the "Set SkyWhite Background" button exists
        WebElement button = driver.findElement(By.cssSelector("button[onclick='myFunctionWhite()']"));
        Assert.assertTrue(button.isDisplayed());
    }

    @When("I click on the button 2")
    public void i_click_on_the_button_2() throws InterruptedException {
    	i_click_on_the_button() ;
        // Click the "Set SkyWhite Background" button
        WebElement button = driver.findElement(By.cssSelector("button[onclick='myFunctionWhite()']"));
//        Thread.sleep(2000);
        button.click();
    }

    @Then("the background color will change to white")
    public void the_background_color_will_change_to_white() throws InterruptedException {
        // Check that the background color has changed to white
    	String bgColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
        
        
        System.out.println("background turned white");
//        Thread.sleep(2000);
        takeScreenshot(driver);
        
        Assert.assertEquals("rgba(255, 255, 255, 1)", bgColor);
        
    }
   
    	  
  		  
  	
    
	@After
	public void tearDown() {
	driver.close();
		driver.quit();
	}

}
