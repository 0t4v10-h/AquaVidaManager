<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% String erro=(String) request.getAttribute("erro"); %>

        <html>

        <head>

            <title>AquaVida Peixes Ornamentais</title>
            <link rel="stylesheet" href="/AquaVidaManager/css/style.css?v=10">

        </head>

        <body class="login-body">

            <div class="login-container">

                <img src="/AquaVidaManager/assets/img/logo2.png" class="login-logo">

                <div class="login-card">

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

                                <button class="link-btn btn-new" type="submit">
                                    Entrar
                                </button>

                            </form>

                            <p style="
                                    text-align:center;
                                    margin-top:20px;
                                ">

                                <a class="link-btn btn-new" href="/AquaVidaManager/cadastro-usuario">
                                    Criar novo usuário
                                </a>

                            </p>
                </div>

            </div>

        </body>

        </html>