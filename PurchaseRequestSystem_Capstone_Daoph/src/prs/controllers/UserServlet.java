package prs.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prs.business.User;
import prs.db.PRSFactory;
import prs.db.UserDAO;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		ServletContext sc = getServletContext();
		String action = request.getParameter("action");
		
		//call UserDAO object
		UserDAO dao = PRSFactory.getUserDAO();
		
		ArrayList<User> users = new ArrayList<User>();

		//if else
		if (action.equals("list")) {
			url = "/users.jsp";
		//create and set attribute
		users = dao.getAllUsers();
		
		System.out.println("Creating User Table...");	
		request.setAttribute("users", users);

		} else {
			url = "/index.html";
		}
		
        sc.getRequestDispatcher(url)
        .forward(request, response);
        
	}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Getting Users");
		doPost(request, response);
	}

}
