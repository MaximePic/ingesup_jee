package maBanque.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe du jeu de données
 */
public class CRUD {

    /**
     * Méthode permettant de créer un client
     * @return le client
     */
    public static ClientEntity createClient(String login, String password, String nom, String prenom){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setLogin(login);
        clientEntity.setPassword(password);
        clientEntity.setNom(nom);
        clientEntity.setPrenom(prenom);

        return clientEntity;
    }

    /**
     * Méthode permettant de créer un compte
     * @param clientEntity
     * @return
     */
    public static CompteEntity createAccount(ClientEntity clientEntity, String libelle, double montant){
        CompteEntity compteEntity = new CompteEntity();
        compteEntity.setClientEntity(clientEntity);
        compteEntity.setLibelle(libelle);
        compteEntity.setMontant(montant);

        return compteEntity;
    }

    /**
     * Méthode permettant d'associer une liste de comptes à un clientEntity
     * @param compteEntity
     * @param clientEntity
     */
    public static void createClientAccountList(CompteEntity compteEntity, ClientEntity clientEntity){
        List<CompteEntity> listeCompteEntities = new ArrayList<CompteEntity>();
        listeCompteEntities.add(compteEntity);
        clientEntity.setCompteEntities(listeCompteEntities);
    }

    /**
     * Méthode permettant de créer une transaction
     * @param compteEntityDebiteur
     * @param compteEntityCrediteur
     * @param montant
     * @param libelle
     * @return
     */
    public static TransactionEntity createTransaction(CompteEntity compteEntityDebiteur, CompteEntity compteEntityCrediteur, double montant, String libelle){
        Date date= new Date();

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setLibelle(libelle);
        transactionEntity.setDate(new Timestamp(date.getTime()));
        transactionEntity.setCompteEntityDebiteur(compteEntityDebiteur);
        transactionEntity.setCompteEntityCrediteur(compteEntityCrediteur);
        transactionEntity.setMontant(montant);
        return transactionEntity;
    }
}
