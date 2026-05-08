<%@ page import="br.com.aquavida.model.Tanque" %>

<%
    Tanque tanque =
            (Tanque) request.getAttribute("tanque");
%>

<html>

<head>

    <title>Editar Tanque</title>

</head>

<body>

<h2>Editar Tanque</h2>

<form action="/AquaVidaManager/tanques" method="post">

    <input
            type="hidden"
            name="id"
            value="<%= tanque.getId() %>"
    >

    <label>Nome:</label>

    <input
            type="text"
            name="nome"
            value="<%= tanque.getNome() %>"
    >

    <br><br>

    <label>Capacidade:</label>

    <input
            type="number"
            name="capacidade"
            value="<%= tanque.getCapacidade() %>"
    >

    <br><br>

    <label>Temperatura:</label>

    <input
            type="number"
            step="0.1"
            name="temperatura"
            value="<%= tanque.getTemperaturaIdeal() %>"
    >

    <br><br>

    <label>pH:</label>

    <input
            type="number"
            step="0.1"
            name="ph"
            value="<%= tanque.getPhIdeal() %>"
    >

    <br><br>

    <button type="submit">
        Atualizar
    </button>

</form>

</body>

</html>