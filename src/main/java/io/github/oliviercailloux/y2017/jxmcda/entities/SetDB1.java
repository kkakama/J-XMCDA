package io.github.oliviercailloux.y2017.jxmcda.entities;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import io.github.oliviercailloux.y2017.jxmcda.utils.QueryHelper;

/**
 * 
 * @author SAMI & BADREDDINE 
 *
 */
public class SetDB1 {

	/**
	 * Methods to insert in BD
	 */
	public void insertProblem(String id){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jxmcda");
		EntityManager em = emFactory.createEntityManager();

		QueryHelper queryHelper = new QueryHelper();
		queryHelper.setEmFactory(emFactory);
		EntityTransaction transaction = em.getTransaction();
		Problem prob=new Problem(id);
		transaction.begin();
		prob.setId(id);
	    em.persist(prob);	
		transaction.commit();
		
	}
	//to write one Alternative object in database
	public void insertAlternative(String id, String name){
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jxmcda");
	EntityManager em = emFactory.createEntityManager();

	QueryHelper queryHelper = new QueryHelper();
	queryHelper.setEmFactory(emFactory);
	EntityTransaction transaction = em.getTransaction();
	Alternative alt=new Alternative();
	transaction.begin();
    alt.setName(name);
    alt.setId(id);
    em.persist(alt);	
	transaction.commit();
	
	}
	public void insertCriteri(int id, String name){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jxmcda");
		EntityManager em = emFactory.createEntityManager();

		QueryHelper queryHelper = new QueryHelper();
		queryHelper.setEmFactory(emFactory);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Criterion cri = new Criterion(id,name);
	    em.persist(cri);	
		transaction.commit();
		
		}
}
