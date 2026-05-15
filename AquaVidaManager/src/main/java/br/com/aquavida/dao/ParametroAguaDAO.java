package br.com.aquavida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.aquavida.model.ParametroAgua;
import br.com.aquavida.util.ConnectionFactory;

public class ParametroAguaDAO {

    public void salvar(ParametroAgua p) {

        String sql = """
            INSERT INTO parametro_agua
            (tanque_id, temperatura, ph, amonia)
            VALUES (?, ?, ?, ?)
        """;

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, p.getTanqueId());
            stmt.setDouble(2, p.getTemperatura());
            stmt.setDouble(3, p.getPh());
            stmt.setDouble(4, p.getAmonia());

            stmt.execute();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ParametroAgua> listar() {

        List<ParametroAgua> lista = new ArrayList<>();

        String sql = """
            SELECT *
            FROM parametro_agua
            ORDER BY data_medicao DESC
        """;

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ParametroAgua p =
                        new ParametroAgua();

                p.setId(rs.getInt("id"));
                p.setTanqueId(rs.getInt("tanque_id"));

                p.setTemperatura(
                        rs.getDouble("temperatura")
                );

                p.setPh(
                        rs.getDouble("ph")
                );

                p.setAmonia(
                        rs.getDouble("amonia")
                );

                p.setDataMedicao(
                        rs.getTimestamp("data_medicao")
                                .toLocalDateTime()
                );

                lista.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<ParametroAgua> listarPorTanque(int tanqueId) {

        List<ParametroAgua> lista = new ArrayList<>();

        String sql = """
            SELECT *
            FROM parametro_agua
            WHERE tanque_id = ?
            ORDER BY data_medicao DESC
        """;

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, tanqueId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ParametroAgua p =
                        new ParametroAgua();

                p.setId(rs.getInt("id"));
                p.setTanqueId(rs.getInt("tanque_id"));

                p.setTemperatura(
                        rs.getDouble("temperatura")
                );

                p.setPh(
                        rs.getDouble("ph")
                );

                p.setAmonia(
                        rs.getDouble("amonia")
                );

                p.setDataMedicao(
                        rs.getTimestamp("data_medicao")
                                .toLocalDateTime()
                );

                lista.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ParametroAgua buscarUltimoPorTanque(int tanqueId) {

        String sql = """
        SELECT *
        FROM parametro_agua
        WHERE tanque_id = ?
        ORDER BY data_medicao DESC
        LIMIT 1
    """;

        try {

            Connection conn =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, tanqueId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                ParametroAgua p =
                        new ParametroAgua();

                p.setId(rs.getInt("id"));

                p.setTanqueId(
                        rs.getInt("tanque_id")
                );

                p.setTemperatura(
                        rs.getDouble("temperatura")
                );

                p.setPh(
                        rs.getDouble("ph")
                );

                p.setAmonia(
                        rs.getDouble("amonia")
                );

                p.setDataMedicao(
                        rs.getTimestamp("data_medicao")
                                .toLocalDateTime()
                );

                rs.close();
                stmt.close();
                conn.close();

                return p;
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}