package myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DemoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
        super.init();


    }
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)  
    		throws IOException{
		//MongoDBConnection mongoDB = new MongoDBConnection();
		System.out.println("GET");
		//mongoDB.test();
		doPost(req,resp);
    	
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String clientOrigin = request.getHeader("origin");
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", clientOrigin);
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        out.println("{ \"name\": \" Primal Manifest is up and running\" }");
        try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.close();
        
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/") + 1, request.getRequestURL().length());
            System.out.println("url:"+url);
            String controller = url;//:url.substring(0, url.indexOf("."));
            System.out.println("CONTROLLER:"+controller);
            ControllerFactory.request = request;
            Controller control = ControllerFactory.getControllerByFullClassName(controller);
            control.init(request);
            control.execute();
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());
           // requestDispatcher.forward(request, response);
            System.out.println("FINAL:");
            	
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}