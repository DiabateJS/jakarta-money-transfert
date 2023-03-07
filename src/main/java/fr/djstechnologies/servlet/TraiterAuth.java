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
        User userAuth = userManager.isAuth(login, password);
        HttpSession session = req.getSession();

        if (userAuth != null){
            session.setAttribute("login",userAuth.getLogin());
            session.setAttribute("nomComplet",userAuth.getNomComplet());
            req.getRequestDispatcher("accueil.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
