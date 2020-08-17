package steps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class datep {
	WebDriver driver = null;
	String driverPath = "C:\\Program Files (x86)/chromedriver.exe";
	@Given("^I log in the application$")
	public void i_log_in_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		String baseUrl = "https://www.seleniumeasy.com/test/";
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]"))).click();
	}
	

	


@Given("^I click on Date picker tab$")
public void i_click_on_Date_picker_tab() throws Throwable {
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Date pickers')]")).click();
}

@Then("^I verify (\\d+) valuesBootstrap Date Picker are being displayed$")
public void i_verify_valuesBootstrap_Date_Picker_are_being_displayed(int arg1) throws Throwable {
	try {
		WebElement bdp = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]"));
		System.out.println("element Bootstrap Date picker is present");
	} catch (NoSuchElementException e) {
		System.out.println("element Bootstrap Date picker is ABSENT");
	}
	driver.close();
}

@Then("^I verify (\\d+) valuesJQuery Date Picker are being displayed$")
public void i_verify_valuesJQuery_Date_Picker_are_being_displayed(int arg1) throws Throwable {
	try {
		WebElement bdp = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'JQuery Date Picker')]"));
		System.out.println("element JQuery Date Picker is present");
	} catch (NoSuchElementException e) {
		System.out.println("element JQuery Date Picker is ABSENT");
	}
	driver.close();
}

@Given("^I click on JQuery Date Picker$")
public void i_click_on_JQuery_Date_Picker() throws Throwable {
	driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'JQuery Date Picker')]")).click();
}

@Given("^I select a month Feb and a date(\\d+) in start$")
public void i_select_a_month_Feb_and_a_date_in_start(int arg1) throws Throwable {
	driver.findElement(By.xpath(" //div[@class='panel-body']//input[@id='from']")).click();
	driver.findElement(By.xpath(" //select[@class='ui-datepicker-month']//option[contains(text(),'Feb')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-handler='selectDay']//a[contains(text(),14)]"))).click();

}

@Then("^I verify months beforeFeb and date(\\d+) is disabled$")
public void i_verify_months_beforeFeb_and_date_is_disabled(int arg1) throws Throwable {
	driver.findElement(By.xpath("//div[@class='panel-body']//input[@id='to']")).click();
	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
	
	List<WebElement> elements = driver.findElements(By.xpath("//select[@class='ui-datepicker-month']//option"));

	if(elements.size()!=12) {
		System.out.println("Months before February DISABLED");

	}
	else
	{
		System.out.println("Months before February  have not been disabled");

	}
	driver.findElement(By.xpath("//div[@class='panel-body']//input[@id='to']")).click();
	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
	driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@value='1']")).click();

	
	List x = driver.findElements(By.xpath("//td[@data-handler='selectDay']//a[contains(text(),'10')]"));
	if(x.size()==0) {
		System.out.println("dates disabled before February 14");
	}
	else
	{
		System.out.println("Dates before February 14 have not been disabled");

	}
	
driver.close();

}

@Given("^I select a month Oct and a date(\\d+) in end$")
public void i_select_a_month_Oct_and_a_date_in_end(int arg1) throws Throwable {
   driver.findElement(By.xpath("//div[@class='panel-body']//input[@id='to']")).click();
   driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@value='9']")).click();
   driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[contains(text(),'3')]")).click();
   
}

@Then("^I verify months afterOct and (\\d+) is disabled$")
public void i_verify_months_afterOct_and_is_disabled(int arg1) throws Throwable {

	driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Date pickers')]")).click();

	driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'JQuery Date Picker')]")).click();
	
	 driver.findElement(By.xpath("//div[@class='panel-body']//input[@id='to']")).click();
	   driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@value='9']")).click();
	   driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[contains(text(),'3')]")).click();
	   
	 driver.findElement(By.xpath("//div[@class='panel-body']//input[@name='from']")).click();
	    driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
	    List<WebElement> elements = driver.findElements(By.xpath("//select[@class='ui-datepicker-month']//option"));

		if(elements.size()<=10) {
			System.out.println("Months before October DISABLED");

		}
		else
		{
			System.out.println("Months before October  have not been disabled");

		}
		 driver.findElement(By.xpath("//div[@class='panel-body']//input[@name='from']")).click();
		    driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
			driver.findElement(By.xpath(" //select[@class='ui-datepicker-month']//option[contains(text(),'Oct')]")).click();
			List b = driver.findElements(By.xpath("//td[@data-handler='selectDay']//a"));
			if(b.size()<4) {
				System.out.println("dates disabled after October 03");

			}
			else
			{
				System.out.println("Dates after October 03 have not been disabled");

			}
	    driver.close();
}


@Given("^I click on Bootstrap date picker tab$")
public void i_click_on_Bootstrap_date_picker_tab() throws Throwable {
    driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]")).click();
}

@Given("^I click on calender in dateeg$")
public void i_click_on_calender_in_dateeg() throws Throwable {
  driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy")).click();
}

@Given("^I click on today$")
public void i_click_on_today() throws Throwable {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@class='today']"))).click();
  
}

@Then("^I verify today's date is being displayed$")
public void i_verify_today_s_date_is_being_displayed() throws Throwable {
	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 Date date = new Date();
	 String date1= format.format(date);
	 System.out.println("todays date is "+ date1);
	  
//	 String date2 = driver.findElement(By.xpath("//div[@class='input-group date']//input")).getText();
//	 
//	 System.out.println("i am printing datee2"+date2);
//
//
//	 Date a = format.parse(date1);
//	 Date b = format.parse(date2);
//
//	 if (date1.compareTo(date2) == 0) {
//	     System.out.println("Dates are same");
//	 }
//	 else {
//		 System.out.println("Dates are different");
//	 }
	 
}

@Then("^I click on clear$")
public void i_click_on_clear() throws Throwable {
	  driver.findElement(By.xpath("//span[@class='input-group-addon']//i[@class='glyphicon glyphicon-th']")).click();
    driver.findElement(By.xpath("//th[@class='clear']")).click();
}

@Then("^I verify the field is empty$")
public void i_verify_the_field_is_empty() throws Throwable {
	WebElement inputBox = driver.findElement(By.xpath("//div[@class='input-group date']//input"));
	String text = inputBox.getText();
	if(text.isEmpty())
	{
		System.out.println("Field has been cleared");
	}
	driver.close();
}


@Given("^I verify all future year and month is disbaled$")
public void i_verify_all_future_year_and_month_is_disbaled() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver,25 );
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='glyphicon glyphicon-th']"))).click();

    System.out.println("All months after august");
   
    WebDriverWait wait1 = new WebDriverWait(driver, 20);
	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'August 2020')]"))).click();

    List<WebElement> lstOpt =  driver.findElements(By.xpath("//span[@class='month disabled']"));
    List<String> strings = new ArrayList<String>();
    for(WebElement e : lstOpt){
        strings.add(e.getText());
    }
    System.out.println(strings);
   System.out.println("heloooooo");
	driver.findElement(By.xpath("//th[contains(text(),'2020')]")).click();

   List<WebElement> two =  driver.findElements(By.xpath("//span[@class='year disabled']"));
   List<String> str2 = new ArrayList<String>();
   for(WebElement e : two){
       str2.add(e.getText());
   }
   System.out.println("list of years disabled after 2020");
   System.out.println(str2);
	
	
   driver.close();
}


}
