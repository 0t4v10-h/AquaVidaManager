<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.aquavida.model.Peixe" %>

<%
    ArrayList<Peixe> lista =
            (ArrayList<Peixe>) request.getAttribute("listaPeixes");
%>

<html>

<head>

    <title>Lista de Peixes</title>

</head>

<body>

<h2>Lista de Peixes</h2>

<a href="/AquaVidaManager/peixes?acao=novo">
    Novo Peixe
</a>

<br><br>

<table border="1">

    <tr>

        <th>ID</th>
        <th>Nome</th>
        <th>Espécie</th>
        <th>Quantidade</th>
        <th>Tanque ID</th>

    </tr>

<%
    for(Peixe p : lista){
%>

<tr>

    <td><%= p.getId() %></td>

    <td><%= p.getNome() %></td>

    <td><%= p.getEspecie() %></td>

    <td><%= p.getQuantidade() %></td>

    <td><%= p.getTanqueId() %></td>

</tr>

<%
    }
%>

</table>

</body>

</html>