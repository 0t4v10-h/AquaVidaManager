<%@ page import="java.util.ArrayList" %>
    <%@ page import="br.com.aquavida.model.Peixe" %>

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

                        <div class="logo">

                            AquaVidaManager

                        </div>

                        <div class="menu">

                            <a href="/AquaVidaManager/peixes">

                                Peixes

                            </a>

                            <a href="/AquaVidaManager/tanques">

                                Tanques

                            </a>

                            <a href="/AquaVidaManager/views/dashboard.jsp">

                                Dashboard

                            </a>

                        </div>

                    </div>

                    <div class="container">

                        <h1>Gerenciamento de Peixes</h1>

                        <a class="link-btn btn-new" href="/AquaVidaManager/peixes?acao=novo">

                            Novo Peixe

                        </a>

                        <table>

                            <tr>

                                <th>ID</th>
                                <th>Nome</th>
                                <th>Espécie</th>
                                <th>Quantidade</th>
                                <th>Tanque</th>
                                <th>Ações</th>

                            </tr>

                            <% for(Peixe p : lista){ %>

                                <tr>

                                    <td>
                                        <%= p.getId() %>
                                    </td>

                                    <td>
                                        <%= p.getNome() %>
                                    </td>

                                    <td>
                                        <%= p.getEspecie() %>
                                    </td>

                                    <td>
                                        <%= p.getQuantidade() %>
                                    </td>

                                    <td>
                                        <%= p.getTanqueId() %>
                                    </td>

                                    <td>

                                        <a class="link-btn btn-edit"
                                            href="/AquaVidaManager/peixes?acao=editar&id=<%= p.getId() %>">

                                            Editar

                                        </a>

                                        <a class="link-btn btn-delete"
                                            href="/AquaVidaManager/peixes?acao=excluir&id=<%= p.getId() %>">

                                            Excluir

                                        </a>

                                    </td>

                                </tr>

                                <% } %>

                        </table>

                    </div>

                </body>

                </html>