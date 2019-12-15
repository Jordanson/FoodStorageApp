package com.jordanson.FoodStorageApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="container")
public class Container {
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	
	@Column(name="name")
	private String name;
	
	
    @JsonIgnore
	@OneToMany(mappedBy="container", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval=true)
	private List<Food> foodList;
	
	public Container(String name) {
		this.name = name;
	}
	
	public Container() {
		
	}
	
	public void addFood(Food food) {
		if (foodList == null) {
			foodList = new ArrayList<>();
		}
		
		foodList.add(food);
		food.setContainer(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  
	public List<Food> getFoodList() {
		return foodList;
	}

	public void setItems(List<Food> foodList) {
		this.foodList = foodList;
	}

	@Override
	public String toString() {
		return "Container [id=" + id + ", name=" + name + ", foodList= " + foodList;
	}
}
