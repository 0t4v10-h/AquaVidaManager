package br.com.aquavida.controller.actions.usuario;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.UsuarioDAO;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarUsuarioAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuarioLogado =
                (Usuario)
                        req.getSession()
                                .getAttribute("user");

        if(!usuarioLogado.getTipo().equals("ADMIN")){

            resp.sendRedirect(
                    "/AquaVidaManager/dashboard"
            );
            return;
        }

        UsuarioDAO dao =
                new UsuarioDAO();

        ArrayList<Usuario> lista =
                dao.listar();

        req.setAttribute(
                "listaUsuarios",
                lista
        );

        req.getRequestDispatcher(
                "views/listar-usuarios.jsp"
        ).forward(req, resp);

    }

}