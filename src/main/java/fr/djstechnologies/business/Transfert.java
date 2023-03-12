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
    private String statut;
    private long idOperateur;

    public Transfert() {
    }

    public Transfert(long id, long idUser, Beneficiaire beneficiaire, long montant, String codePromo, String modeReception, String operateur, String motif, String statut, long idOperateur) {
        this.id = id;
        this.idUser = idUser;
        this.beneficiaire = beneficiaire;
        this.montant = montant;
        this.codePromo = codePromo;
        this.modeReception = modeReception;
        this.operateur = operateur;
        this.motif = motif;
        this.statut = statut;
        this.idOperateur = idOperateur;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public long getIdOperateur() {
        return idOperateur;
    }

    public void setIdOperateur(long idOperateur) {
        this.idOperateur = idOperateur;
    }
}
