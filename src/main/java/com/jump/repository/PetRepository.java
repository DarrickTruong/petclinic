package com.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jump.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	List<Pet> findAllByOwnerId(int customer);

	List<Pet> findAllByType(String type);
}
