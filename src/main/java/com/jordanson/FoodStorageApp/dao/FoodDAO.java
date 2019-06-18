package com.jordanson.FoodStorageApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jordanson.FoodStorageApp.entity.Food;



@Repository
@Transactional
public class FoodDAO {
	private EntityManager em;
	
	@Autowired
	public FoodDAO(EntityManager em) {
		this.em = em;
	}


	public List<Food> findAll() {
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		//create the query
		Query<Food> query = currentSession.createQuery("from Food", Food.class);
		
		//execute query and get result list
		List<Food> food = query.getResultList();
		System.out.println(food);
		//return the results
		return food;
	}


	public Food findById(long id) {
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		Food food = currentSession.get(Food.class, id);
		
		return food;
	}

	public void save(Food food) {
		Session currentSession = em.unwrap(Session.class);
		
		
		currentSession.saveOrUpdate(food);
	}

	public void deleteById(long id) {
		Session currentSession = em.unwrap(Session.class);
		
		Query query = currentSession.createQuery("delete from Food where id=:foodId");
		query.setParameter("foodId", id);
		query.executeUpdate();
	}

}
