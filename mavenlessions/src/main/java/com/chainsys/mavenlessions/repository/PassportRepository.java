package com.chainsys.mavenlessions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessions.entity.Passport;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
	Passport findById(int id);
	List<Passport> findAll();
	Passport save(Passport passport);
	void deleteById(int id);
}
