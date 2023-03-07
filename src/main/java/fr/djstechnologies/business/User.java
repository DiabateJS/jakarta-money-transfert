package fr.djstechnologies.business;

public class User {
    private String login;
    private String pwd;
    private String nom;
    private String prenom;
    private String telephone;

    public User() {
    }

    public User(String login, String pwd, String nom, String prenom, String telephone) {
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String getNomComplet(){
        return this.getNom()+" "+this.getPrenom();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
