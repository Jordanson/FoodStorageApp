package com.jordanson.FoodStorageApp;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jordanson.FoodStorageApp.dao.ContainerDAO;
import com.jordanson.FoodStorageApp.dao.FoodDAO;
import com.jordanson.FoodStorageApp.entity.Container;
import com.jordanson.FoodStorageApp.entity.Food;

import java.time.LocalDate;


@Component
class Initializer implements CommandLineRunner {

    private ContainerDAO containerDAO;
    private FoodDAO foodDAO;

    public Initializer(ContainerDAO containerDAO, FoodDAO foodDAO) {
        this.containerDAO = containerDAO;
        this.foodDAO = foodDAO;
    }

    @Override
    public void run(String... strings) {
    	Container fridge = new Container("fridge");
    	Food hotdog = new Food.FoodBuilder("hotdogs", "meat")
				.setQuantity(10)
				.setExpiration(LocalDate.now())
				.setDescription("kosher")
				.buildFood();
    	//each method is returning the FoodBuilder object (this)
    	//and the next method uses that same object to allow for method chaining
    	//at the end the buildFood method returns the FoodBuilder object to the private constructor in the outer class

//		Food s1 = new Food.FoodBuilder("cheese", "dairy").buildFood();

//    	fridge.addFood(hotdog);
//      containerDAO.save(fridge);
    	long num = 2L;
    	//foodDAO.deleteById(num);
    	containerDAO.deleteById(2);
    	
    }
}