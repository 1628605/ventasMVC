<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>John's Blog</h4>
      <ul class="nav nav-pills nav-stacked">
      	
        <li class="active"><a href="productoServlet">Productos</a></li>
        <li><a href="clienteServlet">Clientes</a></li>
        <li><a href="personalServlet">Personal</a></li>
        <li><a href="ordenServlet">Orden</a></li>
      </ul><br>
      
    </div>

    <div class="col-sm-9">
      <%

	//Deeclarando Variable de Cotenido
	//================================
	String contenido="";

	
	//Obteniendo Contenido
 	//====================
 	
	 	if(request.getAttribute("contenido")==null)
	 	{contenido="/imgPrincipal.jsp";}
	 	else
	 	{contenido=request.getAttribute("contenido")+"";}
 	

 	
%>
      <jsp:include page="<%=contenido%>" flush="true"/>

    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>
</body>
</html>