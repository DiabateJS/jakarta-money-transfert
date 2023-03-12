package fr.djstechnologies.logic;

import fr.djstechnologies.business.Profil;
import fr.djstechnologies.business.User;
import fr.djstechnologies.dal.CoupleValue;
import fr.djstechnologies.dal.DataBaseManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private DataBaseManager bdManager = null;
    public UserManager() {
        this.bdManager = new DataBaseManager();
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        try{
            ResultSet res = this.bdManager.executeSelect(UserConstant.SELECT_ALL);
            int id;
            String nom;
            String prenom;
            String login;
            String pwd;
            String tel;
            String email;
            int idProfil;
            String libelleProfil;
            Profil profil;
            User user;
            while (res.next()){
                id = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                login = res.getString(4);
                pwd = res.getString(5);
                tel = res.getString(6);
                email = res.getString(7);
                idProfil = res.getInt(8);
                libelleProfil = res.getString(9);
                profil = new Profil(idProfil, libelleProfil);
                user = new User(id, login, pwd, nom, prenom, tel, email, profil);
                users.add(user);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return users;
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
        }catch (Exception e){
            System.out.println(e);
        }
        return authUser;

    }

    public User selectById(long userId){
        User user = null;
        CoupleValue[] params = new CoupleValue[1];
        params[0] = new CoupleValue("Int", userId);
        try {
            ResultSet res = this.bdManager.executePreparedSelect(UserConstant.SELECT_BY_ID, params);
            int id;
            String nom;
            String prenom;
            String login;
            String pwd;
            String tel;
            String email;
            int idProfil;
            String libelleProfil;
            Profil profil;
            while (res.next()){
                id = res.getInt(1);
                nom = res.getString(2);
                prenom = res.getString(3);
                login = res.getString(4);
                pwd = res.getString(5);
                tel = res.getString(6);
                email = res.getString(7);
                idProfil = res.getInt(8);
                libelleProfil = res.getString(9);
                profil = new Profil(idProfil, libelleProfil);
                user = new User(id, login, pwd, nom, prenom, tel, email, profil);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return user;
    }

    public void create(User user){
        CoupleValue[] params = new CoupleValue[7];
        params[0] = new CoupleValue("String", user.getNom());
        params[1] = new CoupleValue("String", user.getPrenom());
        params[2] = new CoupleValue("String", user.getLogin());
        params[3] = new CoupleValue("String", user.getPwd());
        params[4] = new CoupleValue("String", user.getTelephone());
        params[5] = new CoupleValue("String", user.getEmail());
        params[6] = new CoupleValue("String", user.getProfil().getLibelle());
        int res = this.bdManager.executePreparedQuery(UserConstant.CREATE_USER, params);
    }

    public void update(User user){
        CoupleValue[] params = new CoupleValue[6];
        params[0] = new CoupleValue("String", user.getNom());
        params[1] = new CoupleValue("String", user.getPrenom());
        params[2] = new CoupleValue("String", user.getLogin());
        params[3] = new CoupleValue("String", user.getTelephone());
        params[4] = new CoupleValue("String", user.getEmail());
        params[5] = new CoupleValue("Int", user.getId());
        int res = this.bdManager.executePreparedQuery(UserConstant.UPDATE_USER, params);
    }

    public void affectProfilToUser(int profilId, int userId){
        CoupleValue[] params = new CoupleValue[2];
        params[0] = new CoupleValue("Int", profilId);
        params[1] = new CoupleValue("Int", userId);
        int res = this.bdManager.executePreparedQuery(UserConstant.AFFECT_PROFIL_USER, params);
    }
}
