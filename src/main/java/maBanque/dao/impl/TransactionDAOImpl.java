package maBanque.dao.impl;

import maBanque.dao.IAbstractDAO;
import maBanque.dao.ITransactionDAO;
import maBanque.model.CompteEntity;
import maBanque.model.TransactionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TransactionDAOImpl implements ITransactionDAO{
    public static IAbstractDAO abstractDAO = new AbstractDAOImpl();

    @Override
    public void createTransaction(String libelle, double montant, CompteEntity compteEntityDebiteur, CompteEntity compteEntityCrediteur) {
        Date date= new Date();

        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setLibelle(libelle);
        transactionEntity.setDate(new Timestamp(date.getTime()));
        transactionEntity.setCompteEntityDebiteur(compteEntityDebiteur);
        transactionEntity.setCompteEntityCrediteur(compteEntityCrediteur);
        transactionEntity.setMontant(montant);

        //Persist
        em.persist(transactionEntity);

        //Commit
        em.getTransaction().commit();

        //Fermeture de la connexion
        abstractDAO.closeConnexion(em);
    }

    @Override
    public List<TransactionEntity> getTransferListByAccountId(int compteId) {
        //Create connexion
        EntityManager em =  abstractDAO.newConnexion();

        //Requete
        Query query = em.createQuery("SELECT t FROM TransactionEntity t where t.compteCrediteur  = :compteId or t.compteCrediteur  = :compteId")
                .setParameter("compteId", compteId);

        List<TransactionEntity> transferList  = query.getResultList();


        //Commit
        em.getTransaction().commit();

        //Close connexion
        abstractDAO.closeConnexion(em);

        return transferList;




    }
}
