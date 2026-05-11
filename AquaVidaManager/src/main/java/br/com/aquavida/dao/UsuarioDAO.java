package br.com.aquavida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.aquavida.model.DTO.UserLoginDTO;
import br.com.aquavida.model.Usuario;
import br.com.aquavida.util.ConnectionFactory;

public class UsuarioDAO {

    public Usuario verificaLogin(UserLoginDTO user) {

        String sql =
                "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, user.getLogin());

            stmt.setString(2, user.getSenha());

            ResultSet rs =
                    stmt.executeQuery();

            if(rs.next()){

                Usuario usuario =
                        new Usuario();

                usuario.setId(
                        rs.getInt("id")
                );

                usuario.setNome(
                        rs.getString("nome")
                );

                usuario.setLogin(
                        rs.getString("login")
                );

                return usuario;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public void salvar(Usuario usuario){

        String sql =
                "INSERT INTO usuario " +
                        "(nome, login, senha) " +
                        "VALUES (?, ?, ?)";

        try {

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(
                    1,
                    usuario.getNome()
            );

            stmt.setString(
                    2,
                    usuario.getLogin()
            );

            stmt.setString(
                    3,
                    usuario.getSenha()
            );

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}