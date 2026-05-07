package br.com.aquavida.dao;

import br.com.aquavida.model.Tanque;
import br.com.aquavida.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TanqueDAO {

    public void salvar(Tanque tanque){

        String sql =
                "INSERT INTO tanque(nome, capacidade, temperatura_ideal, ph_ideal) VALUES (?, ?, ?, ?)";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, tanque.getNome());

            stmt.setInt(2, tanque.getCapacidade());

            stmt.setDouble(3, tanque.getTemperaturaIdeal());

            stmt.setDouble(4, tanque.getPhIdeal());

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public ArrayList<Tanque> listar(){

        ArrayList<Tanque> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM tanque";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

                Tanque tanque =
                        new Tanque();

                tanque.setId(
                        rs.getInt("id")
                );

                tanque.setNome(
                        rs.getString("nome")
                );

                tanque.setCapacidade(
                        rs.getInt("capacidade")
                );

                tanque.setTemperaturaIdeal(
                        rs.getDouble("temperatura_ideal")
                );

                tanque.setPhIdeal(
                        rs.getDouble("ph_ideal")
                );

                lista.add(tanque);

            }

            rs.close();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;

    }

}