package br.com.aquavida.controller;

import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/tanques")
public class TanqueController extends HttpServlet {

    @Override
    protected void doGet(
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

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Tanque tanque =
                new Tanque();

        tanque.setNome(
                req.getParameter("nome")
        );

        tanque.setCapacidade(
                Integer.parseInt(
                        req.getParameter("capacidade")
                )
        );

        tanque.setTemperaturaIdeal(
                Double.parseDouble(
                        req.getParameter("temperatura")
                )
        );

        tanque.setPhIdeal(
                Double.parseDouble(
                        req.getParameter("ph")
                )
        );

        TanqueDAO dao =
                new TanqueDAO();

        dao.salvar(tanque);

        resp.sendRedirect(
                "/AquaVidaManager/tanques"
        );

    }

}