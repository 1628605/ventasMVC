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
<font color="red"><h2>${mensaje}</h2></font>
	<form action="ordenServlet" method="post">
		ID CLIENTE<input type="text" name="idcliente" value="${cliente.idcliente}" /> <br>
		DIRECCION DE CLIENTE<input type="text" name="dirCliente" value="${cliente.dirCliente}"/><br>
		RAZON SOCIAL<input type="text" name="razonSocial"  value="${cliente.razonSocial}"/><br>
		<input type="hidden" name="accion" value="BUSCAR" />
		RUC<input type="text" name="rucCliente"  value="${cliente.rucCliente}"/><br>
		CORREO DE CLIENTE<input type="text" name="emailCliente"  value="${cliente.emailCliente}"/><br>
		<input type="submit" value="BUSCAR">
		<input type="submit" value="GUARDAR">
	</form>
	<form action="detalleOrdenServlet" method="post">
		<h4>Lista de Clientes</h4>
		<table border="1">
		<tr>
			<th>ID PRODUCTO</th>
			<th>NOMBRE PRODUCTO</th>
			<th>DESCRIPCION PRODUCTO</th>
			<th>PRECIO PRODUCTO</th>
			<th>CANTIDAD PRODUCTO</th>
			<th>SUBTOTAL</th>
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
					<td><a href="detalleOrdenServlet?accion=AGREGAR&codigo=${cli.idcliente}">AGREGAR</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
</body>
</html>