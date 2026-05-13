package br.com.aquavida.controller.actions.peixe;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.model.Peixe;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarPeixeAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        PeixeDAO dao =
                new PeixeDAO();

        ArrayList<Peixe> lista =
                dao.listar();

        req.setAttribute(
                "listaPeixes",
                lista
        );

        req.getRequestDispatcher(
                "views/listar-peixes.jsp"
        ).forward(req, resp);

    }

}