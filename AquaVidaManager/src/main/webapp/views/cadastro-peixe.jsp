<%@ page import="java.util.ArrayList" %>
    <%@ page import="br.com.aquavida.model.Tanque" %>

        <% ArrayList<Tanque> lista =
            (ArrayList<Tanque>) request.getAttribute("listaTanques");
                %>

                <html>

                <head>
                    <link rel="stylesheet" href="/AquaVidaManager/css/style.css">
                    <title>Cadastro de Peixe</title>

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

                        <h2>Cadastrar Peixe</h2>

                        <% String erro=(String) request.getAttribute("erro"); if(erro !=null){ %>

                            <p style="color:red;">
                                <%= erro %>
                            </p>

                            <% } %>

                                <form action="/AquaVidaManager/peixes" method="post">

                                    <label>Nome:</label>

                                    <input type="text" name="nome">

                                    <br><br>

                                    <label>Espécie:</label>

                                    <input type="text" name="especie">

                                    <br><br>

                                    <label>Quantidade:</label>

                                    <input type="number" name="quantidade">

                                    <br><br>

                                    <label>Tanque:</label>

                                    <select name="tanque">

                                        <% for(Tanque t : lista){ %>

                                            <option value="<%= t.getId() %>">
                                                <%= t.getNome() %>
                                            </option>

                                            <% } %>

                                    </select>

                                    <br><br>

                                    <button type="submit">
                                        Salvar
                                    </button>

                                </form>
                    </div>
                </body>

                </html>