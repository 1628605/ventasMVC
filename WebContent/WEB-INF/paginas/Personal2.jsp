<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>Personal</title>
</head>
<body>
<font color="red"><h2>${mensaje}</h2></font>
<div class="container bg-info" style="padding-top: 30px; padding-bottom:30px">
<h2>MANTENIMIENTO DE TABLA PERSONAL</h2>
<p>CRUD OPERACION BASICA PARA TABLA PERSONAL</p>
<div class="row">
	<div class="col-sm-4">
		<h2>AGREGAR PERSONAL</h2>
		<p>AGREGAR NUEVO PERSONAL AQUI</p>
		<form role="form" action="personalServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="accion" value="CREATE" />
				<input type="hidden" name="idpersonal" value="${personal.idpersonal}" />
				<label for="bookname">ID PERSONAL</label>
				<input type="text" class="form-control" name="idpersonal" value="${personal.idpersonal}">
			</div>
			<div class="form-group">
				<label for="bookauthor">NOMBRE PERSONAL</label>
				<input type="text" class="form-control" name="nomPersonal" value="${personal.nomPersonal}">
			</div>
			<div class="form-group">
				<label for="bookauthor">APELLIDO PERSONAL</label>
				<input type="text" class="form-control" name="apePersonal" value="${personal.apePersonal}">
			</div>
			<div class="form-group">
				<label for="bookname">CARGO PERSONAL</label>
				<input type="text" class="form-control" name="cargoPersonal" value="${personal.cargoPersonal}">
			</div>
			<div class="form-group">
				<label for="bookname">CLAVE PERSONAL</label>
				<input type="text" class="form-control" name="clavePersonal" value="${personal.clavePersonal}">
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
				<th>ID PERSONAL</th>
				<th>NOMBRE PERSONAL</th>
				<th>APELLIDO PERSONAL</th>
				<th>CARGO PERSONAL</th>
				<th>CLAVE PERSONAL</th>
				<th>ACCESOS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listapersonal}" var="per">
				<tr>
					<td>${per.idpersonal}</td>
					<td>${per.nomPersonal}</td>
					<td>${per.apePersonal}</td>
					<td>${per.cargoPersonal}</td>
					<td>${per.clavePersonal}</td>
					<td>
						<a href="personalServlet?accion=RETRIEVE&codigo=${per.idpersonal}" class="btn btn-info" role="button">
							<span class="glyphicon glyphicon-edit">
							</span>
						</a>
						<a href="personalServlet?accion=DELETE&codigo=${per.idpersonal}" class="btn btn-danger" role="button">
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