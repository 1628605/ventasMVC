<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Clientes</h1>
	<form action="clienteServlet" method="post">
		<input type="hidden" name="accion" value="CREATE" />
		<input type="hidden" name="idcliente" value="${cliente.idcliente}" />
		ID CLIENTE<input type="text" disabled name="idcliente" value="${cliente.idcliente}" /> <br>
		NOMBRE CLIENTE<input type="text" name="nomCliente" value="${cliente.nomCliente}"/><br>
		DNI DE CLIENTE<input type="text"  name="dniCliente" value="${cliente.dniCliente}"/><br>
		DIRECCION DE CLIENTE<input type="text" name="dirCliente" value="${cliente.dirCliente}"/><br>
		RAZON SOCIAL<input type="text" name="razonSocial"  value="${cliente.razonSocial}"/><br>
		RUC<input type="text" name="rucCliente"  value="${cliente.rucCliente}"/><br>
		CORREO DE CLIENTE<input type="text" name="emailCliente"  value="${cliente.emailCliente}"/><br>
		<input type="submit" value="Guardar">
	</form>
	<font color="red"><h2>${mensaje}</h2></font>
		<h4>Lista de Clientes</h4>
		<table border="1">
		<tr>
			<th>ID CLIENTE</th>
			<th>NOMBRE CLIENTE</th>
			<th>DNI DE CLIENTE</th>
			<th>DIRECCION DE CLIENTE</th>
			<th>RAZON SOCIAL</th>
			<th>RUC</th>
			<th>CORREO</th>
			<th>editar</th>
			<th>eliminar</th>
		</tr>
			<c:forEach items="${listacliente}" var="cli">
				<tr>
					<td>${cli.idcliente}</td>
					<td>${cli.nomCliente}</td>
					<td>${cli.dniCliente}</td>
					<td>${cli.dirCliente}</td>
					<td>${cli.razonSocial}</td>
					<td>${cli.rucCliente}</td>
					<td>${cli.emailCliente}</td>
					<td><a href="clienteServlet?accion=RETRIEVE&codigo=${cli.idcliente}">Editar</a></td>
					<td><a href="clienteServlet?accion=DELETE&codigo=${cli.idcliente}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>