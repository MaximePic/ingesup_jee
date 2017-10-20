package maBanque.servlet;

import maBanque.controller.CompteController;
import maBanque.dao.ICompteDAO;
import maBanque.dao.impl.CompteDAOImpl;
import maBanque.model.Compte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accueil/*")
public class Accueil extends HttpServlet {

    CompteController compteCtrl = new CompteController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Compte> accountList = compteCtrl.getAccountsByClientId(1);
        compteCtrl.virement(accountList.get(1), accountList.get(0), 1050);

        request.setAttribute("accountList", accountList);
        request.getRequestDispatcher("/templates/accueil.xhtml").forward(request, response);
    }
}
