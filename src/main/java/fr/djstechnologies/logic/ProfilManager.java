package fr.djstechnologies.logic;

import fr.djstechnologies.business.Profil;
import fr.djstechnologies.dal.CoupleValue;
import fr.djstechnologies.dal.DataBaseManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProfilManager {
    private DataBaseManager bdManager;

    public ProfilManager() {
        this.bdManager = new DataBaseManager();
    }

    public List<Profil> getAll(){
        List<Profil> profils = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(ProfilConstant.SELECT_ALL);
            int id;
            String libelle;
            Profil profil = null;
            while (res.next()){
                id = res.getInt(1);
                libelle = res.getString(2);
                profil = new Profil(id, libelle);
                profils.add(profil);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return profils;
    }

    public Profil selectById(long id){
        Profil profil = null;
        try{
            CoupleValue[] params = new CoupleValue[1];
            params[0] = new CoupleValue("Int", id);
            ResultSet res = this.bdManager.executePreparedSelect(ProfilConstant.SELECT_BY_ID, params);
            String libelle;
            while(res.next()){
                libelle = res.getString(2);
                profil = new Profil(id, libelle);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return profil;
    }

    public Profil selectByLibelle(String libelle){
        CoupleValue[] params = new CoupleValue[1];
        params[0] = new CoupleValue("String", libelle);
        Profil profil = null;
        try{
            ResultSet res = this.bdManager.executePreparedSelect(ProfilConstant.SELECT_BY_LIBELLE, params);
            int id;
            while (res.next()){
                id = res.getInt(1);
                profil = new Profil(id, libelle);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return profil;
    }
}
