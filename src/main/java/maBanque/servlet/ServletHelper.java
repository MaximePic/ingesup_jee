package maBanque.servlet;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {
    public static final String LOGIN = "templates/login.xhtml";
    public static final String ACCOUNTS = "templates/compte.xhtml";
    public static final String SERVLET_LOGIN = "/login";
    public static final String SERVLET_HOME = "/home";



    public static String getServletUrl(String servlet, HttpServletRequest request){
        return request.getContextPath()+ servlet;
    }
}
