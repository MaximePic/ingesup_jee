package maBanque.dao;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAbstractDAO {

    /**
     * Ouvre une connexion
     * @return
     */
    EntityManager newConnexion();

    /**
     * Ferme une connexion
     * @param em
     */
    void closeConnexion(EntityManager em);

    /**
     * Logout un utilisateur
     * @param request
     * @param response
     */
    void logout(HttpServletRequest request, HttpServletResponse response);
}
