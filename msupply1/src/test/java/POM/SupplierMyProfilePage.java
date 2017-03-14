package POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import GenericLibrary.LogReports;
import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;

public class SupplierMyProfilePage extends Scenario1Test {
	
	Logger log = LogReports.writeLog(SupplierMyProfilePage.class);
	
	
	public static void basicDetails() throws Throwable{
		
		WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to MyProfilePage");
		WebDriverCommonFunctions.element_EnterValuesToTextField("BasicDetails_ContactPerson", "SEWRT", "Person name entered");
		
		WebDriverCommonFunctions.element_EnterValuesToTextField("BasicDetails_mobileNo", "9900012301", "MobileNo. edited");
		WebDriverCommonFunctions.element_SelectDropDown("CompanyDetails_BusinessType", 2, "Manufaturer_Selected");
		WebDriverCommonFunctions.element_EnterValuesToTextField("FactoryAddress_AddressLine1", "Niladri Vihar", "Address edited");
		WebDriverCommonFunctions.element_SelectDropDown("FactoryAddress_SelectState", 17, "sdf");
		WebDriverCommonFunctions.element_SelectDropDown("FactoryAddress_SelectCity", 2, "bangalore");
		/*WebDriverCommonFunctions.element_SelectDropDown("FactoryAddress_SelectState", "Karnataka", 17, "Karnataka", "State changed to Karnataka");
		WebDriverCommonFunctions.element_SelectDropDown("FactoryAddress_SelectCity", "", 2, "Bangalore", "Bangalore selected");*/
		WebDriverCommonFunctions.element_Click("Use_as_InvoiceAddress", "Use as invoice address check box clicked");
		WebDriverCommonFunctions.element_Click("BasicDetails_NextButton", "Changes made in Basic details are saved");
		WebDriverCommonFunctions.element_Click("BasicDetails_NextButton", "Changes made in Basic details are saved");
	}
	
	public static void financialInformation() throws Throwable{
		
		//WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Financial Information MyProfilePage");
		WebDriverCommonFunctions.element_EnterValuesToTextField("BankInformation_AccountHolderName", "Arun", "Account Holder Name edited");
		WebDriverCommonFunctions.element_EnterValuesToTextField("BankInformation_AccountNumber", "10258975480", "Account_no. edited");
		WebDriverCommonFunctions.element_EnterValuesToTextField("BankInformation_AccountNumberConfirmation", "10258975480", "Account_no. re-entered");
		WebDriverCommonFunctions.element_EnterValuesToTextField("IFSC_code", "ICIC0458", "IFSC code entered");
		WebDriverCommonFunctions.element_SelectDropDown("Account_Type", 0, "Type changed to current account");
		WebDriverCommonFunctions.element_Click("Financial_Information_Next_Btn", "Next button clicked");
		
	}
	
	
	

}
