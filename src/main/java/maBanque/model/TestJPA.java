package maBanque.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

import java.util.List;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;
import static maBanque.model.CRUD.*;

public class TestJPA {
    private static EntityManagerFactory factory;
    private static Logger logger = LogManager.getLogger(TestJPA.class);

    public static void main(String[] args) {
        //Define variables
        EntityManager em = null;

        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();

            //Create factory
            em.getTransaction().begin();

            //Create ClientEntity
            ClientEntity clientEntity = createClient("root", "root", "Pic", "Maxime");
            ClientEntity clientEntity2 = createClient("admin", "admin", "Administrator", "Administrator");

            //Create CompteEntity
            CompteEntity compteEntity1 = createAccount(clientEntity, "Livret A", 1000.00);
            CompteEntity compteEntity2 = createAccount(clientEntity, "CompteEntity d'épargne", 10000.00);

            //Create liste de compte
            createClientAccountList(compteEntity1, clientEntity);
            createClientAccountList(compteEntity2, clientEntity);

            //Create transactionEntity
            TransactionEntity transactionEntity = createTransaction(compteEntity1, compteEntity2, 1000.00, "Salaire");

            //Persistence
            em.persist(clientEntity);
            em.persist(clientEntity2);
            em.persist(compteEntity1);
            em.persist(compteEntity2);
            em.persist(transactionEntity);

            //Commit
            em.getTransaction().commit();

            //DisplayLOgs
            PersistenceUtil util = Persistence.getPersistenceUtil();

            TypedQuery<ClientEntity> tQuery = em.createQuery("from ClientEntity", ClientEntity.class);
            List<ClientEntity> clientEntityList = tQuery.getResultList();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }

}
