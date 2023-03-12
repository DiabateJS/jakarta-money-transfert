package fr.djstechnologies.servlet;

import fr.djstechnologies.business.Beneficiaire;
import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.BeneficiaireManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/AjoutBeneficiaire")
public class TraiterAjoutBeneficiaire extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numero = request.getParameter("numero_mobile");
        String ville = request.getParameter("ville");
        User conUser = (User) request.getSession().getAttribute("userData");

        Beneficiaire beneficiaire = new Beneficiaire(0,nom, prenom, numero, ville, conUser.getId());
        BeneficiaireManager benManager = new BeneficiaireManager();
        benManager.create(beneficiaire);
        request.getRequestDispatcher("beneficiaire.jsp").forward(request, response);
    }
}
