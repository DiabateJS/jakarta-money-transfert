package fr.djstechnologies.logic;

import fr.djstechnologies.business.Beneficiaire;
import fr.djstechnologies.business.Transfert;
import fr.djstechnologies.dal.CoupleValue;
import fr.djstechnologies.dal.DataBaseManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransfertManager {
    private DataBaseManager bdManager = null;

    public TransfertManager() {
        this.bdManager = new DataBaseManager();
    }

    public void create(Transfert transfert){
        CoupleValue[] params = new CoupleValue[8];
        params[0] = new CoupleValue("Int",transfert.getIdUser());
        params[1] = new CoupleValue("Int", transfert.getBeneficiaire().getId());
        params[2] = new CoupleValue("Int", transfert.getMontant());
        params[3] = new CoupleValue("String", transfert.getCodePromo());
        params[4] = new CoupleValue("String", transfert.getModeReception());
        params[5] = new CoupleValue("String", transfert.getOperateur());
        params[6] = new CoupleValue("String", transfert.getMotif());
        params[7] = new CoupleValue("String", transfert.getStatut());
        this.bdManager.executePreparedQuery(TransfertConstant.CREATE, params);
    }

    public List<Transfert> getAll(){
        BeneficiaireManager beneficiaireManager = new BeneficiaireManager();
        List<Transfert> transferts = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(TransfertConstant.SELECT_ALL);
            if (res != null){
                int id;
                int iduser;
                int idbeneficiaire;
                Beneficiaire beneficiaire;
                int montant;
                String codePromo;
                String modeReception;
                String operateur;
                String motif;
                String statut;
                Transfert transfert;
                while(res.next()) {
                    id = res.getInt(1);
                    iduser = res.getInt(2);
                    idbeneficiaire = res.getInt(3);
                    montant = res.getInt(4);
                    codePromo = res.getString(5);
                    modeReception = res.getString(6);
                    operateur = res.getString(7);
                    motif = res.getString(8);
                    statut = res.getString(9);
                    beneficiaire = beneficiaireManager.selectById((long) idbeneficiaire);
                    transfert = new Transfert(id, (long) iduser, beneficiaire , (long) montant, codePromo, modeReception, operateur, motif, statut);
                    transferts.add(transfert);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return transferts;
    }

    public List<Transfert> selectByUserId(int userid){
        List<Transfert> transferts = new ArrayList<>();
        try{
            CoupleValue[] params = new CoupleValue[1];
            params[0] = new CoupleValue("Int", userid);
            ResultSet res = this.bdManager.executePreparedSelect(TransfertConstant.SELECT_TRANSFERTS_BY_USERID, params);
            BeneficiaireManager beneficiaireManager = new BeneficiaireManager();
            int id;
            int idbeneficiaire;
            Beneficiaire beneficiaire;
            int montant;
            String codePromo;
            String modeReception;
            String operateur;
            String motif;
            String statut;
            Transfert transfert;
            while (res.next()){
                id = res.getInt(1);
                idbeneficiaire = res.getInt(2);
                beneficiaire = beneficiaireManager.selectById(idbeneficiaire);
                montant = res.getInt(3);
                codePromo = res.getString(4);
                modeReception = res.getString(5);
                operateur = res.getString(6);
                motif = res.getString(7);
                statut = res.getString(8);
                transfert = new Transfert(id, userid, beneficiaire, montant, codePromo, modeReception, operateur, motif, statut);
                transferts.add(transfert);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return transferts;
    }
}
