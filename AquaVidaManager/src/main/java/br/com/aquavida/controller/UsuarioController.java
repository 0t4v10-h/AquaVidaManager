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
public class UsuarioController extends HttpServlet {

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

        String nome =
                req.getParameter("nome");

        String login =
                req.getParameter("login");

        String senha =
                req.getParameter("senha");


        if(nome == null || nome.isBlank() ||
                login == null || login.isBlank() ||
                senha == null || senha.isBlank()){

            req.setAttribute(
                    "erro",
                    "Preencha todos os campos."
            );

            req.getRequestDispatcher(
                    "views/cadastro-usuario.jsp"
            ).forward(req, resp);

            return;

        }


        if(senha.length() < 3){

            req.setAttribute(
                    "erro",
                    "A senha deve possuir pelo menos 3 caracteres."
            );

            req.getRequestDispatcher(
                    "views/cadastro-usuario.jsp"
            ).forward(req, resp);

            return;

        }

        UsuarioDAO dao =
                new UsuarioDAO();


        if(dao.loginExiste(login)){

            req.setAttribute(
                    "erro",
                    "Este login já está em uso."
            );

            req.getRequestDispatcher(
                    "views/cadastro-usuario.jsp"
            ).forward(req, resp);

            return;

        }

        Usuario usuario =
                new Usuario();

        usuario.setNome(nome);

        usuario.setLogin(login);

        usuario.setSenha(senha);

        usuario.setTipo("USER");

        dao.salvar(usuario);

        resp.sendRedirect(
                "/AquaVidaManager/login"
        );

    }

}