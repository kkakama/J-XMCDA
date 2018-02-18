package io.github.oliviercailloux.y2017.jxmcda.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import io.github.oliviercailloux.y2017.jxmcda.utils.QueryHelper;


public class InsertDB {
public static void main(String[] args) {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jxmcda");
	EntityManager em = emFactory.createEntityManager();

	QueryHelper queryHelper = new QueryHelper();
	queryHelper.setEmFactory(emFactory);
	

	final CriteriaQuery<Alternative> selectAll = queryHelper.selectAll(Alternative.class);
	final EntityTransaction transaction = em.getTransaction();
	transaction.begin();
	Alternative todo = new Alternative();
    todo.setName("Amandine");
    todo.setId("ok");
    em.persist(todo);
//	final TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
	final TypedQuery<Alternative> query = em.createQuery(selectAll);
	
	final List<Alternative> allItems = query.getResultList();
	
	transaction.commit();
	
	for (Alternative item : allItems) {
		System.out.println(item.getName());
	}
	
}
	
}
