<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Venda" %>
            <%@ page import="br.com.aquavida.model.Peixe" %>
                <%@ page import="br.com.aquavida.model.Usuario" %>
                    <% Usuario usuario=(Usuario) session.getAttribute("user"); %>

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
                                            <link rel="stylesheet" href="/AquaVidaManager/css/style.css?v=10">
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

                                                    <% if(usuario.getTipo().equals("ADMIN")){ %>

                                                        <a href="/AquaVidaManager/usuarios">
                                                            Usuários
                                                        </a>

                                                        <% } %>

                                                            <a href="/AquaVidaManager/logout">
                                                                Sair
                                                            </a>

                                                </div>

                                            </div>

                                            <div class="container">

                                                <h1>Controle de Vendas</h1>

                                                <% String sucesso=request.getParameter("sucesso"); if(sucesso !=null){
                                                    %>

                                                    <div class="success">

                                                        <% if(sucesso.equals("registrada")) { %>
                                                            Venda registrada com sucesso!
                                                            <% } %>

                                                    </div>

                                                    <% } %>

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
                                                                    <input type="number" name="quantidade" min="1"
                                                                        required>
                                                                </div>

                                                                <button class="link-btn btn-new" type="submit">
                                                                    Registrar Venda
                                                                </button>

                                                            </form>

                                                        </div>

                                                        <h2 class="section-title">
                                                            Histórico de Vendas
                                                        </h2>

                                                        <div class="sales-list">

                                                            <% if(vendas.isEmpty()) { %>

                                                                <div class="sale-item">

                                                                    <div class="sale-info">

                                                                        Nenhuma venda registrada.

                                                                    </div>

                                                                </div>

                                                                <% } %>

                                                                    <% for(Venda venda : vendas) { %>

                                                                        <div class="sale-item">

                                                                            <div class="sale-info">

                                                                                <strong>
                                                                                    <%= venda.getNomePeixe() %>
                                                                                </strong>

                                                                            </div>

                                                                            <div class="sale-info">

                                                                                <strong>
                                                                                    Quantidade:
                                                                                </strong>

                                                                                <%= venda.getQuantidade() %>

                                                                            </div>

                                                                            <div class="sale-info">

                                                                                <strong>
                                                                                    Valor:
                                                                                </strong>

                                                                                R$
                                                                                <%= String.format("%.2f",
                                                                                    venda.getValorTotal()) %>

                                                                            </div>

                                                                            <div class="sale-info">

                                                                                <strong>
                                                                                    Data:
                                                                                </strong>

                                                                                <%= venda.getDataVenda() %>

                                                                            </div>

                                                                        </div>

                                                                        <% } %>

                                                        </div>

                                            </div>

                                        </body>

                                        </html>