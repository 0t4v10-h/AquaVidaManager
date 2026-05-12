package br.com.aquavida.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.VendaDAO;

import br.com.aquavida.model.Peixe;
import br.com.aquavida.model.Venda;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vendas")
public class VendaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private VendaDAO vendaDAO =
            new VendaDAO();

    private PeixeDAO peixeDAO =
            new PeixeDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Venda> vendas =
                vendaDAO.listar();

        ArrayList<Peixe> peixes =
                peixeDAO.listar();

        request.setAttribute(
                "vendas",
                vendas
        );

        request.setAttribute(
                "peixes",
                peixes
        );

        request.getRequestDispatcher(
                "views/historico-vendas.jsp"
        ).forward(request, response);

    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int peixeId =
                Integer.parseInt(
                        request.getParameter("peixeId")
                );

        int quantidadeVendida =
                Integer.parseInt(
                        request.getParameter("quantidade")
                );

        Peixe peixe =
                peixeDAO.buscarPorId(peixeId);

        if(peixe != null &&
                quantidadeVendida <= peixe.getQuantidade()){

            double valorTotal =
                    quantidadeVendida *
                            peixe.getPesoMedio() *
                            peixe.getPrecoKg();

            Venda venda =
                    new Venda();

            venda.setPeixeId(peixeId);

            venda.setQuantidade(quantidadeVendida);

            venda.setValorTotal(valorTotal);

            vendaDAO.salvar(venda);

            int novaQuantidade =
                    peixe.getQuantidade()
                            - quantidadeVendida;

            peixeDAO.atualizarQuantidade(
                    peixeId,
                    novaQuantidade
            );

        }

        response.sendRedirect("/AquaVidaManager/vendas");

    }

}