 package Functional_TestCase_HomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.CommonFunctions;
import GenericLibrary.Credentials;
import GenericLibrary.WebDriverCommonFunctions;
import POM.AdminPanel;
import POM.AskForQuotePage;
import POM.CustomerLoginPage;
import POM.HomePage;
import POM.ProductListPage;
import POM.SupplierDashboardPage;
import POM.SupplierEnquiryListPage;
import POM.SupplierLoginPage;
import POM.SupplierMyProfilePage;
import Scenarios.Scenario1Test;

public class HomePageTest extends Scenario1Test
{

	private SupplierLoginPage slp;
	private CustomerLoginPage clp;
	private ProductListPage plp;
	
	private AskForQuotePage afqp;
	
	
	@DataProvider(name="credentialsProvider")
	public static Object[][] getCredentialsData(){
		return new Object[][] { { "9900514935", "123qwe" }};
	}
	
	
	@Test(dataProvider="credentialsProvider")
	public void askForQuoteTest(String userId, String password) throws Throwable{
		
		clp = HomePage.clickOnCustomerLogin();
		CustomerLoginPage.loginProcess(userId, password);
		Thread.sleep(2000);
		plp = HomePage.selectingCategory();
		Thread.sleep(2000);
		afqp = ProductListPage.selectingProduct();
		Thread.sleep(2000);
		AskForQuotePage.fillEnquiryForm();
		//Scenario1Test.driver.close();
		/*Credentials.url=CommonFunctions.readPropertiesFile("AdminPanel");
		Scenario1Test.driver.get(Credentials.url);*/
		
		Scenario1Test.driver.navigate().to("http://internal.stg.msupply.com/");
		AdminPanel.internalPanelLogin();
	}
	
	
}
