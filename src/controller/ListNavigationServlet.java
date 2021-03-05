package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListNavigationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		OrderDetailsHelper dao = new OrderDetailsHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			
		} else if (act.equals("delete")) {
			
			try {
				
				Integer tempId =Integer.parseInt(request.getParameter("id"));
				
				OrderDetails listToDelete =dao.searchForOrderDetailsById(tempId);
				
				dao.deleteList(listToDelete);
				
			} catch (NumberFormatException e) {
				
				System.out.println("Forgot to click abutton");
				
			} finally {
				
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
			
		} else if (act.equals("add")) {
			
			getServletContext().getRequestDispatcher("/addOrdersForListServlet").forward(request, response);
		}
	}

}
