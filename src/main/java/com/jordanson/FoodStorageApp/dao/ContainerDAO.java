package com.jordanson.FoodStorageApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
//import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jordanson.FoodStorageApp.entity.Container;
import com.jordanson.FoodStorageApp.entity.Food;

//jpa implementation
@Transactional
@Repository
public class ContainerDAO {
	private EntityManager em;
	
	@Autowired
	public ContainerDAO(EntityManager em) {
		this.em = em;
	}

	public List<Container> findAll() {
		Query query = em.createQuery("from Container");
		
		List<Container> containers = query.getResultList();
		
		return containers;
		// get the current hibernate session
//				Session currentSession = em.unwrap(Session.class);
//				
//				//create the query
//				Query<Container> query = currentSession.createQuery("from Container", Container.class);
//				
//				//execute query and get result list
//				List<Container> container = query.getResultList();
//				
//				//return the results
//				return container;
	}

	public Container findById(long id) {
		return em.find(Container.class, id);
	}

	public void save(Container container) {
		Container containerdb = em.merge(container);
		//merge method: if id == 0 save, else update
		
		
		//update with id from db... so we can get generated id for save/insert
		//if i comment it out it, my response will have an id of 0 rather than the actual id that is in the db
		//video 533 spring boot testing rest api with jpa impl
		container.setId(containerdb.getId());
	}

	public void deleteById(long id) {
		Query query = em.createQuery("delete from Container where id=:containerId");
		
		query.setParameter("containerId", id);
		
		query.executeUpdate();
	}
	
}
