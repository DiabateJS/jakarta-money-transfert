package fr.djstechnologies.servlet;

import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Auth")
public class TraiterAuth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String login = req.getParameter("login");
        String password = req.getParameter("pwd");
        UserManager userManager = new UserManager();
        User userAuth = userManager.authUser(login, password);
        HttpSession session = req.getSession();

        if (userAuth != null){
            session.setAttribute("userData",userAuth);
            req.getRequestDispatcher("accueil.jsp").forward(req, resp);
        }else{
            session.setAttribute("msgError","Login ou Mot de passe incorrecte");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
