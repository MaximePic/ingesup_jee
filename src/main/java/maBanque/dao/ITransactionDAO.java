package maBanque.dao;

import maBanque.model.Compte;

import java.util.Date;

public interface ITransactionDAO {
    void createTransaction(String libelle, double montant, Compte compteDebiteurNum, Compte CompteCrediteurNum);
}
