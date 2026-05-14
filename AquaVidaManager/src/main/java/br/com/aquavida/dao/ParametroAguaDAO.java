package br.com.aquavida.dao;

import br.com.aquavida.model.ParametroAgua;

import java.util.ArrayList;
import java.util.List;

public class ParametroAguaDAO {

    private static List<ParametroAgua> banco = new ArrayList<>();
    private static int idAuto = 1;

    public void salvar(ParametroAgua p) {
        p.setId(idAuto++);
        banco.add(p);
    }

    public List<ParametroAgua> listar() {
        return banco;
    }

    public List<ParametroAgua> listarPorTanque(int tanqueId) {
        List<ParametroAgua> filtrado = new ArrayList<>();

        for (ParametroAgua p : banco) {
            if (p.getTanqueId() == tanqueId) {
                filtrado.add(p);
            }
        }

        return filtrado;
    }
}