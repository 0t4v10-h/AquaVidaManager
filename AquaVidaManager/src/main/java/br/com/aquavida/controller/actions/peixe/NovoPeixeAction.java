package br.com.aquavida.controller.actions.peixe;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovoPeixeAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuario =
                (Usuario)
                        req.getSession()
                                .getAttribute("user");

        if(!usuario.getTipo().equals("ADMIN")){

            resp.sendRedirect(
                    "/AquaVidaManager/dashboard"
            );
            return;
        }

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        req.setAttribute(
                "listaTanques",
                tanqueDAO.listar()
        );

        req.getRequestDispatcher(
                "views/cadastro-peixe.jsp"
        ).forward(req, resp);

    }

}