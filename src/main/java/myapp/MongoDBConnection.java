/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package myapp;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
//import com.mongodb.MongoCredential;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

/**
 * The tutorial from http://www.mongodb.org/display/DOCS/Java+Tutorial.
 */
public class MongoDBConnection {
    // CHECKSTYLE:OFF //
    /**
     * Run this main method to see the output of this quick example.
     *
     * @param args takes no args
     * @throws UnknownHostException if it cannot connect to a MongoDB instance at localhost:27017
     */
    
	public static void main(final String[] args) throws UnknownHostException {
    	
    }
    
    public void test() 
    {
    	MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	//String server = "mongodb://webuser:toniotonio@ds055709.mongolab.com:55709";
     	//String conectionString = "mongodb://webuser:toniotonio@ds055709.mongolab.com:55709";
     //	MongoClientURI mongoConecctionURI = new MongoClientURI(conectionString);
     //	MongoClient mongoClient = new MongoClient(mongoConecctionURI);
        	
    	
    	DB db = mongoClient.getDB("primal-manifest");
    	//boolean auth = db.authenticate("webuser", "toniotonio".toCharArray());
    	
     	//MongoClient mongoClient = new MongoClient();
            // get handle to "mydb"
    	mongoClient.close();
        
    }
    // CHECKSTYLE:ON
}