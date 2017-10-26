package maBanque.servlet;

import maBanque.controller.TransactionController;
import maBanque.model.TransactionEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {
    TransactionController transactionCtrl = new TransactionController();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TransactionEntity> transferList = transactionCtrl.getTransferListByAccountId(1);

        request.setAttribute("transferList", transferList);

        request.getRequestDispatcher("/templates/transaction.xhtml").forward(request, response);
    }
}
