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
import com.jordanson.FoodStorageApp.entity.Container;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContainerRestController {
	private ContainerDAO containerDAO;
	
	@Autowired
	public ContainerRestController(ContainerDAO containerDAO) {
		this.containerDAO = containerDAO;
	}
	
	@GetMapping("/containers")
	public List<Container> getContainers() {
		return containerDAO.findAll();
	}

	@GetMapping("/containers/{containerId}")
	public Container getContainerByID(@PathVariable long containerId) {
		Container container = containerDAO.findById(containerId);
		
		if (container == null) {
			throw new RuntimeException("Container id not found " + containerId);
		}
		
		return container;
	}
	
	//why return here?
	@PostMapping("/containers")
	public Container addContainer(@RequestBody Container container) {
		//just in case they pass an id in JSON, set id to zero 
		//this is to force a save of new item, instead of update 
		container.setId(0);
		
		containerDAO.save(container);
		
		return container;
	}
	
	//why return here as well?
	@PutMapping("/containers")
	public Container updateContainer(@RequestBody Container container) {
		containerDAO.save(container);
		
		return container;
		//despite postman returning the updated data, i could not get mysql to reflect the changes
		//until i added @Transactional to the "save" method in the Service layer. 
		//i did not have any issues adding a container prior to adding @transactional, however
	}
	
	@DeleteMapping("/containers/{containerId}")
	public String deleteContainer(@PathVariable long containerId) {
		Container container = containerDAO.findById(containerId);
		
		if (container == null) {
			throw new RuntimeException("The container is not found - " + containerId);
		}
		
		containerDAO.deleteById(containerId);
		
		return "Deleted container id - " + containerId;
	}
}