package maBanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWD = "root";

    public static Connection JDBCConnection() {
        Connection con = null;
        try {
            con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/db_banque", DB_LOGIN, DB_PASSWD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
