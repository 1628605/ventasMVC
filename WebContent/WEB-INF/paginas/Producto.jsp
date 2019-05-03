<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>Productos</title>
</head>
<body>
	<h1>Productos</h1>
	<form action="productoServlet" method="post">
		<input type="hidden" name="accion" value="CREATE" />
		<input type="hidden" name="idproducto" value="${producto.idproducto}" />
		ID PRODUCTO<input type="text" disabled name="idproducto" value="${producto.idproducto}" /> <br>
		NOMBRE PRODUCTO<input type="text" name="nomProducto" value="${producto.nomProducto}"/><br>
		DESCRIPCION DE PRODUCTO<input type="text"  name="descProducto" value="${producto.descProducto}"/><br>
		PRECIO DE PRODUCTO<input type="text" name="preciovProducto" value="${producto.preciovProducto}"/><br>
		STOCK DE PRODUCTO<input type="text" name="stockProducto"  value="${producto.stockProducto}"/><br>
		<input type="submit" value="Guardar">
		
	</form>
	
	<font color="red"><h2>${mensaje}</h2></font>
	
		<h4>Lista de Productos</h4>
		<table border="1">
		<tr>
			<th>ID PRODUCTO</th>
			<th>NOMBRE PRODUCTO</th>
			<th>DESCRIPCION PRODUCTO</th>
			<th>PRECIO PRODUCTO</th>
			<th>STOCK PRODUCTO</th>
			<th>editar</th>
			<th>eliminar</th>
		</tr>
			<c:forEach items="${listaproducto}" var="prod">
				<tr>
					<td>${prod.idproducto}</td>
					<td>${prod.nomProducto}</td>
					<td>${prod.descProducto}</td>
					<td>${prod.preciovProducto}</td>
					<td>${prod.stockProducto}</td>
					<td><a href="productoServlet?accion=RETRIEVE&codigo=${prod.idproducto}">Editar</a></td>
					<td><a href="productoServlet?accion=DELETE&codigo=${prod.idproducto}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>