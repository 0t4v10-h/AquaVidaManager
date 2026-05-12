<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ page import="java.util.ArrayList" %>

        <%@ page import="br.com.aquavida.model.Venda" %>
            <%@ page import="br.com.aquavida.model.Peixe" %>

                <% ArrayList<Venda> vendas =
                    (ArrayList<Venda>)
                        request.getAttribute("vendas");

                        ArrayList<Peixe> peixes =
                            (ArrayList<Peixe>)
                                request.getAttribute("peixes");
                                %>

                                <html>

                                <head>
                                    <title>Vendas</title>
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

                                            <a href="/AquaVidaManager/tanques">
                                                Tanques
                                            </a>

                                            <a href="/AquaVidaManager/logout">
                                                Sair
                                            </a>

                                        </div>

                                    </div>

                                    <div class="container">

                                        <h1>Controle de Vendas</h1>

                                        <div class="card">

                                            <h2>Registrar Venda</h2>

                                            <form action="/AquaVidaManager/vendas" method="post">

                                                <div class="form-group">

                                                    <label>Peixe</label>

                                                    <select name="peixeId" required>

                                                        <% for(Peixe peixe : peixes) { %>
                                                            <option value="<%= peixe.getId() %>">
                                                                <%= peixe.getNome() %>
                                                                    -
                                                                    Estoque:
                                                                    <%= peixe.getQuantidade() %>
                                                            </option>
                                                            <% } %>

                                                    </select>

                                                </div>

                                                <div class="form-group">
                                                    <label>Quantidade</label>
                                                    <input type="number" name="quantidade" min="1" required>
                                                </div>

                                                <button class="link-btn btn-new" type="submit">
                                                    Registrar Venda
                                                </button>

                                            </form>

                                        </div>

                                        <h2>Histórico de Vendas</h2>

                                        <div class="cards-container">
                                            <% if(vendas.isEmpty()) { %>
                                                <div class="card">
                                                    <p>
                                                        Nenhuma venda registrada.
                                                    </p>
                                                </div>
                                                <% } %>

                                                    <% for(Venda venda : vendas) { %>

                                                        <div class="card">

                                                            <h2>
                                                                Venda de <%= venda.getNomePeixe() %>
                                                            </h2>

                                                            <div class="card-info">
                                                                <strong>
                                                                    Quantidade:
                                                                </strong>
                                                                <span>
                                                                    <%= venda.getQuantidade() %>
                                                                </span>
                                                            </div>

                                                            <div class="card-info">
                                                                <strong>
                                                                    Valor:
                                                                </strong>
                                                                <span>
                                                                    R$ <%= String.format("%.2f", venda.getValorTotal())
                                                                        %>
                                                                </span>
                                                            </div>

                                                            <div class="card-info">
                                                                <strong>
                                                                    Data:
                                                                </strong>
                                                                <span>
                                                                    <%= venda.getDataVenda() %>
                                                                </span>
                                                            </div>

                                                        </div>

                                                        <% } %>

                                        </div>

                                    </div>

                                </body>

                                </html>