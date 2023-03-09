package fr.djstechnologies.business;

public class Transfert {
    private long id;
    private long idUser;
    private Beneficiaire beneficiaire;
    long montant;
    private String codePromo;
    private String modeReception;
    private String operateur;
    private String motif;

    public Transfert() {
    }

    public Transfert(long id, long idUser, Beneficiaire beneficiaire, long montant, String codePromo, String modeReception, String operateur, String motif) {
        this.id = id;
        this.idUser = idUser;
        this.beneficiaire = beneficiaire;
        this.montant = montant;
        this.codePromo = codePromo;
        this.modeReception = modeReception;
        this.operateur = operateur;
        this.motif = motif;
    }

    public long getId() {
        return id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
