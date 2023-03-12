<%@ page import="fr.djstechnologies.logic.UserManager" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.djstechnologies.logic.ProfilManager" %>
<%@ page import="fr.djstechnologies.business.Profil" %><%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 12/03/2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Affect User Profil</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <br>
  <%@include file="entete.jsp" %>
  <br>
  <h2>Affecter Profil à Utilisateur</h2>
  <br>
  <%
    UserManager userManager = new UserManager();
    List<User> users = userManager.getAll();
    ProfilManager profilManager = new ProfilManager();
    List<Profil> profils = profilManager.getAll();
  %>
  <form action="TraiterAffectProfilToUser" method="post">
    <div class="mb-3">
      <label for="user" class="form-label">Utilisateur</label>
      <select type="text" name="user" id="user" class="form-control" required>
        <%
          for (User user : users){
            out.println("<option value='"+user.getId()+"'>"+user.getNomComplet()+"</option>");
          }
        %>
      </select>
    </div>
    <div class="mb-3">
      <label for="profil" class="form-label">Profil</label>
      <select type="text" name="profil" id="profil" class="form-control" required>
        <%
          for (Profil profil : profils){
              out.println("<option value='"+profil.getId()+"'>"+profil.getLibelle()+"</option>");
          }
        %>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Affecter</button>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
