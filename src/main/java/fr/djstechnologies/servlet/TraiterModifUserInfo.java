package fr.djstechnologies.servlet;

import fr.djstechnologies.business.Profil;
import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.UserManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/TraiterModifUserInfo")
public class TraiterModifUserInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String numero = request.getParameter("numero_mobile");
        String email = request.getParameter("email");

        User user = new User(id, login, null, nom, prenom, numero, email, new Profil());
        UserManager userManager = new UserManager();
        userManager.update(user);
        request.getSession().setAttribute("userData", userManager.selectById(id));
        request.getRequestDispatcher("profil.jsp").forward(request, response);
    }
}
