package br.com.aquavida.controller.actions.tanque;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarTanqueAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        TanqueDAO dao =
                new TanqueDAO();

        ArrayList<Tanque> lista =
                dao.listar();

        req.setAttribute(
                "listaTanques",
                lista
        );

        req.getRequestDispatcher(
                "views/listar-tanques.jsp"
        ).forward(req, resp);

    }

}