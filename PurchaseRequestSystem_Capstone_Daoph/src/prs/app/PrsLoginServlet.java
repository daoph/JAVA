package prs.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prs.business.User;
import prs.db.PRSFactory;
import prs.db.ProductDAO;
import prs.db.UserDAO;
import prs.utility.ConnectionManager;

@WebServlet("/login")
public class PrsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrsLoginServlet() {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//set thread safe instance variables.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//call UserDAO object
		UserDAO dao = PRSFactory.getUserDAO();
		
		//set url with loginValidator method.
		String url = dao.loginValidator(username, password);
		
		//get user first name, last name, privileges
		User user  = dao.getUserObject(username);
		
		//set request object
		request.setAttribute("user", user);
		
		
		//forward user to appropriate page.
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	//cookie and session methods
	
	
	
	
	
	
}
