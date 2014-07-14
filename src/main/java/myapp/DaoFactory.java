package myapp;


import com.mongodb.DBCollection;
import org.apache.catalina.Session;

public class DaoFactory {
    
    public static CategoryDao getCategoryDao()
    {
        return (CategoryDao)getDAOByClassAndName(CategoryDao.class,"category");
    }
    public static AbstractDAO getDAOByClassAndName(Class c,String name)
    {
        try 
        {
            DBCollection collection= getCollection(name);
            
            AbstractDAO d = (AbstractDAO)c.newInstance();
             d.setDbCollection(collection);       
            return d;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     public static DBCollection getCollection(String name)
    {
        return MongoUtil.getCollection(name);
    }
}
