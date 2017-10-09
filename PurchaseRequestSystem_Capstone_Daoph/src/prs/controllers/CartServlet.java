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
import prs.business.PurchaseRequest;
import prs.business.PurchaseRequestLineItem;

import prs.db.PRSFactory;
import prs.db.ProductDAO;
import prs.db.PurchaseRequestDAO;
import prs.db.PurchaseRequestLineItemsDAO;

@WebServlet("/submit")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Console message
		System.out.println("CartServlet running...");
		
		//call DAOs
		PurchaseRequestLineItemsDAO prliDAO = PRSFactory.getPurchaseRequestLineItemsDAO();
		ProductDAO pDAO = PRSFactory.getProductDAO();
		PurchaseRequestDAO prDAO = PRSFactory.getPurchaseRequestDAO();
		
		//create and set products ArrayList
		ArrayList<Product> products = new ArrayList<Product>();
		products = pDAO.listAllProducts();

		
		String url = "";
		double aggregate = 0;
		ServletContext sc = getServletContext();
		String action = request.getParameter("action");

		// if else
		if (action.equals("review")) {
			url = "/user-review-order.jsp";

			// gather and create PurchaseRequest INSERT
			String description = request.getParameter("description");
			String reason = request.getParameter("reason");
			String dateNeeded = request.getParameter("dateNeeded");
			String userid = request.getParameter("userID");
			String deliveryMode = request.getParameter("deliveryMode");
			String status = request.getParameter("status");

			// create PR Entry and return GENERATED KEY TO generatedKey.
			int generatedKey = prDAO.writePRToDatabase(userid, description, reason, dateNeeded, deliveryMode, status,
					aggregate);
			System.out.println("PR written to Purchase Request Table");

			for (int i = 0; i < products.size(); i++) {
				String quantityString = request.getParameter("quantity" + i);
				String productCode = request.getParameter("itemcheck" + i);
				String vendorIDstring = request.getParameter("vendorID" + i);
				String productIDString = request.getParameter("productID" + i);
				String idString = request.getParameter("userID");

				if (productCode != null) {
					int vendorID = (int) Double.parseDouble(vendorIDstring);
					int quantity = (int) Double.parseDouble(quantityString);
					int id = (int) Double.parseDouble(idString);
					int productID = (int) Double.parseDouble(productIDString);

					// console log
					System.out.println("PurchaseRequestID: " + id + " Quantity: " + quantity + " Product Code: "
							+ productCode + " VendorID: " + vendorID);

					// write to database
					prliDAO.writePrliToDatabase(generatedKey, productID, quantity);

					// add to current sum
					double sum = pDAO.getSum(productCode, vendorID, quantity);
					aggregate += sum;
				}

			}
			// GET ALL THE TOTALS
			System.out.println(aggregate);

			// write to Purchase Request DB
			prDAO.writePRToDatabase(description, aggregate);
			System.out.println("Total written to corresponding purchase request");

			// ************************ CODE BORROWED FROM MANAGERSERVLET action: review
			String orderIDString = Integer.toString(generatedKey);

			// set to new PR object
			ArrayList<PurchaseRequest> pendingR = prDAO.getPendingRequests(orderIDString);
			// not as good. Trying to replace.
			ArrayList<PurchaseRequestLineItem> prli = prliDAO.getPurchaseRequestLineItems(orderIDString);

			HttpSession session = request.getSession();
			// create hash map object from session object to pass into product ArrayList
			@SuppressWarnings("unchecked")
			Map<Integer, Product> productMap = (Map<Integer, Product>) session.getAttribute("productHash");

			for (PurchaseRequestLineItem p : prli) {
				Product pr = productMap.get(p.getProductID());
				p.setProduct(pr);
			}
			// set request
			request.setAttribute("orderNumber", orderIDString);
			request.setAttribute("pending", pendingR);
			request.setAttribute("prli", prli);
			// ************************** END OF CODE

			// check if total is less the 50 bucks. if less, send to approval.
			if (aggregate < 50.0) {
				url = "/menu-requests.jsp";
				// call approval method
				prDAO.writePRApproved(generatedKey);
			}

		}

		else if (action.equals("submit")) {
			url = "/menu-requests.jsp";

			String idString = request.getParameter("userid");
			int id = (int) Double.parseDouble(idString);
			prDAO.userWriteSubmit(id);

		}

		else if (action.equals("cancel")) {
			url = "/menu-requests.jsp";

			String idString = request.getParameter("userid");
			int id = (int) Double.parseDouble(idString);
			prDAO.userWriteCancel(id);

		}

		else {
			url = "/index.html";
		}
		sc.getRequestDispatcher(url).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
