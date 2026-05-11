<%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Peixe" %>
                <%@ page import="br.com.aquavida.model.Tanque" %>

                        <% Peixe peixe=(Peixe) request.getAttribute("peixe"); ArrayList<Tanque> listaTanques =
                                (ArrayList<Tanque>)
                                        request.getAttribute("listaTanques");

                                        %>

                                        <html>

                                        <head>

                                                <title>Editar Peixe</title>

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

                                                        </div>

                                                </div>

                                                <div class="container">

                                                        <h1>Editar Peixe</h1>

                                                        <form action="/AquaVidaManager/peixes" method="post">

                                                                <input type="hidden" name="id"
                                                                        value="<%= peixe.getId() %>">

                                                                <label>Nome</label>

                                                                <input type="text" name="nome"
                                                                        value="<%= peixe.getNome() %>">

                                                                <label>Espécie</label>

                                                                <input type="text" name="especie"
                                                                        value="<%= peixe.getEspecie() %>">

                                                                <label>Quantidade</label>

                                                                <input type="number" name="quantidade"
                                                                        value="<%= peixe.getQuantidade() %>">

                                                                <label>Tanque</label>

                                                                <select name="tanque">

                                                                        <% for(Tanque t : listaTanques){ %>

                                                                                <option value="<%= t.getId() %>" <% if(
                                                                                        peixe.getTanqueId()==t.getId()
                                                                                        ){ %>

                                                                                        selected

                                                                                        <% } %>
                                                                                                >

                                                                                                <%= t.getNome() %>

                                                                                </option>

                                                                                <% } %>

                                                                </select>

                                                                <div class="form-buttons">

                                                                        <button type="submit">

                                                                                Atualizar

                                                                        </button>

                                                                        <a class="link-btn btn-cancel"
                                                                                href="/AquaVidaManager/peixes">

                                                                                Cancelar

                                                                        </a>

                                                                </div>

                                                        </form>

                                                </div>

                                        </body>

                                        </html>