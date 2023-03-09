<%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 09/03/2023
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Nouveau Bénéficiaire</title>
</head>
<body>
<br>
<%@include file="entete.jsp" %>
<br>
<form action="AjoutBeneficiaire" method="post">
  <label for="nom">Nom</label>
  <input type="text" name="nom" id="nom"><br>
  <label for="prenom">Prenom</label>
  <input type="text" name="prenom" id="prenom"><br>
  <label for="numero_mobile">Numero Mobile</label>
  <input type="text" name="numero_mobile" id="numero_mobile"><br>
  <label for="ville">Ville</label>
  <input type="text" name="ville" id="ville"><br>
  <input type="submit" value="Ajouter">
</form>
</body>
</html>
