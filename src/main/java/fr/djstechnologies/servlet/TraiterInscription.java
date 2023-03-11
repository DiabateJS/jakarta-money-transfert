package fr.djstechnologies.servlet;

import fr.djstechnologies.business.Profil;
import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.UserManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/TraiterInscription")
public class TraiterInscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("numero_mobile");
        String email = request.getParameter("email");

        Profil profil = new Profil(0,"user");
        User user = new User(0, login, pwd, nom, prenom, tel, email, profil);
        UserManager userManager = new UserManager();
        userManager.create(user);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
