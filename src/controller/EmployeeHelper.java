/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 4, 2021
 */

package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;

public class EmployeeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");
	
	public void insertEmployee(Employee e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> showAllEmployees() {
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allShoppers = em.createQuery("SELECT e FROM Employee e").getResultList();
		return allShoppers;
	}
}
