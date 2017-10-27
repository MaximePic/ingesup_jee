package maBanque.controller;

import maBanque.dao.ILoginDAO;
import maBanque.dao.impl.LoginDAOImpl;
import maBanque.model.Client;

public class LoginController {
    ILoginDAO loginDAO = new LoginDAOImpl();


    /**
     * Méthode permettant de ramener un id client en fonction des ses identifiants
     * @param login
     * @param password
     * @return
     */
    public Client findClientByCred(String login, String password){
        Client client = loginDAO.findClientByCred(login, password);
        return client;
    }
}
