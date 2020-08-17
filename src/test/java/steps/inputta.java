package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class inputta {
	WebDriver driver = null;
	WebElement element;
	String driverPath = "C:\\Program Files (x86)/chromedriver.exe";
	@Given("^I login$")
	public void i_login() throws Throwable {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		String baseUrl = "https://www.seleniumeasy.com/test/";
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]"))).click();

	}
	
	@Given("^I click on input forms tab$")
	public void i_click_on_input_forms_tab() throws Throwable {
	   driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Input Forms')]")).click();
	}

	@Given("^I click on simple form demo$")
	public void i_click_on_simple_form_demo() throws Throwable {
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Simple Form Demo')]")).click();

	}

	@Given("^I click on enter message aparna$")
	public void i_click_on_enter_message_aparna() throws Throwable {
	  element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']//input[@id='user-message']")));
		element.sendKeys("aparna");
	}

	@Then("^I verify aparna is displayed$")
	public void i_verify_aparna_is_displayed() throws Throwable {
	    driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
	    element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"display\"]")));
		String val=element.getAttribute("innerText");
		Assert.assertEquals("aparna", val); 
	}

	@Given("^I enter (\\d+) values (\\d+) (\\d+)$")
	public void i_enter_values(int arg1, int arg2, int arg3) throws Throwable {
	element =driver.findElement(By.xpath("//input[@id='sum1']"));
	element.sendKeys("10");
	element =driver.findElement(By.xpath("//input[@id='sum2']"));
	element.sendKeys("20");
	}

	@Given("^I click on total$")
	public void i_click_on_total() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();
	}

	@Then("^I verify the result(\\d+)$")
	public void i_verify_the_result(int arg1) throws Throwable {
		
		element=new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='displayvalue']")));
		String val=element.getAttribute("innerText");
		int val1=Integer.parseInt(val);
		if(val1==30)
		{
			System.out.println("Correct Sum");
		}
		else {
			System.out.println("Incorrect sum");
		}
	}

	@Given("^I enter (\\d+) values apa rna$")
	public void i_enter_values_apa_rna(int arg1) throws Throwable {
		element =driver.findElement(By.xpath("//input[@id='sum1']"));
		element.sendKeys("apa");
		element =driver.findElement(By.xpath("//input[@id='sum2']"));
		element.sendKeys("rna");
	}

	@Then("^I verify the resultNaN$")
	public void i_verify_the_resultNaN() throws Throwable {
		element=new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='displayvalue']")));
		String val=element.getAttribute("innerText");
	
		if(val.equals("NaN")) {
			System.out.println("output for apa rna sum is CORRECT");
		}
		else
			System.out.println("output for apa rna sum is INCORRECT");

	}

	@Given("^I click on checkbox demo$")
	public void i_click_on_checkbox_demo() throws Throwable {
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Checkbox Demo')]")).click();
	}

	@Given("^I press on singlecheckbox$")
	public void i_press_on_singlecheckbox() throws Throwable {
	driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
	
	}

	@Then("^I verify if it has been checked$")
	public void i_verify_if_it_has_been_checked() throws Throwable {
		if( driver.findElement(By.xpath("//div[@id='txtAge']")).isDisplayed()){
			System.out.println("Element is Visible");
			}
	}

	@Given("^I click on checkall$")
	public void i_click_on_checkall() throws Throwable {
	driver.findElement(By.xpath("//input[@value='Check All']")).click();
	}

	@Then("^I verify if all (\\d+)options are checked$")
	public void i_verify_if_all_options_are_checked(int arg1) throws Throwable {
		WebElement checkbox1 = driver.findElement(By.xpath("//label[text()='Option 1']//input[@class='cb1-element']"));
		if(!checkbox1.isSelected())
		    {
			System.out.println("option 1 unchecked");
		    }
		WebElement checkbox2 = driver.findElement(By.xpath("//label[text()='Option 2']//input[@class='cb1-element']"));
		if(!checkbox2.isSelected())
		    {
			System.out.println("option 2 unchecked");
		    }
		WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Option 3']//input[@class='cb1-element']"));
		if(!checkbox2.isSelected())
		    {
			System.out.println("option 3 unchecked");
		    }
		
		WebElement checkbox4 = driver.findElement(By.xpath("//label[text()='Option 4']//input[@class='cb1-element']"));
		if(!checkbox2.isSelected())
		    {
			System.out.println("option 4 unchecked");
		    }
		

	}

}
