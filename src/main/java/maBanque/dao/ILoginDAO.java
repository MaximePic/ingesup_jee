package maBanque.dao;


import maBanque.model.Client;

public interface ILoginDAO {
    Client findClientByCred(String login, String password);


}
