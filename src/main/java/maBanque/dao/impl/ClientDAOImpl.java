package maBanque.dao.impl;

public class ClientDAOImpl extends AbstractDAOImpl {

    public static AbstractDAOImpl abstractDAOImpl = new AbstractDAOImpl();

 /*   public ClientEntity loadClientById(int clientID) {
        ClientEntity result = new ClientEntity();
        Connection con = abstractDAOImpl.JDBCConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT clientID, nom, prenom, login FROM client where clientID=?");
            stmt.setInt(1, clientID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.setClientID(rs.getInt("clientID"));
                result.setNom(rs.getString("nom"));
                result.setPrenom(rs.getString("prenom"));
                result.setLogin(rs.getString("login"));

                System.out.println("Trouvé un client: " + result.toString());
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ClientEntity insertClient(String nom, String prenom, String login, String password) {
        ClientEntity result = new ClientEntity();

        try {
            Connection con = abstractDAOImpl.JDBCConnection();

            PreparedStatement stmt = con.prepareStatement("insert into client (nom, prenom, login, password)" +
                    " values (?, ?, ?, ?)");

            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, login);
            stmt.setString(4, password);

            stmt.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ClientEntity deleteClientById(int clientID) {
        Connection con = abstractDAOImpl.JDBCConnection();
        ClientEntity result = new ClientEntity();

        try {


            PreparedStatement stmt = con.prepareStatement("DELETE FROM client WHERE clientID=?");

            stmt.setInt(1, clientID);
            stmt.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }*/

}
