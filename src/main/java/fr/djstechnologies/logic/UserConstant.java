package fr.djstechnologies.logic;

public class UserConstant {

    public static String SELECT_ALL = "select u.id, u.nom, u.prenom, u.login, u.password, u.telephone, u.email, u.idprofil, p.libelle as profil from user u join profil p on u.idprofil = p.id";
    public static String SELECT_BY_ID = "select u.id, u.nom, u.prenom, u.login, u.password, u.telephone, u.email, u.idprofil, p.libelle as profil from user u join profil p on u.idprofil = p.id where u.id = ?";
    public static String SELECT_AUTH_USER = "select id,nom, prenom, login, password, telephone, email, idprofil FROM user where login = ? and password = ?";
    public static String CREATE_USER = "insert into user (nom, prenom, login, password, telephone, email, idprofil) values (?, ?, ?, ?, ?, ?, (select id from profil where libelle = ?))";

    public static String UPDATE_USER = "update user set nom = ?, prenom = ?, login = ?, telephone = ?, email = ? where id = ?";
    public static String AFFECT_PROFIL_USER = "update user set idprofil = ? where id = ?";
}

