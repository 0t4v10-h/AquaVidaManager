package br.com.aquavida.controller.actions.peixe;

import java.io.IOException;
import java.util.ArrayList;

import br.com.aquavida.controller.actions.Action;
import br.com.aquavida.dao.PeixeDAO;
import br.com.aquavida.dao.TanqueDAO;
import br.com.aquavida.model.Peixe;
import br.com.aquavida.model.Tanque;
import br.com.aquavida.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalvarPeixeAction implements Action {

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

        String especie =
                req.getParameter("especie");

        String quantidadeStr =
                req.getParameter("quantidade");

        String pesoStr =
                req.getParameter("pesoMedio");

        String precoStr =
                req.getParameter("precoKg");

        String tanqueStr =
                req.getParameter("tanque");

        if(nome == null || nome.isEmpty() ||
                especie == null || especie.isEmpty() ||
                quantidadeStr == null || quantidadeStr.isEmpty() ||
                tanqueStr == null || tanqueStr.isEmpty() ||
                pesoStr.isEmpty() ||
                precoStr.isEmpty()){

            req.setAttribute(
                    "erro",
                    "Preencha todos os campos!"
            );

            TanqueDAO tanqueDAO =
                    new TanqueDAO();

            req.setAttribute(
                    "listaTanques",
                    tanqueDAO.listar()
            );

            req.getRequestDispatcher(
                    "views/cadastro-peixe.jsp"
            ).forward(req, resp);
            return;
        }

        Peixe peixe =
                new Peixe();

        peixe.setNome(nome);

        peixe.setEspecie(especie);

        peixe.setQuantidade(
                Integer.parseInt(
                        quantidadeStr
                )
        );

        peixe.setPesoMedio(
                Double.parseDouble(
                        pesoStr
                )
        );

        peixe.setPrecoKg(
                Double.parseDouble(
                        precoStr
                )
        );

        peixe.setTanqueId(
                Integer.parseInt(
                        tanqueStr
                )
        );

        TanqueDAO tanqueDAO =
                new TanqueDAO();

        Tanque tanque =
                tanqueDAO.buscarPorId(
                        peixe.getTanqueId()
                );

        String idStr =
                req.getParameter("id");

        int quantidadeNova =
                peixe.getQuantidade();

        int ocupacaoAtual =
                tanque.getOcupacaoAtual();

        if(idStr != null && !idStr.isEmpty()){

            Peixe peixeAntigo =
                    new PeixeDAO().buscarPorId(
                            Integer.parseInt(idStr)
                    );

            ocupacaoAtual =
                    ocupacaoAtual -
                            peixeAntigo.getQuantidade();

        }

        if(ocupacaoAtual + quantidadeNova >
                tanque.getCapacidade()){

            req.setAttribute(
                    "erro",
                    "Capacidade do tanque excedida!"
            );

            ArrayList<Tanque> listaTanques =
                    tanqueDAO.listar();

            req.setAttribute(
                    "listaTanques",
                    listaTanques
            );

            req.getRequestDispatcher(
                    "views/cadastro-peixe.jsp"
            ).forward(req, resp);
            return;
        }

        PeixeDAO dao =
                new PeixeDAO();

        if(idStr != null && !idStr.isEmpty()){
            peixe.setId(
                    Integer.parseInt(idStr)
            );

            dao.atualizar(peixe);

            tanqueDAO.atualizarOcupacao(
                    peixe.getTanqueId()
            );

            resp.sendRedirect(
                    "/AquaVidaManager/peixes?sucesso=editado"
            );
        }else{
            dao.salvar(peixe);
            tanqueDAO.atualizarOcupacao(
                    peixe.getTanqueId()
            );

            resp.sendRedirect(
                    "/AquaVidaManager/peixes?sucesso=salvo"
            );

        }
    }
}