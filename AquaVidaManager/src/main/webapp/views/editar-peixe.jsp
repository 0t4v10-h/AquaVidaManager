<%@ page import="java.util.ArrayList" %>
        <%@ page import="br.com.aquavida.model.Tanque" %>
                <%@ page import="br.com.aquavida.model.Peixe" %>

                        <% Peixe peixe=(Peixe) request.getAttribute("peixe"); ArrayList<Tanque> listaTanques =
                                (ArrayList<Tanque>) request.getAttribute("listaTanques");
                                        %>

                                        <html>

                                        <head>
                                                <link rel="stylesheet" href="/AquaVidaManager/css/style.css">
                                                <title>Editar Peixe</title>

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

                                                        <h2>Editar Peixe</h2>

                                                        <form action="/AquaVidaManager/peixes" method="post">

                                                                <input type="hidden" name="id"
                                                                        value="<%= peixe.getId() %>">

                                                                <label>Nome:</label>

                                                                <input type="text" name="nome"
                                                                        value="<%= peixe.getNome() %>">

                                                                <br><br>

                                                                <label>Espécie:</label>

                                                                <input type="text" name="especie"
                                                                        value="<%= peixe.getEspecie() %>">

                                                                <br><br>

                                                                <label>Quantidade:</label>

                                                                <input type="number" name="quantidade"
                                                                        value="<%= peixe.getQuantidade() %>">

                                                                <br><br>

                                                                <label>Tanque:</label>

                                                                <select name="tanque">

                                                                        <% for(Tanque t : listaTanques){ %>

                                                                                <option value="<%= t.getId() %>"
                                                                                        <%=peixe.getTanqueId()==t.getId()
                                                                                        ? "selected" : "" %>
                                                                                        >

                                                                                        <%= t.getNome() %>

                                                                                </option>

                                                                                <% } %>

                                                                </select>

                                                                <br><br>

                                                                <button type="submit">
                                                                        Atualizar
                                                                </button>

                                                        </form>
                                                </div>
                                        </body>

                                        </html>