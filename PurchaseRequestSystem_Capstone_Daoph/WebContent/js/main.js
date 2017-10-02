$().ready(function() {

	$("nav").append(
		"<ul>"+"<li title = 'Home'><a href = 'dashboard.jsp'>Home</a></li>"
				+"<li title = 'PRS'><a href = 'dashboard.jsp'>PRS</a></li>"
				+"<li title = 'Users'><a href = 'dashboard.jsp'>Users</a></li>"
				+"<li title = 'About'><a href = 'about.html'>About</a></li>" + "</ul>"
	)

	$("#aboutPic").append(
		"<img src='media/me-1.jpg'>"
	)
	
});