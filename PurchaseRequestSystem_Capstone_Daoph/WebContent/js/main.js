$().ready(function() {

	$("nav").append(
		"<ul>"+"<li title = 'Home'><a href = 'dashboard.jsp'>Home</a></li>"
				+"<li title = 'Requests'><a href = 'requests.jsp'>Requests</a></li>"
				+"<li title = 'Users'><a href = 'users?action=list'>Users</a></li>"
				+"<li title = 'Products'><a href = 'products?action=list'>Products</a></li>"
				+"<li title = 'Vendors'><a href = 'vendors.jsp'>Vendors</a></li>" 
				+"<li title = 'About'><a href = 'about.jsp'>About</a></li>" + "</ul>"
	)

	$("#aboutPic").append(
		"<img src='media/me-1.jpg'>"
	)
	
	
});