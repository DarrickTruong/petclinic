package com.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jump.model.Pet;
import com.jump.service.PetService;


@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	PetService petService;

	@GetMapping
	public List<Pet> getPets()
	{
		return petService.getPets();
	}
	
	@PostMapping
	public Pet addPet(@RequestBody Pet pet)
	{
		return petService.addPet(pet);
	}
	
	@PutMapping("/{id}")
	public Pet updatePet(@RequestBody Pet pet)
	{
		return petService.updatePet(pet);
	}
	
	@GetMapping("/{id}")
	public Pet getPet(@PathVariable Integer id)
	{
		return petService.getPetById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable Integer id)
	{
		petService.deletePet(id);
	}
	
//	@GetMapping("/customers/{id}")
//	public Iterable<Pet> getPetsByCustomer(@PathVariable int customer) {
//		System.out.println(customer);
//		System.out.println("Calling customer/id");
//		return petService.findPetsByCustomer(customer);
//	}
	
	
	
	@GetMapping("/customer/{customer}")
	public Iterable<Pet> getPetsByCustomer(@PathVariable int customer) {
		return petService.findPetsByCustomer(customer);
	}

	
}