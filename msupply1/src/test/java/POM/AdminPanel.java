package POM;

import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;
import org.openqa.selenium.WebElement;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import GenericLibrary.CommonFunctions;
import GenericLibrary.Credentials;
import GenericLibrary.WebDriverCommonFunctions;
import Scenarios.Scenario1Test;

public class AdminPanel 
{
	
	public static void login_AdminPanel() throws Throwable
	{
		Credentials.url=CommonFunctions.readPropertiesFile("AdminPanel");
		Scenario1Test.driver.get(Credentials.url);
		WebDriverCommonFunctions.element_Click("ClickHere_LinkText_LinkText", "Click on the Link");
		WebDriverCommonFunctions.element_EnterValuesToTextField("InternalPanel_Email_LoginId","anshuman@msupply.com","Entered Email");
		WebDriverCommonFunctions.element_EnterValuesToTextField("InternalPanel_Password","123qwe","Entered Password");
		WebDriverCommonFunctions.element_Click("InternalPanel_Login_Button", "Clicked on Login Button");
		
	}
	
	public static void handlingOTP() throws InterruptedException{
		//MongoClient client = new MongoClient();
		MongoClient mongoClient = null;
		//DB db = mongoClient.getDB("msupplyDB"); 
		char[] password = new char[]{'d','a','t','a','L','o','a','d','1','2','3'};
		MongoCredential credential = MongoCredential.createCredential("msupplyDataLoad","msupplyDB",password);
		//boolean auth = db.authenticate("msupplyDataLoad", password); 
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
		MongoDatabase mydatabase = mongoClient.getDatabase("mydatabase");
		FindIterable<Document> mydatabaserecords = mydatabase.getCollection("collectionName").find();
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("msupplyDB");
		//boolean auth =   db.authenticate("msupplyDataLoad", password); 
		// Use DB 
		DBObject allQuery = new BasicDBObject(); 
		DBCollection collection = db.getCollection("UserOTP"); 
		DBCursor curs = collection.find(); 
		Iterator<DBObject> fields = curs.iterator(); 
		while(fields.hasNext()){ 
		   BasicDBList geoList = (BasicDBList) fields.next().get("GeoLevels");
		   BasicDBObject object = (BasicDBObject) geoList.get(0); // this should return {"5": "Continent_Name"}
		   Object value = object.get("5"); // value should contain "Continent_Name"
		} 
	}
	public static void changeOrderToDelivered(int OrderNumber) throws Throwable
	{
		WebDriverCommonFunctions.element_Click("ManageOrder_Xpath", "Clicked on Manage Order");
		WebElement element=WebDriverCommonFunctions.Table_SearchForElement(CommonFunctions.getElementFromExcel("Xpath_Part_1"),CommonFunctions.getElementFromExcel("Xpath_Part_2"),1,OrderNumber);
		if(element==null)
		{
			WebDriverCommonFunctions.PrintinLogAndHTMLReports("No Order Number generated");
		}
		else
		{
			element.click();
		}
		
		WebDriverCommonFunctions.element_Click("AdminPanel_ConfirmButton_Xpath", "Clicked on Confirm Button");
		WebDriverCommonFunctions.element_Click("AdminPanel_UpdateButton_Xpath","Clicked on UpdateButton");
		WebDriverCommonFunctions.element_SelectDropDown("AdminPanel_SelectDropDown_Xpath", 1, "Success Option Selected");
		WebDriverCommonFunctions.element_Click("AdminPanel_UpdateButton_1_Xpath","Clicked on UpdateButton");
		WebDriverCommonFunctions.element_Click("AdminPanel_AcceptButton_Xpath", "Clicked on Accept Button");
		WebDriverCommonFunctions.element_Click("AdminPanel_ReadyToShipButton_Xpath", "Clicked on ReadyToShip Button");
		WebDriverCommonFunctions.element_Click("AdminPanel_ShipOrderButton_Xpath", "Clicked on ShipOrder Button");
		WebDriverCommonFunctions.element_Click("AdminPanel_DeliverButton_Xpath", "Clicked on ShipOrder Button");
	}
	
	public void MongoConnection(int port) {
		try {
			Mongo mongo = new Mongo("52.30.255.50",27017);
			DB db = mongo.getDB("msupplyDB");
			DBCollection collection = db.getCollection("UserOTP");
			System.out.println(collection.find());
		} 
		catch(MongoException e){
			e.printStackTrace();
		}
	}

}
