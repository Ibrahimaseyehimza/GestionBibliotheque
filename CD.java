package sn;


public class CD extends Article {
    private int duree;

    public CD(int id, String titre, int duree, boolean disponibilite) {
        super(id, titre, "CD", disponibilite);
        this.duree = duree;
    }
    
    @Override
    public void afficherDetails() {
        System.out.println("CD: " + titre + " | Durée: " + duree + " min");
    }

    public int getDuree() {
        return duree;
    }
}
