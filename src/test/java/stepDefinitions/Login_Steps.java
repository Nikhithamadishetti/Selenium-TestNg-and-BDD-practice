package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inetbanking.pageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {
   
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webDriver.chrome.driver",System.getProperty("user")+"//Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
		lp=new LoginPage(driver);
	}
	
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	     driver.get(url);
	}

	@When("User enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) {
	    lp.setusername(email);
	    lp.setpassword(password);
	}

	@When("click on submit")
	public void click_on_submit() throws InterruptedException {
		Thread.sleep(2000);
	    lp.clicksubmit();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		//System.out.println(driver.getTitle());
		Thread.sleep(2000);
	    Assert.assertEquals(title,driver.getTitle());
	}
	
	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}



}
