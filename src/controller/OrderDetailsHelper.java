/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Mar 4, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OrderDetails;

public class OrderDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");
	
	public void insertNewListDetails(OrderDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<OrderDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<OrderDetails> allDetails = em.createQuery("SELECT d FROM OrderDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(OrderDetails toDelete) {

		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<OrderDetails> typedQuery = em.createQuery("select detail from OrderDetails detail where detail.orderDtId = :selectedId", OrderDetails.class);

		typedQuery.setParameter("selectedId", toDelete.getOrderDtId());

		typedQuery.setMaxResults(1);

		OrderDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public OrderDetails searchForOrderDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OrderDetails found = em.find(OrderDetails.class, tempId);
		em.close();
		return found;
	}
	
}
