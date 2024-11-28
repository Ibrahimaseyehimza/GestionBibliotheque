package sn;



public abstract class Article {
    protected int id;
    protected String titre;
    protected String type;
    protected boolean disponibilite;

    public Article(int id, String titre, String type, boolean disponibilite) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.disponibilite = disponibilite;
    }

    public abstract void afficherDetails();

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }
}
