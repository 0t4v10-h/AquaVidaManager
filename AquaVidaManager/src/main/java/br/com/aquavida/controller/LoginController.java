package br.com.aquavida.controller;

import br.com.aquavida.dao.UsuarioDAO;
import br.com.aquavida.model.DTO.UserLoginDTO;
import br.com.aquavida.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/login", ""})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        UserLoginDTO user =
                new UserLoginDTO(

                        req.getParameter("login"),
                        req.getParameter("senha")

                );

        UsuarioDAO uDao =
                new UsuarioDAO();

        Usuario userLogado =
                uDao.verificaLogin(user);

        if(userLogado == null){

            req.setAttribute(
                    "error",
                    "Usuário ou senha inválidos"
            );

            req.getRequestDispatcher(
                    "views/login.jsp"
            ).forward(req, resp);

        }else{

            req.getSession().setAttribute(
                    "user",
                    userLogado
            );

            resp.sendRedirect(
                    "/AquaVidaManager/views/dashboard.jsp"
            );

        }

    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        Usuario u =
                (Usuario) req.getSession()
                        .getAttribute("user");

        if(u == null){

            req.getRequestDispatcher(
                    "views/login.jsp"
            ).forward(req, resp);

        }else{

            req.getRequestDispatcher(
                    "views/dashboard.jsp"
            ).forward(req, resp);

        }

    }

}