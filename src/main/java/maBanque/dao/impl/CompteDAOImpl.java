package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ICompteDAO;
import maBanque.model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class CompteDAOImpl extends AbstractDAOImpl implements ICompteDAO {
        public static IAbstractDAO abstractDAO = new AbstractDAOImpl();

    /**
     * Méthode permettant de récupérer les comptes d'un client
     * @param clientId l'id du client
     * @return
     */
    @Override
    public List<Compte> getAccountsByClientId(int clientId) {

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete
        Query query = em.createQuery("SELECT c FROM Compte c where c.client.clientID = :clientId")
                .setParameter("clientId", clientId);

        List<Compte> accountList  = query.getResultList();


        //Commit
        em.getTransaction().commit();

        //Close connexion
        abstractDAO.closeConnexion(em);

        return accountList;
    }

    /**
     * Méthode permettant de réaliser un virement
     * @param sourceAccount compte source à débiter
     * @param destinationAccount compte destonataire à créditer
     * @param montant montant de la transaction
     */
    @Override
    public void virement(Compte sourceAccount, Compte destinationAccount, double montant) {
        debitCompte(sourceAccount, montant);
        creditCompte(destinationAccount, montant);
    }

    /**
     * Méthode permettant de débiter un compte
     * @param compte
     * @param montant
     */
    @Override
    public void debitCompte(Compte compte, double montant){

        //Numéro de compte à débiter
        int compteSource = compte.getNumero();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete de débit du compte
        Query query = em.createQuery("UPDATE Compte c SET c.montant= c.montant-:somme where numero = :compteSource")
                .setParameter("somme", montant)
                .setParameter("compteSource", compteSource);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);
    }

    /**
     * Méthode permettant de crediter un compte
     * @param compte
     * @param montant
     */
    @Override
    public void creditCompte(Compte compte, double montant){

        //Numéro de compte à créditer
        int compteDestinataire = compte.getNumero();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete de débit du compte
        Query query = em.createQuery("UPDATE Compte c SET c.montant= c.montant+:somme where numero = :compteDestinataire")
                .setParameter("somme", montant)
                .setParameter("compteDestinataire", compteDestinataire);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);


    }

    @Override
    public Compte getAccountById(int accountId) {
        //Create connexion
        EntityManager em = abstractDAO.newConnexion();

      Compte compte = em.find(Compte.class, accountId);


        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);

        return compte;
    }

}
