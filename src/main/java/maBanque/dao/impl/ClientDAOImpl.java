package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.IClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClientDAOImpl extends AbstractDAOImpl implements IClientDAO {

    public static IAbstractDAO abstractDAO = new AbstractDAOImpl();


    /**
     * Change le password utilisateur
     * @param password
     */
    @Override
    public void changePassword(Integer clientId, String password) {
        //Create connexion
        EntityManager em = abstractDAO.newConnexion();


        //Requete de débit du compte
        Query query = em.createQuery("UPDATE Client c SET c.password = :password where c.clientID = :clientId")
                .setParameter("clientId", clientId)
                .setParameter("password", password);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);

    }

}
