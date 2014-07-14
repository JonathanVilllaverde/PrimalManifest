package myapp;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MongoUtil {
    private static  DB database;
    static{
        try {
//connect to the database
            Mongo mongo=new Mongo("localhost" , 27017 );
//get tutorials database
            database=mongo.getDB("primal-manifest");
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MongoException ex) {
            Logger.getLogger(MongoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//get collection from database
    public static DBCollection getCollection(String collectionName){
        return database.getCollection(collectionName);
    }
}
