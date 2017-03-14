package POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.LogReports;
import Scenarios.Scenario1Test;

public class ProductListPage {
	
 static Logger log = LogReports.writeLog(ProductListPage.class);
	public static AskForQuotePage selectingProduct(){
		
		Scenario1Test.driver.findElement(By.xpath("(//div[@class = 'products-wrapper']/div/a/following-sibling::div/button[text()='Request for Quote'])[1]")).click();
		log.info("Product selected");
		return PageFactory.initElements(Scenario1Test.driver, AskForQuotePage.class);
	}
}
