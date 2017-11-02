package maBanque.dao;

public interface IClientDAO {
    /**
     * Change le mot de passe utilisateur
     * @param clientId
     * @param password
     */
    void changePassword(Integer clientId, String password);
}
