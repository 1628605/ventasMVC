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
	<form action="detalleOrdenServlet" method="post">
	<input type="hidden" name="accion" value="BUSCAR" />
	NOMBRE DE PRODUCTO<input type="text" name="nomProducto"  value="${producto.nomProducto}"/><br>
	<input type="submit" value="BUSCAR">
	<h4>Lista de Productos</h4>
		<table border="1">
		<tr>
			<th>ID PRODUCTO</th>
			<th>NOMBRE PRODUCTO</th>
			<th>DESCRIPCION PRODUCTO</th>
			<th>PRECIO PRODUCTO</th>
			<th>STOCK PRODUCTO</th>
			<th>ACCESOS</th>
		</tr>
			<c:forEach items="${listaproducto}" var="prod">
				<tr>
					<td>${prod.idproducto}</td>
					<td>${prod.nomProducto}</td>
					<td>${prod.descProducto}</td>
					<td>${prod.preciovProducto}</td>
					<td>${prod.stockProducto}</td>
					<td><a href="detalleOrdenServlet?accion=AGREGAR&codigo=${prod.idproducto}">Agregar</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>