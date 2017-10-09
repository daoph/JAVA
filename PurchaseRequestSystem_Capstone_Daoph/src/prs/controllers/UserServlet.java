package prs.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prs.business.PurchaseRequest;
import prs.business.User;
import prs.db.PRSFactory;
import prs.db.PurchaseRequestDAO;
import prs.db.UserDAO;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		ServletContext sc = getServletContext();
		String action = request.getParameter("action");

		// call DAO objects
		UserDAO dao = PRSFactory.getUserDAO();
		PurchaseRequestDAO prDAO = PRSFactory.getPurchaseRequestDAO();

		ArrayList<User> users = new ArrayList<User>();

		// if else
		if (action.equals("list")) {
			url = "/users.jsp";
			// create and set attribute
			users = dao.getAllUsers();

			System.out.println("Creating User Table...");
			request.setAttribute("users", users);

		} else if (action.equals("viewpending")) {

			String userID = request.getParameter("userid");
			int id = (int) Double.parseDouble(userID);

			// set url
			url = "/user-pending.jsp";

			// set to new PR object
			ArrayList<PurchaseRequest> pendingR = prDAO.getPendingRequests(id);

			// set request
			request.setAttribute("pending", pendingR);

		} else if (action.equals("viewhistory")) {

			String userID = request.getParameter("userid");
			int id = (int) Double.parseDouble(userID);

			// set url
			url = "/user-history.jsp";

			ArrayList<PurchaseRequest> purchaseR = prDAO.getPurchaseRequests(id);

			// set request
			request.setAttribute("requests", purchaseR);

		} else if (action.equals("removerequest")) {

			String userID = request.getParameter("requestid");
			int id = (int) Double.parseDouble(userID);

			prDAO.userRemoveRequest(id);

			url = "/menu-requests.jsp";

		} else {
			url = "/index.html";
		}

		sc.getRequestDispatcher(url).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Getting Users");
		doPost(request, response);
	}

}
