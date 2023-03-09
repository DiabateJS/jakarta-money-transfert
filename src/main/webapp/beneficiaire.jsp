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
</head>
<body>
<br>
<%@include file="entete.jsp" %>
<br>
<a href="nouveauBeneficiaire.jsp">Ajouter Nouveau Bénéficiaire</a>
<h3>Liste des bénéficiaires</h3>
<br>
<ul>
<%
    BeneficiaireManager benManager = new BeneficiaireManager();
    List<Beneficiaire> beneficiaires = benManager.getAll();
    for (Beneficiaire b : beneficiaires){
        out.println("<li>"+b.getNomComplet()+"</li>");
    }
%>
</ul>
</body>
</html>
