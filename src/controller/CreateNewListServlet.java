package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoffeeBeanOrder;
import model.Employee;
import model.OrderDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeBeanOrderHelper coffeeBeanHelper = new CoffeeBeanOrderHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String employeeName = request.getParameter("employeeName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allOrdersToAdd");
		List<CoffeeBeanOrder> selectedItemsInList = new ArrayList<CoffeeBeanOrder>();

		if (selectedItems != null && selectedItems.length > 0)
		{
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				CoffeeBeanOrder c = coffeeBeanHelper.searchForOrderByID(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		Employee employee = new Employee(employeeName);
		OrderDetails orderDetails = new OrderDetails(listName, ld, employee);

		orderDetails.setListOfItems(selectedItemsInList);

		OrderDetailsHelper orderDetailsHelper = new OrderDetailsHelper();
		orderDetailsHelper.insertNewListDetails(orderDetails);
		System.out.println("Success!");
		System.out.println(orderDetails.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
