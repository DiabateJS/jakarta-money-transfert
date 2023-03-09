package fr.djstechnologies.logic;

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
        CoupleValue[] params = new CoupleValue[6];
        params[0] = new CoupleValue("Int",transfert.getIdUser());
        params[1] = new CoupleValue("Int", transfert.getIdBeneficiaire());
        params[2] = new CoupleValue("Int", transfert.getMontant());
        params[3] = new CoupleValue("String", transfert.getCodePromo());
        params[4] = new CoupleValue("String", transfert.getModeReception());
        params[5] = new CoupleValue("String", transfert.getOperateur());
        this.bdManager.executePreparedQuery(TransfertConstant.CREATE, params);
    }

    public List<Transfert> getAll(){
        List<Transfert> transferts = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(TransfertConstant.SELECT_ALL);
            if (res != null){
                int id;
                int iduser;
                int idbeneficiaire;
                int montant;
                String codePromo;
                String modeReception;
                String operateur;
                Transfert transfert;
                while(res.next()) {
                    id = res.getInt(1);
                    iduser = res.getInt(2);
                    idbeneficiaire = res.getInt(3);
                    montant = res.getInt(4);
                    codePromo = res.getString(5);
                    modeReception = res.getString(6);
                    operateur = res.getString(7);
                    transfert = new Transfert(id, (long) iduser, (long) idbeneficiaire, (long) montant, codePromo, modeReception, operateur);
                    transferts.add(transfert);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return transferts;
    }
}
