<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>Producto</title>
</head>
<body>
<font color="red"><h2>${mensaje}</h2></font>
<div class="container bg-info" style="padding-top: 30px; padding-bottom:30px">
<h2>MANTENIMIENTO DE TABLA PRODUCTO</h2>
<p>CRUD OPERACION BASICA PARA TABLA PRODUCTO</p>
<div class="row">
	<div class="col-sm-4">
		<h2>AGREGAR PRODUCTO</h2>
		<p>AGREGAR NUEVO PRODUCTO AQUI</p>
		<form role="form" action="productoServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="accion" value="CREATE" />
				<input type="hidden" name="idproducto" value="${producto.idproducto}" />
				<label for="bookname">ID PRODUCTO</label>
				<input type="text" class="form-control" name="idproducto" value="${producto.idproducto}">
			</div>
			<div class="form-group">
				<label for="bookauthor">NOMBRE PRODUCTO</label>
				<input type="text" class="form-control" name="nomProducto" value="${producto.nomProducto}">
			</div>
			<div class="form-group">
				<label for="bookauthor">DESCRIPCION DE PRODUCTO</label>
				<input type="text" class="form-control" name="descProducto" value="${producto.descProducto}">
			</div>
			<div class="form-group">
				<label for="bookname">PRECIO DE PRODUCTO</label>
				<input type="text" class="form-control" name="preciovProducto" value="${producto.preciovProducto}">
			</div>
			<div class="form-group">
				<label for="bookname">STOCK DE PRODUCTO</label>
				<input type="text" class="form-control" name="stockProducto" value="${producto.stockProducto}">
			</div>
			<div align="center" class="form-group">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-plus"></span> Guardar
				</button>
			</div>
		</form>
	</div>
	
	<div class="col-sm-8">
	<h2>TODOS LOS PRODUCTOS</h2>
	<p>Aqui lista de productos </p>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID PRODUCTO</th>
				<th>NOMBRE PRODUCTO</th>
				<th>DESCRIPCION PRODUCTO</th>
				<th>PRECIO PRODUCTO</th>
				<th>STOCK PRODUCTO</th>
				<th>ACCESOS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaproducto}" var="prod">
				<tr>
					<td>${prod.idproducto}</td>
					<td>${prod.nomProducto}</td>
					<td>${prod.descProducto}</td>
					<td>${prod.preciovProducto}</td>
					<td>${prod.stockProducto}</td>
					<td>
						<a href="productoServlet?accion=RETRIEVE&codigo=${prod.idproducto}" class="btn btn-info" role="button">
							<span class="glyphicon glyphicon-edit">
							</span>
						</a>
						<a href="productoServlet?accion=DELETE&codigo=${prod.idproducto}" class="btn btn-danger" role="button">
							<span class="glyphicon glyphicon-trash">
							</span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	</div>
</div>
<script src="js/jquery.js"></script>
<script src="bootstrap//js/boostrap.js"></script>
</div>
</body>
</html>