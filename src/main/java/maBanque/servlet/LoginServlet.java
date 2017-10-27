package maBanque.servlet;

import maBanque.controller.LoginController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    LoginController loginController = new LoginController();

    public LoginServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userConnectedId = 0;

        //Find user by login and pswd
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login != null && password!= null){
            userConnectedId = loginController.findClientByCred(login, password);
        }

        //Si les identifiants sont bon
        if(userConnectedId != 0){
            //On créer une session et on set les id de l'utilisateur
            HttpSession session = request.getSession();
            session.setAttribute("client", userConnectedId);

            //On redirige vers page d'accueil
            response.sendRedirect(request.getContextPath() + ServletHelper.SERVLET_ACCOUNT);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/templates/login.xhtml").forward(request, response);
    }
}
