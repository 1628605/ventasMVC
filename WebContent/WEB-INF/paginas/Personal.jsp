<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css" />   		
<script src="C:\Users\Jesús\eclipse-workspace\ventasMVC\WebContent\bootstrap\js\bootstrap.min.js"></script> 
<title>Personal</title>
</head>
<body>
<h1>Personal</h1>
	<form action="personalServlet" method="post">
		<input type="hidden" name="accion" value="CREATE" />
		<input type="hidden" name="idpersonal" value="${personal.idpersonal}" />
		ID PERSONAL<input type="text" disabled name="idpersonal" value="${personal.idpersonal}" /> <br>
		NOMBRE PERSONAL<input type="text" name="nomPersonal" value="${personal.nomPersonal}"/><br>
		APELLIDO PERSONAL<input type="text"  name="apePersonal" value="${personal.apePersonal}"/><br>
		CARGO PERSONAL<input type="text" name="cargoPersonal" value="${personal.cargoPersonal}"/><br>
		CLAVE PERSONAL<input type="text" name="clavePersonal"  value="${personal.clavePersonal}"/><br>
		<input type="submit" value="Guardar">
	</form>
	<font color="red"><h2>${mensaje}</h2></font>
		<h4>Lista de Personal</h4>
		<table border="1">
		<tr>
			<th>ID PERSONAL</th>
			<th>NOMBRE PERSONAL</th>
			<th>APELLIDO PERSONAL</th>
			<th>CARGO PERSONAL</th>
			<th>CLAVE PERSONAL</th>
			<th>editar</th>
			<th>eliminar</th>
		</tr>
			<c:forEach items="${listapersonal}" var="per">
				<tr>
					<td>${per.idpersonal}</td>
					<td>${per.nomPersonal}</td>
					<td>${per.apePersonal}</td>
					<td>${per.cargoPersonal}</td>
					<td>${per.clavePersonal}</td>
					<td><a href="personalServlet?accion=RETRIEVE&codigo=${per.idpersonal}">Editar</a></td>
					<td><a href="personalServlet?accion=DELETE&codigo=${per.idpersonal}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>