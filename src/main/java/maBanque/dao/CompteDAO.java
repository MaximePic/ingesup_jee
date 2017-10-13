package maBanque.dao;

import maBanque.model.Client;
import maBanque.model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;

public class CompteDAO extends AbstractDAO {
    public static AbstractDAO  abstractDAO = new AbstractDAO();

    private static EntityManagerFactory factory;
    EntityManager em = null;

    public List<Compte> loadAccountsByClientId(int clientId){
        List<Compte> accountList = new ArrayList<>();

        try {
            //Create factory
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
            em.getTransaction().begin();

            //Requete
            Connection con = abstractDAO.JDBCConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Compte where clientID=?");
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();

            //Resultat
            while (rs.next()) {
                Compte actualAccount = new Compte();
                actualAccount.setLibelle(rs.getString("libelle"));
                actualAccount.setNumero(rs.getInt("numero"));

                accountList.add(actualAccount);
            }

            //Commit
            em.getTransaction().commit();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

}
