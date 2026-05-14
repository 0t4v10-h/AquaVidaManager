package br.com.aquavida.controller.actions.tanque;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalvarTanqueAction implements Action {

    @Override
    public void executar(
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

        tanque.setNome(nome);

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
            resp.sendRedirect(
                    "/AquaVidaManager/tanques?sucesso=editado"
            );
        }else{
            dao.salvar(tanque);
            resp.sendRedirect(
                    "/AquaVidaManager/tanques?sucesso=salvo"
            );

        }

    }

}