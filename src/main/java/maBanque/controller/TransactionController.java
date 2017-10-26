package maBanque.controller;

import maBanque.dao.ITransactionDAO;
import maBanque.dao.impl.TransactionDAOImpl;
import maBanque.model.TransactionEntity;

import java.util.List;

public class TransactionController {
    ITransactionDAO transactionDAO = new TransactionDAOImpl();


    /**
     * Récupère la liste des comptes d'un client
     * @param compteId id du client
     * @return
     */
    public List<TransactionEntity> getTransferListByAccountId(int compteId){
        List<TransactionEntity> transferList = transactionDAO.getTransferListByAccountId(compteId);
        return transferList;
    }



    //****GETTERS AND SETTERS****//
}
