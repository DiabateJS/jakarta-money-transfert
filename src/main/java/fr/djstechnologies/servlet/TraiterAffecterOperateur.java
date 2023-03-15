package fr.djstechnologies.servlet;

import fr.djstechnologies.business.Transfert;
import fr.djstechnologies.business.User;
import fr.djstechnologies.logic.TransfertManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/TraiterAffecterOperateur")
public class TraiterAffecterOperateur extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User conUser = (User) request.getSession().getAttribute("userData");
        String sTransfertId = request.getParameter("id");
        int transfertId = Integer.parseInt(sTransfertId);
        TransfertManager transfertManager = new TransfertManager();
        Transfert transfert = transfertManager.selectById(transfertId);
        transfert.setStatut("ATTENTE_VALIDATION");
        transfert.getOperateur().setId(conUser.getId());
        transfertManager.update(transfert);
        request.getRequestDispatcher("operateur.jsp").forward(request, response);
    }
}
