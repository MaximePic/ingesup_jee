package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ICompteDAO;
import maBanque.dao.ITransactionDAO;
import maBanque.model.Compte;
import maBanque.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TransactionDAOImpl implements ITransactionDAO{
    public static IAbstractDAO abstractDAO = new AbstractDAOImpl();
    public static ICompteDAO compteDAO = new CompteDAOImpl();

    @Override
    public void createTransaction(String libelle, double montant, Compte compteDebiteur, Compte compteCrediteur) {
        Date date= new Date();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        Transaction transaction = new Transaction();
        transaction.setLibelle(libelle);
        transaction.setDate(new Timestamp(date.getTime()));
        transaction.setCompteDebiteur(compteDebiteur);
        transaction.setCompteCrediteur(compteCrediteur);
        transaction.setMontant(montant);

        //Persist
        em.persist(transaction);

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);
    }

    @Override
    public List<Transaction> getTransferListByAccountId(int compteId) {


        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        Compte compte = compteDAO.getAccountById(compteId);


        //Requete
        Query query = em.createQuery("SELECT t FROM Transaction t where t.compteCrediteur  = :compte or t.compteDebiteur  = :compte")
                .setParameter("compte", compte);

        List<Transaction> transferList  = query.getResultList();


        //Commit
        em.getTransaction().commit();

        //Close connexion
        abstractDAO.closeConnexion(em);

        return transferList;




    }
}
