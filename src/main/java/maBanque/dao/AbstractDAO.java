package maBanque.dao;


import javax.persistence.*;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;

public class AbstractDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;

    private static EntityManager em;

    /**
     * Méthode permettant d'ouvrir une connexion
     * @return em
     */
    public EntityManager newConnexion(){

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    /**
     * Méthode permettant de fermer une connexion
     */
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


}
