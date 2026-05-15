<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
        <%@ page import="java.time.format.DateTimeFormatter" %>
            <%@ page import="br.com.aquavida.model.ParametroAgua" %>
                <%@ page import="br.com.aquavida.model.Tanque" %>
                    <%@ page import="br.com.aquavida.model.Usuario" %>

                        <% DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); %>
                            <% Usuario usuario=(Usuario) session.getAttribute("user"); ArrayList<ParametroAgua> lista =
                                (ArrayList<ParametroAgua>) request.getAttribute("listaParametros");

                                    ArrayList<Tanque> listaTanques =
                                        (ArrayList<Tanque>) request.getAttribute("listaTanques");

                                            String tanqueFiltrado =
                                            (String) request.getAttribute("tanqueFiltrado");

                                            if (lista == null) lista = new ArrayList<>();
                                                if (listaTanques == null) listaTanques = new ArrayList<>();
                                                    %>

                                                    <html>

                                                    <head>
                                                        <title>Parâmetros da Água</title>
                                                        <link rel="stylesheet"
                                                            href="/AquaVidaManager/css/style.css?v=10">
                                                    </head>

                                                    <body>

                                                        <div class="navbar">

                                                            <img src="/AquaVidaManager/assets/img/logo.png"
                                                                class="navbar-logo">

                                                            <div class="menu">

                                                                <a href="/AquaVidaManager/dashboard">
                                                                    Home
                                                                </a>

                                                                <a href="/AquaVidaManager/peixes">
                                                                    Peixes
                                                                </a>

                                                                <a href="/AquaVidaManager/tanques">
                                                                    Tanques
                                                                </a>

                                                                <a href="/AquaVidaManager/vendas">
                                                                    Vendas
                                                                </a>

                                                                <% if (usuario !=null && "ADMIN"
                                                                    .equals(usuario.getTipo())) { %>
                                                                    <a href="/AquaVidaManager/usuarios">
                                                                        Usuários
                                                                    </a>

                                                                    <% } %>

                                                                        <a href="/AquaVidaManager/logout">
                                                                            Sair
                                                                        </a>

                                                            </div>
                                                        </div>

                                                        <div class="container">

                                                            <h1>Parâmetros da Água</h1>

                                                            <% String sucesso=request.getParameter("sucesso"); if
                                                                (sucesso !=null) { %>

                                                                <div class="success">
                                                                    Medição registrada com sucesso!
                                                                </div>

                                                                <% } %>

                                                                    <a class="link-btn btn-new"
                                                                        href="/AquaVidaManager/parametros?acao=novo">
                                                                        Nova Medição
                                                                    </a>

                                                                    <form action="/AquaVidaManager/parametros"
                                                                        method="get" style="margin: 16px 0;">
                                                                        <label>Filtrar por tanque:</label>

                                                                        <select name="tanqueId"
                                                                            onchange="this.form.submit()">
                                                                            <option value="">Todos os tanques</option>

                                                                            <% for (Tanque t : listaTanques) { boolean
                                                                                selecionado=tanqueFiltrado !=null &&
                                                                                tanqueFiltrado.equals(String.valueOf(t.getId()));
                                                                                %>

                                                                                <option value="<%= t.getId() %>"
                                                                                    <%=selecionado ? "selected" : "" %>>
                                                                                    <%= t.getNome() %>
                                                                                </option>

                                                                                <% } %>

                                                                        </select>
                                                                    </form>

                                                                    <div class="cards-container">

                                                                        <% if (lista.isEmpty()) { %>
                                                                            <p>Nenhuma medição cadastrada.</p>
                                                                            <% } %>
                                                                                <% for (ParametroAgua p : lista) { %>

                                                                                    <div class="card">

                                                                                        <h2>
                                                                                            <%= p.getNomeTanque() %>
                                                                                        </h2>

                                                                                        <div class="card-info">
                                                                                            <strong>Data:</strong>
                                                                                            <span>
                                                                                                <%= p.getDataMedicao()
                                                                                                    !=null ?
                                                                                                    p.getDataMedicao().format(fmt)
                                                                                                    : "-" %>
                                                                                            </span>
                                                                                        </div>

                                                                                        <div class="card-info">
                                                                                            <strong>Temperatura:</strong>
                                                                                            <span>
                                                                                                <%= String.format("%.1f",
                                                                                                    p.getTemperatura())
                                                                                                    %>
                                                                                            </span>
                                                                                        </div>

                                                                                        <div class="card-info">
                                                                                            <strong>pH:</strong>
                                                                                            <span>
                                                                                                <%= String.format("%.1f",
                                                                                                    p.getPh()) %>
                                                                                            </span>
                                                                                        </div>

                                                                                        <div class="card-info">
                                                                                            <strong>Amônia:</strong>
                                                                                            <span>
                                                                                                <%= String.format("%.2f",
                                                                                                    p.getAmonia()) %>
                                                                                            </span>
                                                                                        </div>

                                                                                        <div class="card-info">
                                                                                            <strong>Status:</strong>
                                                                                            <span
                                                                                                class="status-badge <%= p.getClasseCss() %>">
                                                                                                <%= p.getStatusGeral()
                                                                                                    %>
                                                                                            </span>
                                                                                        </div>

                                                                                    </div>

                                                                                    <% } %>

                                                                    </div>

                                                        </div>

                                                    </body>

                                                    </html>