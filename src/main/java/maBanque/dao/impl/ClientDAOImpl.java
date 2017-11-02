package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.IClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static maBanque.constants.Constants.PASSWORD_REGEX;

public class ClientDAOImpl extends AbstractDAOImpl implements IClientDAO {

    public static IAbstractDAO abstractDAO = new AbstractDAOImpl();


    /**
     * Change le password utilisateur
     * @param password
     */
    @Override
    public boolean changePassword(Integer clientId, String password) {
        //Create connexion
        EntityManager em = abstractDAO.newConnexion();

        if(!password.matches(PASSWORD_REGEX) || clientId == null){
            return false;
        }


        //Requete de débit du compte
        Query query = em.createQuery("UPDATE Client c SET c.password = :password where c.clientID = :clientId")
                .setParameter("clientId", clientId)
                .setParameter("password", password);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);

        return true;

    }

}
