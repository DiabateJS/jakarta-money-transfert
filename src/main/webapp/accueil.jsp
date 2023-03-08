<%@ page import="fr.djstechnologies.business.User" %><%--
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
<h2>Bienvenu <%= currentUser.getNomComplet() %> !</h2>
<br>
</body>
</html>
