package sn;

public class TestMembre {

        public static void main(String[] args) {
            MembreDAO membreDAO = new MembreDAO();
            
            // Étape 1 : Ajouter un membre
            int membreId = membreDAO.ajouterMembre("Yannick", "barella", "123 Rue keurmassar", "0123456789", "yannick.barella@example.com");
            
            if (membreId != -1) {
                // Étape 2 : Créer un compte pour ce membre
                membreDAO.creerCompte(membreId);
            } else {
                System.out.println("Erreur lors de l'ajout du membre.");
            }
        }
    
    
}
