package com.jordanson.FoodStorageApp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordanson.FoodStorageApp.dao.ContainerDAO;
import com.jordanson.FoodStorageApp.dao.FoodDAO;
import com.jordanson.FoodStorageApp.entity.Container;
import com.jordanson.FoodStorageApp.entity.Food;
import com.jordanson.FoodStorageApp.service.FoodService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodRestController {
	private FoodDAO foodDAO;
	private FoodService service;
	
	@Autowired
	public FoodRestController(FoodDAO foodDAO, FoodService service) {
		this.foodDAO = foodDAO;
		this.service = service;
	}
	
	@GetMapping("/food")
	public List<Food> getFood() {
		return foodDAO.findAll();
	}

	@GetMapping("/food/{foodId}")
	public Food getFoodByID(@PathVariable long foodId) {
		Food food = foodDAO.findById(foodId);
		
		if (food == null) {
			throw new RuntimeException("Food id not found " + foodId);
		}
		
		return food;
	}
	
	
	@GetMapping("/food/containers/{containerId}")
	public List<Food> getFoodByContainer(@PathVariable long containerId) {
		return service.getFoodByContainer(containerId).getFoodList();
	}
	
	//why return here?
	@PostMapping("/food/{containerId}")
	public Food addFood(@RequestBody Food food, @PathVariable long containerId) {
		//just in case they pass an id in JSON, set id to zero 
		//this is to force a save of new item, instead of update 
		food.setId(0);
		
		service.save(food, containerId);
		//foodDAO.save(food);
		
		return food;
	}
	
	//why return here as well?
	@PutMapping("/food")
	public Food updateFood(@RequestBody Food food) {
		System.out.println(food.getContainer());
		service.update(food);
		return food;
		//despite postman returning the updated data, i could not get mysql to reflect the changes
		//until i added @Transactional to the "save" method in the Service layer. 
		//i did not have any issues adding food prior to adding @transactional, however
	}
	
	@DeleteMapping("/food/{foodId}")
	public String deleteFood(@PathVariable long foodId) {
		Food food = foodDAO.findById(foodId);
		
		if (food == null) {
			throw new RuntimeException("The food is not found - " + foodId);
		}
		
		foodDAO.deleteById(foodId);
		
		return "Deleted food id - " + foodId;
	}
}