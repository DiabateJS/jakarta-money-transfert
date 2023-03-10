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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<br>
<%@include file="entete.jsp" %>
<br>
    <h3>Transfert d'argent vers la CI</h3>
    <br>
<form action="Transfert" method="post">
    <div class="mb-3">
        <label for="mode_reception" class="form-label">Mode Reception</label>
        <select name="mode_reception" id="mode_reception" class="form-control" required>
            <option value="espece">Retrait en espèces</option>
            <option value="portefeuille_mobile">Portefeuille Mobile</option>
            <option value="recharge_mobile">Recharge Mobile</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="montant" class="form-label">Montant</label>
        <input type="text" class="form-control" name="montant" id="montant" required>
    </div>
    <div class="mb-3">
        <label for="code_promo" class="form-label">Code promo</label>
        <input type="text" class="form-control" name="code_promo" id="code_promo">
    </div>
    <div class="mb-3">
        <label for="operateur_telephonique" class="form-label">Opérateur Téléphonique</label>
        <select name="operateur_telephonique" id="operateur_telephonique" class="form-control" required>
            <option value="orange">Orange Mobile</option>
            <option value="mtn">MTN</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="beneficiaire" class="form-label">Bénéficiaire</label>
        <select name="beneficiaire" id="beneficiaire" class="form-control" required>
            <%
                BeneficiaireManager benManager = new BeneficiaireManager();
                List<Beneficiaire> beneficiaires = benManager.getAll();
                for (Beneficiaire b : beneficiaires){
                    out.println("<option value='"+b.getId()+"'>"+b.getNomComplet()+"</option>");
                }
            %>
        </select>
    </div>
    <div class="mb-3">
        <label for="motif" class="form-label">Motif</label>
        <input type="text" name="motif" id="motif" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary">Envoyer</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
