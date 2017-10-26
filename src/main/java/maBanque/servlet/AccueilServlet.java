package maBanque.servlet;

import maBanque.controller.CompteController;
import maBanque.model.CompteEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class AccueilServlet extends HttpServlet {

    CompteController compteCtrl = new CompteController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CompteEntity> accountList = compteCtrl.getAccountsByClientId(1);

        request.setAttribute("accountList", accountList);
        request.getRequestDispatcher("/templates/accueil.xhtml").forward(request, response);
    }
}