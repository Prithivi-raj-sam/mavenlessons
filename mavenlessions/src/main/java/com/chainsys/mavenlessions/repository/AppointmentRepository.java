package com.chainsys.mavenlessions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessions.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	Appointment findById(int id);

	Appointment save(Appointment apt);

	void deleteById(int id);

	List<Appointment> findAll();

	// jpql(java persistence query language)
	// here a is an instance of Appointment Entity
//	@Query(value = "select a from Appointments a where a.docId=?1")
	List<Appointment> findByDoctorsId(int drId); //here findBy-
	
}