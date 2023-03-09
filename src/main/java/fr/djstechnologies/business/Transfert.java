package fr.djstechnologies.business;

public class Transfert {
    private long id;
    private long idUser;
    private long idBeneficiaire;
    long montant;
    private String codePromo;
    private String modeReception;
    private String operateur;

    public Transfert() {
    }

    public Transfert(long id, long idUser, long idBeneficiaire, long montant, String codePromo, String modeReception, String operateur) {
        this.id = id;
        this.idUser = idUser;
        this.idBeneficiaire = idBeneficiaire;
        this.montant = montant;
        this.codePromo = codePromo;
        this.modeReception = modeReception;
        this.operateur = operateur;
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

    public long getIdBeneficiaire() {
        return idBeneficiaire;
    }

    public void setIdBeneficiaire(long idBeneficiaire) {
        this.idBeneficiaire = idBeneficiaire;
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
}
