package br.com.aquavida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSet;
import java.util.ArrayList;
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

                usuario.setTipo(
                        rs.getString("tipo")
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
                        "(nome, login, senha, tipo) " +
                        "VALUES (?, ?, ?, ?)";

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

            stmt.setString(
                4, 
                    usuario.getTipo()
            );

            stmt.execute();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public boolean loginExiste(String login){

        String sql =
                "SELECT * FROM usuario WHERE login = ?";

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, login);

            ResultSet rs =
                    stmt.executeQuery();

            boolean existe =
                    rs.next();

            rs.close();
            stmt.close();
            conexao.close();

            return existe;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    public ArrayList<Usuario> listar(){

        ArrayList<Usuario> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM usuario";

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while(rs.next()){

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

                usuario.setTipo(
                        rs.getString("tipo")
                );

                lista.add(usuario);

            }

            rs.close();
            stmt.close();
            conexao.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public void alterarTipo(
            int id,
            String tipo
    ){

        String sql =
                "UPDATE usuario SET tipo = ? WHERE id = ?";

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, tipo);

            stmt.setInt(2, id);

            stmt.execute();

            stmt.close();
            conexao.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public boolean autenticarAdmin(
            String login,
            String senha
    ){

        String sql =
                """
                SELECT * FROM usuario
                WHERE login = ?
                AND senha = ?
                AND tipo = 'ADMIN'
                """;

        try{

            Connection conexao =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, login);

            stmt.setString(2, senha);

            ResultSet rs =
                    stmt.executeQuery();

            boolean autenticado =
                    rs.next();

            rs.close();
            stmt.close();
            conexao.close();
            return autenticado;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}