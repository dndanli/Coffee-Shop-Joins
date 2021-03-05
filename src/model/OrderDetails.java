/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 4, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_dt_id")
	private int orderDtId;
	
	@Column(name="order_dt_name")
	private String orderDtName;
	
	@Column(name="order_on_date")
	private LocalDate orderDtDate;
	
	//connects to the employee table using employee id as a foreign key
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@OneToMany( cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable(name ="orders_on_list", joinColumns={ @JoinColumn(name="order_dt_id",referencedColumnName="order_dt_id") },
				   inverseJoinColumns={ @JoinColumn(name="coffee_bean_id", referencedColumnName="id", unique=true) })
	private List<CoffeeBeanOrder> listOfItems;
	
	
	public OrderDetails() {
		super();
	}

	
	public OrderDetails(int orderDtId, String orderDtName, LocalDate orderDtDate, Employee employee, List<CoffeeBeanOrder> listOfItems) {
		super();
		this.orderDtId = orderDtId;
		this.orderDtName = orderDtName;
		this.orderDtDate = orderDtDate;
		this.employee = employee;
		this.listOfItems = listOfItems;
	}


	public OrderDetails(String orderDtName, LocalDate orderDtDate, Employee employee, List<CoffeeBeanOrder> listOfItems) {
		super();
		this.orderDtName = orderDtName;
		this.orderDtDate = orderDtDate;
		this.employee =  employee;
		this.listOfItems = listOfItems;
	}


	public OrderDetails(String orderDtName, LocalDate orderDtDate, Employee employee) {
		super();
		this.orderDtName = orderDtName;
		this.orderDtDate = orderDtDate;
		this.employee = employee;
	}


	public int getOrderDtId() {
		return orderDtId;
	}


	public void setOrderDtId(int orderDtId) {
		this.orderDtId = orderDtId;
	}


	public String getOrderDtName() {
		return orderDtName;
	}


	public void setOrderDtName(String orderDtName) {
		this.orderDtName = orderDtName;
	}


	public LocalDate getOrderDtDate() {
		return orderDtDate;
	}


	public void setOrderDtDate(LocalDate orderDtDate) {
		this.orderDtDate = orderDtDate;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public List<CoffeeBeanOrder> getListOfItems() {
		return listOfItems;
	}


	public void setListOfItems(List<CoffeeBeanOrder> listOfItems) {
		this.listOfItems = listOfItems;
	}


	@Override
	public String toString() {
		return "OrderDetails [orderDtId=" + orderDtId + ", orderDtName=" + orderDtName + ", orderDtDate=" + orderDtDate
				+ ", employeeID=" + employee + ", listOfItems=" + listOfItems + "]";
	}
		
}
