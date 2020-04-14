<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basket</title>
</head>
<body>
<a href="Logout">Log Out</a>
<div>
	<p>${errorMessage}</p>
</div>

	<h2>Welcome ${users.firstname} ${users.lastname}</h2>
	
	<div>
		<h3>Items in your basket: </h3>
	</div>
	<div>
		<c:forEach items="${user.basket}" var="item">
			
				<p>Name: ${item.name}</p>
				<p>Description: ${item.description}</p>
				<p>Price: £${item.price}</p>
				
				<p>---------------</p>
		
		</c:forEach>
		
	<div>
		<h3>Basket Total: £${users.totalPrice}</h3>
		<a href="BuyBasket?id=${user.userId}">Purchase Basket</a>
	</div>
			
			
	
		
	</div>
</body>
</html>