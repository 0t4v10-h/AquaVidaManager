<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Login</title>

</head>

<body>

<h2>Login do Sistema</h2>

<%
    String error =
            (String) request.getAttribute("error");

    if(error != null){
%>

<p style="color:red;">
    <%= error %>
</p>

<%
    }
%>

<form action="/AquaVidaManager/login" method="post">

    <label>Login:</label>

    <input type="text" name="login">

    <br><br>

    <label>Senha:</label>

    <input type="password" name="senha">

    <br><br>

    <button type="submit">
        Entrar
    </button>

</form>

</body>

</html>