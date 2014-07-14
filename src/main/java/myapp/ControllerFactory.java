package myapp;

import javax.servlet.http.HttpServletRequest;

public class ControllerFactory {
     public static HttpServletRequest request;

    public static final Controller getControllerByClass(Class actionClass) {
        try {
            Controller controller = (Controller) actionClass.newInstance();

            return (Controller) actionClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            //e.printStackTrace();
            //ignored
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
            //ignored
        } catch (ClassCastException e) {
            //e.printStackTrace();
            //ignored
        }
        return null;
    }

    public static final Controller getControllerByFullClassName(String className) {
        try {
            String name = "myapp.Test" + className + "Controller";
            Class actionClass = Class.forName(name);
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}