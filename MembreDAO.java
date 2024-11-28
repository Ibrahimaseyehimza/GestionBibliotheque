package sn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;


public class MembreDAO {
    private Connection connection;

    public MembreDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            // Gérer l'exception, par exemple afficher un message d'erreur ou loguer l'erreur
            e.printStackTrace();
        }
    }

    //Methode pour ajouter un membre
    public int ajouterMembre(String prenom, String nom, String adresse, String telephone, String email) {
        String sql = "INSERT INTO membres (prenom, nom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, prenom);
            statement.setString(2, nom);
            statement.setString(3, adresse);
            statement.setString(4, telephone);
            statement.setString(5, email);
            
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int membreId = generatedKeys.getInt(1);  // Récupère l'ID du membre généré
                    System.out.println("Membre ajouté avec succès, ID: " + membreId);
                    return membreId;  // Retourne l'ID du membre pour créer un compte ultérieurement
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // Si l'insertion échoue, retourner -1
    }

    //MEthode pour créer Compte
    public void creerCompte(int membreId) {
        String sql = "INSERT INTO comptes (membre_id, date_creation, emprunts_en_cours) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, membreId);  // ID du membre pour lier le compte
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));  // Date actuelle
            statement.setInt(3, 0);  // Aucun emprunt en cours au début
            
            statement.executeUpdate();
            System.out.println("Compte créé avec succès pour le membre ID: " + membreId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
