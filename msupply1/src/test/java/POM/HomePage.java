package POM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.BrowserSelection;
import GenericLibrary.CommonFunctions;
import GenericLibrary.LoadLocators;
import GenericLibrary.LogReports;
import GenericLibrary.RetrieveXlsxData;
import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;



public class HomePage extends LoadLocators
{
	static Logger log = LogReports.writeLog(HomePage.class);
	
	
	
	
	

	/*public static void SlidersVerification() throws Exception
	{
	   int Total=1;	   
	   Scenario1Test.driver.switchTo().defaultContent();
	  	   
   	   for(int j=0;j<7;j++)	
	   {	
		
		    JavascriptExecutor jse2 = (JavascriptExecutor)Scenario1Test.driver;
	        jse2.executeScript("window.scrollBy(0,250)","");
	        
	       int Price = 0;	     
		   for(int i=1;i<16;i++)
		   {			  
			  if(i==6||i==11)
			  {  
				  Scenario1Test.driver.findElement(By.xpath("(//div[@class='owl-next']/a)["+(j+1)+"]")).click();
				  Thread.sleep(1000);
			  }
			   try
			   {
				   
				   Price=(int) getNumber(Scenario1Test.driver.findElement(By.xpath("((//div[@class='price_tag wishlist_price'])["+Total+"]/span[3])")).getText());
				   Total=Total+1;
				   
			   }
			   catch(NoSuchElementException e)
			   {
				   
				   Price=(int) getNumber(Scenario1Test.driver.findElement(By.xpath("((//div[@class='price_tag wishlist_price'])["+Total+"]/span[1])")).getText());
				   Total=Total+1;
				   
			   }
			   
			  if(Price==0)
			  {
				   Scenario1Test.log.info("Price is displaying as Zero in");
				   throw new Exception();
			  }
			  
			  if((Total-1)==1||Total==16||Total==46||Total==61||Total==76||Total==91||Total==106)
			  {
				  Thread.sleep(5000);  
				 
				  Scenario1Test.driver.findElement(By.xpath("(//div[@class='hmptitleblock']/a)["+Total+"]")).click();
				  
				  if((Total-1)==1)
				  {
					  Scenario1Test.driver.findElement(By.xpath("//*[@id='popzip']")).sendKeys("560064");
					  Scenario1Test.driver.findElement(By.xpath("//*[@id='go']")).click();
					  Thread.sleep(5000);
				  }
				  
				  WebElement offerPrice=Scenario1Test.driver.findElement(By.xpath("//*[@id='product-price-3753']/span[1]"));
				  int Price_Poductdetails=(int) getNumber(offerPrice.getText());
				  
				  System.out.println(Price_Poductdetails+""+Price);
				  if(Price_Poductdetails<Price)
				  {
					  Scenario1Test.log.info("Prices are Diffrent from Home Page and Product Details page");
					  throw new Exception();
				  }
				 
				  Thread.sleep(500);				  
				  Scenario1Test.driver.navigate().back();
			  }
			 
		   }
	     }   	    
		Thread.sleep(1000);
	   
	}
	
	
	
	public void ClickonClosePOPup() throws Throwable
	{
		//Get Locators from Excel and create the WebElement object
	  WebDriverCommonFunctions.element_Click("closeIcon_xpath", "Clicked on Close ICON");
	}

	public void HeaderImageVerification() throws Exception 
	{
		//WhatsApp number verification
		Scenario1Test.wdcf.mouseOverOperation(Scenario1Test.driver.findElement(By.xpath("//*[@id='bang']")));
		Thread.sleep(3000);
		long BangaloreNumber=(long) getLongNumber(Scenario1Test.driver.findElement(By.xpath("//div[@class='phoneBlock']/ul/li[1]")).getText());
		long MysoreNumber=(long) getLongNumber(Scenario1Test.driver.findElement(By.xpath("//div[@class='phoneBlock']/ul/li[2]")).getText());
		long BangaloreNumber_Expected=7899777078L;
		long MysoreNumber_Expected=7899901142L;
		Assert.assertEquals(BangaloreNumber , BangaloreNumber_Expected);
		Assert.assertEquals(MysoreNumber_Expected , MysoreNumber);
		
		//Verify Service Provider
		Scenario1Test.driver.findElement(By.xpath("//b[text()='Service Provider']")).click();
		Thread.sleep(6000);
		Scenario1Test.wdcf.select(ServiceProvider,1);
		Thread.sleep(10000);
		String ServiceProvidervalue=ServiceProvidertext.getText();
		System.out.println("ServiceProvidervalue="+ServiceProvidervalue);
		Assert.assertEquals(ServiceProvidervalue,"Some of our Service Providers");
		mainPage.click();
		
		//DownLoad from Googleplay
		Scenario1Test.driver.findElement(By.xpath("//div[@class='text-right banner-top']/a[2]")).click();
		Thread.sleep(3000);
		Iterator<String> windows=Scenario1Test.driver.getWindowHandles().iterator();
		String HomeWindow=windows.next();
		String GoogleplayWindow=windows.next();
		
		Scenario1Test.driver.switchTo().window(GoogleplayWindow);
		Assert.assertEquals(Scenario1Test.driver.getTitle(),"mSupply – Android Apps on Google Play");
		Scenario1Test.driver.close();
		Scenario1Test.driver.switchTo().window(HomeWindow);
		
		//Verify Become a Seller
		BecomeSeller.click();
		Assert.assertEquals(VerifyBecomeSeller.getText(),"Sell On mSupply");
		HomepageLogo.click();
	}

	public void VerifyMarketingPromos() throws Exception 
	{
	    //Verify GooglePlayStore
		Thread.sleep(6000);
		ServiceProviderPromo.click();
		Iterator<String> windows = Scenario1Test.driver.getWindowHandles().iterator();
		String Parent=windows.next();
		String Child=windows.next();
		Scenario1Test.driver.switchTo().window(Child);
		Assert.assertEquals(Scenario1Test.driver.getTitle(),"Service Provider – Android Apps on Google Play");		
		Scenario1Test.driver.close();		
		Scenario1Test.driver.switchTo().window(Parent);
		
		//Verify Calculator option
		CommonFunctions.scrollDownPage(0,560);
		CalculatorPromo.click();
		Iterator<String> windows_2=Scenario1Test.driver.getWindowHandles().iterator();
		String Parent_2=windows_2.next();
		String Child_2=windows_2.next();
		Scenario1Test.driver.switchTo().window(Child_2);
		Assert.assertEquals(CalculatorPageContent.getText(),"Calculators");
		Scenario1Test.driver.close();
		Scenario1Test.driver.switchTo().window(Parent_2);
		
		//Verify Kitchen Products
		CommonFunctions.scrollDownPage(0,300);
		KitchenPagePromo.click();
		Thread.sleep(5000);
		Assert.assertEquals(BreadCrumbContent.getText(),"Kitchen");
		HomepageLogo.click();
		
		//Verify Paints Products
		CommonFunctions.scrollDownPage(0,300);
		PaintsPagePromo.click();
		Thread.sleep(5000);
		Assert.assertEquals(BreadCrumbContent.getText(),"Paints");	
		HomepageLogo.click();
				
		
		//Verify Hardware Products
		CommonFunctions.scrollDownPage(0,300);
		HardwarePagePromo.click();
		Thread.sleep(5000);
		Assert.assertEquals(BreadCrumbContent.getText(),"Hardware");	
		HomepageLogo.click();
		
		
		//Verify Plumbing Products
	    CommonFunctions.scrollDownPage(0,300);
		PlumbingPagePromo.click();
		Thread.sleep(5000);
		Assert.assertEquals(BreadCrumbContent.getText(),"Plumbing");	
		HomepageLogo.click();
				
		//Verify Carpentry Products
	    CommonFunctions.scrollDownPage(0,300);
		CarpentaryPagePromo.click();
		Thread.sleep(5000);
		Assert.assertEquals(BreadCrumbContent.getText(),"Carpentry");	
		HomepageLogo.click();
		
		
		
		
	}
	
	public void validateLeftStaticLinks(WebDriver driver) throws InterruptedException
	{
		
		
		int size=leftStaticLinks.size();
		for(int i=1;i<=size;i++)
		{
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,3000)");
						
			WebElement link=driver.findElement(By.xpath("//ul[@class='list-address msupply_help']/li["+i+"]/a"));
			String linkText=link.getText();
			if(linkText.equals("Our Team"))
			{
				log.info("............Clicked on "+linkText+" link.........");
				link.click();
				String title=driver.findElement(By.xpath("//div[@class='img-desc']/div[text()='Ishwar Subramanian']")).getText();
				Assert.assertEquals(title.toUpperCase(), "ISHWAR SUBRAMANIAN");
		
			}
			else if(!linkText.equals("mSupply Blog"))
			{
				log.info("............Clicked on "+linkText+" link.........");
				
				link.click();
				String title=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
				Assert.assertEquals(title, linkText);
			}
			

			PageFactory.initElements(BrowserSelection.driver, HomePage.class);
		}
		
	}
	
	public void validateRightStaticLinks(WebDriver driver)
	{
		Scenario1Test.wdcf.waitForPageToLoad();
		
		String titles[]={"Returns and Cancellations","Terms and Conditions of Use","FAQs","Sell On mSupply","Contact Us"};
		
		int size=rightStaticLinks.size();
		for(int i=1;i<=size;i++)
		{
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,3000)");
				
			WebElement link=driver.findElement(By.xpath("//ul[@class='list-address']/li["+i+"]/a"));
			String linkText=link.getText();
			String actTitle="";
			log.info("............Clicked on "+linkText+" link.........");
			link.click();
			if(linkText.equals("Sell on mSupply"))
			{
				actTitle=driver.findElement(By.xpath("//div[@class='well-block']/h1")).getText();
			}
			else if(linkText.equals("Contact Us"))
			{
				actTitle=driver.findElement(By.xpath("//div[@class='col-md-12 page-title title-c']/h1")).getText();
			}
			else
			{
				
				actTitle=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
			}
			Assert.assertEquals(actTitle,titles[i-1]);

			PageFactory.initElements(BrowserSelection.driver, HomePage.class);
		}
		
	}
	
//	This method verifies that the static links of second left division opens proper page
	
	public void validateContactDetails()
	{
//		String email="support@msupply.com";
//		//String phone="18001033447";
//		String phone="18005320555";
//		Assert.assertEquals(emailId.getText(), email); 
//		Assert.assertEquals(phoneNo.getText(), phone);
	}
	
	public void validateQuickLinks(WebDriver driver)
	{
//		Scenario1Test.wdcf.waitForPageToLoad();
//		closeIcon.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,3000)");
		int k=0;
		int size=quickLinks.size();
		for(int i=1;i<=size;i++)
		{
			
			List<WebElement> innerLinks=driver.findElements(By.xpath("//div[@id='seo_section']/ul["+i+"]/li"));
			int innerLinkSize=innerLinks.size();
			String titles[]={"Blocks",
					"Consumable",
					"Cables and Wires",
					"Home Automation",
					"Consumables","Solvent",
					"Chimneys & Hobs",
					"Modular Kitchen",
					"Plumbing Tools",
					"Gardening Tools",
					"Tools",
					"Solar Products",
					"Bathroom Faucets",
					"Bathroom Accessories",
					"Tiles",
					"Outdoor Flooring",
					"Plywood",
					"Adhesive",
					"Skin Door",
					"Veneer Door",
					"Fittings",
					"Consumables",
					"Wall Putty",
					"Painting Accessories",
					"Pots and Planters",
					"Clay Roofing"
					};
			for(int j=2;j<=innerLinkSize;j++)
			{
				if(j==2 || j==innerLinkSize)
				{
					WebElement link=driver.findElement(By.xpath("//div[@id='seo_section']/ul["+i+"]/li["+j+"]"));
					
					link.click();
					String pageTitle=driver.findElement(By.xpath("//div[@class='current-product']/b")).getText();
					Assert.assertEquals(pageTitle, titles[k]);
					k++;
				}
				
				
			}
			
		}
	}
	
	
	public void navigateToShoppingListPage() throws InterruptedException
	{
		Scenario1Test.wdcf.waitForPageToLoad();
		Thread.sleep(1000);
		shoppingListLink.click();
	}
	
	
	
	public void verifyEmptyCartPage()
	{
		Assert.assertEquals(emptyMsg.getText(), "Your Shopping List is empty !");
	}
	
	
	

	public int getCartItemsCount(WebDriver driver)
	{
		//homeLink.click();
		try
		{
			String count=cartCount.getText();
			System.out.println("Count== "+count);
			return Integer.parseInt(count);
		}
		catch(NoSuchElementException e)
		{
			return 0;
		}
	}
	
	public void addCementProductToCart() throws Throwable
	{
	
		
		
		log.info("............Selecting Product from Navigation.........");
		Scenario1Test.wdcf.mouseOverOperation(shop);
		Thread.sleep(500);
		Scenario1Test.wdcf.mouseOverOperation(Buildingmaterial);
		Thread.sleep(500);
		Scenario1Test.wdcf.mouseOverOperation(Buildingmaterial_Cement);
		Thread.sleep(500);
		
		Buildingmaterial_Cement_PPC.click();
		log.info("Moved to : Buildingmaterial_Cement_PPC");		
		
		Buildingmaterial_Cement_PPC_Nagarjuna.click();
		log.info("Moved to : Buildingmaterial_Cement_PPC_Nagarjuna");
		
		
		//zipcode_popup.sendKeys("560064");
	    //log.info("Moved to : Buildingmaterial_Blocks_ConcreteCover_15mm_zipcode_popup");
		
		//zipcode_popup_Go.click();
		//log.info("Moved to : Buildingmaterial_Blocks_ConcreteCover_15mm_zipcode_popup_Go");
		
		Buildingmaterial_Blocks_ConcreteCover_15mm_AddtoList.click();
		log.info("Moved to : Buildingmaterial_Blocks_ConcreteCover_15mm_AddtoList");
		Thread.sleep(12000);
		//Scenario1Test.driver.switchTo().defaultContent();
	}
	
	public String validateSuccessMsgInShoppingList()
	{
		//System.out.println("Checking the Succes msg");
		return successMsg.getText();
	}
	
	public void addElectricalProductToCart() throws InterruptedException
	{
		Scenario1Test.wdcf.waitForPageToLoad();
		
		
		log.info("............Selecting Product from Navigation.........");
		System.out.println("Entered into electricals");
		
		Thread.sleep(2000);
		
		Scenario1Test.wdcf.mouseOverOperation(shop);
		System.out.println("Mouse hovered on Shop");
		
		Thread.sleep(500);
		Scenario1Test.wdcf.mouseOverOperation(Electrical);
		System.out.println("Mouse hovered on Electrical");
	
		Thread.sleep(500);
		//Scenario1Test.wdcf.mouseOverOperation(Electrical_CablesAndWirres);
		Electrical_CablesAndWirres.click();
		System.out.println("Clicked on Cables & Wires");
		
//		Electrical_Cables_Housewires.click();
//		log.info("Moved to : ElectricalCat_Cables_Housewires");
		//System.out.println("Clicked on house wires");
		
		//Thread.sleep(500);
		
		Electrical_Cables_polycab.click();
		log.info("Moved to : Electrical_Cables_polycab");
		System.out.println("Clicked on polycab product");
		
		Buildingmaterial_Blocks_ConcreteCover_15mm_AddtoList.click();
		log.info("Moved to : Buildingmaterial_Blocks_ConcreteCover_15mm_AddtoList");
		//Thread.sleep(12000);
		//Scenario1Test.driver.switchTo().defaultContent();
	}
		
	public void removeProductFromShoppingList()
	{
		removeProduct.click();
		
	}
	
	public void logoutOfMsupply() throws InterruptedException
	{
		Scenario1Test.wdcf.mouseOverOperation(mouseonAccount);
        Thread.sleep(3000);
        logoutButton.click();
	}
	
//==================================================================================================================================================================	
	
	public  static void mSupplylogin_HomePage() throws Throwable
	{	   
		   String ExcelData[]=RetrieveXlsxData.getExcelData("LoginID_4");
		   String mobileNumber=ExcelData[1];
		   String password=ExcelData[2];
		   WebDriverCommonFunctions.element_ClickLoginButtonHomePage("HomePageAccount_Xpath","HomePageLogin_Xpath","Navigation to Account->Login");
		   WebDriverCommonFunctions.element_EnterValuesToTextField("MobileNumberField_Xpath", mobileNumber, "Entered MobileNumber");
		   WebDriverCommonFunctions.element_EnterValuesToTextField("PasswordField_Xpath", password, "Entered Password");
	       WebDriverCommonFunctions.element_Click("LoginButton_Xpath", "Clicked on Login Button");
	       CommonFunctions.LoadPageExpicitWait();
	       
	}
//==================================================================================================================================================================	
	
		public  static void mSupplylogout_HomePage() throws Throwable
		{	   
			ArrayList<String> Logoutelements=new ArrayList<String>();
			Logoutelements.add("HomePageAccount_Xpath");
			Logoutelements.add("LogoutButton_Xpath");		
			WebDriverCommonFunctions.element_MouseOver_TillElementClick(Logoutelements, "Clicked on Logout Button");
			CommonFunctions.LoadPageExpicitWait();
		}

//==================================================================================================================================================================	
		
		public  static void mSupplySignIn_HomePage() throws Throwable
		{	   
			ArrayList<String> NewAccountelements=new ArrayList<String>();
			NewAccountelements.add("HomePageAccount_Xpath");
			NewAccountelements.add("HomePageSignIn_Xpath");		
			WebDriverCommonFunctions.element_MouseOver_TillElementClick(NewAccountelements, "Clicked on SigIn Button");
					
		       
		}
	
//==================================================================================================================================================================	
	public void SelectProductsForReviewsandRatings() throws Throwable 
	{
		ArrayList<String> elements=new ArrayList<String>();
		elements.add("Navigation_Shop_Xpath");
		elements.add("Navigation_BuildingMaterial_xpath");
		elements.add("Navigation_BuildingMaterial_Cement_xpath");
		elements.add("Navigation_Buildingmaterial_Cement_PPC_Xpath");
		
		WebDriverCommonFunctions.element_MouseOver_TillElementClick(elements, "Navigation => Buildingmaterial->Cement->Product1");
		WebDriverCommonFunctions.element_Click("Buildingmaterial_Cement_Product1_Staging_Xpath", "Clicked on : First Cement Product");
		
	}

//==================================================================================================================================================================
	
		public static void Sliders_ProductLink_Verification() throws Throwable
		{
			WebDriverCommonFunctions.PrintinLogAndHTMLReports("Verifing 120 Product links from the Slider");
			
			 Scenario1Test.driver.switchTo().defaultContent();
			 int Total=1;
	         list=new ArrayList();
	         
			 for(int j=1;j<=8;j++)	
			 {
				 CommonFunctions.scrollDownPage(0,200);
			     
			     for(int i=1;i<=15;i++)
				 {
			    	 //for electrical product
			    	 if(Total!=31)
			    	 {
			    		 
					 //Slide to the next products
			    	 if(i>=6)
					 {  
						  Scenario1Test.driver.findElement(By.xpath("(//div[@class='owl-next']/a)["+j+"]")).click();
						  Thread.sleep(1000);
					 }
			    	 if(i>=11)
			    	 {
			    		  Scenario1Test.driver.findElement(By.xpath("(//div[@class='owl-next']/a)["+j+"]")).click();
						  Thread.sleep(1000);
					 	 
			    	 }
			    	 
			    	 try
			    	 {
			    		WebDriverCommonFunctions.PrintinLogAndHTMLReports("============================="+" : Slider="+j+": Product="+i+"==================================================");	 
			    	 
			    	    String HomePageProduct=Scenario1Test.driver.findElement(By.xpath("(//div[@class='hmptitleblock']/a)["+Total+"]")).getText();
			    	    if(HomePageProduct.equals(null)) // if the product details or product not present on the slider
			    	       throw new Exception();
			    	     
			    	     try
			    	     {
			    		   Scenario1Test.driver.findElement(By.xpath("(//li[@class='divider item']/a)["+Total+"]")).click();
			    	     }
			    	     catch(Exception e)
			    	     {
			    	    	 CommonFunctions.scrollPageUp(0,-1000);
			    	    	 CommonFunctions.scrollDownPage(0,200*j);
			    	    	 Scenario1Test.driver.findElement(By.xpath("(//li[@class='divider item']/a)["+Total+"]")).click();
			    	     }
			    	     
			    	     
			    		 CommonFunctions.LoadPageExpicitWait();
			    		 
			    		 if(Total==1)
			    		 {
			    				try
			    				{
			    				  WebDriverCommonFunctions.element_EnterValuesToTextField("ZipCodePOPUP_Xpath","560064","Pincode Entered");
			    				  WebDriverCommonFunctions.element_Click("ZipCodePOPUP_GoButton_Xpath", "Clicked on ZipCode Go Button");
			    				}
			    				catch(Exception e)
			    				{
			    					//do nothing
			    				}
			    		 }
			    		 
			    		 String DetailsPageProductname=WebDriverCommonFunctions.element_GetTextFromLabel("ProductName_Xpath");
			    		 HomePageProduct=HomePageProduct.toLowerCase();
			    		 DetailsPageProductname=DetailsPageProductname.toLowerCase();
			    		 	    		 
		    			 WebDriverCommonFunctions.PrintinLogAndHTMLReports("HomePageProduct = "+HomePageProduct);
		    			 WebDriverCommonFunctions.PrintinLogAndHTMLReports("ProductDetailsPageProductname = "+DetailsPageProductname);
			    		 
			    		 WebDriverCommonFunctions.PrintinLogAndHTMLReports("Product => "+Total+":Slider=>"+j+":Product=>"+i);
			    		 WebDriverCommonFunctions.Print_WithException_SoftAssert_inLogAndHTMLReports(HomePageProduct, DetailsPageProductname, true);
			    		 
			    		 
//			    		 if(HomePageProduct.equalsIgnoreCase(DetailsPageProductname))
//			    			 WebDriverCommonFunctions.PrintinLogAndHTMLReports("Product => "+Total+" : Navigated to Correct Page =>"+HomePageProduct+":Slider=>"+j+":Product=>"+i);
//			    		 else
//			    		 {
//			    			 WebDriverCommonFunctions.PrintinLogAndHTMLReports("HomePageProduct = "+HomePageProduct);
//			    			 WebDriverCommonFunctions.PrintinLogAndHTMLReports("ProductDetailsPageProductname = "+DetailsPageProductname);		    			 
//			    			 WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Navigated to Correct Page => "+Total);
//			    		 }
			    		 
			    		 Thread.sleep(500);				  
						 Scenario1Test.driver.navigate().back();
						 CommonFunctions.LoadPageExpicitWait();
					   
			    	     Total=Total+1;
			    	 }		    	
			    	 catch(Exception e)
			    	 {
			    		 Total=Total+1;
			    		 WebDriverCommonFunctions.PrintinLogAndHTMLReports("================Error : Product => "+Total+":Slider=>"+j+":Product=>"+i);
			    		 list.add(j);		    		 
			    	 }
			      }
			      else
			      {
			    		 Total=Total+1;
			      }
				}
			}		 
			 		 
	}
	
//==================================================================================================================================================================	
public static void Functional_MarketingPromos() throws Throwable
{
	//Verify Marketing Promos
	for(int i=1;i<=8;i++)
	{		   
	   if(i==1)
	   {  
		   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_1", "Service Provider text obtained");
		   CommonFunctions.scrollDownPage(0,100);
		   if(WebDriverCommonFunctions.element_ReturnWebElement("MarketingPromos_Xpath_1").isEnabled()==true)
           {
			   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Element is Clickable");
           }
           else
           {
        	   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Element is not clickable");
           }
		   
		   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_1", "Clicked on Service Provider");
		   WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Child");
		   String PageText=Scenario1Test.driver.getTitle();
		   
		   if(ImageText.contains("Provider")&&PageText.contains("Provider"))
			   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Navigated to Service Provider Page");
		   else
			   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Navigated to PlayStore");
		   		
		   WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to HomePage");			   
	   }
	   if(i==2)
	   {
		   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_2", "Service Provider text obtained");
		  
		   if(ImageText.contains("WhatsApp to Order"))
			   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Whatsapp Image Present");
		   else
			   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Whatsapp Image not present");			   
	   }
	   if(i==3)
	   {
		  WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_3", "Clicked on Calculator");
		  WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Calculator Page");
		  WebDriverCommonFunctions.element_VerifyTextAndAssert("Calculator_Header_Xpath", "Calculators", "Navigated to Calculator page");
		  WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to HomePage");
		   
	   }
	   if(i==4)
	   {
		   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_4", "Service Provider text obtained");
		   //System.out.println(ImageText);
		   
		   if(ImageText.contains("Kitchen Products"))
		       WebDriverCommonFunctions.PrintinLogAndHTMLReports("Kitchen Products Image Present");
	       else
		       WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Kitchen Products not present");
		   
		   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_4", "Clicked on kitchen Promo - Discount 44%");
		   
		   List<WebElement> elements=WebDriverCommonFunctions.element_Collection("DiscountRange_CheckBox_Xpath", 0, false, "Discount Filters Count");
		   int DiscountCheckBoxCount=elements.size();
		   
		   int Dicountnumber=CommonFunctions.getNumber(ImageText);
		   int Discount=CommonFunctions.get_SelectedDiscount_CheckBoxNumber(Dicountnumber);

		   ArrayList<String> AttributeValues=(ArrayList<String>) (WebDriverCommonFunctions.Table_SearchForElement_Action(CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_1"), CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_2"), 1, "CheckBoxSelectedCount",DiscountCheckBoxCount));
		   for(int j=0;j<Discount;j++)
			   if(AttributeValues.get(j).equals("m-checkbox-checked"))
				   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Selected CheckBox ="+(j+1));
			   else
				   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Selected the required CheckBox ="+(j+1));
		   
		   WebDriverCommonFunctions.navigateBack(1);
		   
	   }
		   if(i==5)
		   {
			   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_5", "Paints Image text obtained");
			   //System.out.println(ImageText);
			   
			   if(ImageText.contains("Paints"))
			       WebDriverCommonFunctions.PrintinLogAndHTMLReports("Paints Products Image Present");
		       else
			       WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Paints Products not present");
			   
			   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_5", "Clicked on Paints Promo - Discount 57%");
			   
			   List<WebElement> elements=WebDriverCommonFunctions.element_Collection("DiscountRange_CheckBox_Xpath", 0, false, "Discount Filters Count");
			   int DiscountCheckBoxCount=elements.size();
			   
			   int Dicountnumber=CommonFunctions.getNumber(ImageText);
			   int Discount=CommonFunctions.get_SelectedDiscount_CheckBoxNumber(Dicountnumber);

			   ArrayList<String> AttributeValues=(ArrayList<String>) (WebDriverCommonFunctions.Table_SearchForElement_Action(CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_1"), CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_2"), 1, "CheckBoxSelectedCount", DiscountCheckBoxCount));
			   for(int j=0;j<Discount;j++)
				   if(AttributeValues.get(j).equals("m-checkbox-checked"))
					   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Selected CheckBox ="+(j+1));
				   else
					   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Selected the required CheckBox ="+(j+1));	
			   
			   WebDriverCommonFunctions.navigateBack(1);
		   }
		   if(i==6)
		   {
			   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_6", "Hardware Image text obtained");
			   //System.out.println(ImageText);
			   
			   if(ImageText.contains("Hardware"))
			       WebDriverCommonFunctions.PrintinLogAndHTMLReports("Hardware Products Image Present");
		       else
			       WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Hardware Products not present");
			   
			   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_6", "Clicked on Hardware Promo - Discount 21%");
			   
			   List<WebElement> elements=WebDriverCommonFunctions.element_Collection("DiscountRange_CheckBox_Xpath", 0, false, "Discount Filters Count");
			   int DiscountCheckBoxCount=elements.size();
			   
			   int Dicountnumber=CommonFunctions.getNumber(ImageText);
			   int Discount=CommonFunctions.get_SelectedDiscount_CheckBoxNumber(Dicountnumber);

			   ArrayList<String> AttributeValues=(ArrayList<String>) (WebDriverCommonFunctions.Table_SearchForElement_Action(CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_1"), CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_2"), 1, "CheckBoxSelectedCount", DiscountCheckBoxCount));
			   for(int j=0;j<Discount;j++)
				   if(AttributeValues.get(j).equals("m-checkbox-checked"))
					   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Selected CheckBox ="+(j+1));
				   else
					   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Selected the required CheckBox ="+(j+1));	
			   
			   WebDriverCommonFunctions.navigateBack(1);
		   }
		   if(i==7)
		   {
			   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_7", "Plumbing Image text obtained");
			   //System.out.println(ImageText);
			   
			   if(ImageText.contains("Plumbing"))
			       WebDriverCommonFunctions.PrintinLogAndHTMLReports("Plumbing Products Image Present");
		       else
			       WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Plumbing Products not present");
			   
			   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_7", "Clicked on Plumbing Promo - Discount 21%");
			   
			   List<WebElement> elements=WebDriverCommonFunctions.element_Collection("DiscountRange_CheckBox_Xpath", 0, false, "Discount Filters Count");
			   int DiscountCheckBoxCount=elements.size();
			   
			   int Dicountnumber=CommonFunctions.getNumber(ImageText);
			   int Discount=CommonFunctions.get_SelectedDiscount_CheckBoxNumber(Dicountnumber);

			   ArrayList<String> AttributeValues=(ArrayList<String>) (WebDriverCommonFunctions.Table_SearchForElement_Action(CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_1"), CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_2"), 1, "CheckBoxSelectedCount", DiscountCheckBoxCount));
			   for(int j=0;j<Discount;j++)
				   if(AttributeValues.get(j).equals("m-checkbox-checked"))
					   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Selected CheckBox ="+(j+1));
				   else
					   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Selected the required CheckBox ="+(j+1));	
			   
			   WebDriverCommonFunctions.navigateBack(1);
		   } 
		   
		   if(i==8)
		   {
			   String ImageText= WebDriverCommonFunctions.element_getTextFromImage("MarketingPromos_Xpath_8", "Carpentry Image text obtained");
			   //System.out.println(ImageText);
			   
			   if(ImageText.contains("Carpentry"))
			       WebDriverCommonFunctions.PrintinLogAndHTMLReports("Carpentry Products Image Present");
		       else
			       WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Carpentry Products not present");
			   
			   WebDriverCommonFunctions.element_Click("MarketingPromos_Xpath_8", "Clicked on Carpentry Promo - Discount 33%");
			   
			   List<WebElement> elements=WebDriverCommonFunctions.element_Collection("DiscountRange_CheckBox_Xpath", 0, false, "Discount Filters Count");
			   int DiscountCheckBoxCount=elements.size();
			   
			   
			   int Dicountnumber=CommonFunctions.getNumber(ImageText);
			   int Discount=CommonFunctions.get_SelectedDiscount_CheckBoxNumber(Dicountnumber);

			   ArrayList<String> AttributeValues=(ArrayList<String>) (WebDriverCommonFunctions.Table_SearchForElement_Action(CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_1"), CommonFunctions.getElementFromExcel("DiscountRange_CheckBox_Xpath_2"), 1, "CheckBoxSelectedCount",DiscountCheckBoxCount));
			   for(int j=0;j<Discount;j++)
				   if(AttributeValues.get(j).equals("m-checkbox-checked"))
					   WebDriverCommonFunctions.PrintinLogAndHTMLReports("Selected CheckBox ="+(j+1));
				   else
					   WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Selected the required CheckBox ="+(j+1));	
			   
			   WebDriverCommonFunctions.navigateBack(1);
		   }
	    
	   
	}*/
/*}
//========================================================================================================================================================================================================================================================================================================================
Verify Header-1 links
public static void Header1Verification() throws Throwable
{
	
	//Verify Navigation Links
	WebDriverCommonFunctions.element_MouseOver("Navigation_Shop_Xpath", "Mouse over on Navigation");
	WebDriverCommonFunctions.element_Collection("Navigation_AllCategory_Xpath",15, true, "All categories Present");
	WebDriverCommonFunctions.element_Selectproduct_Navigation(1,1,false,"Navigating to the Product list page");
	try
	{
	  WebDriverCommonFunctions.element_EnterValuesToTextField("ZipCodePOPUP_Xpath","560064","Pincode Entered");
	  WebDriverCommonFunctions.element_Click("ZipCodePOPUP_GoButton_Xpath", "Clicked on ZipCode Go Button");
	}
	catch(Exception e)
	{
		//do nothing
	}
	String Productname=WebDriverCommonFunctions.element_GetTextFromLabel("ProductName_Xpath");
		
	if(Productname.contains("BLOCK"))
		WebDriverCommonFunctions.PrintinLogAndHTMLReports("Navigated to the Product details page");
	else
		WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Not Navigated to the Product details page ");
			
	WebDriverCommonFunctions.navigateBack(2);
			
	
	//Check if Click on logo redirects to home Page
	WebDriverCommonFunctions.element_Click("mSupply_Logo_Image_Xpath","Clicked on mSupply Logo");
	WebDriverCommonFunctions.element_Collection("Eight_Category_Section_Xpath", 8,true, "All Eight category Section Present on WebPage");
	
	//Verify SearchBox
	WebDriverCommonFunctions.element_Present("Search_Box_Xpath", "SearchBox Present", "SearchBox not Present");
	WebDriverCommonFunctions.element_GetTextFromTextField("Search_Box_Xpath", "placeholder", "Because Quality Matters", "Ghost Text Present in SearchBox");
//	WebDriverCommonFunctions.element_EnterValuesToTextField("Search_Box_Xpath", "Electrical", "Enetered Value Electrical in SearchBox");
//	WebDriverCommonFunctions.element_Click("Search_Box_Button_Xpath", "Clicked on Search Box Button");
//	WebDriverCommonFunctions.element_VerifyLinkTextAndAssert("PageName_Xpath", "Electrical", "Navigated to Electrical page");
	
	//Verify Contact
	ArrayList<String> Contact=new ArrayList<String>();
	Contact.add("Contact_Header_Xpath");
	WebDriverCommonFunctions.element_MouseOver_TillElementClick(Contact, "Moved to Contact");
    boolean Contact_1_status=WebDriverCommonFunctions.element_isVisible("Contact_Details_Xpath_1", "Drop Down");
    boolean Contact_2_status=WebDriverCommonFunctions.element_isVisible("Contact_Details_Xpath_2", "Drop Down");
    String Contatct_1_no=WebDriverCommonFunctions.element_GetTextFromLabel("Contact_Details_Xpath_1");
    String Contatct_2_no=WebDriverCommonFunctions.element_GetTextFromLabel("Contact_Details_Xpath_2");
	if(Contact_1_status==true && Contact_2_status==true&&!Contatct_1_no.equals(null)&&!Contatct_2_no.equals(null))
        WebDriverCommonFunctions.PrintinLogAndHTMLReports("Contact Drop Down is Visible");
	else
		WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Contact Drop Down is not Visible");
	
    //Verify Email
	ArrayList<String> Email=new ArrayList<String>();
	Email.add("Email_Header_Xpath");
	WebDriverCommonFunctions.element_MouseOver_TillElementClick(Email, "Moved to Email");
    boolean Email_1_status=WebDriverCommonFunctions.element_isVisible("Email_Details_Xpath_1", "Email Header");
    boolean Email_2_status=WebDriverCommonFunctions.element_isVisible("Email_Details_Xpath_2", "Email Header");
    String Email_1=WebDriverCommonFunctions.element_GetTextFromLabel("Email_Details_Xpath_1");
    String Email_2=WebDriverCommonFunctions.element_GetTextFromLabel("Email_Details_Xpath_2");
    
	if(Email_1_status==true&&Email_2_status==true&&!Email_1.equals(null)&&!Email_2.equals(null))
        WebDriverCommonFunctions.PrintinLogAndHTMLReports("Email Drop Down is Visible");
	else
		WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Email Drop Down is not Visible");
	
	
	//verify Account
	ArrayList<String> Account=new ArrayList<String>();
	Contact.add("HomePageAccount_Xpath");
	WebDriverCommonFunctions.element_MouseOver_TillElementClick(Contact, "Moved to Account");
	boolean Login_1_status=WebDriverCommonFunctions.element_isVisible("HomePageLogin_Xpath", "Drop Down");
    boolean Signup_2_status=WebDriverCommonFunctions.element_isVisible("HomePageSignIn_Xpath", "Drop Down");
    String Login=WebDriverCommonFunctions.element_GetTextFromLabel("HomePageLogin_Xpath");
    String Signup=WebDriverCommonFunctions.element_GetTextFromLabel("HomePageSignIn_Xpath");
    if(Login_1_status==true && Signup_2_status==true&&!Login.equals(null)&&!Signup.equals(null))
        WebDriverCommonFunctions.PrintinLogAndHTMLReports("Account Drop Down is Visible");
	else
		WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Account Drop Down is not Visible");
	
	
	//Verify LoginPopup
	ArrayList<String> Loginelements=new ArrayList<String>();
	Loginelements.add("HomePageAccount_Xpath");
	Loginelements.add("HomePageLogin_Xpath");		
	WebDriverCommonFunctions.element_MouseOver_TillElementClick(Loginelements, "Clicked on Login Button");
	WebDriverCommonFunctions.element_VerifyTextAndAssert("LoginPOPUp_Header_Xpath", "Sign in", "Sign In popup present on the WebPage");
	WebDriverCommonFunctions.element_Click("LoginPOPUp_CloseButton_Xpath", "Clicked on Close Button - LoginPopup");
			
	//Verify SignInpopup
	ArrayList<String> NewAccountelements=new ArrayList<String>();
	NewAccountelements.add("HomePageAccount_Xpath");
	NewAccountelements.add("HomePageSignIn_Xpath");		
	WebDriverCommonFunctions.element_MouseOver_TillElementClick(NewAccountelements, "Clicked on SigIn Button");
	WebDriverCommonFunctions.element_VerifyTextAndAssert("SignIn_Header_Xpath", "Create New Account", "Create New Account popup present on the WebPage");
	WebDriverCommonFunctions.element_Click("LoginPOPUp_CloseButton_Xpath", "Clicked on Close Button - Create New Account");
			
	//Verify Shopping Kart Page
	WebDriverCommonFunctions.element_Click("HomePage_ShoppingKart_Xpath", "Clicked on Shopping kart Page");
	WebDriverCommonFunctions.ExplicitWait();
	WebDriverCommonFunctions.element_VerifyTextAndAssert("ShoppingKart_Header_Xpath","Your Shopping List is empty !", "Navigated to ShoppingKart Page");
	WebDriverCommonFunctions.navigateBack(1);
	
}
//======================================================================================================================================================================================================================================
Verify Header-2 links
public static void Header2verification() throws Throwable
{
	//Check Service provide link
			WebDriverCommonFunctions.element_Click("HomePage_ServiceProvider_Xpath"," Clicked on Become Service Provider");
			WebDriverCommonFunctions.element_SelectDropDown("HomePage_ServiceProvider_Logo_Xpath", "INDEX", 1, "", "Selected Fisrt Index from DropDown");
			WebDriverCommonFunctions.ExplicitWait();
			WebDriverCommonFunctions.element_VerifyTextAndAssert("ServiceProvider_Xpath", "Some of our Service Providers", "Navigated to Service provider page");
			WebDriverCommonFunctions.navigateBack(1);
			CommonFunctions.LoadPageExpicitWait();
			
			//Check GooglePlay Link 
			WebDriverCommonFunctions.element_Click("Homepage_GooglePlay_Xpath", "clicked on GooglePlay");
			WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to GooglePlay Window");
			Assert.assertEquals(Scenario1Test.driver.getTitle(),"mSupply – Android Apps on Google Play");
			WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply HomePage - Download on GooglePlay navigating to the right page");
					
			//verify Become a Seller
			WebDriverCommonFunctions.element_Click("HomePage_BecomeSeller_Xpath", "Clicked on Become a Seller");
			WebDriverCommonFunctions.element_VerifyTextAndAssert("Seller_HeaderText_Xpath","Sell On mSupply","Navigated to - Sell on msupply page");
			WebDriverCommonFunctions.navigateBack(1);
			
}

//======================================================================================================================================================================================================================================
Verify Footer-1 Links
public static void msupplyAboutusFooter() throws Throwable
{
		List<WebElement> elements=WebDriverCommonFunctions.element_Collection("Footer_Links_1_Xpath", 0, false, "Got Links From Footer-1");
		for(int i=0;i<elements.size();i++)
		{				
			if(i==0)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_1_Xpath_1", "Clicked on About us");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "About Us", "About Us Page Verified");
			}
			if(i==1)
			{
				
				WebDriverCommonFunctions.element_Click("Footer_Links_1_Xpath_2", "Clicked on Out Team");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("OurTeam_HeaderPage_Xpath","ISHWAR SUBRAMANIAN", "Our Team Verified");
			}
			if(i==2)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_1_Xpath_3", "Clicked on Our Investors");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "Our Investors", "Our Investors Page Verified");
			}
			if(i==3)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_1_Xpath_4", "Clicked on Our Carrers");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "Careers", "Careers Page Verified");
			}
			if(i==4)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_1_Xpath_5", "Clicked on msupply Blog");
				WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Blog");
				String Title=Scenario1Test.driver.getTitle();
				Assert.assertEquals(Title, "mSupply Official Blog - Buy Construction & Interior Materials");
				WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply Home Page");				
			}
			

		}
		
		
		List<WebElement> elements2=WebDriverCommonFunctions.element_Collection("Footer_Links_2_Xpath", 0, false, "Got Links From Footer-2");
		
		for(int i=0;i<elements2.size();i++)
		{				
			if(i==0)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_2_Xpath_1", "Clicked on Returns & Cancellations");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "Returns and Cancellations", "Returns & Cancellations Page Verified");
			}
			if(i==1)
			{
				
				WebDriverCommonFunctions.element_Click("Footer_Links_2_Xpath_2", "Clicked on Returns & Cancellations");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "Terms and Conditions of Use", "Terms and Conditions of Use Page Verified");
			}
			if(i==2)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_2_Xpath_3", "Clicked on FAQs");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Header_Xpath", "FAQs", "FAQs Page Verified");
			}
			if(i==3)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_2_Xpath_4", "Clicked on FAQs");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("Seller_HeaderText_Xpath", "Sell On mSupply", "Sell On mSupply Verified");
			}
			
			if(i==4)
			{
				WebDriverCommonFunctions.element_Click("Footer_Links_2_Xpath_5", "Clicked on Contact Us");
				WebDriverCommonFunctions.element_VerifyTextAndAssert("ContactUs_Xpath", "Contact Us", "Contact Us Page Verified");
			}
		}
		
		
        List<WebElement> elements3=WebDriverCommonFunctions.element_Collection("SocialMediaLinks_Xpaths", 0, false, "Got Links From Footer-2");
		
		for(int i=0;i<elements3.size();i++)
		{				
			if(i==0)
			{
				WebDriverCommonFunctions.element_Click("SocialMediaLinks_Xpaths_1", "Clicked on Facebook");
				WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Facebook Tab");
				String Title=Scenario1Test.driver.getTitle();
				Assert.assertEquals(Title, "mSupply | Facebook");
				WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply Home Page");				
		
			}
			
			if(i==1)
			{
				WebDriverCommonFunctions.element_Click("SocialMediaLinks_Xpaths_2", "Clicked on Twitter");
				WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Twitter Tab");
				String Title=Scenario1Test.driver.getTitle();
				Assert.assertEquals(Title, "mSupply (@mSupplydotcom) | Twitter");
				WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply Home Page");				
		
			}
			if(i==2)
			{
				WebDriverCommonFunctions.element_Click("SocialMediaLinks_Xpaths_3", "Clicked on Google+");
				WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to Google+ Tab");
				String Title=Scenario1Test.driver.getTitle();
				Assert.assertEquals(Title, "mSupply - Google+");
				WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply Home Page");				
		
			}
			if(i==3)
			{
				WebDriverCommonFunctions.element_Click("SocialMediaLinks_Xpaths_4", "Clicked on LinkedIn");
				WebDriverCommonFunctions.element_Window_SwitchToChild("Switched to LinkedIn Tab");
				String Title=Scenario1Test.driver.getTitle();
				Assert.assertEquals(Title, "mSupply.com | LinkedIn");
				WebDriverCommonFunctions.element_Window_SwitchToParent("Switched to msupply Home Page");				
		
			}
			
		}
		
		WebDriverCommonFunctions.element_Click("mSupply_Logo_Image_Xpath","Clicked on mSupply Logo");
		
		//Verify Reach Us Section
		WebDriverCommonFunctions.element_VerifyTextAndAssert("ReachUs_Xpath", "Reach Us", "Reach Us Text Present on the Home Page");
		
		
		//Verify address is present
		String Address=WebDriverCommonFunctions.element_ReturnWebElement("ReachUs_Address_Xpath").getText();
		if(Address.equals(null))
			WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Address not present in the footer");
		else
			WebDriverCommonFunctions.PrintinLogAndHTMLReports("Address present in the footer");
		
		
		
		//Verify Contact No is present
		String Contact=WebDriverCommonFunctions.element_ReturnWebElement("ReachUs_ContactNo_Xpath").getText();
		if(Contact.equals(null))
			WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Contact not present in the footer");
		else
			WebDriverCommonFunctions.PrintinLogAndHTMLReports("Contact present in the footer");
						
		
		
		//Verify Email is present
		String Email=WebDriverCommonFunctions.element_ReturnWebElement("ReachUs_Email_Xpath").getText();
		if(Email.equals(null))
				WebDriverCommonFunctions.Print_WithException_inLogAndHTMLReports("Email not present in the footer");
		else
				WebDriverCommonFunctions.PrintinLogAndHTMLReports("Email present in the footer");
										
		
		
		
		
		
     }
//======================================================================================================================================================================================================================================
public static void ProductQuickLinks() throws Throwable
{
		List<WebElement> elements=WebDriverCommonFunctions.element_Collection("ProductQuickLinks_Xpath", 0, false, "Got Links From Footer-2");
		for(int i=1;i<=elements.size();i++)
		{	
			
			    WebElement element=Scenario1Test.driver.findElement(By.xpath("(//div[@id='seo_section']/ul/li/a)["+i+"]"));
			    CommonFunctions.SearchForElement(element);
			    String LinkText=element.getText();
			    element.click();
			    CommonFunctions.LoadPageExpicitWait();
			    
			    try
			    {
			      if(i==6)
				  {
					WebDriverCommonFunctions.element_EnterValuesToTextField("ZipCodePOPUP_Xpath","560064","Pincode Entered");
					WebDriverCommonFunctions.element_Click("ZipCodePOPUP_GoButton_Xpath", "Clicked on ZipCode Go Button");
				  }
			    }
			    catch(Exception e)
			    {
			    	//do nothing
			    }
			    
			    CommonFunctions.LoadPageExpicitWait();
			    String HeaderText=Scenario1Test.driver.findElement(By.xpath("//div[@class='mb-breadcrumbs']//li[3]")).getText();
                WebDriverCommonFunctions.Print_WithException_SoftAssert_inLogAndHTMLReports(LinkText, HeaderText,false);
		    			
		}
}		

//===================================================================================================================================================================================

public static void ValidateLinks_HomePage() throws Throwable 
{
 verify Header-1 links 
 HomePage.Header1Verification();
			
Verify Header-2 links
 HomePage.Header2verification();	
			
//Verify Sliders
 HomePage.Sliders_ProductLink_Verification();
	
//Verify marketting promos
 HomePage.Functional_MarketingPromos();

//Verify footer-1 links
 HomePage.msupplyAboutusFooter();
	
//Verify footer-1 Product category links
 HomePage.ProductQuickLinks();

}*/
//===================================================================================================================================================================================


 public static SupplierLoginPage cliclOnSupplierService() throws Throwable{
	    WebDriverCommonFunctions.element_Click("Supplier","Clicked on Supplier");
		//WebDriverCommonFunctions.element_Window_SwitchToChild("Switched");
		/*WebDriverCommonFunctions.element_EnterValuesToTextField("SupplierUserId", "reshma1", "userId entered");
		WebDriverCommonFunctions.element_EnterValuesToTextField("SupplierPassword", "123456", "password entered");
		WebDriverCommonFunctions.element_Click("SupplierSignInBTN", "SignIn button clicked");*/
		return PageFactory.initElements(Scenario1Test.driver, SupplierLoginPage.class);
 }

//===================================================================================================================================
 
 public static CustomerLoginPage clickOnCustomerLogin() throws Throwable
 
 {	
	//WebDriverCommonFunctions.element_Click("Customer_Login_Link", "CustomerLogin is clicked");
	WebElement loginLink = Scenario1Test.driver.findElement(By.xpath("//div[@class='ng-col-33 pad0 ng-scope']//li/a[text()='Customer Login']"));
	System.out.println(loginLink);
	loginLink.click();
	return PageFactory.initElements(Scenario1Test.driver, CustomerLoginPage.class);
	 
 }
 
 public static ProductListPage selectingCategory(){
	 
	 log.info("Scrolling down page");
	 JavascriptExecutor jse2 = (JavascriptExecutor)Scenario1Test.driver;
     jse2.executeScript("window.scrollBy(0,230)","");
     
     Scenario1Test.driver.findElement(By.xpath("html/body/div[4]/ng-view/div[3]/div[1]/div[2]/div[3]/a/img")).click();
     log.info("A category selected");
	return PageFactory.initElements(Scenario1Test.driver, ProductListPage.class);
 }
 
 public static ProductListPage selectingProduct(){
	 
	 JavascriptExecutor jse2 = (JavascriptExecutor)Scenario1Test.driver;
     jse2.executeScript("window.scrollBy(0,230)","");
     
     Scenario1Test.driver.findElement(By.xpath("")).click();
	 return PageFactory.initElements(Scenario1Test.driver, ProductListPage.class);
	 
 }
}
	

