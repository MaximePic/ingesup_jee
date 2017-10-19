package maBanque.dao;

import maBanque.model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


public class CompteDAO extends AbstractDAO {
    public static AbstractDAO abstractDAO = new AbstractDAO();

    /**
     * Méthode permettant de récupérer les comptes d'un client
     * @param clientId l'id du client
     * @return
     */
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
    public void virement(Compte sourceAccount, Compte destinationAccount, double montant) {

        debitCompte(sourceAccount, montant);

        creditCompte(destinationAccount, montant);
    }

    private void debitCompte(Compte compte, double montant){

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

    private void creditCompte(Compte compte, double montant){

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


}
