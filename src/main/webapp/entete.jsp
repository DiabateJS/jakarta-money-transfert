<%@ page import="fr.djstechnologies.business.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%
        User conUser = (User) request.getSession().getAttribute("userData");
    %>
    Utilisateur : <%= conUser.getPrenom() %>  - <a href="profil.jsp">Profil</a> - <a href="deconnexion.jsp">Déconnexion</a> <br>
    <a href="accueil.jsp">Accueil</a> - <a href="transfert.jsp">Transferts</a> - <a href="beneficiaire.jsp">Bénéficiaire</a> - <a href="#">Aide</a>
</div>
