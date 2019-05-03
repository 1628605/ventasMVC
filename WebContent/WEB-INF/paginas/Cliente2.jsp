<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>Cliente</title>
</head>
<body>
<font color="red"><h2>${mensaje}</h2></font>
<div class="container bg-info" style="padding-top: 30px; padding-bottom:30px">
<h2>MANTENIMIENTO DE TABLA CLIENTE</h2>
<p>CRUD OPERACION BASICA PARA TABLA CLIENTE</p>
<div class="row">
	<div class="col-sm-4">
		<h2>AGREGAR CLIENTE</h2>
		<p>AGREGAR NUEVO CLIENTE AQUI</p>
		<form role="form" action="clienteServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="accion" value="CREATE" />
				<input type="hidden" name="idcliente" value="${cliente.idcliente}" />
				<label for="bookname">ID CLIENTE</label>
				<input type="text" class="form-control" name="idcliente" value="${cliente.idcliente}">
			</div>
			<div class="form-group">
				<label for="bookauthor">NOMBRE CLIENTE</label>
				<input type="text" class="form-control" name="nomCliente" value="${cliente.nomCliente}">
			</div>
			<div class="form-group">
				<label for="bookauthor">DNI DE CLIENTE</label>
				<input type="text" class="form-control" name="dniCliente" value="${cliente.dniCliente}">
			</div>
			<div class="form-group">
				<label for="bookname">DIRECCION DE CLIENTE</label>
				<input type="text" class="form-control" name="dirCliente" value="${cliente.dirCliente}">
			</div>
			<div class="form-group">
				<label for="bookname">RAZON SOCIAL</label>
				<input type="text" class="form-control" name="razonSocial" value="${cliente.razonSocial}">
			</div>
			<div class="form-group">
				<label for="bookname">RUC</label>
				<input type="text" class="form-control" name="rucCliente" value="${cliente.rucCliente}">
			</div>
			<div class="form-group">
				<label for="bookname">CORREO DE CLIENTE</label>
				<input type="text" class="form-control" name="emailCliente" value="${cliente.emailCliente}">
			</div>
			<div align="center" class="form-group">
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-plus"></span> Guardar
				</button>
			</div>
		</form>
	</div>
	
	<div class="col-sm-8">
	<h2>TODOS LOS CLIENTE</h2>
	<p>Aqui lista de clientes </p>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID CLIENTE</th>
				<th>NOMBRE CLIENTE</th>
				<th>DNI DE CLIENTE</th>
				<th>DIRECCION DE CLIENTE</th>
				<th>RAZON SOCIAL</th>
				<th>RUC</th>
				<th>CORREO</th>
				<th>ACCESOS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listacliente}" var="cli">
				<tr>
					<td>${cli.idcliente}</td>
					<td>${cli.nomCliente}</td>
					<td>${cli.dniCliente}</td>
					<td>${cli.dirCliente}</td>
					<td>${cli.razonSocial}</td>
					<td>${cli.rucCliente}</td>
					<td>${cli.emailCliente}</td>
					<td>
						<a href="clienteServlet?accion=RETRIEVE&codigo=${cli.idcliente}" class="btn btn-info" role="button">
							<span class="glyphicon glyphicon-edit">
							</span>
						</a>
						<a href="clienteServlet?accion=DELETE&codigo=${cli.idcliente}" class="btn btn-danger" role="button">
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