<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Peixe" %>
            <%@ page import="br.com.aquavida.model.Usuario" %>
                <% Usuario usuario=(Usuario) session.getAttribute("user"); %>
                    <% ArrayList<Peixe> lista =
                        (ArrayList<Peixe>)
                            request.getAttribute("listaPeixes");

                            %>

                            <html>

                            <head>

                                <title>Peixes</title>
                                <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

                            </head>

                            <body>

                                <div class="navbar">

                                    <div class="logo">AquaVidaManager</div>

                                    <div class="menu">

                                        <a href="/AquaVidaManager/dashboard">
                                            Home
                                        </a>

                                        <a href="/AquaVidaManager/tanques">
                                            Tanques
                                        </a>

                                        <a href="/AquaVidaManager/vendas">
                                            Vendas
                                        </a>

                                        <a href="/AquaVidaManager/logout">
                                            Sair
                                        </a>

                                    </div>

                                </div>

                                <div class="container">

                                    <h1>
                                        Gerenciamento de Peixes
                                    </h1>

                                    <% String erro=(String) session.getAttribute("erro"); if(erro !=null){ %>

                                        <div class="alert">
                                            <%= erro %>
                                        </div>

                                        <% session.removeAttribute("erro"); } %>

                                            <% if(usuario.getTipo().equals("ADMIN")){ %>

                                                <a class="link-btn btn-new" href="/AquaVidaManager/peixes?acao=novo">
                                                    Novo Peixe
                                                </a>

                                                <% } %>

                                                    <div class="cards-container">

                                                        <% for(Peixe p : lista){ %>

                                                            <div class="card">

                                                                <h2>
                                                                    <%= p.getNome() %>
                                                                </h2>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        ID:
                                                                    </strong>

                                                                    <span>
                                                                        <%= p.getId() %>
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Espécie:
                                                                    </strong>

                                                                    <span>
                                                                        <%= p.getEspecie() %>
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Quantidade:
                                                                    </strong>

                                                                    <span>
                                                                        <%= p.getQuantidade() %>
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Tanque:
                                                                    </strong>

                                                                    <span>
                                                                        <%= p.getNomeTanque() %>
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Peso Médio:
                                                                    </strong>

                                                                    <span>
                                                                        <%= p.getPesoMedio() %> kg
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Preço/Kg:
                                                                    </strong>

                                                                    <span>
                                                                        R$ <%= p.getPrecoKg() %>
                                                                    </span>

                                                                </div>

                                                                <div class="card-info">

                                                                    <strong>
                                                                        Valor Estimado:
                                                                    </strong>

                                                                    <span>
                                                                        R$
                                                                        <%= p.getQuantidade() * p.getPesoMedio() *
                                                                            p.getPrecoKg() %>
                                                                    </span>

                                                                </div>

                                                                <% if(usuario.getTipo().equals("ADMIN")){ %>

                                                                    <div class="card-actions">

                                                                        <a class="link-btn btn-edit"
                                                                            href="/AquaVidaManager/peixes?acao=editar&id=<%= p.getId() %>">
                                                                            Editar
                                                                        </a>

                                                                        <a class="link-btn btn-delete"
                                                                            href="/AquaVidaManager/peixes?acao=excluir&id=<%= p.getId() %>">
                                                                            Excluir
                                                                        </a>

                                                                    </div>

                                                                    <% } %>

                                                            </div>

                                                            <% } %>

                                                    </div>

                                </div>

                            </body>

                            </html>