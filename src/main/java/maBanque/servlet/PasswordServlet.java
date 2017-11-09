package maBanque.servlet;

import maBanque.dao.IClientDAO;
import maBanque.dao.ICompteDAO;
import maBanque.dao.impl.ClientDAOImpl;
import maBanque.dao.impl.CompteDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static maBanque.constants.Constants.PASSWORD_REGEX;

@WebServlet("/changePassword")
public class PasswordServlet extends HttpServlet {
    IClientDAO clientDAO = new ClientDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String newPasswordConfirm = request.getParameter("new-password-confirm");

        //Non null;
        boolean condition1 = oldPassword != null && newPassword != null && newPasswordConfirm != null;
        boolean condition2 = !oldPassword.isEmpty() && !newPassword.isEmpty() && !newPasswordConfirm.isEmpty();
        boolean condition3 = newPassword.equals(newPasswordConfirm);

        if(condition1 && condition2 && condition3){
            HttpSession session = request.getSession(false);
            Integer clientId = (Integer) session.getAttribute("clientId");

            clientDAO.changePassword(clientId, newPassword);
            request.getRequestDispatcher("/templates/login.xhtml").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("connected", true);
        request.getRequestDispatcher("/templates/change-password.xhtml").forward(request, response);
    }
}
