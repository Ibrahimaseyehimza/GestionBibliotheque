package sn;

import java.sql.*;


public class EmpruntDAO {

    private Connection connection;

    public EmpruntDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour emprunter un article
    public boolean emprunterArticle(int membreId, int articleId) {
        String sqlCheckAvailability = "SELECT disponibilite FROM articles WHERE id = ?";
        String sqlInsertEmprunt = "INSERT INTO emprunts (compte_id, article_id, date_emprunt, date_retour, amende) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdateArticle = "UPDATE articles SET disponibilite = false WHERE id = ?";
        String sqlUpdateCompte = "UPDATE comptes SET emprunts_en_cours = emprunts_en_cours + 1 WHERE membre_id = ?";
        String sqlGetCompteId = "SELECT id FROM comptes WHERE membre_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);  // Démarre la transaction

            // Vérifier si l'article est disponible
            try (PreparedStatement stmtCheck = conn.prepareStatement(sqlCheckAvailability)) {
                stmtCheck.setInt(1, articleId);
                ResultSet rs = stmtCheck.executeQuery();
                if (rs.next() && rs.getBoolean("disponibilite") == false) {
                    System.out.println("L'article n'est pas disponible.");
                    return false;  // L'article n'est pas disponible
                }
            }

            // Récupérer l'ID du compte du membre
            int compteId = -1;
            try (PreparedStatement stmtGetCompte = conn.prepareStatement(sqlGetCompteId)) {
                stmtGetCompte.setInt(1, membreId);
                ResultSet rsCompte = stmtGetCompte.executeQuery();
                if (rsCompte.next()) {
                    compteId = rsCompte.getInt("id");
                }
            }

            // Enregistrer l'emprunt dans la table 'emprunts'
            try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsertEmprunt)) {
                stmtInsert.setInt(1, compteId);  // ID du compte
                stmtInsert.setInt(2, articleId);  // ID de l'article
                stmtInsert.setDate(3, new java.sql.Date(System.currentTimeMillis()));  // Date actuelle pour l'emprunt
                stmtInsert.setNull(4, Types.DATE);  // Date de retour (à définir ultérieurement)
                stmtInsert.setFloat(5, 0.0f);  // Aucune amende au début
                stmtInsert.executeUpdate();
            }

            // Mettre à jour la disponibilité de l'article (le marquer comme emprunté)
            try (PreparedStatement stmtUpdateArticle = conn.prepareStatement(sqlUpdateArticle)) {
                stmtUpdateArticle.setInt(1, articleId);
                stmtUpdateArticle.executeUpdate();
            }

            // Mettre à jour le nombre d'emprunts en cours du membre
            try (PreparedStatement stmtUpdateCompte = conn.prepareStatement(sqlUpdateCompte)) {
                stmtUpdateCompte.setInt(1, membreId);
                stmtUpdateCompte.executeUpdate();
            }

            // Commit de la transaction
            conn.commit();
            System.out.println("Emprunt effectué avec succès.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();  // Annuler en cas d'erreur
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        }
    }
}
