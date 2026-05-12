package br.com.aquavida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.aquavida.model.Venda;
import br.com.aquavida.util.ConnectionFactory;

public class VendaDAO {

    public void salvar(Venda venda){

        String sql =
                "INSERT INTO venda(peixe_id, quantidade, valor_total) " +
                        "VALUES (?, ?, ?)";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, venda.getPeixeId());

            stmt.setInt(2, venda.getQuantidade());

            stmt.setDouble(3, venda.getValorTotal());

            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Venda> listar(){

        ArrayList<Venda> lista =
                new ArrayList<>();

        String sql =
                "SELECT v.*, p.nome AS nome_peixe " +
                        "FROM venda v " +
                        "INNER JOIN peixe p " +
                        "ON v.peixe_id = p.id " +
                        "ORDER BY data_venda DESC";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

                Venda venda =
                        new Venda();

                venda.setId(
                        rs.getInt("id")
                );

                venda.setPeixeId(
                        rs.getInt("peixe_id")
                );

                venda.setQuantidade(
                        rs.getInt("quantidade")
                );

                venda.setValorTotal(
                        rs.getDouble("valor_total")
                );

                venda.setNomePeixe(
                        rs.getString("nome_peixe")
                );

                venda.setDataVenda(
                        rs.getTimestamp("data_venda")
                );

                lista.add(venda);

            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public double totalVendido(){

        String sql =
                "SELECT SUM(valor_total) AS total FROM venda";

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

    public int totalVendas(){

        String sql =
                "SELECT COUNT(*) AS total FROM venda";

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


    public String peixeMaisVendido(){

        String sql =
                "SELECT p.nome, " +
                        "SUM(v.quantidade) AS total " +
                        "FROM venda v " +
                        "INNER JOIN peixe p " +
                        "ON v.peixe_id = p.id " +
                        "GROUP BY p.nome " +
                        "ORDER BY total DESC " +
                        "LIMIT 1";

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            if(rs.next()){

                return rs.getString("nome") +
                        " - " +
                        rs.getInt("total") +
                        " vendidos";

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return "Nenhuma venda";
    }
}