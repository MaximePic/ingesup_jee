package maBanque.dao;


public interface ILoginDAO {
    int findClientByCred(String login, String password);
}
