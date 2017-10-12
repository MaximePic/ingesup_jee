package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestJPA {
    private static  final String PERSISTENCE_UNIT_NAME = "db_banque_jpa";
    private static EntityManagerFactory factory;
    /*private static Logger logger = */

    public static void main(String[] args){
        //Define variables
        Date date= new Date();

        //Create factory
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        //Create Client
        Client client = new Client();
        client.setLogin("root");
        client.setPassword("root");
        client.setNom("Pic");
        client.setPrenom("Maxime");

        //Create Compte
        Compte la = new Compte();
        la.setClient(client);
        la.setLibelle("Livret A");

        //Create liste de compte
        List<Compte> listeComptes = new ArrayList<Compte>();
        listeComptes.add(la);
        client.setComptes(listeComptes);

        //Create transaction
        Transaction transaction = new Transaction();
        transaction.setLibelle("Transaction");
        transaction.setDate(new Timestamp(date.getTime()));
        transaction.setLeCompte(la);

        //Persistence
        em.persist(client);
        em.persist(la);
        em.persist(transaction);

        //Commit
        em.getTransaction().commit();

    }
}
