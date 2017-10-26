package maBanque.dao;

import maBanque.model.CompteEntity;
import maBanque.model.TransactionEntity;

import java.util.List;

public interface ITransactionDAO {
    void createTransaction(String libelle, double montant, CompteEntity compteEntityDebiteurNum, CompteEntity compteEntityCrediteurNum);

    List<TransactionEntity> getTransferListByAccountId(int compteId);
}
