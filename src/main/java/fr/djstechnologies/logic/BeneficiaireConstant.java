package fr.djstechnologies.logic;

public class BeneficiaireConstant {
    public static String CREATE = "insert into beneficiaire(nom, prenom, numero, ville, userid) values (? ,? ,? ,? , ?)";
    public static String SELECT_ALL = "select id, nom, prenom, numero, ville, userid from beneficiaire";
    public static String SELECT_BY_ID = "select id, nom, prenom, numero, ville, userid from beneficiaire where id = ?";
    public static  String SELECT_BY_USER_ID = "select id, nom, prenom, numero, ville from beneficiaire where userid = ?";
}
