package maBanque.dao.impl;


import maBanque.dao.IAbstractDAO;

import javax.persistence.*;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;

public class AbstractDAOImpl implements IAbstractDAO {

    private static EntityManagerFactory factory = null;

    private static EntityManager em;


    /**
     * Méthode permettant d'ouvrir une connexion
     * @return em
     */
    @Override
    public EntityManager newConnexion(){
        factory = createFactory();
        if(em == null){
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            return em;
        }

        return em;
    }

    /**
     * Méthode permettant de fermer une connexion
     */
    @Override
    public void closeConnexion(EntityManager em) {
        if (em != null) {
            if (em.isOpen()) {
                EntityTransaction t = em.getTransaction();
                if (t.isActive()) {
                    try {
                        t.rollback();
                    } catch (PersistenceException e) {
                    }
                }
                em.close();
            }
        }
    }

    /**
     * Create factory
     * @return
     */
    private static EntityManagerFactory createFactory(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }


}
