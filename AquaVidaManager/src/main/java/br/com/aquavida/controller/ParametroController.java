package br.com.aquavida.controller;

import java.io.IOException;
import java.util.List;

import br.com.aquavida.dao.ParametroAguaDAO;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.ParametroAgua;
import br.com.aquavida.model.Tanque;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/parametros")
public class ParametroController extends HttpServlet {

    private ParametroAguaDAO dao = new ParametroAguaDAO();
    private TanqueDAO tanqueDAO = new TanqueDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        if (acao == null) acao = "listar";

        switch (acao) {

            case "novo":

                TanqueDAO tanqueDAO = new TanqueDAO();

                req.setAttribute("listaTanques", tanqueDAO.listar());

                req.getRequestDispatcher("/views/cadastro-parametro.jsp")
                        .forward(req, resp);

                break;

            default:
                listar(req, resp);
                break;
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String tanqueIdStr = req.getParameter("tanqueId");

        List<ParametroAgua> parametros;

        if (tanqueIdStr != null && !tanqueIdStr.isEmpty()) {
            int tanqueId = Integer.parseInt(tanqueIdStr);
            parametros = dao.listarPorTanque(tanqueId);
            req.setAttribute("tanqueFiltrado", tanqueIdStr);
        } else {
            parametros = dao.listar();
        }

        List<Tanque> tanques = tanqueDAO.listar();

        for (ParametroAgua p : parametros) {

            Tanque tanqueRef = null;

            for (Tanque t : tanques) {
                if (t.getId() == p.getTanqueId()) {
                    tanqueRef = t;
                    break;
                }
            }

            String statusTemp = (tanqueRef != null)
                    ? p.getStatusTemperatura(tanqueRef.getTemperaturaIdeal())
                    : "-";

            String statusPh = (tanqueRef != null)
                    ? p.getStatusPh(tanqueRef.getPhIdeal())
                    : "-";

            String statusAmonia = p.getStatusAmonia();

            boolean alerta =
                    "Crítico".equals(statusTemp) ||
                            "Crítico".equals(statusPh) ||
                            "Crítico".equals(statusAmonia);

            boolean atencao =
                    "Atenção".equals(statusTemp) ||
                            "Atenção".equals(statusPh) ||
                            "Atenção".equals(statusAmonia);

            String statusGeral = alerta ? "Crítico"
                    : atencao ? "Atenção"
                    : "Normal";

            String classe = alerta ? "status-danger"
                    : atencao ? "status-warning"
                    : "status-safe";

            if (tanqueRef != null) {
                p.setNomeTanque(tanqueRef.getNome());
            }

            p.setStatusGeral(statusGeral);
            p.setClasseCss(classe);
        }

        req.setAttribute("listaParametros", parametros);
        req.setAttribute("listaTanques", tanques);

        req.getRequestDispatcher("/views/listar-parametros.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int tanqueId = Integer.parseInt(req.getParameter("tanqueId"));
        double temperatura = Double.parseDouble(req.getParameter("temperatura"));
        double ph = Double.parseDouble(req.getParameter("ph"));
        double amonia = Double.parseDouble(req.getParameter("amonia"));

        ParametroAgua p = new ParametroAgua(tanqueId, temperatura, ph, amonia);

        dao.salvar(p);

        resp.sendRedirect("/AquaVidaManager/parametros?sucesso=true");
    }
}