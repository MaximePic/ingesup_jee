package maBanque.filter;

import maBanque.servlet.ServletHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //Page de login
        String loginURI = ServletHelper.getServletUrl(ServletHelper.SERVLET_LOGIN, req);

        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("clientId") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean staticResource = req.getRequestURI().matches(".*[css|jpg|png|gif|js].*");

        // Si identifiants corrects: ok, sinon send vers login
        if (loggedIn || loginRequest || staticResource) {
           chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
