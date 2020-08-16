package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class openGoogle extends listbox {

@Given("^I click on Progress Bar Tab$")
public void i_click_on_Progress_Bar_Tab1() throws Throwable {
    driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/a")).click();
    System.out.println(". I clicked on Progress Bar Tab");
}

@Then("^I verify three drop-down values are getting displayed$")
public void i_verify_three_drop_down_values_are_getting_displayed() throws Throwable {
	 List<WebElement> listOptionDropdown = driver.findElements(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/ul/li"));

	 

     int dropdownCount = listOptionDropdown.size();
     if(dropdownCount==3) {
     	System.out.println(". Three drop-down values are displayed");
         driver.close();
     }
     else {
     	System.out.println(". Three drop-down values are NOT displayed");}
         driver.close();

}




@When("^I click on sub tab JQuery Download Progress bars$")
public void i_click_on_sub_tab_JQuery_Download_Progress_bars1() throws Throwable {
	 driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/ul/li[1]/a")).click();
}

@Then("^I verify text on webpage \"([^\"]*)\"is \"([^\"]*)\"$")
public void i_verify_text_on_webpage_is(String arg1, String arg2) throws Throwable {
	String str=driver.findElement(By.xpath(arg1)).getText();
    if(str.equals(arg2))
    {
	    System.out.println(". I verified text on web page is same as expected");
    }
    else
    {
	    System.out.println(". I verified text on web page is NOT same as expected");
    }
    driver.close();
}



@Then("^I click on Start Download button$")
public void i_click_on_Start_Download_button() throws Throwable {
    driver.findElement(By.xpath("//*[@id=\"downloadButton\"]")).click();
}

@Then("^I verify download status is complete before clicking close button$")
public void i_verify_download_status_is_complete_before_clicking_close_button() throws Throwable {
	Thread.sleep(10000);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dialog\"]/div[1]")));
	String status=driver.findElement(By.xpath("//*[@id=\"dialog\"]/div[1]")).getText();
	if(status.equals("Complete!"))
	{
	     System.out.println(". I verified download status is complete before clicking close button");
	}
	else
	{
		System.out.println(". I verified download status is NOT complete before clicking close button");
	}
}

@Then("^I click on Close button$")
public void i_click_on_Close_button() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/button"))).click();
    System.out.println(". I clicked on Close button"); 
    driver.close();
}
/////Scenario - 5
@When("^I click on sub tab Bootstrap Progress Bar$")
public void i_click_on_sub_tab_Bootstrap_Progress_Bar() throws Throwable {
    driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/ul/li[2]/a")).click();
}

//@Given("^I click on sub tab Bootstrap Progress Bar$")
//public void i_click_on_sub_tab_Bootstrap_Progress_Bar1() throws Throwable {
//	 driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/ul/li[2]/a")).click();
//}

@Then("^I verify initial value of progress bar is \"([^\"]*)\"$")
public void i_verify_initial_value_of_progress_bar_is(String arg1) throws Throwable {
	if((driver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]")).getText()).equals(arg1))
	{
		System.out.println(". I verified initial value of progress bar is 0%"); 
	}
	else
	{
		System.out.println(". I verify initial value of progress bar is NOT 0%"); 
	}
}

@Given("^I click on Downloadsize:(\\d+)kb button$")
public void i_click_on_Downloadsize_kb_button(int arg1) throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"cricle-btn\"]")).click();
}

@Then("^I verify the progress bar stops at (\\d+)%$")
public void i_verify_the_progress_bar_stops_at(int arg1) throws Throwable {
	 WebDriverWait wait = new WebDriverWait(driver, 20);
     wait.until(new ExpectedCondition<Boolean>() {
     	public Boolean apply(WebDriver webDriver) {
     		return driver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]")).getText().equals("100%");
     	}
     });
 if((driver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]")).getText()).equals("100%"))
 {
 	System.out.println(". I verified that the progress bar stops at 100%");
 }
 else
 {
 	System.out.println(". I verified that the progress bar NOT stops at 100%");
 }
 driver.close();
}

@Given("^I click on sub tab Drag and Drop Slider$")
public void i_click_on_sub_tab_Drag_and_Drop_Slider() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[1]/ul/li[3]/a")).click();
}


}

