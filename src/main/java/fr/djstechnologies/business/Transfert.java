package fr.djstechnologies.business;

public class Transfert {
    private long id;
    private User user;
    private Beneficiaire beneficiaire;
    long montant;
    private String codePromo;
    private String modeReception;
    private String operateurMobile;
    private String motif;
    private String statut;
    private User operateur;

    public Transfert() {
    }

    public Transfert(long id, User user, Beneficiaire beneficiaire, long montant, String codePromo, String modeReception, String operateurMobile, String motif, String statut, User operateur) {
        this.id = id;
        this.user = user;
        this.beneficiaire = beneficiaire;
        this.montant = montant;
        this.codePromo = codePromo;
        this.modeReception = modeReception;
        this.operateurMobile = operateurMobile;
        this.motif = motif;
        this.statut = statut;
        this.operateur = operateur;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public long getMontant() {
        return montant;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public String getModeReception() {
        return modeReception;
    }

    public void setModeReception(String modeReception) {
        this.modeReception = modeReception;
    }

    public String getOperateurMobile() {
        return operateurMobile;
    }

    public void setOperateurMobile(String operateurMobile) {
        this.operateurMobile = operateurMobile;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public User getOperateur() {
        return operateur;
    }

    public void setOperateur(User operateur) {
        this.operateur = operateur;
    }
}
