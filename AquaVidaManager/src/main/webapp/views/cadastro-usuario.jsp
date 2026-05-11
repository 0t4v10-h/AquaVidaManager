<html>

<head>

    <title>Criar Usuário</title>

    <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

</head>

<body class="login-body">

    <div class="login-container">

        <div class="login-card">

            <h1>Criar Usuário</h1>

            <p class="subtitle">

                Cadastre um novo acesso ao sistema

            </p>

            <form action="/AquaVidaManager/cadastro-usuario" method="post">

                <label>Nome</label>

                <input type="text" name="nome" placeholder="Digite seu nome">

                <label>Login</label>

                <input type="text" name="login" placeholder="Digite o login">

                <label>Senha</label>

                <input type="password" name="senha" placeholder="Digite a senha">

                <button type="submit">

                    Criar Usuário

                </button>

            </form>

            <p style="
                    text-align:center;
                    margin-top:20px;
                ">

                <a href="/AquaVidaManager/login">

                    Voltar para login

                </a>

            </p>

        </div>

    </div>

</body>

</html>