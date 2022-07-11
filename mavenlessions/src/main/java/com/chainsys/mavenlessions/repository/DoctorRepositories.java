package com.chainsys.mavenlessions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessions.entity.Doctor;

public interface DoctorRepositories extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);
	Doctor save(Doctor dr);
	// used for adding a new customer and modifying the existing customer
	void deleteById(int id);
	List<Doctor> findAll();
	
}
