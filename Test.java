package sn;


public class Test {
    public static void main(String[] args) {
        ArticleDAO articleDAO = new ArticleDAO();

        // Création d'un livre  
        Livre livre = new Livre(0, "Java Programming", "Ibrahima seye", 123456, true);
        articleDAO.ajouterArticle(livre);

        //Création d'un CD
        CD cd = new CD(0, "Waly seck", 42, true);
        articleDAO.ajouterArticle(cd);

        //Création d'un DVD
        DVD dvd = new DVD(0, "Amadeuse", 148, true);
        articleDAO.ajouterArticle(dvd);


        //Ajouter un membre
        // Membre membre = new Membre(1, "Mouhamed", "Fall", "saint_louis", "778967766", "fallAmeth@gmail.com");
        // // articleDAO.ajouterMembre(membre);
        // articleDAO.ajouterMembre(
        // membre.getPrenom(),
        // membre.getNom(),
        // membre.getAdresse(),
        // membre.getTelephone(),
        // membre.getEmail()
        // );




        // Lister les articles
        articleDAO.listerArticles().forEach(article -> article.afficherDetails());
    }
}

