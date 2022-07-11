package com.chainsys.mavenlessions.controller;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.mavenlessions.entity.Appointment;
import com.chainsys.mavenlessions.entity.Doctor;
import com.chainsys.mavenlessions.repository.AppointmentRepository;

@RestController
public class AppointmentControl {
	 @Autowired
	    private AppointmentRepository aptRepo;
	 
	   @GetMapping(value = "/getDoctorByAppointmentId")
	    public String getDoctorByAppointmentId(int id) {
	    	Appointment app=aptRepo.findById(id);
	    	Doctor doc=app.getDoctors();
	    	return doc.toString();
	    }
	    @GetMapping(value = "/fetchappointment")
	    public Appointment getAppointmentById(int id) {
	    	return aptRepo.findById(id);
	    }
	    @GetMapping(value = "/fetchappointmentbydoctor")
	    public String getAppointmentByDocId(int id) {
	    	List<Appointment> applist= aptRepo.findByDoctorsId(id);
	    	String result="";
	    	Iterator<Appointment> itr=applist.iterator();
	    	while(itr.hasNext()){
	    		Appointment app=itr.next();
	    		result+=app.toString()+" \n";
	    	}
	    	return result;
	    }
	    @GetMapping(value = "/fetchallappointments")
	    public String getAllAppointments(){
	    	List<Appointment> applist=aptRepo.findAll();
	        String result="";
	    	Iterator<Appointment> itr=applist.iterator();
	    	while(itr.hasNext()){
	    		Appointment app=itr.next();
	    		result+=app.toString()+" \n";
	    	}
	    	return result;
	    }
	    @PostMapping(value = "/newappointment", consumes = "application/json")
	    public RedirectView addAppointment(@RequestBody Appointment apt) {
	         aptRepo.save(apt);
	         return new RedirectView("/fetchallappointments");
	    }
	    @PutMapping(value = "/modifyappointment", consumes = "application/json")
	    public RedirectView updateAppointment(@RequestBody Appointment apt) {
	         aptRepo.save(apt);
	         return new RedirectView("/fetchallappointments");
	    }
	    @DeleteMapping(value = "/removeappointment")
	    public RedirectView deleteAppointment(int id) {
	        aptRepo.deleteById(id);
	         return new RedirectView("/fetchallappointments");
	    }
}
