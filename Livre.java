package sn;



public class Livre extends Article {
    private String auteur;
    private int isbn;

    public Livre(int id, String titre, String auteur, int isbn, boolean disponibilite) {
        super(id, titre, "Livre", disponibilite);
        this.auteur = auteur;
        this.isbn = isbn;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre: " + titre + " | Auteur: " + auteur + " | ISBN: " + isbn);
    }

    public String getAuteur() {
        return auteur;
    }

    public int getIsbn() {
        return isbn;
    }
}

