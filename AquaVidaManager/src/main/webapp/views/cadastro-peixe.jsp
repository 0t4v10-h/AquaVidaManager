<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.aquavida.model.Tanque" %>

<%
    ArrayList<Tanque> lista =
            (ArrayList<Tanque>) request.getAttribute("listaTanques");
%>

<html>

<head>

    <title>Cadastro de Peixe</title>

</head>

<body>

<h2>Cadastrar Peixe</h2>

<form action="/AquaVidaManager/peixes" method="post">

    <label>Nome:</label>

    <input type="text" name="nome">

    <br><br>

    <label>Espécie:</label>

    <input type="text" name="especie">

    <br><br>

    <label>Quantidade:</label>

    <input type="number" name="quantidade">

    <br><br>

    <label>Tanque:</label>

    <select name="tanque">

        <%
            for(Tanque t : lista){
        %>

        <option value="<%= t.getId() %>">
            <%= t.getNome() %>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <button type="submit">
        Salvar
    </button>

</form>

</body>

</html>