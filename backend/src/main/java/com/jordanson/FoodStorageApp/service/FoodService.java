package com.jordanson.FoodStorageApp.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jordanson.FoodStorageApp.dao.ContainerDAO;
import com.jordanson.FoodStorageApp.dao.FoodDAO;
import com.jordanson.FoodStorageApp.entity.Container;
import com.jordanson.FoodStorageApp.entity.Food;

@Service
public class FoodService {
	
	private ContainerDAO containerDAO;
	private FoodDAO foodDAO; 
	
	@Autowired
	public FoodService(ContainerDAO containerDAO, FoodDAO foodDAO) {
		this.containerDAO = containerDAO;
		this.foodDAO = foodDAO;
	}
	
	@Transactional
	public void save(Food food, long id) {
		Container container = containerDAO.findById(id);
		container.addFood(food);
		containerDAO.save(container);
	}
	
	@Transactional
	public void update(Food food) {
		
		
		foodDAO.update(food);
	}
	
	@Transactional
	public Container getFoodByContainer(long id) {
		Container container = containerDAO.findById(id);		
		//this allows getFoodByContainer
		Hibernate.initialize(container.getFoodList());

		return container;
	}
}
