package br.com.aquavida.controller.actions.tanque;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Tanque;
import br.com.aquavida.dao.ParametroAguaDAO;
import br.com.aquavida.model.ParametroAgua;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarTanqueAction implements Action {

    @Override
    public void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        TanqueDAO dao =
                new TanqueDAO();

        ArrayList<Tanque> lista =
                dao.listar();

        ParametroAguaDAO parametroDAO =
                new ParametroAguaDAO();

        for (Tanque t : lista) {

            ParametroAgua p =
                    parametroDAO.buscarUltimoPorTanque(
                            t.getId()
                    );

            if (p != null) {

                String statusTemp =
                        p.getStatusTemperatura(
                                t.getTemperaturaIdeal()
                        );

                String statusPh =
                        p.getStatusPh(
                                t.getPhIdeal()
                        );

                String statusAmonia =
                        p.getStatusAmonia();

                boolean alerta =
                        "Crítico".equals(statusTemp)
                                || "Crítico".equals(statusPh)
                                || "Crítico".equals(statusAmonia);

                boolean atencao =
                        "Atenção".equals(statusTemp)
                                || "Atenção".equals(statusPh)
                                || "Atenção".equals(statusAmonia);

                String status = alerta
                        ? "Crítico"
                        : atencao
                        ? "Atenção"
                        : "Normal";

                String classe = alerta
                        ? "status-danger"
                        : atencao
                        ? "status-warning"
                        : "status-safe";

                t.setStatusAgua(status);

                t.setClasseStatus(classe);

                t.setUltimaMedicao(
                        p.getDataMedicao()
                                .toString()
                                .replace("T", " ")
                );

            } else {

                t.setStatusAgua("Sem medições");

                t.setClasseStatus("status-warning");

                t.setUltimaMedicao("-");
            }
        }

        req.setAttribute(
                "listaTanques",
                lista
        );

        req.getRequestDispatcher(
                "views/listar-tanques.jsp"
        ).forward(req, resp);

    }

}