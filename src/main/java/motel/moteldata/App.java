package motel.moteldata;

import java.io.File;
import java.io.IOException;

import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	com.mongodb.client.MongoClient mongoClient = MongoClients.create("mongodb://125.7.128.42:4001");
    	MongoDatabase database = mongoClient.getDatabase("meteor");
    	for (String name : database.listCollectionNames()) {
    	    System.out.println(name);
    	}
    	//MongoCollection<Document> coll = database.getCollection("rooms");

        System.out.println( "Hello World!" );
        File file = new File("c:\\motel\\1024Hotel.mdb");
        Database db = new DatabaseBuilder()
                .setFile(file)
                .setReadOnly(true)
                //.setCodecProvider(new CryptCodecProvider("inanojoa"))
                .open();
       
        Table table = db.getTable("TotalEvent");
        for(Row row : table) {
          System.out.println("Column 'a' has value: " + row.get("nToId"));
        }
    }
}
