package fr.djstechnologies.logic;

import fr.djstechnologies.business.Profil;
import fr.djstechnologies.business.User;
import fr.djstechnologies.dal.CoupleValue;
import fr.djstechnologies.dal.DataBaseManager;

import java.sql.ResultSet;

public class UserManager {
    private DataBaseManager bdManager = null;
    public UserManager() {
        this.bdManager = new DataBaseManager();
    }

    public User authUser(String login, String pwd){
        User authUser = null;
        CoupleValue[] params = new CoupleValue[2];
        params[0] = new CoupleValue("String",login);
        params[1] = new CoupleValue("String", pwd);

        ResultSet res = null;
        try{
            res = this.bdManager.executePreparedSelect(UserConstant.SELECT_AUTH_USER, params);
            if (res != null){
                int id;
                String nom;
                String prenom;
                String telephone;
                String email;
                Profil profil;
                int idprofil;
                ProfilManager profilManager = new ProfilManager();
                while(res.next()) {
                    id = res.getInt(1);
                    nom = res.getString(2);
                    prenom = res.getString(3);
                    telephone = res.getString(6);
                    email = res.getString(7);
                    idprofil = res.getInt(8);
                    profil = profilManager.selectById(idprofil);
                    authUser = new User(id, login, pwd, nom, prenom, telephone, email, profil);
                }
            }
            this.bdManager.closeConn();
        }catch (Exception e){
            System.out.println(e);
        }
        return authUser;

    }
}
