package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ILoginDAO;
import maBanque.model.ClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LoginDAOImpl implements ILoginDAO{
    IAbstractDAO abstractDAO = new AbstractDAOImpl();
    @Override
    public ClientEntity findClientByCred(String login, String password) {

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete
        Query query = em.createQuery("SELECT c.clientID" +
                " FROM ClientEntity c " +
                "WHERE c.login=:login" +
                " AND c.password=:password")
                .setParameter("login", login)
                .setParameter("password", password);

        ClientEntity client = (ClientEntity) query.getSingleResult();

        //Commit
        em.getTransaction().commit();

        //Close connexion
        abstractDAO.closeConnexion(em);

        return client;

    }
}
