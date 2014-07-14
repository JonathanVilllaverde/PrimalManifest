package myapp;

import com.google.gson.Gson;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class TestdemoController extends AbstractController {

    public void execute() {

        CategoryDao categoriesDao = DaoFactory.getCategoryDao();
        DBCursor mainCategories = categoriesDao.getMainCategories();
        System.out.print(mainCategories);
       // this.setReturnPage("/index.jsp");
       this.getRequest().setAttribute("categories", mainCategories);
    }

    public static String dbobjectToJson(DBCursor mainCategories)
    {
    	
    	//Gson gson = new Gson();
    	//String json = gson.toJson(mainCategories);
    	
    	//String json = "{'test' : 1}";

        return JSON.serialize(mainCategories.next());
    }
    
}