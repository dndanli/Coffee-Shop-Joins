import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.OrderDetailsHelper;
import model.CoffeeBeanOrder;
import model.Employee;
import model.OrderDetails;

/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 4, 2021
 */


@SuppressWarnings("unused")
public class EmployeeTester {
	public static void main(String[] args) {
		/*
		Employee andre = new Employee("Andre");
		EmployeeHelper employeeHelper = new EmployeeHelper();
		
		employeeHelper.insertEmployee(andre);
		
		List<Employee> allEmployees = employeeHelper.showAllEmployees();
		for(Employee e : allEmployees) {
			System.out.println(e.toString());
		}
		
		Employee rebecca = new Employee("Rebecca");
		
		EmployeeHelper employeeHelper = new EmployeeHelper();
		
		employeeHelper.insertEmployee(rebecca);

		OrderDetailsHelper orderDetailsHelper = new OrderDetailsHelper();
		OrderDetails rebeccasList = new OrderDetails("Rebecca's List", LocalDate.now(), rebecca);
		
		orderDetailsHelper.insertNewListDetails(rebeccasList);
		List<OrderDetails> allOrdersLists = orderDetailsHelper.getLists();
		
		for (OrderDetails a : allOrdersLists) {
			System.out.println(a.toString());
		}
	
		Employee mark = new Employee ("Mark");
		OrderDetailsHelper orderDetailsHelper = new OrderDetailsHelper();
		
		CoffeeBeanOrder arabica = new CoffeeBeanOrder("Arabica",45, 122, "ABC.co");
		
		CoffeeBeanOrder liberica = new CoffeeBeanOrder("Liberica",12, 332, "XYZ.co");
		
		List<CoffeeBeanOrder> marksOrders = new ArrayList<CoffeeBeanOrder>();
		
		marksOrders.add(arabica);
		marksOrders.add(liberica);
		
		OrderDetails marksList = new OrderDetails("Mark's List", LocalDate.now(), mark);
		marksList.setListOfItems(marksOrders);
		
		orderDetailsHelper.insertNewListDetails(marksList);
		
		List<OrderDetails> allLists = orderDetailsHelper.getLists();
		for(OrderDetails detail: allLists) {
			System.out.println(detail.toString());
		}
		*/
		
	}
}
