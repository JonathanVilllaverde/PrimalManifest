package myapp;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public  class AbstractDAO {
    
    private DBCollection dbCollection;
    public AbstractDAO() {
    }

    /**
     * @return the dbCollectionl
     */
    public DBCollection getDbCollection() {
        return dbCollection;
    }

    /**
     * @param dbCollectionl the dbCollectionl to set
     */
    public void setDbCollection(DBCollection dbCollection) {
        this.dbCollection = dbCollection;
    }
    public  DBCursor getAll(){
        DBCursor find = dbCollection.find();
        return find;
    }
    public void insert(BasicDBObject dbObject){
        dbCollection.insert(dbObject);
    }
    public void remove(BasicDBObject dbObject){
        dbCollection.remove(dbObject);
    }
    public void update(BasicDBObject old,BasicDBObject dbObject){
        dbCollection.update(old, dbObject);
    }
    public DBObject getByID(int id){
        DBObject returnObject=null;
        BasicDBObject query=new BasicDBObject();
        query.put("id", new Integer(id));
        DBCursor find = dbCollection.find(query);
        while(find.hasNext()){
            returnObject=find.next();
            
        }
        return returnObject;
    }
}