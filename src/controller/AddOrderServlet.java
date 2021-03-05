/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Feb 25, 2021
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoffeeBeanOrder;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String beanName = request.getParameter("beanName");
		int quantity = Integer.parseInt(request.getParameter("orderQuantity"));
		int packagesInStock = Integer.parseInt(request.getParameter("packagesStock"));
		String supplierName = request.getParameter("supplierName");
		CoffeeBeanOrder cbo = new CoffeeBeanOrder(beanName, quantity, packagesInStock, supplierName);
		CoffeeBeanOrderHelper dao = new CoffeeBeanOrderHelper();
		dao.insertOrder(cbo);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
