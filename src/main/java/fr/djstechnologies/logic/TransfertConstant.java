package fr.djstechnologies.logic;

public class TransfertConstant {
    public static String CREATE = "insert into transfert(iduser,idbeneficiaire,montant,codepromo,modereception,operateur,motif,statut) values (?,?,?,?,?,?,?,?)";
    public static String SELECT_ALL = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur, motif, statut from transfert";
    public static String SELECT_TRANSFERTS_BY_USERID = "select id, idbeneficiaire, montant, codepromo, modereception, operateur, motif, statut from transfert where iduser = ?";
}
