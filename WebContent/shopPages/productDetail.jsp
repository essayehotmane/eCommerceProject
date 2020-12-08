<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*" %>
 <%@ page import =  "java.util.*"%>
 <%@ page import = "com.ecom.models.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" href="template-folders/css/productDetailsStyle.css">
</head>
<body>

	<div class="container bootdey">
		<div class="row">
			<div class="col-md-6">
				<img src="https://via.placeholder.com/550x380/87CEFA/000000" alt="">
			</div>

			<div class="col-md-6 pl-5 pt-5">
				<h2>db:${product.name}</h2>
				<h2>session :${productt.name}</h2>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate vel alias quas explicabo ipsam molestiae quia saepe. Mollitia minus, ut non, nisi architecto fuga repellendus sequi, odit molestias ipsum maiores.</p>
				<h6>db:${product.price}MAD</h6>
				<h6>session :${productt.price}MAD</h6>
				<form action="${pageContext.request.contextPath}/order"  method="get">
				<input name="id" type="hidden" value="${product.id}">
				<div class="number-input md-number-input">
					<button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
					<input class="quantity" min="0" name="quantity" value="1" type="number">
					<button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
				</div>
				<button type="submit" class="btn btn-primary btn-lg btn-block mt-4">Buy</button>
				
				</form>
			</div>
		</div>
	</div>

</body>
</html>
