<%@ page import="fr.djstechnologies.business.User" %>
<%@ page import="fr.djstechnologies.logic.TransfertManager" %>
<%@ page import="fr.djstechnologies.business.Transfert" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DJS Technologies
  Date: 07/03/2023
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/accueil_style.css">
</head>
<body>
<%
    User currentUser = (User)session.getAttribute("userData");
%>
<br>
<%@include file="entete.jsp" %>
<br>
<h2>Bienvenu <%= currentUser.getNomComplet() %> !</h2>
<br>
<h3>Transferts récents</h3>
<br>
<div class="container">
    <div class="row">
<%
    TransfertManager transfertManager = new TransfertManager();
    List<Transfert> transferts = transfertManager.getAll();
    for (Transfert t : transferts){
        out.println("<div class='col-md-4'>");
        out.println("<div class='card'>");
        out.println("<div class='card-block'>");
        out.println("<h4 class='card-title'>"+t.getBeneficiaire().getNomComplet()+"</h4>");
        out.println("<h5 class='card-subtitle text-muted'>"+t.getMontant()+"euros </h5>");
        out.println("<span class='h5 badge bg-primary'>"+t.getStatut()+"</span>");
        out.println("<p class='card-text p-y-1'>");
        out.println("Mode Reception : "+t.getModeReception()+"<br>");
        out.println("Operateur : "+t.getOperateur()+"<br>");
        out.println("Motif : "+t.getMotif());
        out.println("</p>");
        out.println("<a href='#' class='card-link'>link</a> ");
        out.println("<a href='#' class='card-link'>Second link</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
    }
%>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
