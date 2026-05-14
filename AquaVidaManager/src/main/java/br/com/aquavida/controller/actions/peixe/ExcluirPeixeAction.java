package br.com.aquavida.controller.actions.peixe;

import java.io.IOException;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Peixe;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcluirPeixeAction implements Action {

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
                    "/AquaVidaManager/dashboard"
            );
            return;
        }

        int id =
                Integer.parseInt(
                        req.getParameter("id")
                );

        PeixeDAO dao =
                new PeixeDAO();

        Peixe peixe =
                dao.buscarPorId(id);

        int tanqueId =
                peixe.getTanqueId();

        boolean excluiu =
                dao.excluir(id);

        if(!excluiu){
            req.getSession().setAttribute(
                    "erro",
                    "Não é possível excluir um peixe que possui vendas registradas."
            );
        }else{
            TanqueDAO tanqueDAO =
                    new TanqueDAO();

            tanqueDAO.atualizarOcupacao(
                    tanqueId
            );
        }
        resp.sendRedirect(
                "/AquaVidaManager/peixes?sucesso=excluido"
        );

    }

}