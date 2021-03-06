package maBanque.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;
import static maBanque.model.CRUD.*;

public class GenerateJDD {
    private static EntityManagerFactory factory;
    private static Integer MAX_ACCOUNTS = 20;
    private static Integer MIN_VALUE = 0;
    private static Integer MAX_MONEY = 10000;
    private static Integer MAX_CLIENTS = 5;

    public static void main(String[] args) {
        //Define variables
        EntityManager em = null;

        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();

            //Create factory
            em.getTransaction().begin();

            //**********STANDARD DATA**********//
            //Create Client
            Client client = createClient("root", "root", "Pic", "Maxime");
            Client client2 = createClient("admin", "admin", "Administrator", "Administrator");


            //Create Compte
            Compte compte1 = createAccount(client, "Livret A", 1000.00);
            Compte compte2 = createAccount(client, "Compte d'épargne", 10000.00);

            //Create liste de compte
            createClientAccountList(compte1, client);
            createClientAccountList(compte2, client);

            //Create transaction
            Transaction transaction = createTransaction(compte1, compte2, 1000.00, "Salaire");
            //Create transaction
            Transaction transaction2 = createTransaction(compte2, compte1, 50.00, "Cantine");

            //Persistence
            em.persist(client);
            em.persist(client2);
            em.persist(compte1);
            em.persist(compte2);
            em.persist(transaction);
            em.persist(transaction2);


            //**********GENERATED DATA**********//

            //Generate Accounts
            for (int i = 0; i<MAX_ACCOUNTS; i++){
                Compte tempCompte = createAccount( client, "Compte"+ i, ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_MONEY));
                em.persist(tempCompte);
            }

            //Generate clients
            for (int i = 0; i<MAX_CLIENTS; i++){
               Client tempClient = createClient("login"+i, "2%Azerty","client"+i, "Bot"+i);
                em.persist(tempClient);
            }

            //Commit
            em.getTransaction().commit();

            //DisplayLOgs
            PersistenceUtil util = Persistence.getPersistenceUtil();

            TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
            List<Client> clientList = tQuery.getResultList();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }

}
