<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="br.com.aquavida.model.Usuario" %>

        <% Usuario usuario=(Usuario) session.getAttribute("user"); if(usuario==null){
            response.sendRedirect( "/AquaVidaManager/login" ); return; } %>

            <html>

            <head>

                <title>Dashboard</title>

                <link rel="stylesheet" href="/AquaVidaManager/css/style.css">

            </head>

            <body>

                <div class="navbar">

                    <div class="logo">AquaVidaManager</div>

                    <div class="menu">

                        <a href="/AquaVidaManager/peixes">
                            Peixes
                        </a>

                        <a href="/AquaVidaManager/tanques">
                            Tanques
                        </a>

                        <a href="/AquaVidaManager/logout">
                            Sair
                        </a>

                    </div>

                </div>

                <div class="container">

                    <div class="welcome-box">

                        <h1>
                            Bem-vindo,
                            <%= usuario.getNome() %>
                        </h1>

                        <p>
                            Gerencie seus tanques e monitore a ocupação em tempo real.
                        </p>

                    </div>

                    <% Boolean alertaLotacao=(Boolean) request.getAttribute( "alertaLotacao" ); if(alertaLotacao !=null
                        && alertaLotacao){ %>

                        <div class="alert">
                            ATENCÃO: Existem tanques próximos da lotação máxima!
                        </div>

                        <% } %>

                            <div class="dashboard-grid">

                                <div class="dashboard-card">
                                    <h2>Total de Peixes</h2>
                                    <div class="dashboard-number">
                                        <%= request.getAttribute("totalPeixes") %>
                                    </div>

                                </div>

                                <div class="dashboard-card">
                                    <h2>Total de Tanques</h2>
                                    <div class="dashboard-number">
                                        <%= request.getAttribute("totalTanques") %>
                                    </div>

                                </div>

                                <div class="dashboard-card">
                                    <h2>Ocupação Atual</h2>
                                    <div class="dashboard-number">
                                        <%= request.getAttribute("ocupacaoTotal") %>
                                    </div>

                                </div>

                                <div class="dashboard-card">
                                    <h2>Espaços Disponíveis</h2>
                                    <div class="dashboard-number">
                                        <%= request.getAttribute("espacosDisponiveis") %>
                                    </div>

                                </div>

                                <div class="dashboard-card">
                                    <h2>Valor Total Estimado</h2>
                                    <div class="dashboard-number">
                                        R$ <%= request.getAttribute("valorTotal") %>
                                    </div>

                                </div>

                            </div>

                            <% if(usuario.getTipo().equals("ADMIN")){ %>
                                <div class="quick-actions">

                                    <a class="quick-btn" href="/AquaVidaManager/peixes?acao=novo">
                                        Novo Peixe
                                    </a>

                                    <a class="quick-btn" href="/AquaVidaManager/tanques?acao=novo">
                                        Novo Tanque
                                    </a>
                                </div>
                                <% } %>

                </div>

            </body>

            </html>