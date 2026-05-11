package br.com.aquavida.controller;

import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        PeixeDAO peixeDAO =
                new PeixeDAO();

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        int totalPeixes =
                peixeDAO.totalPeixes();

        int totalTanques =
                tanqueDAO.totalTanques();

        int ocupacaoTotal =
                tanqueDAO.ocupacaoTotal();

        int espacosDisponiveis =
                tanqueDAO.espacosDisponiveis();

        req.setAttribute(
                "totalPeixes",
                totalPeixes
        );

        req.setAttribute(
                "totalTanques",
                totalTanques
        );

        req.setAttribute(
                "ocupacaoTotal",
                ocupacaoTotal
        );

        req.setAttribute(
                "espacosDisponiveis",
                espacosDisponiveis
        );

        req.getRequestDispatcher(
                "views/dashboard.jsp"
        ).forward(req, resp);

    }

}