package br.com.aquavida.controller;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.controller.actions.peixe.EditarPeixeAction;
import br.com.aquavida.controller.actions.peixe.ExcluirPeixeAction;
import br.com.aquavida.controller.actions.peixe.ListarPeixeAction;
import br.com.aquavida.controller.actions.peixe.NovoPeixeAction;
import br.com.aquavida.controller.actions.peixe.SalvarPeixeAction;
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

        Action action;

        if("novo".equals(acao)){

            action =
                    new NovoPeixeAction();

        }
        else if("editar".equals(acao)){

            action =
                    new EditarPeixeAction();

        }
        else if("excluir".equals(acao)){

            action =
                    new ExcluirPeixeAction();

        }
        else{

            action =
                    new ListarPeixeAction();

        }

        action.executar(req, resp);

    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Action action =
                new SalvarPeixeAction();

        action.executar(req, resp);

    }

}