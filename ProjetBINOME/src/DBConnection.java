
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    // Paramètres de connexion
    private final static String userName = "root";
    private final static String password = "";
    private final static String serverName = "127.0.0.1";
    private final static String portNumber = "3306";

    // Nom de la base de données
    private static String dbName = "testpersonne";

    // Instance unique de connexion
    private static Connection instance;

    // Constructeur privé
    private DBConnection() throws SQLException {

        Properties connectionProps = new Properties();

        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        String urlDB = "jdbc:mysql://" + serverName + ":";
        urlDB += portNumber + "/" + dbName;

        instance = DriverManager.getConnection(
                urlDB, connectionProps
        );
    }

    // Méthode pour récupérer la connexion
    public static synchronized Connection getConnection()
            throws SQLException {

        if (instance == null || instance.isClosed()) {
            new DBConnection();
        }

        return instance;
    }
    public static synchronized void setNomDB(String nomDB) throws SQLException {
        if (instance != null && !instance.isClosed()) {
            instance.close();
        }
        dbName = nomDB;
        instance = null;


    }
}
