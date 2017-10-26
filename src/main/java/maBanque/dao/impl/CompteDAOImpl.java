package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ICompteDAO;
import maBanque.model.CompteEntity;

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
    public List<CompteEntity> getAccountsByClientId(int clientId) {

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete
        Query query = em.createQuery("SELECT c FROM CompteEntity c where c.client.clientID = :clientId")
                .setParameter("clientId", clientId);

        List<CompteEntity> accountList  = query.getResultList();


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
    public void virement(CompteEntity sourceAccount, CompteEntity destinationAccount, double montant) {
        debitCompte(sourceAccount, montant);
        creditCompte(destinationAccount, montant);
    }

    /**
     * Méthode permettant de débiter un compteEntity
     * @param compteEntity
     * @param montant
     */
    @Override
    public void debitCompte(CompteEntity compteEntity, double montant){

        //Numéro de compteEntity à débiter
        int compteSource = compteEntity.getNumero();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete de débit du compteEntity
        Query query = em.createQuery("UPDATE CompteEntity c SET c.montant= c.montant-:somme where numero = :compteSource")
                .setParameter("somme", montant)
                .setParameter("compteSource", compteSource);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);
    }

    /**
     * Méthode permettant de crediter un compteEntity
     * @param compteEntity
     * @param montant
     */
    @Override
    public void creditCompte(CompteEntity compteEntity, double montant){

        //Numéro de compteEntity à créditer
        int compteDestinataire = compteEntity.getNumero();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete de débit du compteEntity
        Query query = em.createQuery("UPDATE CompteEntity c SET c.montant= c.montant+:somme where numero = :compteDestinataire")
                .setParameter("somme", montant)
                .setParameter("compteDestinataire", compteDestinataire);

        query.executeUpdate();

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);


    }

    @Override
    public CompteEntity getAccountById(int accountId) {
        //Create connexion
        EntityManager em = abstractDAO.newConnexion();

      CompteEntity compteEntity = em.find(CompteEntity.class, accountId);


        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);

        return compteEntity;
    }

}
