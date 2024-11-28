package sn;


import java.util.Date;

public class Emprunt {
    private int id;
    private Compte compte;
    private Article article;
    private Date dateEmprunt;
    private Date dateRetour;

    public Emprunt(int id, Compte compte, Article article, Date dateEmprunt, Date dateRetour) {
        this.id = id;
        this.compte = compte;
        this.article = article;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

     // Getters et Setters
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    // Méthode d'affichage des détails de l'emprunt
    public void afficherDetails() {
        System.out.println("Emprunt de l'article: " + article.getTitre() + " | Membre: " + compte.getMembre().getPrenom() + " " + compte.getMembre().getNom());
        System.out.println("Date d'emprunt: " + dateEmprunt);
        System.out.println("Date de retour prévue: " + dateRetour);
    }
}

