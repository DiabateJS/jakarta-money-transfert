package fr.djstechnologies.business;

public class Beneficiaire {
    private long id;
    private String nom;
    private String prenom;
    private String numero;
    private String ville;

    public Beneficiaire() {
    }

    public Beneficiaire(long id, String nom, String prenom, String numero, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.ville = ville;
    }

    public long getId() {
        return id;
    }

    public String getNomComplet(){
        return this.nom + " " + this.prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
