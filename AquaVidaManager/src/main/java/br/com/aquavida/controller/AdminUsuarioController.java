package br.com.aquavida.controller;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.controller.actions.usuario.AlterarTipoUsuarioAction;
import br.com.aquavida.controller.actions.usuario.ConfirmarAlteracaoUsuarioAction;
import br.com.aquavida.controller.actions.usuario.ListarUsuarioAction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class AdminUsuarioController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        String acao =
                req.getParameter("acao");

        Action action;

        if("alterarTipo".equals(acao)){

            action =
                    new AlterarTipoUsuarioAction();

        }
        else if("confirmar".equals(acao)){

            action =
                    new ConfirmarAlteracaoUsuarioAction();

        }
        else{
            action =
                    new ListarUsuarioAction();
        }
        action.executar(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Action action =
                new AlterarTipoUsuarioAction();

        action.executar(req, resp);

    }

}