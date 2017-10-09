package prs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prs.business.Product;
import prs.business.User;
import prs.business.Vendor;
import prs.db.PRSFactory;
import prs.db.ProductDAO;
import prs.db.UserDAO;
import prs.db.VendorDAO;

@WebServlet("/login")
public class PrsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrsLoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get action parameters from index.html form
		ServletContext sc = getServletContext();
		String action = request.getParameter("action");

		// LOGIN ********************************************************************************************
		if (action.equals("login")) {
			String url = "";
			boolean isValid = false;

			// set thread safe instance variables.
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// call UserDAO object
			UserDAO dao = PRSFactory.getUserDAO();
			VendorDAO vdao = PRSFactory.getVendorDAO();

			// set set boolean isValid with loginValidator method.
			isValid = dao.loginValidator(username, password);

			if (isValid == true) {
				System.out.println("Login success! Sending to Dashboard...");
				url = "/dashboard.jsp";
			} else {
				System.out.println("Authentication failed.");
				url = "/loginerror.html";
			}

			// get user first name, last name, privileges
			User user = dao.getUserObject(username);

			// set request object
			request.setAttribute("user", user);
			// check if session exists else create session

			if (url.equalsIgnoreCase("/dashboard.jsp")) {

				
				// checking if session exists
				HttpSession session = request.getSession(false);
				if (session == null) {
					System.out.println("No Session Found");
				} else {
					System.out.println("Current Session Found: " + session.getId());
				}

				//get session ID or create new
				session = request.getSession(true);

				System.out.println("Session ID: " + session.getId());

				// create and set vendors hash map with method below...
				Map<Integer, Vendor> vendors = setVendorHashMap();
				Map<Integer, Product> productHash = setProductHashMap();
				
				//created for vendors.jsp. NEED to just use the vendors Hashmap instead for efficiency improvements.
				ArrayList<Vendor> vendor2 = vdao.listAllVendors();

				// set session attributes
				session.setAttribute("user", user);
				session.setAttribute("vendors", vendors);
				session.setAttribute("productHash", productHash);
				session.setAttribute("vendor2", vendor2);

			} else {
				System.out.println("No Session Created");
			}
			
			// forward user to appropriate page.
			getServletContext().getRequestDispatcher(url).forward(request, response);
			

			// LOGOUT ********************************************************************************************
			
		} else if (action.equals("logout")) {

			System.out.println("Logging off...");
			String url = "";

			url = "/index.html";
			System.out.println("Closing Session...");

			// get and invalidate session
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.removeAttribute("vendors");
			session.removeAttribute("products");
			session.invalidate();

			System.out.println("Logged off.");

			sc.getRequestDispatcher(url).forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// method to create Vendor HashMap
	protected static Map<Integer, Vendor> setVendorHashMap() {

		VendorDAO vDao = PRSFactory.getVendorDAO();
		ArrayList<Vendor> vendors = vDao.listAllVendors();
		// create an empty hash map
		Map<Integer, Vendor> vendorMap = new HashMap<>();
		
		// create loop to add values
		for (Vendor v : vendors) {
			vendorMap.put(v.getId(), v);
		}
		return vendorMap;
	}

	// method to create Product HashMap
	private Map<Integer, Product> setProductHashMap() {

		ProductDAO productDAO = PRSFactory.getProductDAO();
		ArrayList<Product> productL = productDAO.listAllProducts();
		// create an empty hash map
		Map<Integer, Product> productMap = new HashMap<>();

		// create loop to add values
		for (Product p : productL) {
			productMap.put(p.getId(), p);
		}
		return productMap;
	}

}
