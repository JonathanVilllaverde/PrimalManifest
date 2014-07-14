package myapp;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class CategoryDao extends AbstractDAO{
    
    public CategoryDao(){
        super();
    }
    public DBCursor getMainCategories(){
        BasicDBObject query=new BasicDBObject();
        //query.put("x", 10);
        DBCursor find = this.getDbCollection().find();
        return find;
    }
}
