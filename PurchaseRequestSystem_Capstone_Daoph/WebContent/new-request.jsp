<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Requests</title>
<link href="styles/main.css" type="text/css" rel="stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	type=text/javascript></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js" type="text/javascript"></script>

<style>
#num1 {
	overflow: scroll;
	height: 350px;
}

#num2 {
	overflow: scroll;
	height: 350px;
}

#num1, #num2 {
	position: relative;
	border: 1px solid black;
	margin: 1%;
}

#clearSubmit {
	padding: 20px;
	float:right;
}

#link:hover {
	background-color: transparent;
	text-decoration: none;
}
}
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

	<form action="submit" method="POST">
		<input type="hidden" name="action" value="review">


		<div id='num1'>

			<table class="table">
				<tr>
					<th>Vendor</th>
					<th>Vendor Code</th>
					<th>Part Number</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Select</th>
				</tr>

				<c:forEach var="product" items="${products}" varStatus="loop">
					<tr>
						<td>${product.vendor.name}</td>

						<td>${product.vendor.code}</td>

						<td>${product.vendorPartNumber}</td>

						<td><a id='link' href="${product.photoPath}">${product.name}</a></td>

						<td>
						<fmt:setLocale value="en_US" /> 
						<fmt:formatNumber value="${product.price}" type="currency" />
						</td>
						<td align="center"><input type="number"
							name="quantity${loop.index}" min="0" max="20" value="0"></td>

						<td align="center"><input type="checkbox" id="checkitem"
							name="itemcheck${loop.index}" value="${product.vendorPartNumber}"></td>
						<td><input type="hidden" name="userID"
							value="${user.id}"> <input type="hidden"
							name="vendorID${loop.index}" value="${product.vendorID}">
							<input type="hidden" name="vendorID${loop.index}"
							value="${product.vendorID}">
							<input type="hidden" name="productID${loop.index}"
							value="${product.id}">
							<input type="hidden" name="status"
							value="created">
							</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div id='num2'>

			<h2 align="center">New Request Data Entry Form</h2>
			<div style="margin: 20px">

				<div class="form-group">
					<label for="usr">ID</label> <input type="text"
						class="form-control input-sm" name="userid" value="${user.id}" disabled
						>
				</div>
				<div class="form-group">
					<label for="usr">User Email</label> <input type="text"
						class="form-control input-sm" value="${user.email}" disabled>
				</div>
				<div class="form-group">
					<label for="usr">Phone Number</label> <input type="text"
						class="form-control input-sm" value="${user.phone}" disabled>
				</div>
				<div class="form-group">
					<label for="usr">Short Description</label> <input type="text"
						class="form-control input-sm" name="description" required>
				</div>
				<div class="form-group">
					<label for="usr">Order Reason</label> <input type="text"
						class="form-control input-sm" name="reason" required>
				</div>
				<div class="form-group">
					<label for="usr">Date Needed By</label> <input type="date"
						class="form-control input-sm" name="dateNeeded"
						required>
				</div>
				
				<div class="form-group">
					
					<label for="usr">Delivery Mode</label> 
					<input list = "shipping" class="form-control input-sm" name="deliveryMode">
					
					
						<datalist id="shipping">
						<option value="Economy">
						<option value="Ground">
						<option value="2nd Day">
						<option value="Overnight">
						<option value="Local Pickup">
						</datalist>

					
				</div>
				<div id="clearSubmit">
					<button type="reset" class="btn btn-default">Clear</button>
					<button type="submit" class="btn btn-success">Review</button>
				</div>
			</div>
		</div>

	</form>
	
	
</body>
</html>