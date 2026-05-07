<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Cadastro de Tanque</title>

</head>

<body>

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

</body>

</html>