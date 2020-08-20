package steps;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class listbox {
	
	
	public WebDriver driver;
	 
    
	
	String driverPath = "C:\\Program Files (x86)/chromedriver.exe";
	@Given("^I login to the application$")
	
	
	public void i_login_to_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		String baseUrl = "https://www.seleniumeasy.com/test/";
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]")))
				.click();
	}
	
	@Given("^I click on list box tab$")
	public void i_click_on_list_box_tab() throws Throwable {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'List Box')]")).click();
	}

	// wrong count value is being displayed
	@Then("^I verify three drop down values are getting displayed$")
	public void i_verify_three_drop_down_values_are_getting_displayed() throws Throwable {
		List<WebElement> elements = driver.findElements(
				By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']//li"));
		System.out.println("count is" + elements.size());
		
	}

	@Given("^I click on bootstrap list box$")
	public void i_click_on_bootstrap_list_box() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap List Box')]")).click();
	}

	@When("^I select some results bootstrap-duallist$")
	public void i_select_some_results_bootstrap_duallist() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'bootstrap-duallist')]")));
		
		driver.findElement(By.xpath("//li[contains(text(),'bootstrap-duallist')]")).click();
	}

	@When("^I press the shift elements button$")
	public void i_press_the_shift_elements_button() throws Throwable {
		driver.findElement(By.xpath(
				"//div[@class='list-arrows col-md-1 text-center']/descendant::button[@class='btn btn-default btn-sm move-right']"))
				.click();
	}

	
	@Then("^I verify the resultsbootstrap-duallist are shifted$")
	public void i_verify_the_resultsbootstrap_duallist_are_shifted() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='well']/descendant::ul[@class='list-group']//li[contains(text(),'bootstrap-duallist')]")));
		
		
		WebElement first = driver.findElement(By.xpath(
				"//div[@class='well']/descendant::ul[@class='list-group']//li[contains(text(),'bootstrap-duallist')]"));
		Assert.assertEquals(true, first.isDisplayed());
		driver.close();
	}

	

	@Given("^I click on data list filter tab$")
	public void i_click_on_data_list_filter_tab() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Data List Filter')]")).click();
	}

	@Given("^I enter a value Tyreese Burn$")
	public void i_enter_a_value_Tyreese_Burn() throws Throwable {
		Object search = driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@id='input-search']"));
		((WebElement) search).sendKeys("Tyreese Burn");
	}

	@Then("^I verify the resultsTyreese Burn are shown$")
	public void i_verify_the_resultsTyreese_Burn_are_shown() throws Throwable {

		List<WebElement> textDemo = driver.findElements(By.xpath("//*[contains(text(),'Tyreese Burn')]"));
		System.out.println("Number of web elements: " + textDemo.size());
		if (textDemo.size() > 0) {
			System.out.println("element Tyreese Burn is present");
		} else {
			System.out.println("element Tyreese Burn is absent");
		}
		driver.close();
	}

	@Given("^I enter a value manager$")
	public void i_enter_a_value_manager() throws Throwable {
		Object search = driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@id='input-search']"));
		((WebElement) search).sendKeys("manager");
	}

	@Then("^I verify the resultsmanager are shown$")
	public void i_verify_the_resultsmanager_are_shown() throws Throwable {
		List<WebElement> textDemo = driver.findElements(By.xpath("//*[contains(text(),'Manager')]"));
		System.out.println("Number of web elements: " + textDemo.size());
		if (textDemo.size() > 0) {
			System.out.println("element manager is present");
		} else {
			System.out.println("element manager is absent");
		}
		driver.close();
	}

	@Given("^I enter a value (\\d+)-(\\d+)-(\\d+)$")
	public void i_enter_a_value(int arg1, int arg2, int arg3) throws Throwable {
		Object search = driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@id='input-search']"));
		((WebElement) search).sendKeys("980-543-3333");
	}

	@Then("^I verify the results(\\d+)-(\\d+)-(\\d+) are shown$")
	public void i_verify_the_results_are_shown(int arg1, int arg2, int arg3) throws Throwable {
		List<WebElement> textDemo = driver.findElements(By.xpath("//*[contains(text(),'980-543-3333')]"));
		System.out.println("Number of web elements: " + textDemo.size());
		if (textDemo.size() > 0) {
			System.out.println("element 980-543-3333 is present");
		} else {
			System.out.println("element 980-543-3333 is absent");
		}
		driver.close();
	}

	@Given("^I enter a value test(\\d+)@company\\.com$")
	public void i_enter_a_value_test_company_com(int arg1) throws Throwable {
		Object search = driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@id='input-search']"));
		((WebElement) search).sendKeys("test5@company.com");
	}

	@Then("^I verify the resultstest(\\d+)@company\\.com are shown$")
	public void i_verify_the_resultstest_company_com_are_shown(int arg1) throws Throwable {
		List<WebElement> textDemo = driver.findElements(By.xpath("//*[contains(text(),'test5@company.com')]"));
		System.out.println("Number of web elements: " + textDemo.size());
		if (textDemo.size() > 0) {
			System.out.println("element test5@company.com is present");
		} else {
			System.out.println("element test5@company.com is absent");
		}
		driver.close();
	}

	@Given("^I click on JQuery$")
	public void i_click_on_JQuery() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'JQuery List Box')]")).click();
	}

	@Given("^I select a result Alice$")
	public void i_select_a_result_Alice() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Alice')]")));
		
		driver.findElement(By.xpath("//option[contains(text(),'Alice')]")).click();
	}

	@Given("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='pAdd btn btn-primary btn-sm']")).click();
	}

	@Then("^I verify result Alice is added$")
	public void i_verify_result_Alice_is_added() throws Throwable {
		try {
			WebElement third = driver.findElement(By.xpath(
					"//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'Alice')]"));
			Assert.assertEquals(true, third.isDisplayed());
		} catch (AssertionError e) {
			System.out.println("Alice is absent");
			throw e;
		}
		System.out.println("Alice is present");

	}




	@When("^I select a resultAlice$")
	public void i_select_a_resultAlice() throws Throwable {
		driver.findElement(By.xpath(
				"//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'Alice')]")).click();
	}

	@When("^I click on remove$")
	public void i_click_on_remove() throws Throwable {
		driver.findElement(By.xpath("//button[@class='pRemove btn btn-primary btn-sm']")).click();
	}

	@Then("^I verify the element Aliceis removed$")
	public void i_verify_the_element_Aliceis_removed() throws Throwable {
		List elements =driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'Alice')]"));
		if(elements.size()==0){
		    System.out.println("Element Alice has been removed");

		 } else {
		    System.out.println("Alice has not been removed");
		 }
		driver.close();
	}



	
	@When("^I click on addall button$")
	public void i_click_on_addall_button() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='pAddAll btn btn-primary btn-sm']")));
			
	   driver.findElement(By.xpath("//button[@class='pAddAll btn btn-primary btn-sm']")).click();}
		catch(NoSuchElementException e) {
			System.out.println("No such element- add all");
		}
	}

	

	@Then("^when I click on removeall button$")
	public void when_I_click_on_removeall_button() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='pRemoveAll btn btn-primary btn-sm']")));
			
	driver.findElement(By.xpath("//button[@class='pRemoveAll btn btn-primary btn-sm']")).click();  }
		catch(NoSuchElementException e) {
			System.out.println("no such element excpetion- remove all");
		}
	}

	@Then("^I verify that all the results are added$")
	public void i_verify_that_all_the_results_are_added() throws Throwable {
		List<WebElement> elements = driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option"));
		System.out.println("count of elements after the action Addall " + elements.size());
		if(elements.size()==15) {
			System.out.println("All elements ADDED");
		}
		else {
			System.out.println("All elements NOT Added");
		}
		
	}

	@Then("^I verify  all the results are removed$")
	public void i_verify_all_the_results_are_removed() throws Throwable {
		List<WebElement> links = driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option"));
		System.out.println("count of elements after the action RemoveAll " + links.size());
		if(links.size()>0) {
			System.out.println("All elements NOT removed");
		}
		else {
			System.out.println("All elements have been removed");
		}
		
		driver.close();
	}
	
}

