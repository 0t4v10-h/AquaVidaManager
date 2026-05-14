<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <html>

    <head>

        <title>Criar Usuário</title>
        <link rel="stylesheet" href="/AquaVidaManager/css/style.css?v=10">

    </head>

    <body class="login-body">

        <div class="login-container">

            <img src="/AquaVidaManager/assets/img/logo2.png" class="login-logo">

            <div class="login-card">

                <h1>Criar Usuário</h1>

                <% if(request.getAttribute("erro") !=null){ %>

                    <div class="alert">

                        <%= request.getAttribute("erro") %>

                    </div>

                    <% } %>

                        <form action="/AquaVidaManager/cadastro-usuario" method="post">

                            <label>Nome</label>
                            <input type="text" name="nome" required placeholder="Digite seu nome">

                            <label>Login</label>
                            <input type="text" name="login" required placeholder="Digite o login">

                            <label>Senha</label>
                            <input type="password" name="senha" minlength="3" required placeholder="Digite a senha">

                            <button class="link-btn btn-new" type="submit">
                                Criar Usuário
                            </button>

                        </form>

                        <p style="
                    text-align:center;
                    margin-top:20px;
                ">

                            <a class="link-btn btn-new" href="/AquaVidaManager/login">
                                Voltar para login
                            </a>

                        </p>

            </div>

        </div>

    </body>

    </html>