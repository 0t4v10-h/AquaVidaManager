package br.com.aquavida.controller.actions.tanque;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcluirTanqueAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuario =
                (Usuario)
                        req.getSession()
                                .getAttribute("user");

        if (!usuario.getTipo().equals("ADMIN")) {

            resp.sendRedirect(
                    "/AquaVidaManager/dashboard"
            );
            return;
        }

        int id =
                Integer.parseInt(
                        req.getParameter("id")
                );

        TanqueDAO dao =
                new TanqueDAO();

        if (dao.possuiPeixes(id)) {

            req.setAttribute(
                    "erro",
                    "Não é possível excluir um tanque com peixes cadastrados."
            );

            ArrayList<Tanque> lista =
                    dao.listar();

            req.setAttribute(
                    "listaTanques",
                    lista
            );

            req.getRequestDispatcher(
                    "views/listar-tanques.jsp"
            ).forward(req, resp);

        } else {

            dao.excluir(id);

            resp.sendRedirect(
                    "/AquaVidaManager/tanques?sucesso=excluido"
            );

        }
    }
}