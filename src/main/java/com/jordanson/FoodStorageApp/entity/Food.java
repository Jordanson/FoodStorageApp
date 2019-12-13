package com.jordanson.FoodStorageApp.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Entity
@Table(name="food")
@JsonDeserialize(builder = Food.FoodBuilder.class)
public class Food {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private LocalDate expiration;
	
	@ManyToOne
	@JoinColumn(name="container_id", foreignKey = @ForeignKey(name = "FK_FOOD"))
	private Container container;
	
	private Food(FoodBuilder foodbuilder) {
		this.name = foodbuilder.name;
		this.type = foodbuilder.type;
		this.description = foodbuilder.description;
		this.expiration = foodbuilder.expiration;
	}
	
	public Food() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + ", expiration="
				+ expiration + ", container=" + container.getName() + "]";
	}
	
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	public static class FoodBuilder {
		private String name;	
		private String type;
		private String description;
		private LocalDate expiration;
		
		//DELEGATING is for single argument. PROPERTIES is for multi? 
		//Or can I can leave it as default when i introduce more parameters to the constructor?
		@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
		public FoodBuilder(@JsonProperty("name") String name) {
			this.name = name;
		}
		
		public FoodBuilder setType(String type) {
			this.type = type;
			return this;
		}
		
		public FoodBuilder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public FoodBuilder setExpiration(LocalDate expiration) {
			this.expiration = expiration;
			return this;
		}
		
		public Food build(){
			return new Food(this);
		}
	}
	
}
