package maBanque.controller;

import maBanque.dao.ILoginDAO;
import maBanque.dao.impl.LoginDAOImpl;

public class LoginController {
    ILoginDAO loginDAO = new LoginDAOImpl();


    /**
     * Méthode permettant de ramener un id client en fonction des ses identifiants
     * @param login
     * @param password
     * @return
     */
    public int findClientByCred(String login, String password){
        int clientId = loginDAO.findClientByCred(login, password);
        return clientId;
    }
}
