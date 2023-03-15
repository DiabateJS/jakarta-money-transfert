<%@ page import="fr.djstechnologies.logic.TransfertManager" %>
<%@ page import="fr.djstechnologies.business.Transfert" %><%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 15/03/2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Affecter Transfert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <%@include file="entete.jsp" %>
    <br>
  <h2>Affecter Transfert à Opérateur</h2>
  <br>
    <%
        String strId = request.getParameter("id");
        TransfertManager transfertManager = new TransfertManager();
        Transfert transfert = transfertManager.selectById(Integer.parseInt(strId));
    %>
    <form action="TraiterAffecterOperateur" method="post">
        <input type="hidden" name="id" value="<%= strId %>"><br>
        Client : <%= transfert.getUser().getNomComplet() %><br>
        Beneficiaire : <%= transfert.getBeneficiaire().getNomComplet() %><br>
        Montant : <%= transfert.getMontant() %><br>
        Mode Reception : <%= transfert.getModeReception() %><br>
        Operateur Mobile : <%= transfert.getOperateur() %><br>
        Motif : <%= transfert.getMotif() %><br>
        Statut : <%= transfert.getStatut() %><br>
        <br>
        <br>
        <button type="submit" class="btn btn-success">M'affecter ce transfert</button>
    </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
