package prs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prs.business.Product;
import prs.business.Vendor;
import prs.db.PRSFactory;
import prs.db.ProductDAO;
import prs.presentation.PrsConsoleApp;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductsServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Console message
				System.out.println("ProductsServlet running...");

		String url = "";
		ServletContext sc = getServletContext();
		String action = request.getParameter("action");

		// call ProductDAO object and PRLIDAO
		ProductDAO dao = PRSFactory.getProductDAO();

		// new instance created for the method.
		ArrayList<Product> products = new ArrayList<Product>();

		// if else
		if (action.equals("list")) {
			url = "/products.jsp";
			// set product list to products object
			products = dao.listAllProducts();

			// console logic to print out products. Completely independent and non-critical
			// to function.
			String s = PrsConsoleApp.populateList(products);
			System.out.println(s);
			System.out.println("ProductsServlet running...");

			// get the session
			HttpSession session = request.getSession();
			// create hash map object from session object to pass into product ArrayList
			@SuppressWarnings("unchecked")
			Map<Integer, Vendor> vMap = (Map<Integer, Vendor>) session.getAttribute("vendors");
			// forloop to add a vendor object.
			for (Product p : products) {
				Vendor v = vMap.get(p.getVendorID());
				p.setVendor(v);
			}

			session.setAttribute("products", products);

		} else if (action.equals("new")) {
			url = "/new-request.jsp";
			// set product list to products object and get prli
			products = dao.listAllProducts();

			// console logic to print out products. Completely independent and non-critical
			// to function.
			String s = PrsConsoleApp.populateList(products);
			System.out.println(s);
			System.out.println("ProductsServlet running...");

			// get the session
			HttpSession session = request.getSession();
			// create hash map object from session object to pass into product ArrayList
			@SuppressWarnings("unchecked")
			Map<Integer, Vendor> vMap = (Map<Integer, Vendor>) session.getAttribute("vendors");
			// forloop to add a vendor object.
			for (Product p : products) {
				Vendor v = vMap.get(p.getVendorID());
				p.setVendor(v);

			}

			session.setAttribute("products", products);

		} else {
			url = "/index.html";
		}

		sc.getRequestDispatcher(url).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
