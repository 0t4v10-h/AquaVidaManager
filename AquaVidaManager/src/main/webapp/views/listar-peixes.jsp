<%@ page import="java.util.ArrayList" %>
    <%@ page import="br.com.aquavida.model.Peixe" %>

        <% ArrayList<Peixe> lista =
            (ArrayList<Peixe>) request.getAttribute("listaPeixes");
                %>

                <html>

                <head>
                    <link rel="stylesheet" href="/AquaVidaManager/css/style.css">
                    <title>Lista de Peixes</title>

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
                        </div>

                    </div>
                    <div class="container">

                        <h2>Lista de Peixes</h2>

                        <a href="/AquaVidaManager/peixes?acao=novo">
                            Novo Peixe
                        </a>

                        <br><br>

                        <table border="1">

                            <tr>

                                <th>ID</th>
                                <th>Nome</th>
                                <th>Espécie</th>
                                <th>Quantidade</th>
                                <th>Tanque ID</th>
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

                                        |

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