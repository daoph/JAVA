<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>Requests</title>
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
	
			<table class="table">
				<tr>
					<td align =center>
					<button type="submit" onClick="location.href='products?action=new'" class="btn btn-primary btn-block" style="font-size:16pt">New Request</button></td>
				</tr>
				<tr>
					<td align=center>
					<form name="frm" action="users" method="POST">
					<input type="hidden" name="action" value="viewpending">
					<input type="hidden" name="userid" value="${user.id}">
					<button class="btn btn-warning btn-block" style="font-size:16pt">View Pending Requests</button>
					</form>
					</td>
				</tr>
				<tr>
					<td align=center>
					<form name="frm" action="users" method="POST">
					<input type="hidden" name="action" value="viewhistory">
					<input type="hidden" name="userid" value="${user.id}">
					<button class="btn btn-default btn-block" style="font-size:16pt">Your Order History</button>
					</form>
					</td>
				</tr>
				<tr>
				<td align=center>
				<c:if test ="${ user.reviewer == true}"> <!-- if statement to check if session user is manager -->
					<button type="submit"  onClick="location.href='manager?action=pending'" class="btn btn-basic btn-block"  style="font-size:16pt">Pending Requests | Manager</button>
					<button type="submit"  onClick="location.href='manager?action=history'" class="btn btn-basic btn-block"  style="font-size:16pt">Request History | Manager</button>		
				</c:if>
				</td>
				</tr>
							
			</table>	
	
	
	
	
	
</body>

<c:import url="/includes/footer.jsp" />