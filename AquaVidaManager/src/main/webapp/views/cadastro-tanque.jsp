<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

    <html>

    <head>

        <title>Novo Tanque</title>
        <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

    </head>

    <body>

        <div class="navbar">

            <div class="logo">AquaVidaManager</div>

        </div>

        <div class="container">

            <h1>Cadastrar Tanque</h1>

            <% String erro=(String) request.getAttribute("erro"); if(erro !=null){ %>

                <div class="alert">
                    <%= erro %>
                </div>

                <% } %>

                    <form action="/AquaVidaManager/tanques" method="post">

                        <label>Nome</label>
                        <input type="text" name="nome">

                        <label>Capacidade</label>
                        <input type="number" name="capacidade">

                        <label>Temperatura Ideal</label>
                        <input type="number" step="0.1" name="temperatura">

                        <label>pH Ideal</label>
                        <input type="number" step="0.1" name="ph">

                        <div class="form-buttons">
                            <button class="link-btn btn-new" type="submit">
                                Salvar
                            </button>

                            <a class="link-btn cancel-btn" href="/AquaVidaManager/tanques">
                                Cancelar
                            </a>
                        </div>

                    </form>

        </div>

    </body>

    </html>