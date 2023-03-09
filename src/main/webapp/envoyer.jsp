<%@ page import="fr.djstechnologies.logic.BeneficiaireManager" %>
<%@ page import="fr.djstechnologies.business.Beneficiaire" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 08/03/2023
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Envoyer</title>
</head>
<body>
<br>
<%@include file="entete.jsp" %>
<br>
<form action="Envoyer" method="post">
    <h3>Transfert d'argent vers la CI</h3>
    <br>
    <label for="mode_reception">Mode Reception</label>
    <select name="mode_reception" id="mode_reception" required>
        <option value="espece">Retrait en espèces</option>
        <option value="portefeuille_mobile">Portefeuille Mobile</option>
        <option value="recharge_mobile">Recharge Mobile</option>
    </select><br>
    <label for="montant">Montant</label>
    <input type="text" name="montant" id="montant" required><br>
    <label for="code_promo">Code promo</label>
    <input type="text" name="code_promo" id="code_promo"><br>
    <label for="operateur_telephonique">Opérateur Téléphonique</label>
    <select name="operateur_telephonique" id="operateur_telephonique" required>
        <option value="orange">Orange Mobile</option>
        <option value="mtn">MTN</option>
    </select><br>
    <label for="beneficiaire">Bénéficiaire</label>
    <select name="beneficiaire" id="beneficiaire" required>
        <%
            BeneficiaireManager benManager = new BeneficiaireManager();
            List<Beneficiaire> beneficiaires = benManager.getAll();
            for (Beneficiaire b : beneficiaires){
                out.println("<option value='"+b.getId()+"'>"+b.getNomComplet()+"</option>");
            }
        %>
    </select><br>
    <input type="submit" value="Envoyer">
</form>
</body>
</html>
