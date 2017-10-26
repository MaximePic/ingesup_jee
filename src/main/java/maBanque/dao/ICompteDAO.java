package maBanque.dao;

import maBanque.model.CompteEntity;

import java.util.List;

public interface ICompteDAO {
    List<CompteEntity> getAccountsByClientId(int clientId);

    void virement(CompteEntity sourceAccount, CompteEntity destinationAccount, double montant);

    void debitCompte(CompteEntity compteEntity, double montant);

    void creditCompte(CompteEntity compteEntity, double montant);

    CompteEntity getAccountById(int accountId);
}
