package br.com.aquavida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.aquavida.model.Peixe;
import br.com.aquavida.util.ConnectionFactory;

public class PeixeDAO {

    public void salvar(Peixe peixe){

        String sql =
                "INSERT INTO peixe(nome, especie, quantidade, tanque_id, peso_medio, preco_kg) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, peixe.getNome());

            stmt.setString(2, peixe.getEspecie());

            stmt.setInt(3, peixe.getQuantidade());

            stmt.setInt(4, peixe.getTanqueId());

            stmt.setDouble(5, peixe.getPesoMedio());

            stmt.setDouble(6, peixe.getPrecoKg());

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public ArrayList<Peixe> listar(){

        ArrayList<Peixe> lista =
                new ArrayList<>();

        String sql =
                "SELECT p.*, t.nome AS nome_tanque\r\n" +
                        "FROM peixe p\r\n" +
                        "INNER JOIN tanque t\r\n" +
                        "ON p.tanque_id = t.id";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

                Peixe peixe =
                        new Peixe();

                peixe.setId(
                        rs.getInt("id")
                );

                peixe.setNome(
                        rs.getString("nome")
                );

                peixe.setEspecie(
                        rs.getString("especie")
                );

                peixe.setQuantidade(
                        rs.getInt("quantidade")
                );

                peixe.setTanqueId(
                        rs.getInt("tanque_id")
                );

                peixe.setNomeTanque(
                        rs.getString("nome_tanque")
                );

                peixe.setPesoMedio(
                        rs.getDouble("peso_medio")
                );

                peixe.setPrecoKg(
                        rs.getDouble("preco_kg")
                );

                lista.add(peixe);

            }

            rs.close();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;

    }

    public Peixe buscarPorId(int id){

        String sql =
                "SELECT * FROM peixe WHERE id = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs =
                    stmt.executeQuery();

            if(rs.next()){

                Peixe peixe =
                        new Peixe();

                peixe.setId(
                        rs.getInt("id")
                );

                peixe.setNome(
                        rs.getString("nome")
                );

                peixe.setEspecie(
                        rs.getString("especie")
                );

                peixe.setQuantidade(
                        rs.getInt("quantidade")
                );

                peixe.setTanqueId(
                        rs.getInt("tanque_id")
                );

                peixe.setPesoMedio(
                        rs.getDouble("peso_medio")
                );

                peixe.setPrecoKg(
                        rs.getDouble("preco_kg")
                );

                return peixe;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public void atualizar(Peixe peixe){

        String sql =
                "UPDATE peixe SET " +
                        "nome = ?, " +
                        "especie = ?, " +
                        "quantidade = ?, " +
                        "tanque_id = ?, " +
                        "peso_medio = ?, " +
                        "preco_kg = ? " +
                        "WHERE id = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, peixe.getNome());

            stmt.setString(2, peixe.getEspecie());

            stmt.setInt(3, peixe.getQuantidade());

            stmt.setInt(4, peixe.getTanqueId());

            stmt.setDouble(5, peixe.getPesoMedio());

            stmt.setDouble(6, peixe.getPrecoKg());

            stmt.setInt(7, peixe.getId());

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public boolean excluir(int id){

        String sql =
                "DELETE FROM peixe WHERE id = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

            stmt.close();

            conexao.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

        }
        return false;
    }

    public int totalPeixes(){

        String sql =
                "SELECT SUM(quantidade) AS total FROM peixe";

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            if(rs.next()){

                return rs.getInt("total");

            }

        }catch(Exception e){

            e.printStackTrace();

        }
        return 0;
    }

    public double valorTotalEstoque(){

        String sql =
                """
                SELECT
                SUM(
                        quantidade
                        * peso_medio
                        * preco_kg
                ) AS total
                FROM peixe
                """;

        try{

                Connection conexao =
                        ConnectionFactory.getConnection();

                PreparedStatement stmt =
                        conexao.prepareStatement(sql);

                ResultSet rs =
                        stmt.executeQuery();

                if(rs.next()){

                return rs.getDouble("total");

                }

        }catch(Exception e){

                e.printStackTrace();

        }
        return 0;
    }

    public void atualizarQuantidade(int peixeId, int novaQuantidade){

        String sql =
                "UPDATE peixe SET quantidade = ? WHERE id = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, novaQuantidade);

            stmt.setInt(2, peixeId);

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public ArrayList<Peixe> listarPorTanque(int tanqueId){

        ArrayList<Peixe> lista = new ArrayList<>();

        String sql = """
            SELECT p.*, t.nome AS nome_tanque
            FROM peixe p
            INNER JOIN tanque t
            ON p.tanque_id = t.id
            WHERE tanque_id = ?
            ORDER BY p.nome
        """;

        try{

            Connection conn =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, tanqueId);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

                Peixe p = new Peixe();

                p.setId(rs.getInt("id"));

                p.setNome(rs.getString("nome"));

                p.setEspecie(rs.getString("especie"));

                p.setQuantidade(rs.getInt("quantidade"));

                p.setPesoMedio(rs.getDouble("peso_medio"));

                p.setPrecoKg(rs.getDouble("preco_kg"));

                p.setTanqueId(rs.getInt("tanque_id"));

                p.setNomeTanque(
                        rs.getString("nome_tanque")
                );

                lista.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}