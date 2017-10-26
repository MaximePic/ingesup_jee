package maBanque.controller;

import maBanque.dao.ILoginDAO;
import maBanque.dao.impl.LoginDAOImpl;
import maBanque.model.ClientEntity;

public class LoginController {
    ILoginDAO loginDAO = new LoginDAOImpl();


    /**
     * Méthode permettant de ramener un objet client en fonction des ses identifiants
     * @param login
     * @param password
     * @return
     */
    public ClientEntity findClientByCred(String login, String password){
        ClientEntity client = loginDAO.findClientByCred(login, password);
        return client;
    }
}
