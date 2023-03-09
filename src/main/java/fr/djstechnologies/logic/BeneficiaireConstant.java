package fr.djstechnologies.logic;

public class BeneficiaireConstant {
    public static String CREATE = "insert into beneficiaire(nom, prenom, numero, ville) values (? ,? ,? ,?)";
    public static String SELECT_ALL = "select id, nom, prenom, numero, ville from beneficiaire";
    public static String SELECT_BY_ID = "select id, nom, prenom, numero, ville from beneficiaire where id = ?";
}
