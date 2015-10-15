package inmemdb.nosql;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
 
import com.mongodb.DB;
import com.mongodb.MongoClient;
 
public class MongoTry2 {
 
    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient();
		 
		@SuppressWarnings("deprecation")
		List<String> databases = mongoClient.getDatabaseNames();
		 
		
		
		for (String dbName : databases) {
		    System.out.println("- Database: " + dbName);
		     
		    DB db = mongoClient.getDB(dbName);
		     
		    Set<String> collections = db.getCollectionNames();
		    for (String colName : collections) {
		        System.out.println("\t + Collection: " + colName);
		    }
		}
		 
		mongoClient.close();
         
    }
}