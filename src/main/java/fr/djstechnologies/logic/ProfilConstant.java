package fr.djstechnologies.logic;

public class ProfilConstant {
    public static String SELECT_ALL = "select id, libelle from profil";
    public static String SELECT_BY_ID = "select id, libelle from profil where id = ?";
    public static String SELECT_BY_LIBELLE = "select id from profil where libelle = ?";
}
