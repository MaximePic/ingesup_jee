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

        HttpSession session = req.getSession(false);
        String loginURI = ServletHelper.getServletUrl(ServletHelper.SERVLET_LOGIN, req);

        boolean loggedIn = session != null && session.getAttribute("client") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        /* Non-filtrage des ressources statiques */
        if(req.getRequestURI().matches(".*[css|jpg|png|gif|js].*")){
            chain.doFilter(request, response);
            return;
        }

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
