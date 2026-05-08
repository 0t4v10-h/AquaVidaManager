<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>

    <head>
        <link rel="stylesheet" href="/AquaVidaManager/css/style.css">
        <title>Cadastro de Tanque</title>

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
            <h2>Cadastrar Tanque</h2>

            <form action="../tanques" method="post">

                <label>Nome:</label>

                <input type="text" name="nome">

                <br><br>

                <label>Capacidade:</label>

                <input type="number" name="capacidade">

                <br><br>

                <label>Temperatura Ideal:</label>

                <input type="number" step="0.1" name="temperatura">

                <br><br>

                <label>pH Ideal:</label>

                <input type="number" step="0.1" name="ph">

                <br><br>

                <button type="submit">
                    Salvar
                </button>

            </form>
        </div>
    </body>

    </html>