package br.com.aquavida.controller.actions.tanque;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovoTanqueAction implements Action {

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

        req.getRequestDispatcher(
                "views/cadastro-tanque.jsp"
        ).forward(req, resp);

    }

}