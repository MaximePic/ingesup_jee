package maBanque.dao;

import javax.persistence.EntityManager;

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
}
