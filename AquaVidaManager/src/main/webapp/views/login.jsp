<% String erro=(String) request.getAttribute("erro"); %>

    <html>

    <head>

        <title>AquaVidaManager</title>

        <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

    </head>

    <body class="login-body">

        <div class="login-container">

            <div class="login-card">

                <h1>AquaVidaManager</h1>

                <p class="subtitle">
                    Controle inteligente de tanques e peixes
                </p>

                <% if(erro !=null){ %>

                    <div class="alert">

                        <%= erro %>

                    </div>

                    <% } %>

                        <form action="/AquaVidaManager/login" method="post">

                            <label>Usuário</label>

                            <input type="text" name="login" placeholder="Digite seu usuário">

                            <label>Senha</label>

                            <input type="password" name="senha" placeholder="Digite sua senha">

                            <button type="submit">

                                Entrar

                            </button>

                        </form>

            </div>

        </div>

    </body>

    </html>