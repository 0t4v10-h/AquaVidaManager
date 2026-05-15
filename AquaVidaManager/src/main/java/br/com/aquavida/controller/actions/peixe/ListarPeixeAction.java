package br.com.aquavida.controller.actions.peixe;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.model.Peixe;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
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

        String tanqueId =
                req.getParameter("tanqueId");

        ArrayList<Peixe> lista;

        if(tanqueId != null && !tanqueId.isEmpty()){

            lista = dao.listarPorTanque(
                    Integer.parseInt(tanqueId)
            );

        }else{

            lista = dao.listar();
        }

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        ArrayList<Tanque> listaTanques =
                tanqueDAO.listar();

        req.setAttribute(
                "listaTanques",
                listaTanques
        );

        req.setAttribute(
                "tanqueFiltrado",
                tanqueId
        );

        req.setAttribute(
                "listaPeixes",
                lista
        );

        req.getRequestDispatcher(
                "views/listar-peixes.jsp"
        ).forward(req, resp);

    }

}