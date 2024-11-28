package sn;


public class Membre {
    private int id;
    private String prenom;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;

    public Membre(int id, String prenom, String nom, String adresse, String telephone, String email) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    

    // Getters et setters
     // Getters pour accéder aux attributs
     public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void emprunterArticle(Article article) {
        System.out.println(prenom + " a emprunté l'article: " + article.getTitre());
    }

    public void retournerArticle(Article article) {
        System.out.println(prenom + " a retourné l'article: " + article.getTitre());
    }

    public void afficherDetails() {
        System.out.println("Membre: " + prenom + " " + nom);
    }
    
}
