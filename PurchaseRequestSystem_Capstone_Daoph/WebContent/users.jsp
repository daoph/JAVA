<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>Users</title>
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

<div style = "align: center; margin: 10px 2%">

<table class = "table">
<tr>
<th>User ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Username</th>
<th>Phone</th>
<th>Email</th>
<th>Role</th>
</tr>

<c:forEach var = "user" items = "${users}">
<tr>
<td style = "text-align:center">${user.id}</td>
<td>${user.firstName}</td>
<td>${user.lastName}</td>
<td>${user.username}</td>
<td>${user.phone}</td>
<td><a href = "mailto:${user.email}">${user.email}</a></td>
<td>${user.reviewer ?  "Manager" : "User"}</td>
</tr>
</c:forEach>

</table>
</div>

</body>
<c:import url="/includes/footer.jsp" />
</html>