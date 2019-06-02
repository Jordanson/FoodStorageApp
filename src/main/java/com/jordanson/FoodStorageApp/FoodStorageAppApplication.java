package com.jordanson.FoodStorageApp;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jordanson.FoodStorageApp.entity.Food;

@SpringBootApplication
public class FoodStorageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodStorageAppApplication.class, args);
		
		Food s1 = new Food.FoodBuilder("cheese", "dairy").buildFood();
		Food s2 = new Food.FoodBuilder("hotdogs", "meat")
				.setQuantity(10)
				.setExpiration(LocalDate.now())
				.setDescription("kosher")
				.buildFood();
		//each method is returning the FoodBuilder object (this)
		//and the next method uses that same object to allow for method chaining
		//at the end the buildFood method returns the FoodBuilder object to the private constructor in the outer class
		
		
		                 
		System.out.println(s1);
		System.out.println(s2);
	}

}
