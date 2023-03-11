<%--
  Created by IntelliJ IDEA.
  User: Moi
  Date: 11/03/2023
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Transfert</title>
</head>
<body>
<%
    request.getSession().setAttribute("userData","");
    request.getRequestDispatcher("index.jsp").forward(request, response);
%>
</body>
</html>
