<%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 10/03/2023
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - User Profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <%@include file="entete.jsp" %>
    <br>
    <a href="modif_user_info.jsp">Modifier Info</a><br>
    Profil : <b><%= conUser.getProfil().getLibelle() %></b><br>
    Login : <%= conUser.getLogin() %><br>
    Nom : <%= conUser.getNom()%> <br>
    Prenom : <%= conUser.getPrenom() %><br>
    Telephone : <%= conUser.getTelephone() %><br>
    Email : <%= conUser.getEmail() %><br>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
