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

@Entity
@Table(name="food")
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
	
	public Food() {
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
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
	
	
	public static class FoodBuilder {
		private String name;	
		private String type;
		private String description;
		private LocalDate expiration;
		
		public FoodBuilder(String name, String type) {
			this.name = name;
			this.type = type;
		}
		
		public FoodBuilder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public FoodBuilder setExpiration(LocalDate expiration) {
			this.expiration = expiration;
			return this;
		}
		
		public Food buildFood(){
			return new Food(this);
		}
	}
	
}
