package br.com.aquavida.util;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        Connection conexao =
                ConnectionFactory.getConnection();

        if(conexao != null){

            System.out.println(
                    "Conexão realizada com sucesso!"
            );

        }

    }

}