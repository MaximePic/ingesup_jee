package maBanque.dao;

import javax.persistence.EntityManager;

public interface IAbstractDAO {

    EntityManager newConnexion();

    void closeConnexion(EntityManager em);
}
