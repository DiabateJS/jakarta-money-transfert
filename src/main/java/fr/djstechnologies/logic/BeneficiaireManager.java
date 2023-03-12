package fr.djstechnologies.logic;

import fr.djstechnologies.business.Beneficiaire;
import fr.djstechnologies.dal.CoupleValue;
import fr.djstechnologies.dal.DataBaseManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaireManager {
    private DataBaseManager bdManager = null;

    public BeneficiaireManager() {
        this.bdManager = new DataBaseManager();
    }

    public void create(Beneficiaire beneficiaire){
        CoupleValue[] params = new CoupleValue[5];
        params[0] = new CoupleValue("String",beneficiaire.getNom());
        params[1] = new CoupleValue("String", beneficiaire.getPrenom());
        params[2] = new CoupleValue("String", beneficiaire.getNumero());
        params[3] = new CoupleValue("String", beneficiaire.getVille());
        params[4] =new CoupleValue("Int", beneficiaire.getUserId());
        this.bdManager.executePreparedQuery(BeneficiaireConstant.CREATE, params);
    }

    public List<Beneficiaire> getAll(){
        List<Beneficiaire> beneficiaires = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(BeneficiaireConstant.SELECT_ALL);
            if (res != null){
                int id;
                String nom;
                String prenom;
                String numero;
                String ville;
                int userId;
                Beneficiaire beneficiaire;
                while(res.next()) {
                    id = res.getInt(1);
                    nom = res.getString(2);
                    prenom = res.getString(3);
                    numero = res.getString(4);
                    ville = res.getString(5);
                    userId = res.getInt(6);
                    beneficiaire = new Beneficiaire(id, nom, prenom, numero, ville, userId);
                    beneficiaires.add(beneficiaire);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return beneficiaires;
    }

    public List<Beneficiaire> selectByUserId(long userId){
        List<Beneficiaire> beneficiaires = new ArrayList<>();
        CoupleValue[] params = new CoupleValue[1];
        params[0] = new CoupleValue("Int", userId);
        try{
            ResultSet res = this.bdManager.executePreparedSelect(BeneficiaireConstant.SELECT_BY_USER_ID, params);
            int id;
            String nom;
            String prenom;
            String numero;
            String ville;
            Beneficiaire beneficiaire;
            while (res.next()){
                id = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                numero = res.getString(4);
                ville = res.getString(5);
                beneficiaire = new Beneficiaire(id, nom, prenom, numero, ville, userId);
                beneficiaires.add(beneficiaire);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return beneficiaires;
    }

    public Beneficiaire selectById(long idBeneficiaire){
        CoupleValue[] params = new CoupleValue[1];
        params[0] = new CoupleValue("Int",idBeneficiaire);
        Beneficiaire beneficiaire = null;
        try{
            ResultSet res = this.bdManager.executePreparedSelect(BeneficiaireConstant.SELECT_BY_ID, params);
            int id;
            String nom;
            String prenom;
            String numero;
            String ville;
            int userId;
            while (res.next()){
                id = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                numero = res.getString(4);
                ville = res.getString(5);
                userId = res.getInt(6);
                beneficiaire = new Beneficiaire(id, nom, prenom, numero, ville, userId);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return beneficiaire;
    }
}
