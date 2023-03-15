package fr.djstechnologies.servlet;

import fr.djstechnologies.business.Beneficiaire;
import fr.djstechnologies.business.Transfert;
import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.TransfertManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/Transfert")
public class TraiterTransfert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modeReception = request.getParameter("mode_reception");
        String montant = request.getParameter("montant");
        Long mt = Long.parseLong(montant);
        String codePromo = request.getParameter("code_promo");
        String operateurMobile = request.getParameter("operateur_telephonique");
        String idBeneficiaire = request.getParameter("beneficiaire");
        String motif = request.getParameter("motif");
        String statut = "EN_COURS";
        long idBen = Long.parseLong(idBeneficiaire);
        User connectUser = (User) request.getSession().getAttribute("userData");
        long idUser = connectUser.getId();
        long idOperateur = 0;

        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(Long.parseLong(idBeneficiaire));
        User user = new User();
        user.setId(idUser);
        Transfert transfert = new Transfert(0, user, beneficiaire, mt, codePromo, modeReception, operateurMobile, motif, statut, idOperateur);
        TransfertManager transfertManager = new TransfertManager();
        transfertManager.create(transfert);

        request.getRequestDispatcher("accueil.jsp").forward(request, response);

    }
}
