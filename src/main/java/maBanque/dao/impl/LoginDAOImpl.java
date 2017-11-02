package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ILoginDAO;
import maBanque.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class LoginDAOImpl implements ILoginDAO{
    IAbstractDAO abstractDAO = new AbstractDAOImpl();
    @Override
    public Client findClientByCred(String login, String password) {

        try {
            //Create connexion
            EntityManager em = abstractDAO.newConnexion();

            //Requete
            Query query = em.createQuery("SELECT c" +
                    " FROM Client c " +
                    "WHERE c.login=:login" +
                    " AND c.password=:password")
                    .setParameter("login", login)
                    .setParameter("password", password);

            Client client = (Client) query.getSingleResult();


            //Commit
            em.getTransaction().commit();

            //Close connexion
            abstractDAO.closeConnexion(em);

            return client;
        }catch (NoResultException e){
            return null;
        }

    }
}
