package maBanque.servlet;

import maBanque.dao.CompteDAO;
import maBanque.model.Compte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accueil")
public class Accueil extends HttpServlet {
    CompteDAO compteDAO = new CompteDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Compte> accountList = compteDAO.loadAccountsByClientId(17);

        request.setAttribute("accountList",accountList);
        request.getRequestDispatcher("/templates/accueil.xhtml").forward(request, response);
    }
}
