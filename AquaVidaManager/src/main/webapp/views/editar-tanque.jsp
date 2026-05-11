<%@ page import="br.com.aquavida.model.Tanque" %>

        <% Tanque tanque=(Tanque) request.getAttribute("tanque"); %>

                <html>

                <head>

                        <title>Editar Tanque</title>

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

                                <h1>Editar Tanque</h1>

                                <form action="/AquaVidaManager/tanques" method="post">

                                        <input type="hidden" name="id" value="<%= tanque.getId() %>">

                                        <label>Nome</label>

                                        <input type="text" name="nome" value="<%= tanque.getNome() %>">

                                        <label>Capacidade</label>

                                        <input type="number" name="capacidade" value="<%= tanque.getCapacidade() %>">

                                        <label>Temperatura Ideal</label>

                                        <input type="number" step="0.1" name="temperatura"
                                                value="<%= tanque.getTemperaturaIdeal() %>">

                                        <label>pH Ideal</label>

                                        <input type="number" step="0.1" name="ph" value="<%= tanque.getPhIdeal() %>">

                                        <div class="form-buttons">

                                                <button type="submit">

                                                        Atualizar

                                                </button>

                                                <a class="link-btn btn-cancel" href="/AquaVidaManager/tanques">

                                                        Cancelar

                                                </a>

                                        </div>

                                </form>

                        </div>

                </body>

                </html>