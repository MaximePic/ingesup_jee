package maBanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static maBanque.constants.Constants.DB_LOGIN;
import static maBanque.constants.Constants.DB_PASSWORD;

public class AbstractDAO {

    public static Connection JDBCConnection() {
        Connection con = null;
        try {
            con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/db_banque_jpa", DB_LOGIN, DB_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
