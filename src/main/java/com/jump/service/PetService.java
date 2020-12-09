package com.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.exception.PetNotFoundException;

import com.jump.model.Pet;
import com.jump.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;
	
	public Pet addPet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet updatePet(Pet pet) {
		getPetById(pet.getId());
		return petRepository.save(pet);
	}

	public List<Pet> getPets() {
		return petRepository.findAll();
	}

	public Pet getPetById(Integer id) {
		return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
	}

	public void deletePet(Integer id) {
		getPetById(id);
		petRepository.deleteById(id);
	}
	
	public List<Pet> findPetsByCustomer(int customer) {
		return petRepository.findAllByOwnerId(customer);
	}
	
	public List<Pet> findPetsByType(String type) {
		return petRepository.findAllByType(type);
	}
	
	
}