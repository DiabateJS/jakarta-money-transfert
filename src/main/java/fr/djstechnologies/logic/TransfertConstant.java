package fr.djstechnologies.logic;

public class TransfertConstant {
    public static String CREATE = "insert into transfert(iduser,idbeneficiaire,montant,codepromo,modereception,operateur) values (?,?,?,?,?,?)";
    public static String SELECT_ALL = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur from transfert";
}
