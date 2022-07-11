package com.chainsys.mavenlessions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Doctors") // mapping, this work belongs to ORM(object relational mapping)
public class Doctor {
	@Id
	@Column(name="doc_id")
	private int id; 
	@Column(name="doc_name")
	private String doc_name;
	@Column(name="dob")
	private Date dob;
	@Column(name="speciality")
	private String speciality;
	@Column(name="doc_city")
	private String doc_city;
	@Column(name="phone")
	private long phone;
	@Column(name = "standard_fees")
	private float standard_fees;
	
	// each doctor can have one or more appointments so the list is used 
	@OneToMany (mappedBy = "doctors", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Appointment> appointments;
	
	public List<Appointment> getAppointments(){ 
	return this.appointments;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getdoc_city() {
		return doc_city;
	}

	public void setCity(String doc_city) {
		this.doc_city = doc_city;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public float getstandard_fees() {
		return standard_fees;
	}

	public void setstandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}

	@Override
	public String toString() {
		return String.format(" { %d, %s, %s, %s, %s, %d, %.2f }",
				id, doc_name, dob, speciality, doc_city, phone, standard_fees);
	}
}
