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
<div id="transferts">
<%
    TransfertManager transfertManager = new TransfertManager();
    List<Transfert> transferts = transfertManager.getAll();
    for (Transfert t : transferts){
        out.println("<div id='transfert'>");
        out.println("Beneficiaire Id : "+t.getIdBeneficiaire()+"<br>");
        out.println("Montant : "+t.getMontant()+"<br>");
        out.println("Mode Reception : "+t.getModeReception()+"<br>");
        out.println("Operateur : "+t.getOperateur()+"<br>");
        out.println("Motif : "+t.getMotif()+"<br>");
        out.println("</div>");
    }
%>
</div>
</body>
</html>
