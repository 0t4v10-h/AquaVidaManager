<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Tanque" %>

            <% ArrayList<Tanque> listaTanques =
                (ArrayList<Tanque>)
                    request.getAttribute("listaTanques");

                    String erro =
                    (String)
                    request.getAttribute("erro");

                    %>

                    <html>

                    <head>

                        <title>Novo Peixe</title>
                        <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

                    </head>

                    <body>

                        <div class="navbar">

                            <div class="logo">AquaVidaManager</div>

                        </div>

                        <div class="container">

                            <h1>Cadastrar Peixe</h1>

                            <% if(erro !=null){ %>

                                <div class="alert">
                                    <%= erro %>
                                </div>

                                <% } %>

                                    <form action="/AquaVidaManager/peixes" method="post">

                                        <label>Nome</label>
                                        <input type="text" name="nome">

                                        <label>Espécie</label>
                                        <input type="text" name="especie">

                                        <label>Quantidade</label>
                                        <input type="number" name="quantidade">

                                        <label>Peso Médio (kg)</label>
                                        <input type="number" step="0.01" name="pesoMedio" required>

                                        <label>Preço por Kg</label>
                                        <input type="number" step="0.01" name="precoKg" required>

                                        <label>Tanque</label>
                                        <select name="tanque">

                                            <% for(Tanque t : listaTanques){ %>
                                                <option value="<%= t.getId() %>">
                                                    <%= t.getNome() %>
                                                </option>
                                                <% } %>

                                        </select>

                                        <div class="form-buttons">

                                            <button class="link-btn btn-new" type="submit">
                                                Salvar
                                            </button>

                                            <a class="link-btn btn-cancel" href="/AquaVidaManager/peixes">
                                                Cancelar
                                            </a>

                                        </div>

                                    </form>

                        </div>

                    </body>

                    </html>