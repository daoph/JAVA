<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<head>
<title>Pending Requests</title>
<link href="styles/main.css" type="text/css" rel="stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" type=text/javascript></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "js/main.js" type = "text/javascript"></script>

<style>
</style>

</head>
<body>
	<nav>
		<div class="dropdown" style="float: right">
			<button class="dropbtn">
				<c:out value="${user.firstName}" />
				<c:out value="${user.lastName}" />
				<c:out value=' ${user.reviewer ?  "(manager)" : "(user)"}' />
			</button>
			<div class="dropdown-content">
				<a href="login?action=logout">Sign Out</a>
			</div>
		</div>
	</nav>
	
	<h2>Manager Portal</h2>
	
	
	<div style = "align: center; margin: 10px 2%">

<table class = "table">
<tr>
<th>Order ID</th>
<th>User ID</th>
<th>Order Description</th>
<th>Order Reason</th>
<th>Date Needed</th>
<th>Shipping</th>
<th>Photo</th>
</tr>

<c:forEach var = "product" items = "${products}">
<tr>


<td>    ${product.vendor.name}		</td>

<td>    ${product.vendor.code}		</td>

<td>${product.vendorPartNumber}</td>
<td>${product.name}</td>
<td><fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${product.price}" type = "currency"/></td>
<td>${product.unit}</td>

<td><a href = "${product.photoPath}">view</a></td>

</tr>
</c:forEach>

</table>
</div>
	
	
	
	
	
	
	
</body>
</html>