package fr.djstechnologies.logic;

public class TransfertConstant {
    public static String CREATE = "insert into transfert(iduser,idbeneficiaire,montant,codepromo,modereception,operateur_mobile,motif,statut, idoperateur) values (?,?,?,?,?,?,?,?,?)";
    public static String SELECT_ALL = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur_mobile, motif, statut, idoperateur from transfert";
    public static String SELECT_TRANSFERTS_BY_USERID = "select id, idbeneficiaire, montant, codepromo, modereception, operateur_mobile, motif, statut, idoperateur from transfert where iduser = ?";
    public static String SELECT_WITHOUT_OPERATOR = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur_mobile, motif, statut from transfert where idoperateur = NULL OR idoperateur = 0";
    public static String UPDATE = "update transfert set iduser = ? , idbeneficiaire = ? , montant = ? , codepromo = ? , modereception = ? , operateur_mobile = ? , motif = ? , statut = ? , idoperateur = ? where id = ?";
    public static String SELECT_BY_ID = "select id, iduser, idbeneficiaire, montant, codepromo, modereception, operateur_mobile, motif, statut, idoperateur from transfert where id = ?";
}
