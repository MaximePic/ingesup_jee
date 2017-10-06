package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TestJPA {
    private static  final String PERSISTENCE_UNIT_NAME = "db_banque_jpa";
    private static EntityManagerFactory factory;

    public static void main(String[] args){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        //Create Client
        em.getTransaction().begin();
        Client client = new Client();
        client.setLogin("root");
        client.setPassword("root");
        client.setNom("Pic");
        client.setPrenom("Maxime");

        //Create Compte
        Compte compte = new Compte();
        compte.setLibelle("Livret A");
        List<Compte> listeComptes = new ArrayList<Compte>();
        listeComptes.add(compte);
        client.setComptes(listeComptes);

        //Persistence et commit
        em.persist(client);
        em.persist(compte);
        em.getTransaction().commit();

        TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
        List<Client> clientList = tQuery.getResultList();
        for(Client toto: clientList){
            System.out.println(toto);
        }


    }
}
