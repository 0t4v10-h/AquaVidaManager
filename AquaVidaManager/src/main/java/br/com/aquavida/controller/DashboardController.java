package br.com.aquavida.controller;

import java.io.IOException;

import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        boolean alertaLotacao =
                false;

        double valorTotal =
                peixeDAO.valorTotalEstoque();

        for(var t : tanqueDAO.listar()){

                if(t.getPercentualOcupacao() >= 80){

                alertaLotacao =
                        true;

                break;

                }

        }

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

        req.setAttribute(
                "alertaLotacao",
                alertaLotacao
        );

        req.setAttribute(
                "valorTotal",
                valorTotal
        );

        req.getRequestDispatcher(
                "views/dashboard.jsp"
        ).forward(req, resp);

        }

}