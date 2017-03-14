package POM;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;

public class SupplierLoginPage extends Scenario1Test {
	
	/*@DataProvider(name="credentialsProvider")
	public static Object[][] getCredentialsData(){
		return new Object[][] { { "reshma1", "123456" }, { "reshma1", "password" },};
	}*/
	
	
	public static SupplierDashboardPage navigateToSupplierDashboardPage(String UserId, String Password) throws Throwable{
		WebDriverCommonFunctions.element_Window_SwitchToChild("Switched");
		WebDriverCommonFunctions.element_EnterValuesToTextField("SupplierUserId", UserId, "userId entered");
		WebDriverCommonFunctions.element_EnterValuesToTextField("SupplierPassword", Password, "password entered");
		WebDriverCommonFunctions.element_Click("SupplierSignInBTN", "SignIn button clicked");
		return PageFactory.initElements(Scenario1Test.driver, SupplierDashboardPage.class);
	}
}	