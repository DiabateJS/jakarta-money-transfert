package fr.djstechnologies.logic;

public class UserConstant {
    public static String SELECT_AUTH_USER = "select id,nom, prenom, login, password, telephone, email, idprofil FROM user where login = ? and password = ?";
    public static String CREATE_USER = "insert into user (nom, prenom, login, password, telephone, email, idprofil) values (?, ?, ?, ?, ?, ?, (select id from profil where libelle = ?))";
}

