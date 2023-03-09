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
        String operateur = request.getParameter("operateur_telephonique");
        String idBeneficiaire = request.getParameter("beneficiaire");
        String motif = request.getParameter("motif");
        long idBen = Long.parseLong(idBeneficiaire);
        User connectUser = (User) request.getSession().getAttribute("userData");
        long idUser = connectUser.getId();

        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(Long.parseLong(idBeneficiaire));
        Transfert transfert = new Transfert(0, idUser, beneficiaire, mt, codePromo, modeReception, operateur, motif);
        TransfertManager transfertManager = new TransfertManager();
        transfertManager.create(transfert);

        request.getRequestDispatcher("accueil.jsp").forward(request, response);

    }
}
