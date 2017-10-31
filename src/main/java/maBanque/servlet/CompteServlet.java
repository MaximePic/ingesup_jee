package maBanque.servlet;

import maBanque.controller.CompteController;
import maBanque.model.Compte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/comptes")
public class CompteServlet extends HttpServlet {

    CompteController compteCtrl = new CompteController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int clientId = (int) session.getAttribute("clientId");
        String clientNom = (String) session.getAttribute("clientNom");
        String clientPrenom = (String) session.getAttribute("clientPrenom");

        session.setAttribute("clientNom", clientNom);
        session.setAttribute("clientPrenom", clientPrenom);

        //Liste des comptes du client
        List<Compte> accountList = compteCtrl.getAccountsByClientId(clientId);
        request.setAttribute("connected", true);
        request.setAttribute("accountList", accountList);
        request.getRequestDispatcher("/templates/compte.xhtml").forward(request, response);
    }
}
