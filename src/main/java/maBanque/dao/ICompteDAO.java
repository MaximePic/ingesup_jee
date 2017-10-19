package maBanque.dao;

import maBanque.model.Compte;

import java.util.List;

public interface ICompteDAO {
    List<Compte> getAccountsByClientId(int clientId);

    void virement(Compte sourceAccount, Compte destinationAccount, double montant);

    void debitCompte(Compte compte, double montant);

    void creditCompte(Compte compte, double montant);
}
