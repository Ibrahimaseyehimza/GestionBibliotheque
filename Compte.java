package sn;


import java.util.List;

public class Compte {
    private int id;
    private Membre membre;
    private String dateCreation;
    private List<Article> articlesEmpruntes;

    public Compte(int id, Membre membre, String dateCreation) {
        this.id = id;
        this.membre = membre;
        this.dateCreation = dateCreation;
    }

    public Membre getMembre() {
        return membre;
    }
    
    public void emprunterArticle(Article article) {
        articlesEmpruntes.add(article);
    }

    public void retournerArticle(Article article) {
        articlesEmpruntes.remove(article);
    }

    public void afficherDetails() {
        System.out.println("Compte ID: " + id + " | Membre: " + membre);
    }
}

