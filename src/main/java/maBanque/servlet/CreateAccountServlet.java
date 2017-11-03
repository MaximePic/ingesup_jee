package maBanque.servlet;

import maBanque.dao.ICompteDAO;
import maBanque.dao.impl.CompteDAOImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {
    ICompteDAO compteDAO = new CompteDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession(false);
       int clientId= (int) session.getAttribute("clientId");
       String accountLibelle = request.getParameter("account-libelle");
       compteDAO.createAccount(accountLibelle, clientId);
       request.getRequestDispatcher("/templates/create-account.xhtml").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("connected", true);
        request.getRequestDispatcher("/templates/create-account.xhtml").forward(request, response);
    }
}
