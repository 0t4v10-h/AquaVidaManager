package br.com.aquavida.controller;

import java.io.IOException;

import br.com.aquavida.dao.UsuarioDAO;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastro-usuario")
public class CadastroUsuarioController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        req.getRequestDispatcher(
                "views/cadastro-usuario.jsp"
        ).forward(req, resp);

    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario usuario =
                new Usuario();

        usuario.setNome(
                req.getParameter("nome")
        );

        usuario.setLogin(
                req.getParameter("login")
        );

        usuario.setSenha(
                req.getParameter("senha")
        );

        UsuarioDAO dao =
                new UsuarioDAO();

        dao.salvar(usuario);

        resp.sendRedirect(
                "/AquaVidaManager/login"
        );

    }

}