package br.com.aquavida.controller;

import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Peixe;
import br.com.aquavida.model.Tanque;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/peixes")
public class PeixeController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        String acao =
                req.getParameter("acao");

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        ArrayList<Tanque> listaTanques =
                tanqueDAO.listar();

        req.setAttribute(
                "listaTanques",
                listaTanques
        );

        if("novo".equals(acao)){

            req.getRequestDispatcher(
                    "views/cadastro-peixe.jsp"
            ).forward(req, resp);

        }else{

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

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Peixe peixe =
                new Peixe();

        peixe.setNome(
                req.getParameter("nome")
        );

        peixe.setEspecie(
                req.getParameter("especie")
        );

        peixe.setQuantidade(
                Integer.parseInt(
                        req.getParameter("quantidade")
                )
        );

        peixe.setTanqueId(
                Integer.parseInt(
                        req.getParameter("tanque")
                )
        );

        PeixeDAO dao =
                new PeixeDAO();

        dao.salvar(peixe);

        resp.sendRedirect(
                "/AquaVidaManager/peixes"
        );

    }

}