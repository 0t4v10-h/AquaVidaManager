package br.com.aquavida.controller.actions.usuario;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfirmarAlteracaoUsuarioAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        req.getParameter("id")
                );

        String tipo =
                req.getParameter("tipo");

        req.getSession().setAttribute(
                "idAlteracao",
                id
        );

        req.getSession().setAttribute(
                "tipoAlteracao",
                tipo
        );

        req.getRequestDispatcher(
                "views/confirmar-admin.jsp"
        ).forward(req, resp);

    }

}