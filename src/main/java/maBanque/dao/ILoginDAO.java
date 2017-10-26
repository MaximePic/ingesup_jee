package maBanque.dao;

import maBanque.model.ClientEntity;

public interface ILoginDAO {
    ClientEntity findClientByCred(String login, String password);
}
