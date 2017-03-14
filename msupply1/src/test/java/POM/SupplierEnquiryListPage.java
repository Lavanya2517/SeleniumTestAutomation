package POM;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import GenericLibrary.CommonFunctions;
import GenericLibrary.LogReports;
import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SupplierEnquiryListPage {
	
	static Logger log = LogReports.writeLog(SupplierEnquiryListPage.class);
	
	public static void myEnquiriesDetail() throws Throwable{
		
		WebDriverCommonFunctions.element_Click("FromDate_pop_up", "from date date_picker link clicked");
		for (int i = 0; i < 3; i++) {
			if (WebDriverCommonFunctions.element_GetTextFromLabel("DatePicker_Month").contains("January")) {				
				break;
			}
			else {				
				WebDriverCommonFunctions.element_Click("DatePicker_previewMonth", "Moving to previous month");
				//WebDriverCommonFunctions.element_Click("DatePicker_previewMonth", "Moving to previous month");
			}
		}
		WebDriverCommonFunctions.element_Click("selectingFrom_date", "1st January selected");
		WebDriverCommonFunctions.element_Click("ToDate_pop_up", "DatePicker to select current date clicked");
		selectingDate("24");
		
		//WebDriverCommonFunctions.element_Click("selectingTo_date", "Todays date selected");
		WebDriverCommonFunctions.element_Click("DatePicker_forwardLink", "after selecting date from date picker, next link clicked");
		WebDriverCommonFunctions.element_Click("Actions_viewEnquiry_1st", "Clicked on the first action view enquiryLink");
		WebDriverCommonFunctions.element_Click("EnquiryDetails_QuoteButton", "Quote button clicked");
		//String
		for (int i = 0; i <3; i++) {
			if (WebDriverCommonFunctions.element_GetTextFromTextBox(
					"Quote_BrandName", "checking text box").equals("")) {

				WebDriverCommonFunctions.element_EnterValuesToTextField(
						"Quote_BrandName", "Dsrt", "Brand entered");
			}
		}
		
		String test2 = Scenario1Test.driver.findElement(By.xpath("//tr[@id='addBrandTbl']/td/table/tbody/tr[1]/td[1]/input")).getText();
		System.out.println(test2);
		if (isStringNullOrWhiteSpace(test2)) {
			WebDriverCommonFunctions.element_EnterValuesToTextField("Quote_BrandName", "fgb", "entered brand name");
		}
		//WebDriverCommonFunctions.element_EnterValuesToTextField("", Value, Message);
		WebDriverCommonFunctions.element_EnterValuesToTextField("Quote_BaseRate", "788", "Base value entered");
		WebDriverCommonFunctions.element_EnterValuesToTextField("Quote_VAT", "12", "Vat entered");
		WebDriverCommonFunctions.element_Click("Credit_RadioBtn", "Radio button clicked");
		WebDriverCommonFunctions.element_EnterValuesToTextField("Credit_TextBox", "7", "Credit extended for a week");
		WebDriverCommonFunctions.element_Click("QuoteDatePicker", "Datepicker icon clicked");
		WebDriverCommonFunctions.element_Click("ValiUpto_Date", "Quote valid date selected");
		WebDriverCommonFunctions.element_Click("terms_and_condition_checkbox", "terms_and_condition_accepted");
		WebDriverCommonFunctions.element_Click("Quote_SubmitButton", "Quote submitted");
		WebDriverCommonFunctions.element_Click("Quotation_succesful_OK_button", "Quotation submitted succesfully");
		WebDriverCommonFunctions.element_MouseOver("MyProfile_Link", "Moving cursor over to MyProfileLink");
		WebDriverCommonFunctions.element_Click("Supplier_Profile_Link", "Profile link clicked");
		//SupplierMyProfilePage.basicDetails();
	}
	
	
	
	public static boolean isStringNullOrWhiteSpace(String value) {
	    if (value == null) {
	        return true;
	    }

	    for (int i = 0; i < value.length(); i++) {
	        if (!Character.isWhitespace(value.charAt(i))) {
	            return false;
	        }
	    }

	    return true;
	}
	
	public static void selectingDate(String day) throws Exception{
		
		//WebDriverCommonFunctions.element_Click("DatePicker_currentMonthdates", "");
		By selDate = 
		By.xpath("(//div[@class='datepicker-days']//tbody/tr/td[not(contains(@class,'day old')) and not(contains(@class,'day disabled new'))])["+day+"]");
		
		Scenario1Test.driver.findElement(selDate).click();
		Thread.sleep(2000);
	}
	
	public static void quotePendingInquiriesList() throws Throwable{ 
		Select set;
		
		
		Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[1]/ul/li[2]/a")).click();
		//WebDriverCommonFunctions.element_Click("QuotePending_Link", "Quote Pending Link clicked");
		//List<WebElement> list = WebDriverCommonFunctions.element_Collection("PendingEnquiries_List", 0, false, "Retrieving list of inquiries pending to be quoted");
		log.info("Quote Pending Link clicked");
		
		
		selectingPaymentType("On Delivery");
		int totalEnquiries;
	
		totalEnquiries = Integer.parseInt(Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[2]/span")).getText());
		System.out.println(totalEnquiries);
	
		if (totalEnquiries < 50) {
			
			
			set = new Select(Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[3]/span/select")));
			set.selectByValue("number:50");
		}
	
		//Thread.sleep(5000);
		CommonFunctions.LoadPageExpicitWait();
		int enquiryList = Scenario1Test.driver.findElements(By.xpath("//ng-view[@class='main-view ng-scope']/div[2]/div[5]/table/tbody/tr[@class='enqheight ng-scope']/td[2]/div/div[1]/div[2]")).size();
		
		System.out.println(enquiryList);
		
		for (int i = 1; i <= enquiryList; i++) 
		{
			
			if(i>3)
			{
				JavascriptExecutor js = (JavascriptExecutor) Scenario1Test.driver;
				js.executeScript("window.scrollBy(0,250)", "");
			}
			
			String text=Scenario1Test.driver.findElement(By.xpath("(//ng-view[@class='main-view ng-scope']/div[2]/div[5]/table/tbody/tr[@class='enqheight ng-scope']/td[2]/div/div[1]/div[2])["+i+"]")).getText();
		
			System.out.println(text);
			writeToTextFile(text);
		}
	}
	
	public static void selectingPaymentType(String type) throws Throwable{
		
		Select set1;
		//set1 = new Select(WebDriverCommonFunctions.element_ReturnWebElement("SupplierWebPanel_paymentType"));
		set1 = new Select(Scenario1Test.driver.findElement(By.xpath("//div[@class='enquiry-content minHeight ng-scope']/div[3]/div/div[2]/select")));
		if (type.contains("Credit")) {
			
			set1.selectByVisibleText("Credit");
		}else {
			set1.selectByVisibleText("On Delivery");
		}
			
	}
	
	public static void writeToTextFile(String content){
		
		String filePath = "E:\\MsupplyProject\\msupply1\\target\\test-classes\\enquiriesData.txt" ;
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			bw.write(content);

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

	}
			
 }
}
	
	public static void supplierQuoteShortListed() throws Throwable{
		
		Select set;
		
		Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[1]/ul/li[4]/a")).click();
		//WebDriverCommonFunctions.element_Click("QuotePending_Link", "Quote Pending Link clicked");
		//List<WebElement> list = WebDriverCommonFunctions.element_Collection("PendingEnquiries_List", 0, false, "Retrieving list of inquiries pending to be quoted");
		log.info("Quote ShortListed Link clicked");
		
		
		selectingPaymentType("Credit");
		int totalEnquiries;
	
		totalEnquiries = Integer.parseInt(Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[2]/span")).getText());
		System.out.println(totalEnquiries);
	
		if (totalEnquiries < 50) {
			
			
			set = new Select(Scenario1Test.driver.findElement(By.xpath("html/body/div[3]/ng-view/div[2]/div[4]/div/div[3]/span/select")));
			set.selectByValue("number:50");
		}
	
		//Thread.sleep(5000);
		CommonFunctions.LoadPageExpicitWait();
		int enquiryList = Scenario1Test.driver.findElements(By.xpath("//ng-view[@class='main-view ng-scope']/div[2]/div[5]/table/tbody/tr[@class='enqheight ng-scope']/td[2]/div/div[1]/div[2]")).size();
		
		System.out.println(enquiryList);
		
		for (int i = 1; i <= enquiryList; i++) 
		{
			
			if(i>3)
			{
				JavascriptExecutor js = (JavascriptExecutor) Scenario1Test.driver;
				js.executeScript("window.scrollBy(0,250)", "");
			}
			
			String text=Scenario1Test.driver.findElement(By.xpath("(//ng-view[@class='main-view ng-scope']/div[2]/div[5]/table/tbody/tr[@class='enqheight ng-scope']/td[2]/div/div[1]/div[2])["+i+"]")).getText();
		
			System.out.println(text);
			//writeToTextFile(text);
		}
	}
}