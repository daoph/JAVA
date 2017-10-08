<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>About</title>
<link href="styles/main.css" type="text/css" rel="stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" type=text/javascript></script>
<script src = "js/main.js" type = "text/javascript"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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


<div id="bioName"><h2>Phuc Dao</h2></div>

<div>
<div id="aboutPic"></div>
<div>
<p id="aboutDesc"> 
	 Vietnamese-American who came to the United States at the age of 3. 
	 One of three boys in the Dao family. Grew up in East Price Hill and attended St. Lawrence Elementary School, 
	 Elder HS, and subsequently graduated from the University of Cincinnati Lidner College of Business. 
	 Began his career as a Case Manager at Ohio National Financial, moved to Cleveland for a short stint at N2 Publishing 
	 and coming back home to work at a local Allstate agency as a Licensed Sales Producer. 
	 He is one half of a wedding/lifestyle photography duo with soon-to-be wife, Vy Pham. 
	 Has a keen interest in photo composition and attention to detail in post processing. 
	 Current student at the Max Technical Training School in 
	 Mason, Ohio and seeking a fulfilling career in the world of software engineering.
</p>
</div>
</div>
</body>


<c:import url="/includes/footer.jsp" />