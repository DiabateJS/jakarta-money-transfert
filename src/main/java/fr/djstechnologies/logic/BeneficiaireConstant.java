package fr.djstechnologies.logic;

public class BeneficiaireConstant {
    public static String CREATE = "insert into beneficiaire(nom, prenom, numero, ville, motif) values (? ,? ,? ,? ,? )";
    public static String SELECT_ALL = "select id, nom, prenom, numero, ville, motif from beneficiaire";
}
