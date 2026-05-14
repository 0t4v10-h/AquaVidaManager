<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Tanque" %>

            <% ArrayList<Tanque> listaTanques =
                (ArrayList<Tanque>) request.getAttribute("listaTanques");

                    String erro =
                    (String) request.getAttribute("erro");

                    if (listaTanques==null) { listaTanques=new ArrayList<>();
                        }
                        %>

                        <html>

                        <head>
                            <title>Novo Parâmetro</title>
                            <link rel="stylesheet" href="/AquaVidaManager/css/style.css?v=10">
                        </head>

                        <body>

                            <!-- NAVBAR (mesmo padrão do sistema) -->
                            <div class="navbar">

                                <img src="/AquaVidaManager/assets/img/logo.png" class="navbar-logo">

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

                                    <a href="/AquaVidaManager/parametros">
                                        Parâmetros
                                    </a>

                                    <a href="/AquaVidaManager/logout">
                                        Sair
                                    </a>

                                </div>
                            </div>

                            <div class="container">

                                <h1>Cadastrar Parâmetro da Água</h1>

                                <% if (erro !=null) { %>
                                    <div class="alert">
                                        <%= erro %>
                                    </div>
                                    <% } %>

                                        <form action="/AquaVidaManager/parametros" method="post">

                                            <label>Tanque</label>
                                            <select name="tanqueId" required>

                                                <% for (Tanque t : listaTanques) { %>
                                                    <option value="<%= t.getId() %>">
                                                        <%= t.getNome() %>
                                                    </option>
                                                    <% } %>

                                            </select>

                                            <label>Temperatura (°C)</label>
                                            <input type="number" step="0.1" name="temperatura" required>

                                            <label>pH</label>
                                            <input type="number" step="0.1" name="ph" required>

                                            <label>Amônia (mg/L)</label>
                                            <input type="number" step="0.01" name="amonia" required>

                                            <div class="form-buttons">

                                                <button class="link-btn btn-new" type="submit">
                                                    Salvar
                                                </button>

                                                <a class="link-btn btn-cancel" href="/AquaVidaManager/parametros">
                                                    Cancelar
                                                </a>

                                            </div>

                                        </form>

                            </div>

                        </body>

                        </html>