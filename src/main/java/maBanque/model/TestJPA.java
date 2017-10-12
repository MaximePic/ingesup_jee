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

            //Create Client
            Client client = createClient("root", "root", "Pic", "Maxime");

            //Create Compte
            Compte compte = createAccount(client, "Livret A");

            //Create liste de compte
            createClientAccountList(compte, client);

            //Create transaction
            Transaction transaction = createTransaction(compte, "Transaction 1");

            //Persistence
            em.persist(client);
            em.persist(compte);
            em.persist(transaction);

            //Commit
            em.getTransaction().commit();

            //DisplayLOgs
            PersistenceUtil util = Persistence.getPersistenceUtil();

            TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
            List<Client> clientList = tQuery.getResultList();

            for (Client c : clientList) {
                logger.info(c.toString());
                logger.debug("is client loaded ? " + util.isLoaded(c));
                logger.debug("Are account loaded ? " + util.isLoaded(c.getComptes()));
                Compte co = c.getComptes().get(0);
                logger.debug("are transactions loaded ? " + util.isLoaded(co, "transcations"));
                co.getTransactions();
                logger.debug("are transactions loaded now ? " + util.isLoaded(co, "transactions"));

                if(co.getTransactions() != null){
                    for (Transaction tran : co.getTransactions()) {
                        logger.info(tran.toString());
                    }
                }else{
                    logger.info("Compte sans transaction");
                }

            }
            logger.info("Size " + clientList.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }

}
