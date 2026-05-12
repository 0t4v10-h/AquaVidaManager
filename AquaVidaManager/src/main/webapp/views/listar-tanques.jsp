<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Tanque" %>
            <%@ page import="br.com.aquavida.model.Usuario" %>
                <% Usuario usuario=(Usuario) session.getAttribute("user"); %>
                    <% ArrayList<Tanque> lista =
                        (ArrayList<Tanque>)
                            request.getAttribute("listaTanques");

                            String erro =
                            (String)
                            request.getAttribute("erro");

                            %>

                            <html>

                            <head>

                                <title>Tanques</title>
                                <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

                            </head>

                            <body>

                                <div class="navbar">

                                    <div class="logo">AquaVidaManager</div>

                                    <div class="menu">
                                        <a href="/AquaVidaManager/dashboard">
                                            Home
                                        </a>

                                        <a href="/AquaVidaManager/peixes">
                                            Peixes
                                        </a>

                                        <a href="/AquaVidaManager/logout">
                                            Sair
                                        </a>

                                    </div>

                                </div>

                                <div class="container">

                                    <h1>Gerenciamento de Tanques</h1>

                                    <% if(usuario.getTipo().equals("ADMIN")){ %>
                                        <a class="link-btn btn-new" href="/AquaVidaManager/views/cadastro-tanque.jsp">
                                            Novo Tanque
                                        </a>
                                        <% } %>

                                            <% if(erro !=null){ %>

                                                <div class="alert">
                                                    <%= erro %>
                                                </div>

                                                <% } %>

                                                    <div class="cards-container">

                                                        <% for(Tanque t : lista){ %>

                                                            <div class="card">

                                                                <h2>
                                                                    <%= t.getNome() %>
                                                                </h2>

                                                                <div class="card-info">
                                                                    <strong>Capacidade:</strong>
                                                                    <%= t.getCapacidade() %>
                                                                </div>

                                                                <div class="card-info">
                                                                    <strong>Ocupação:</strong>
                                                                    <%= t.getOcupacaoAtual() %>
                                                                </div>

                                                                <div class="card-info">
                                                                    <strong>Disponível:</strong>
                                                                    <%= t.getEspacosDisponiveis() %>
                                                                </div>

                                                                <div class="card-info">
                                                                    <strong>Temperatura:</strong>
                                                                    <%= t.getTemperaturaIdeal() %> °C
                                                                </div>

                                                                <div class="card-info">
                                                                    <strong>pH:</strong>
                                                                    <%= t.getPhIdeal() %>
                                                                </div>

                                                                <div class="progress-container">

                                                                    <% int percentual=t.getPercentualOcupacao(); String
                                                                        barraClasse="progress-safe" ; String
                                                                        statusClasse="status-safe" ; if(percentual>=
                                                                        80){

                                                                        barraClasse =
                                                                        "progress-danger";

                                                                        statusClasse =
                                                                        "status-danger";

                                                                        }
                                                                        else if(percentual >= 50){

                                                                        barraClasse =
                                                                        "progress-warning";

                                                                        statusClasse =
                                                                        "status-warning";

                                                                        }

                                                                        %>

                                                                        <div class="progress-bar <%= barraClasse %>"
                                                                            style="width: <%= percentual %>%">
                                                                            <%= percentual %>%
                                                                        </div>

                                                                </div>

                                                                <div class="status-badge <%= statusClasse %>">
                                                                    <%= t.getStatusLotacao() %>
                                                                </div>

                                                                <div class="card-actions">
                                                                    <% if(usuario.getTipo().equals("ADMIN")){ %>
                                                                        <a class="link-btn btn-edit"
                                                                            href="/AquaVidaManager/tanques?acao=editar&id=<%= t.getId() %>">
                                                                            Editar
                                                                        </a>

                                                                        <a class="link-btn btn-delete"
                                                                            href="/AquaVidaManager/tanques?acao=excluir&id=<%= t.getId() %>">
                                                                            Excluir
                                                                        </a>
                                                                        <% } %>
                                                                </div>

                                                            </div>

                                                            <% } %>

                                                    </div>

                                </div>

                            </body>

                            </html>