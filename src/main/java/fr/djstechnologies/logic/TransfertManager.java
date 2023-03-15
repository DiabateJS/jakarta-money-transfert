package fr.djstechnologies.logic;

import fr.djstechnologies.business.Beneficiaire;
import fr.djstechnologies.business.Transfert;
import fr.djstechnologies.business.User;
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
        CoupleValue[] params = new CoupleValue[9];
        params[0] = new CoupleValue("Int",transfert.getUser().getId());
        params[1] = new CoupleValue("Int", transfert.getBeneficiaire().getId());
        params[2] = new CoupleValue("Int", transfert.getMontant());
        params[3] = new CoupleValue("String", transfert.getCodePromo());
        params[4] = new CoupleValue("String", transfert.getModeReception());
        params[5] = new CoupleValue("String", transfert.getOperateurMobile());
        params[6] = new CoupleValue("String", transfert.getMotif());
        params[7] = new CoupleValue("String", transfert.getStatut());
        params[8] = new CoupleValue("Int", transfert.getIdOperateur());
        this.bdManager.executePreparedQuery(TransfertConstant.CREATE, params);
    }

    public void update(Transfert transfert){
        CoupleValue[] params = new CoupleValue[10];
        params[0] = new CoupleValue("Int", transfert.getUser().getId());
        params[1] = new CoupleValue("Int", transfert.getBeneficiaire().getId());
        params[2] = new CoupleValue("Int", transfert.getMontant());
        params[3] = new CoupleValue("String", transfert.getCodePromo());
        params[4] = new CoupleValue("String", transfert.getModeReception());
        params[5] = new CoupleValue("String", transfert.getOperateurMobile());
        params[6] = new CoupleValue("String", transfert.getMotif());
        params[7] = new CoupleValue("String", transfert.getStatut());
        params[8] = new CoupleValue("Int", transfert.getIdOperateur());
        params[9] = new CoupleValue("Int", transfert.getId());
        int res = this.bdManager.executePreparedQuery(TransfertConstant.UPDATE, params);
    }

    public List<Transfert> getAll(){
        BeneficiaireManager beneficiaireManager = new BeneficiaireManager();
        List<Transfert> transferts = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(TransfertConstant.SELECT_ALL);
            if (res != null){
                int id;
                int iduser;
                User user;
                int idbeneficiaire;
                Beneficiaire beneficiaire;
                int montant;
                String codePromo;
                String modeReception;
                String operateurMobile;
                String motif;
                String statut;
                int idOperateur;
                Transfert transfert;
                UserManager userManager = new UserManager();
                while(res.next()) {
                    id = res.getInt(1);
                    iduser = res.getInt(2);
                    user = userManager.selectById(iduser);
                    idbeneficiaire = res.getInt(3);
                    montant = res.getInt(4);
                    codePromo = res.getString(5);
                    modeReception = res.getString(6);
                    operateurMobile = res.getString(7);
                    motif = res.getString(8);
                    statut = res.getString(9);
                    idOperateur = res.getInt(10);
                    beneficiaire = beneficiaireManager.selectById((long) idbeneficiaire);
                    transfert = new Transfert(id, user, beneficiaire , (long) montant, codePromo, modeReception, operateurMobile, motif, statut, (long) idOperateur);
                    transferts.add(transfert);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return transferts;
    }

    public Transfert selectById(int transfertId){
        Transfert transfert = null;
        BeneficiaireManager beneficiaireManager = new BeneficiaireManager();
        try{
            CoupleValue[] params = new CoupleValue[1];
            params[0] = new CoupleValue("Int", transfertId);
            ResultSet res = this.bdManager.executePreparedSelect(TransfertConstant.SELECT_BY_ID, params);
            if (res != null) {
                int id;
                int iduser;
                User user;
                int idbeneficiaire;
                Beneficiaire beneficiaire;
                int montant;
                String codePromo;
                String modeReception;
                String operateurMobile;
                String motif;
                String statut;
                int idOperateur;
                UserManager userManager = new UserManager();
                while (res.next()) {
                    id = res.getInt(1);
                    iduser = res.getInt(2);
                    user = userManager.selectById(iduser);
                    idbeneficiaire = res.getInt(3);
                    montant = res.getInt(4);
                    codePromo = res.getString(5);
                    modeReception = res.getString(6);
                    operateurMobile = res.getString(7);
                    motif = res.getString(8);
                    statut = res.getString(9);
                    idOperateur = res.getInt(10);
                    beneficiaire = beneficiaireManager.selectById((long) idbeneficiaire);
                    transfert = new Transfert(id, user, beneficiaire, (long) montant, codePromo, modeReception, operateurMobile, motif, statut, (long) idOperateur);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return transfert;
    }

    public List<Transfert> selectByUserId(int userid){
        List<Transfert> transferts = new ArrayList<>();
        UserManager userManager = new UserManager();
        User user = userManager.selectById(userid);
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
            String operateurMobile;
            String motif;
            String statut;
            int idOperateur;
            Transfert transfert;
            while (res.next()){
                id = res.getInt(1);
                idbeneficiaire = res.getInt(2);
                beneficiaire = beneficiaireManager.selectById(idbeneficiaire);
                montant = res.getInt(3);
                codePromo = res.getString(4);
                modeReception = res.getString(5);
                operateurMobile = res.getString(6);
                motif = res.getString(7);
                statut = res.getString(8);
                idOperateur = res.getInt(9);
                transfert = new Transfert(id, user, beneficiaire, montant, codePromo, modeReception, operateurMobile, motif, statut, idOperateur);
                transferts.add(transfert);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return transferts;
    }

    public List<Transfert> selectWithoutOperators(){
        List<Transfert> transferts = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(TransfertConstant.SELECT_WITHOUT_OPERATOR);
            BeneficiaireManager beneficiaireManager = new BeneficiaireManager();
            UserManager userManager = new UserManager();
            int id;
            int userId;
            User user;
            int idbeneficiaire;
            Beneficiaire beneficiaire;
            int montant;
            String codePromo;
            String modeReception;
            String operateurMobile;
            String motif;
            String statut;
            int idOperateur;
            Transfert transfert;
            while (res.next()){
                id = res.getInt(1);
                userId = res.getInt(2);
                user = userManager.selectById(userId);
                idbeneficiaire = res.getInt(3);
                beneficiaire = beneficiaireManager.selectById(idbeneficiaire);
                montant = res.getInt(4);
                codePromo = res.getString(5);
                modeReception = res.getString(6);
                operateurMobile = res.getString(7);
                motif = res.getString(8);
                statut = res.getString(9);
                idOperateur = 0;
                transfert = new Transfert(id, user, beneficiaire, montant, codePromo, modeReception, operateurMobile, motif, statut, idOperateur);
                transferts.add(transfert);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return transferts;
    }
}
