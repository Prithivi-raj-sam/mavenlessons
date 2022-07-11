package com.chainsys.mavenlessions.controller;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.context.annotation.Bean;

import com.chainsys.mavenlessions.entity.Appointment;
import com.chainsys.mavenlessions.entity.Doctor;
import com.chainsys.mavenlessions.repository.DoctorRepositories;

@RestController
public class DoctorService {
	@Autowired
	private DoctorRepositories repo;
//	@Bean
//	private void createRepo(DoctorRepositories repo) {
//		this.repo=repo;
//	}
	@GetMapping("/getDoctor")
	public String getDoctor(int id) {
		return repo.toString();
	}
	@GetMapping(value = "/getdoctorappointments") 
	public String getAppointments (int id) { 
		Doctor doc = repo.findById(id);
		List<Appointment> appointments = doc.getAppointments(); 
		return appointments.toString();
	}
	@PostMapping(value="/addDoctors", consumes="application/json")
	// we need to give where to readdata from the http request and also the content type (application/json)
	public RedirectView AddNewDoctor(@RequestBody Doctor dr) {
//		System.out.println("Doctor: "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return new RedirectView("/GetAllDoctors");
	}
	@PostMapping(value="/modifyDoctors", consumes="application/json")
	public RedirectView modifyDoctor(@RequestBody Doctor dr) {
//		System.out.println("Doctor: "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return new RedirectView("/GetAllDoctors");
	}
	@GetMapping("GetAllDoctors")
	public List<Doctor> GetAllDoctors(){
		return repo.findAll();
	}
	@DeleteMapping("/deleteDoctors")
	public RedirectView DeleteDoctor(int id) {
		repo.deleteById(id);
		return new RedirectView("/GetAllDoctors");
	}
}
