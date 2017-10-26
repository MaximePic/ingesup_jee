package maBanque.dao;

import maBanque.model.Compte;
import maBanque.model.Transaction;

import java.util.Date;
import java.util.List;

public interface ITransactionDAO {
    void createTransaction(String libelle, double montant, Compte compteDebiteurNum, Compte CompteCrediteurNum);

    List<Transaction> getTransferListByAccountId(int compteId);
}
