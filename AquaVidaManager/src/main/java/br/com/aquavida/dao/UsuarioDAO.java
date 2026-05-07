package br.com.aquavida.dao;

import br.com.aquavida.model.DTO.UserLoginDTO;
import br.com.aquavida.model.Usuario;
import br.com.aquavida.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}