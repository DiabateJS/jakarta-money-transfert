package fr.djstechnologies.logic;

public class UserConstant {
    public static String SELECT_AUTH_USER = "select id,nom, prenom, login, password, telephone, email FROM user where login = ? and password = ?";
}