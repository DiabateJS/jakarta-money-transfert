<%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 12/03/2023
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - User Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <%@include file="entete.jsp" %>
  <br>
  <h2>Informations Utilisateur</h2>
  <br>
    <form action="TraiterModifUserInfo" method="post">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" name="nom" id="nom" class="form-control" value="<%= conUser.getNom()%>" required>
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom</label>
            <input type="text" name="prenom" id="prenom" class="form-control" value="<%= conUser.getPrenom()%>" required>
        </div>
        <div class="mb-3">
            <label for="login" class="form-label">Login</label>
            <input type="text" name="login" id="login" class="form-control" value="<%= conUser.getLogin()%>" required>
        </div>
        <div class="mb-3">
            <label for="numero_mobile" class="form-label">Numero Mobile</label>
            <input type="text" name="numero_mobile" id="numero_mobile" class="form-control" value="<%= conUser.getTelephone()%>" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" name="email" id="email" class="form-control" value="<%= conUser.getEmail()%>" required>
        </div>
        <input type="hidden" name="id" value="<%= conUser.getId()%>">
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
