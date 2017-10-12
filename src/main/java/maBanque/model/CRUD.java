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
    public static Client createClient(String login, String password, String nom, String prenom){
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        client.setNom(nom);
        client.setPrenom(prenom);

        return client;
    }

    /**
     * Méthode permettant de créer un compte
     * @param client
     * @return
     */
    public static Compte createAccount(Client client, String libelle){
        Compte compte = new Compte();
        compte.setClient(client);
        compte.setLibelle(libelle);

        return compte;
    }

    /**
     * Méthode permettant d'associer une liste de comptes à un client
     * @param compte
     * @param client
     */
    public static void createClientAccountList(Compte compte, Client client){
        List<Compte> listeComptes = new ArrayList<Compte>();
        listeComptes.add(compte);
        client.setComptes(listeComptes);
    }

    /**
     * Méthode permettant de créer une transaction
     * @param compte
     * @return la transaction
     */
    public static Transaction createTransaction(Compte compte, String libelle){
        Date date= new Date();

        Transaction transaction = new Transaction();
        transaction.setLibelle(libelle);
        transaction.setDate(new Timestamp(date.getTime()));
        transaction.setLeCompte(compte);
        return transaction;
    }
}
