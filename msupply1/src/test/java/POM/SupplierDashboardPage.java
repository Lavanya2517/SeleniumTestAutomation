package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;

public class SupplierDashboardPage {
	
	public static SupplierEnquiryListPage navigateToSupplierEnquiryListPage() throws Throwable{
		
		WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to SupplierEnquiryListPage");
		WebDriverCommonFunctions.element_Click("SupplierMyenquiryList_Link", "My enquiries link clicked");
		return PageFactory.initElements(Scenario1Test.driver,SupplierEnquiryListPage.class);
		
	}
	
	public static SupplierMyProfilePage navigateToMyProfilePage()throws Throwable{
		
		WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to SupplierMyProfilePage");
		/*WebDriverCommonFunctions.element_MouseOver("MyProfile_Link", "Mouseover to MyProfile");
		WebDriverCommonFunctions.element_Click("Supplier_Profile_Link", "Profile link clicked");*/
		WebElement elemt = Scenario1Test.driver.findElement(By.xpath("//div[@class='enq-menubar']//li/a[text()='My Profile']"));
		Actions act = new Actions(Scenario1Test.driver);
		act.moveToElement(elemt).perform();
		Scenario1Test.driver.findElement(By.xpath("(//div[@class='enq-menubar']//li/a[text()='My Profile']/following-sibling::ul/li)[1]/a"))
		.click();
		return PageFactory.initElements(Scenario1Test.driver, SupplierMyProfilePage.class);
	}

}
