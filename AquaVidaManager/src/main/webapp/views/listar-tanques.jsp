<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.aquavida.model.Tanque" %>

<%
    ArrayList<Tanque> lista =
            (ArrayList<Tanque>) request.getAttribute("listaTanques");
%>

<html>

<head>

    <title>Lista de Tanques</title>

</head>

<body>

<h2>Lista de Tanques</h2>

<a href="views/cadastro-tanque.jsp">
    Novo Tanque
</a>

<br><br>

<table border="1">

    <tr>

        <th>ID</th>
        <th>Nome</th>
        <th>Capacidade</th>
        <th>Temperatura</th>
        <th>pH</th>
        <th>Ocupação Atual</th>
        <th>Espaços Disponíveis</th>

    </tr>

<%
    for(Tanque t : lista){
%>

<tr>

    <td><%= t.getId() %></td>

    <td><%= t.getNome() %></td>

    <td><%= t.getCapacidade() %></td>

    <td><%= t.getTemperaturaIdeal() %></td>

    <td><%= t.getPhIdeal() %></td>

    <td><%= t.getOcupacaoAtual() %></td>

    <td><%= t.getEspacosDisponiveis() %></td>

</tr>

<%
    }
%>

</table>

</body>

</html>