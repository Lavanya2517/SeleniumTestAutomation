package POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import GenericLibrary.LogReports;
import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;

public class AskForQuotePage {
	
	static Logger log = LogReports.writeLog(AskForQuotePage.class);
	
	public static void fillEnquiryForm() throws InterruptedException{
		
		Scenario1Test.driver.findElement(By.xpath("//div[@class='AFQprodDetials']//input[@id='AFQ.quantity']")).sendKeys("100");
		log.info("Quantity entered");
		
		Thread.sleep(2000);
		
		Select select = new Select(Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//select[@id='AFQ.stateSelect']")));
		
		select.selectByVisibleText("Karnataka");
		
		log.info("Karnataka selected");
		
		
		Thread.sleep(2000);
		select = new Select(Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//select[@id='AFQ.citySelect']")));
		select.selectByVisibleText("Bangalore");
		log.info("Bangalore selected");
		
		Thread.sleep(1000);
		Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//input[@name='AFQ.pincode']")).sendKeys("560088");
		Thread.sleep(1000);
		
		log.info("Pin code entered");
		select = new Select(Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//select[@id='AFQ.payment']")));
		select.selectByVisibleText("On Credit");
		Thread.sleep(1000);
		
		log.info("Payment type selected");
		
		Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//div/i")).click();
		
		Scenario1Test.driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody/tr[5]/td[6]")).click();
		Thread.sleep(1000);
		log.info("Delivery date selected" );
		
		select = new Select(Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//select[@id='AFQ.creditDays']")));
		select.selectByVisibleText("30 days");
		Thread.sleep(1000);
		log.info("Days for credit is selected");
		Scenario1Test.driver.findElement(By.xpath("//form[@id='enquiry_form']//button")).click();
		
		Thread.sleep(3000);
		
		log.info("Validating success message");
		
		String expectedText = "Thank you for showing interest with us!" ;
		
		String actualText;
		
		actualText = Scenario1Test.driver.findElement(By.xpath("//div[@class='ng-model-dialog']//span[text()='Thank you for showing interest with us!']")).getText();
		
		Assert.assertEquals(actualText, expectedText, "Succes message is not displayed properly");
		Thread.sleep(1000);
		
		Scenario1Test.driver.findElement(By.xpath("html/body/ng-include/div/div/div[2]/div/div/div[2]/div[4]/input")).click();
		
		log.info("Enquiry submitted successfully");	
		
	}
	
	

}
