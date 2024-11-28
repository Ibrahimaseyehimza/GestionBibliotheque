package sn;



public class DVD extends Article {
    private int duree;

    public DVD(int id, String titre, int duree, boolean disponibilite) {
        super(id, titre, "DVD", disponibilite);
        this.duree = duree;
    }

    @Override
    public void afficherDetails() {
        System.out.println("DVD: " + titre + " | Durée: " + duree + " min");
    }

    public int getDuree() {
        return duree;
    }
}

