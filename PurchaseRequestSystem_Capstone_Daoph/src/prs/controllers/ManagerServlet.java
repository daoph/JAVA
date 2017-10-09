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
import prs.db.PurchaseRequestDAO;
import prs.db.PurchaseRequestLineItemsDAO;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "";

		ServletContext sc = getServletContext();
		String action = request.getParameter("action");

		// call DAOs
		PurchaseRequestDAO prDAO = PRSFactory.getPurchaseRequestDAO();
		PurchaseRequestLineItemsDAO prliDAO = PRSFactory.getPurchaseRequestLineItemsDAO();

		if (action.equals("pending")) {

			// set url
			url = "/manager-pending.jsp";

			// set to new PR object
			ArrayList<PurchaseRequest> pendingR = prDAO.getPendingRequests();

			// set request
			request.setAttribute("pending", pendingR);

		} else if (action.equals("review")) {

			String orderIDString = request.getParameter("orderid");

			System.out.println("Order ID #:" + orderIDString);
			// set url
			url = "/manager-review.jsp";

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

		} else if (action.equals("approved")) {

			String idString = request.getParameter("userid");
			int id = (int) Double.parseDouble(idString);

			url = "/menu-requests.jsp";
			prDAO.writeManagerApproved(id);

		} else if (action.equals("denied")) {

			String idString = request.getParameter("userid");
			int id = (int) Double.parseDouble(idString);
			String s = request.getParameter("denialreason");

			url = "/menu-requests.jsp";
			prDAO.writeManagerDenied(id, s);

		} else if (action.equals("history")) {

			// set url
			url = "/manager-history.jsp";

			// set to new PR object
			ArrayList<PurchaseRequest> purchaseR = prDAO.getPurchaseRequests();

			// set request
			request.setAttribute("requests", purchaseR);

		} else {
			url = "/index.html";
		}

		// redirect
		sc.getRequestDispatcher(url).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
