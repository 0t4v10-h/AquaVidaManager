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
                "INSERT INTO peixe(nome, especie, quantidade, tanque_id) VALUES (?, ?, ?, ?)";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, peixe.getNome());

            stmt.setString(2, peixe.getEspecie());

            stmt.setInt(3, peixe.getQuantidade());

            stmt.setInt(4, peixe.getTanqueId());

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
                "SELECT * FROM peixe";

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
                        "tanque_id = ? " +
                        "WHERE id = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(
                    1,
                    peixe.getNome()
            );

            stmt.setString(
                    2,
                    peixe.getEspecie()
            );

            stmt.setInt(
                    3,
                    peixe.getQuantidade()
            );

            stmt.setInt(
                    4,
                    peixe.getTanqueId()
            );

            stmt.setInt(
                    5,
                    peixe.getId()
            );

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void excluir(int id){

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

        } catch (Exception e) {

            e.printStackTrace();

        }

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

}