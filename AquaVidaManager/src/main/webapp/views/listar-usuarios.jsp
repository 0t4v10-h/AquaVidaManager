<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Usuario" %>

            <% Usuario usuarioLogado=(Usuario) session.getAttribute("user"); ArrayList<Usuario> lista =
                (ArrayList<Usuario>)
                    request.getAttribute("listaUsuarios");
                    %>

                    <!DOCTYPE html>

                    <html lang="pt-br">

                    <head>

                        <meta charset="UTF-8">

                        <title>
                            Usuários
                        </title>

                        <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

                    </head>

                    <body>

                        <div class="navbar">

                            <div class="logo">
                                AquaVidaManager
                            </div>

                            <div class="menu">

                                <a href="/AquaVidaManager/dashboard">
                                    Home
                                </a>

                                <a href="/AquaVidaManager/peixes">
                                    Peixes
                                </a>

                                <a href="/AquaVidaManager/tanques">
                                    Tanques
                                </a>

                                <a href="/AquaVidaManager/vendas">
                                    Vendas
                                </a>

                                <a href="/AquaVidaManager/usuarios">
                                    Usuários
                                </a>

                                <a href="/AquaVidaManager/logout">
                                    Sair
                                </a>

                            </div>

                        </div>

                        <div class="container">

                            <h1>
                                Gerenciamento de Usuários
                            </h1>

                            <div class="cards-container">

                                <% for(Usuario usuario : lista){ %>

                                    <div class="card">

                                        <h2>
                                            <%= usuario.getNome() %>
                                        </h2>

                                        <div class="card-info">

                                            <strong>
                                                Login:
                                            </strong>

                                            <span>
                                                <%= usuario.getLogin() %>
                                            </span>

                                        </div>

                                        <div class="card-info">

                                            <strong>
                                                Tipo:
                                            </strong>

                                            <span>
                                                <%= usuario.getTipo() %>
                                            </span>

                                        </div>

                                        <% if(usuarioLogado.getId() !=usuario.getId()){ %>

                                            <div class="card-actions">

                                                <% if(usuario.getTipo().equals("USER")){ %>

                                                    <a class="link-btn btn-new"
                                                        href="/AquaVidaManager/usuarios?acao=confirmar&id=<%= usuario.getId() %>&tipo=ADMIN">
                                                        Tornar ADMIN
                                                    </a>

                                                    <% }else{ %>

                                                        <a class="link-btn btn-delete"
                                                            href="/AquaVidaManager/usuarios?acao=confirmar&id=<%= usuario.getId() %>&tipo=USER">
                                                            Tornar USER
                                                        </a>

                                                        <% } %>

                                            </div>

                                            <% } %>

                                    </div>

                                    <% } %>

                            </div>

                        </div>

                    </body>

                    </html>