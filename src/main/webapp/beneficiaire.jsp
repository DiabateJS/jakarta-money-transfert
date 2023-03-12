<%@ page import="fr.djstechnologies.logic.BeneficiaireManager" %>
<%@ page import="fr.djstechnologies.business.Beneficiaire" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 09/03/2023
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Beneficiaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<br>
<%@include file="entete.jsp" %>
<br>
    <a href='nouveauBeneficiaire.jsp'>Ajouter Nouveau Bénéficiaire</a>
    <br>
<ul class="list-group">
<%
    BeneficiaireManager benManager = new BeneficiaireManager();
    List<Beneficiaire> beneficiaires = benManager.selectByUserId(conUser.getId());
    out.println("<li class='list-group-item active' aria-current='true'>Bénéficiaires</li>");
    for (Beneficiaire b : beneficiaires){
        out.println("<li class='list-group-item'>"+b.getNomComplet()+"</li>");
    }
%>
</ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
