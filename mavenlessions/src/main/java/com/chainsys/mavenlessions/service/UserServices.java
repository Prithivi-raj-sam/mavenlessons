package com.chainsys.mavenlessions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.mavenlessions.entity.User;
import com.chainsys.mavenlessions.repository.UserRepository;
@Service
public class UserServices {

	@Autowired
	private UserRepository uRepo;
	public void addUser(User user) {
		uRepo.save(user);
	}
	public User findUserById(int id) {
		return uRepo.findById(id);
	}
	
	public User findUserByIdQuery(int id) {
		return uRepo.getUserByQuery(id);
	}

	public User findUserByIdNativeQuery(int id) {
		return uRepo.getUserByNativeSQL(id);
	}
	
	public List<User> getUsers(){
		return uRepo.findAll();
	}
	
	public void modifyUser(User user) {
//		TODO: validate User.id before uRepo.save()
		uRepo.save(user);
	}
	public void deleteUserById(int id) {
		uRepo.deleteById(id);
	} 
}