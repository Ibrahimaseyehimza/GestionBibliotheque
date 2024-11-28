package sn;

public class TestEmprunt {
    public static void main(String[] args) {
        // Créer une instance de EmpruntDAO
        EmpruntDAO empruntDAO = new EmpruntDAO();
        
        // Supposons qu'un membre avec ID 1 veuille emprunter un article avec ID 1
        int membreId = 1;  // ID du membre
        int articleId = 1; // ID de l'article à emprunter
        
        // Appeler la méthode d'emprunt
        boolean empruntEffectue = empruntDAO.emprunterArticle(membreId, articleId);
        
        if (empruntEffectue) {
            System.out.println("L'emprunt a été effectué avec succès.");
        } else {
            System.out.println("L'emprunt a échoué.");
        }
    }


}
