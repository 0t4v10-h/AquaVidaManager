package br.com.aquavida.controller.actions.usuario;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.UsuarioDAO;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlterarTipoUsuarioAction implements Action {

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

        int id =
                (Integer)
                        req.getSession()
                                .getAttribute("idAlteracao");

        String tipo =
                (String)
                        req.getSession()
                                .getAttribute("tipoAlteracao");

        if(tipo == null){

            resp.sendRedirect(
                    "/AquaVidaManager/usuarios"
            );
            return;
        }

        String login =
                req.getParameter("login");

        String senha =
                req.getParameter("senha");

        UsuarioDAO dao =
                new UsuarioDAO();

        boolean autenticado =
                dao.autenticarAdmin(
                        login,
                        senha
                );

        if(!autenticado){

            req.setAttribute(
                    "erro",
                    "Login ou senha inválidos."
            );

            req.setAttribute(
                    "id",
                    id
            );

            req.setAttribute(
                    "tipo",
                    tipo
            );

            req.getRequestDispatcher(
                    "views/confirmar-admin.jsp"
            ).forward(req, resp);
            return;
        }

        if(usuarioLogado.getId() == id){

            resp.sendRedirect(
                    "/AquaVidaManager/usuarios"
            );
            return;
        }

        dao.alterarTipo(id, tipo);

        req.getSession().removeAttribute(
                "idAlteracao"
        );

        req.getSession().removeAttribute(
                "tipoAlteracao"
        );

        resp.sendRedirect(
                "/AquaVidaManager/usuarios"
        );

    }

}