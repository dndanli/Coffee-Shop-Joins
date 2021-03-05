package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;

/**
 * Servlet implementation class ViewAllListsServlet
 */
@WebServlet("/viewAllListsServlet")
public class ViewAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllListsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDetailsHelper orderDetailsHelper = new OrderDetailsHelper();
		String path = "/order-list-by-employee.jsp";
		List<OrderDetails> listOfOrderDetails = orderDetailsHelper.getLists();
		
		request.setAttribute("allLists", listOfOrderDetails);
		
		if(listOfOrderDetails.isEmpty()){
			request.setAttribute("allLists", " ");
			path = "/index.html";
		}
		
		
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
