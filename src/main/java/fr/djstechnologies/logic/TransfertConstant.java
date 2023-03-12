package fr.djstechnologies.logic;

public class TransfertConstant {
    public static String CREATE = "insert into transfert(iduser,idbeneficiaire,montant,codepromo,modereception,operateur,motif,statut, idoperateur) values (?,?,?,?,?,?,?,?,?)";
    public static String SELECT_ALL = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur, motif, statut, idoperateur from transfert";
    public static String SELECT_TRANSFERTS_BY_USERID = "select id, idbeneficiaire, montant, codepromo, modereception, operateur, motif, statut, idoperateur from transfert where iduser = ?";
}
