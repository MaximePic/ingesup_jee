package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ITransactionDAO;
import maBanque.model.Compte;
import maBanque.model.Transaction;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;

public class TransactionDAOImpl implements ITransactionDAO{
    public static IAbstractDAO abstractDAO = new AbstractDAOImpl();

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
}
