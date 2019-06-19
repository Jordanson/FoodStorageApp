package com.jordanson.FoodStorageApp.service;

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
	//private FoodDAO foodDAO; 
	
	@Autowired
	public FoodService(ContainerDAO containerDAO, FoodDAO foodDAO) {
		this.containerDAO = containerDAO;
		//this.foodDAO = foodDAO;
	}
	
	@Transactional
	public void save(Food food, long id) {
		Container container = containerDAO.findById(id);
		container.addFood(food);
		containerDAO.save(container);
	}
}
