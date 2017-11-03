package maBanque.dao;

import maBanque.model.Compte;

import java.util.List;

public interface ICompteDAO {
    List<Compte> getAccountsByClientId(int clientId);

    /**
     * Permet de réaliser un virement inter-bancaire
     * @param sourceAccount
     * @param destinationAccount
     * @param montant
     */
    void virement(Compte sourceAccount, Compte destinationAccount, double montant);

    /**
     * Permet de débiter un compte
     * @param compte
     * @param montant
     */
    void debitCompte(Compte compte, double montant);

    /**
     * Permet de créditer un compte
     * @param compte
     * @param montant
     */
    void creditCompte(Compte compte, double montant);

    /**
     * Récupère un compte par son id
     * @param accountId
     * @return
     */
    Compte getAccountById(int accountId);

    /**
     * CRéer un compte
     * @param clientId
     */
    void createAccount(String libelle, int clientId);
}
