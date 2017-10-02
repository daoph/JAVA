<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<head>
<title>PRS Capstone Project</title>
<link href="css/main.css" type="text/css" rel="stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" type=text/javascript></script>
<script src = "js/main.js" type = "text/javascript"></script>

<style>

.dropbtn {
    background-color: #454545;
    color: white;
    font: tahoma;
    font-size: 16pt;
    border: none;
    cursor: pointer;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    font:tahoma;
    font-size: 14pt;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 0 0 0 10px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #a6a6a6;
}




</style>



</head>
<body>
<nav>
	<div class="dropdown" style = "float: right">
  <button class="dropbtn">${user.firstName} ${user.lastName} ${user.reviewer ?  "(manager)" : "(user)"}</button>
  <div class="dropdown-content">
    <a href="#">Sign Out</a>
  </div>
</div>
</nav>

<p>

<%-- <div style = "float: right"><h4>Welcome ${user.firstName} ${user.lastName}!</h4></div> --%>

</p>



	
</body>


<c:import url="/includes/footer.jsp" />