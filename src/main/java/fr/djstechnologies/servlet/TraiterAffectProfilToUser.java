package fr.djstechnologies.servlet;

import fr.djstechnologies.logic.UserManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/TraiterAffectProfilToUser")
public class TraiterAffectProfilToUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user"));
        int profilId = Integer.parseInt(request.getParameter("profil"));
        UserManager userManager = new UserManager();
        userManager.affectProfilToUser(profilId, userId);
        request.getSession().setAttribute("userData",userManager.selectById(userId));
        request.getRequestDispatcher("profil.jsp").forward(request, response);
    }
}
