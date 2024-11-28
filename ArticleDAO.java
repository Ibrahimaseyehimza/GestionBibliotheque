package sn;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private Connection connection;

    // public ArticleDAO() {
    //     connection = DatabaseConnection.getConnection();
    // }
    public ArticleDAO() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            // Gérer l'exception, par exemple afficher un message d'erreur ou loguer l'erreur
            e.printStackTrace();
        }
    }
    

    public void ajouterArticle(Article article) {
        String sql = "INSERT INTO articles (titre, type, auteur, isbn, duree, disponibilite) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, article.getTitre());
            statement.setString(2, article.getType());
            if (article instanceof Livre) {
                Livre livre = (Livre) article;
                statement.setString(3, livre.getAuteur());
                statement.setInt(4, livre.getIsbn());
                statement.setNull(5, Types.INTEGER);  // CD/DVD n'ont pas d'ISBN
            } else if (article instanceof CD || article instanceof DVD) {
                statement.setNull(3, Types.VARCHAR); // Pas d'auteur pour CD/DVD
                statement.setNull(4, Types.INTEGER); // Pas d'ISBN pour CD/DVD
                statement.setInt(5, ((CD) article).getDuree());
            }
            statement.setBoolean(6, article.isDisponibilite());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Article> listerArticles() {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM articles";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("type");
                if ("Livre".equals(type)) {
                    articles.add(new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"),
                            rs.getInt("isbn"), rs.getBoolean("disponibilite")));
                } else if ("CD".equals(type)) {
                    articles.add(new CD(rs.getInt("id"), rs.getString("titre"), rs.getInt("duree"),
                            rs.getBoolean("disponibilite")));
                } else if ("DVD".equals(type)) {
                    articles.add(new DVD(rs.getInt("id"), rs.getString("titre"), rs.getInt("duree"),
                            rs.getBoolean("disponibilite")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    // Méthodes pour supprimer et mettre à jour les articles...
    // public void supprimerArticle(int articleId) {
    //     String sql = "DELETE FROM articles WHERE id = ?";
    //     try (PreparedStatement statement = connection.prepareStatement(sql)) {
    //         statement.setInt(1, articleId);  // L'ID de l'article à supprimer
    //         int rowsAffected = statement.executeUpdate();
    //         if (rowsAffected > 0) {
    //             System.out.println("L'article a été supprimé avec succès.");
    //         } else {
    //             System.out.println("Aucun article trouvé avec cet ID.");
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    
    
    
}

