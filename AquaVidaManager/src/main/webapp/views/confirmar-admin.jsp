<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <html>

    <head>
        <title>Confirmar Alteração</title>
        <link rel="stylesheet" href="/AquaVidaManager/css/style.css?v=10">
    </head>

    <body>

        <div class="navbar">

            <div class="logo">AquaVidaManager</div>

        </div>

        <div class="container">

            <div class="page-header">

                <h1>
                    Confirmar Alteração
                </h1>

                <p>
                    Confirme suas credenciais de administrador
                    para alterar permissões de usuário.
                </p>

            </div>


            <% if(request.getAttribute("erro") !=null){ %>

                <div class="alert">

                    <%= request.getAttribute("erro") %>

                </div>

                <% } %>

                    <div class="card form-card">

                        <form action="/AquaVidaManager/usuarios" method="post">

                            <div class="form-group">

                                <label>
                                    Login de Administrador
                                </label>

                                <input type="text" name="login" required>

                            </div>

                            <div class="form-group">

                                <label>
                                    Senha
                                </label>

                                <input type="password" name="senha" required>

                            </div>

                            <div class="form-buttons">

                                <button class="link-btn btn-new" type="submit">
                                    Confirmar
                                </button>

                                <a href="/AquaVidaManager/usuarios" class="link-btn btn-cancel">
                                    Cancelar
                                </a>

                            </div>

                        </form>
                    </div>

        </div>

    </body>

    </html>