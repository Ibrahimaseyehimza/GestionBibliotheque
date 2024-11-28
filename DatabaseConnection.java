package sn;

// public class DatabaseConnection {
    
// }
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/gestionbibliotheque";  // URL de la base de données
    private static final String USER = "postgres"; // Nom d'utilisateur PostgreSQL
    private static final String PASSWORD = "user"; // Mot de passe PostgreSQL

    public static Connection getConnection() throws SQLException {
        try {
            // Charger le driver JDBC PostgreSQL (optionnel, dépend de la version de JDBC)
            Class.forName("org.postgresql.Driver");
            // Retourner la connexion
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL JDBC driver is missing", e);
        }
    }
}
