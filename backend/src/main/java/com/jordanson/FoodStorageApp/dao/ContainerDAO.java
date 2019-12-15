package com.jordanson.FoodStorageApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jordanson.FoodStorageApp.entity.Container;



@Repository
@Transactional
public class ContainerDAO {
	private EntityManager em;
	
	@Autowired
	public ContainerDAO(EntityManager em) {
		this.em = em;
	}


	public List<Container> findAll() {
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		//create the query
		Query<Container> query = currentSession.createQuery("from Container", Container.class);
		
		//execute query and get result list
		List<Container> containers = query.getResultList();
		System.out.println(containers);
		//return the results
		return containers;
	}


	public Container findById(long id) {
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		Container container = currentSession.get(Container.class, id);
		
		return container;
	}

	public void save(Container container) {
		Session currentSession = em.unwrap(Session.class);
		
		
		currentSession.saveOrUpdate(container);
	}
	
	public void update(Container container) {
		Session currentSession = em.unwrap(Session.class);
		
		
		currentSession.merge(container);
	}

	public void deleteById(long id) {
		Session currentSession = em.unwrap(Session.class);
		
		currentSession.delete((em.find(Container.class, id)));
//		Query query = currentSession.createQuery("delete from Container where id=:containerId");
//		query.setParameter("containerId", id);
//		query.executeUpdate();
	}

}
