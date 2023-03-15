<%@ page import="fr.djstechnologies.business.Transfert" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.djstechnologies.logic.TransfertManager" %><%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 12/03/2023
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert - Operateur</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <br>
  <%@include file="entete.jsp" %>
  <br>
  <h2>Bienvenu <%= conUser.getNomComplet() %> !</h2>
  <br>
  <h3>Transferts en attente de traitement</h3>
  <br>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>User</th>
        <th>Beneficiaire</th>
        <th>Montant</th>
        <th>Mode Reception</th>
        <th>Operateur Mobile</th>
        <th>Motif</th>
        <th>Statut</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
  <%
    TransfertManager transfertManager = new TransfertManager();
    List<Transfert> transferts = transfertManager.selectWithoutOperators();
    for (Transfert t : transferts){
      out.print("<tr>");
      out.print("<td>"+t.getUser().getNomComplet()+"</td>");
      out.print("<td>"+t.getBeneficiaire().getNomComplet()+"</td>");
      out.print("<td>"+t.getMontant()+"</td>");
      out.print("<td>"+t.getModeReception()+"</td>");
      out.print("<td>"+t.getOperateurMobile()+"</td>");
      out.print("<td>"+t.getMotif()+"</td>");
      out.print("<td>"+t.getStatut()+"</td>");
      out.print("<td><a href='affecter_transfert.jsp?id="+t.getId()+"' class='btn btn-primary'>M'affecter</a></td>");
      out.print("</tr>");
      out.println("");
    }
  %>
    </tbody>
  </table>
  <br>
  <br>
  <h3>Transfert en cours de traitement</h3>
  <br>
  <h3>Transferts traités</h3>
  <br>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
