package br.com.aquavida.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tanques")
public class TanqueController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuario =
                (Usuario)
                        req.getSession()
                                .getAttribute("user");
        String acao =
                req.getParameter("acao");

        TanqueDAO dao =
                new TanqueDAO();

        if("excluir".equals(acao)){

            if(!usuario.getTipo().equals("ADMIN")){
                resp.sendRedirect(
                        "/AquaVidaManager/dashboard"
                );
                return;
            }
            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );

            if(dao.possuiPeixes(id)){

                req.setAttribute(
                        "erro",
                        "Não é possível excluir um tanque com peixes cadastrados."
                );

            }else{

                dao.excluir(id);

            }

            ArrayList<Tanque> lista =
                    dao.listar();

            req.setAttribute(
                    "listaTanques",
                    lista
            );

            req.getRequestDispatcher(
                    "views/listar-tanques.jsp"
            ).forward(req, resp);

        } else if("editar".equals(acao)) {

            if(!usuario.getTipo().equals("ADMIN")){
                resp.sendRedirect(
                        "/AquaVidaManager/dashboard"
                );
                return;
            }
            int id =
                    Integer.parseInt(
                            req.getParameter("id")
                    );

            Tanque tanque =
                    dao.buscarPorId(id);

            req.setAttribute(
                    "tanque",
                    tanque
            );

            req.getRequestDispatcher(
                    "views/editar-tanque.jsp"
            ).forward(req, resp);

        } else {
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

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuario =
                (Usuario)
                        req.getSession()
                                .getAttribute("user");

        if(!usuario.getTipo().equals("ADMIN")){
            resp.sendRedirect(
                    "/AquaVidaManager/peixes"
            );
            return;
        }

        String nome =
                req.getParameter("nome");

        String capacidadeStr =
                req.getParameter("capacidade");

        String temperaturaStr =
                req.getParameter("temperatura");

        String phStr =
                req.getParameter("ph");

        if(nome == null || nome.isEmpty() ||
                capacidadeStr == null || capacidadeStr.isEmpty() ||
                temperaturaStr == null || temperaturaStr.isEmpty() ||
                phStr == null || phStr.isEmpty()){

            req.setAttribute(
                    "erro",
                    "Preencha todos os campos!"
            );

            req.getRequestDispatcher(
                    "views/cadastro-tanque.jsp"
            ).forward(req, resp);

            return;

        }

        Tanque tanque =
                new Tanque();

        tanque.setNome(
                nome
        );

        tanque.setCapacidade(
                Integer.parseInt(
                        capacidadeStr
                )
        );

        tanque.setTemperaturaIdeal(
                Double.parseDouble(
                        temperaturaStr
                )
        );

        tanque.setPhIdeal(
                Double.parseDouble(
                        phStr
                )
        );

        String idStr =
                req.getParameter("id");

        TanqueDAO dao =
                new TanqueDAO();

        if(idStr != null && !idStr.isEmpty()){

            tanque.setId(
                    Integer.parseInt(idStr)
            );

            dao.atualizar(tanque);

        }else{

            dao.salvar(tanque);

        }

        resp.sendRedirect(
                "/AquaVidaManager/tanques"
        );

    }

}