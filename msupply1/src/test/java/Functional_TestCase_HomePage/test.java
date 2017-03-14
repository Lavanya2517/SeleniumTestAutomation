package Functional_TestCase_HomePage;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class test {

	public static void main(String[] args) {
		new test().MongoConnection(0);
	}
	
	public void MongoConnection(int port) {
		try {
			MongoClient mongoClient = null;
			//DB db = mongoClient.getDB("msupplyDB"); 
			char[] password = new char[]{'d','a','t','a','L','o','a','d','1','2','3'};
			MongoCredential credential = MongoCredential.createCredential("msupplyDataLoad","msupplyDB",password);
			//boolean auth = db.authenticate("msupplyDataLoad", password); 
			mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
			MongoDatabase mydatabase = mongoClient.getDatabase("mydatabase");
			FindIterable<Document> mydatabaserecords = mydatabase.getCollection("collectionName").find();
		} 
		catch(MongoException e){
			e.printStackTrace();
		}
	}
	
}
