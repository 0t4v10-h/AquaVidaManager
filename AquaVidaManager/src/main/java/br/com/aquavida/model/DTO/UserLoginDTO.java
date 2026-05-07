package br.com.aquavida.model.DTO;

public class UserLoginDTO {

    private String login;

    private String senha;

    public UserLoginDTO(String login, String senha) {

        this.login = login;
        this.senha = senha;

    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}