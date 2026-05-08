package br.com.aquavida.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Peixe;
import br.com.aquavida.model.Tanque;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        if("excluir".equals(acao)){

            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );

            PeixeDAO dao =
                    new PeixeDAO();

            dao.excluir(id);

            resp.sendRedirect(
                    "/AquaVidaManager/peixes"
            );

        }
        else if("editar".equals(acao)){

            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );

            PeixeDAO peixeDAO =
                    new PeixeDAO();

            Peixe peixe =
                    peixeDAO.buscarPorId(id);

            req.setAttribute(
                    "peixe",
                    peixe
            );

            req.setAttribute(
                    "listaTanques",
                    tanqueDAO.listar()
            );

            req.getRequestDispatcher(
                    "views/editar-peixe.jsp"
            ).forward(req, resp);

        }
        else if("novo".equals(acao)){

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

        String nome =
                req.getParameter("nome");

        String especie =
                req.getParameter("especie");

        String quantidadeStr =
                req.getParameter("quantidade");

        String tanqueStr =
                req.getParameter("tanque");

        if(nome == null || nome.isEmpty() ||
                especie == null || especie.isEmpty() ||
                quantidadeStr == null || quantidadeStr.isEmpty() ||
                tanqueStr == null || tanqueStr.isEmpty()){

            req.setAttribute(
                    "erro",
                    "Preencha todos os campos!"
            );

            TanqueDAO tanqueDAO =
                    new TanqueDAO();

            req.setAttribute(
                    "listaTanques",
                    tanqueDAO.listar()
            );

            req.getRequestDispatcher(
                    "views/cadastro-peixe.jsp"
            ).forward(req, resp);

            return;

        }

        Peixe peixe =
                new Peixe();

        peixe.setNome(
                nome
        );

        peixe.setEspecie(
                especie
        );

        peixe.setQuantidade(
                Integer.parseInt(
                        quantidadeStr
                )
        );

        peixe.setTanqueId(
                Integer.parseInt(
                        tanqueStr
                )
        );

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        Tanque tanque =
                tanqueDAO.buscarPorId(
                        peixe.getTanqueId()
                );

        int quantidadeNova =
                peixe.getQuantidade();

        if(quantidadeNova >
                tanque.getEspacosDisponiveis()){

            req.setAttribute(
                    "erro",
                    "Capacidade do tanque excedida!"
            );

            ArrayList<Tanque> listaTanques =
                    tanqueDAO.listar();

            req.setAttribute(
                    "listaTanques",
                    listaTanques
            );

            req.getRequestDispatcher(
                    "views/cadastro-peixe.jsp"
            ).forward(req, resp);

        }else{

            String idStr =
                    req.getParameter("id");

            PeixeDAO dao =
                    new PeixeDAO();

            if(idStr != null && !idStr.isEmpty()){

                peixe.setId(
                        Integer.parseInt(idStr)
                );

                dao.atualizar(peixe);

            }else{

                dao.salvar(peixe);

            }

            resp.sendRedirect(
                    "/AquaVidaManager/peixes"
            );

        }

    }

}