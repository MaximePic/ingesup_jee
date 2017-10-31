package maBanque.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import maBanque.controller.CompteController;
import maBanque.controller.TransactionController;
import maBanque.dao.IAbstractDAO;
import maBanque.dao.ICompteDAO;
import maBanque.dao.impl.AbstractDAOImpl;
import maBanque.dao.impl.CompteDAOImpl;
import maBanque.model.Compte;
import maBanque.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/transactions/*")
public class TransactionServlet extends HttpServlet {
    IAbstractDAO abstractDAO = new AbstractDAOImpl();
    TransactionController transactionCtrl = new TransactionController();
    ICompteDAO compteDAO = new CompteDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("connected", true);

        //Id du compte qui sera utilisé pour afficher les transactions
        Integer accountId = abstractDAO.getLastUriParameter(request);

        //Compte
        Compte compte = compteDAO.getAccountById(accountId);
        int accountNumber = compte.getNumero();
        String accountName = compte.getLibelle().toString();


        if(accountId != null){
            request.setAttribute("account", accountId);
            request.setAttribute("accountName", accountName);
            request.setAttribute("accountNumber", accountNumber);
            List<Transaction> transferList = transactionCtrl.getTransferListByAccountId(accountId);
            request.setAttribute("transferList", transferList);
            request.getRequestDispatcher("/templates/transaction.xhtml").forward(request, response);
        }

    }
}
