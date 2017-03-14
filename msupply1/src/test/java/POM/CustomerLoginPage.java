package POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import GenericLibrary.LogReports;
import Scenarios.Scenario1Test;

public class CustomerLoginPage {
	
	static Logger log = LogReports.writeLog(CustomerLoginPage.class);
	
	public static void loginProcess(String userName, String password){
		
		
		Scenario1Test.driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(userName);
		log.info("User name entered");
		
		Scenario1Test.driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		log.info("Password entered");
		Scenario1Test.driver.findElement(By.xpath("html/body/ng-include/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/form/div[5]/button")).click();
		
		log.info("Login button clicked");
	}

}
