package br.com.aquavida.controller;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.controller.actions.tanque.EditarTanqueAction;
import br.com.aquavida.controller.actions.tanque.ExcluirTanqueAction;
import br.com.aquavida.controller.actions.tanque.ListarTanqueAction;
import br.com.aquavida.controller.actions.tanque.NovoTanqueAction;
import br.com.aquavida.controller.actions.tanque.SalvarTanqueAction;
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

        String acao =
                req.getParameter("acao");

        Action action;

        if("novo".equals(acao)){

            action =
                    new NovoTanqueAction();

        }
        else if("editar".equals(acao)){

            action =
                    new EditarTanqueAction();

        }
        else if("excluir".equals(acao)){

            action =
                    new ExcluirTanqueAction();

        }
        else{

            action =
                    new ListarTanqueAction();

        }

        action.executar(req, resp);

    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Action action =
                new SalvarTanqueAction();

        action.executar(req, resp);

    }

}