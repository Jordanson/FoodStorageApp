package com.jordanson.FoodStorageApp;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jordanson.FoodStorageApp.dao.FoodDAO;
import com.jordanson.FoodStorageApp.entity.Container;
import com.jordanson.FoodStorageApp.entity.Food;

@SpringBootApplication
public class FoodStorageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodStorageAppApplication.class, args);
	}

}
