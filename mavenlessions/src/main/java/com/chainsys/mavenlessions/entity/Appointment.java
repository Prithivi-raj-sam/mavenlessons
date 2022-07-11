package com.chainsys.mavenlessions.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Appointments")
public class Appointment {
	@Id
	@Column(name = "app_id")
	private int id;
	@Column(name = "APP_DATE")
	private Date appdate;
//	@Column(name = "DOC_ID")
//	private int docId;
	@Column(name = "PATIENT_NAME")
	private String name;
	@Column(name = "FEES_COLLECTED")
	private float feeCal;
	@Column(name = "FEES_CATEGORY")
	private String feeCat;
	// for many instances of appointment object only one instance of doctor object
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_id", nullable= false, insertable=false, updatable=false)
	@JsonIgnore
	private Doctor doctors; 

	public Doctor getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Doctor doc) {
		this.doctors = doc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppdate() {
		return appdate;
	}

	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}

//	public int getDocId() {
//		return docId;
//	}
//
//	public void setDocId(int docId) {
//		this.docId = docId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFeeCal() {
		return feeCal;
	}

	public void setFeeCal(float feeCal) {
		this.feeCal = feeCal;
	}

	public String getFeeCat() {
		return feeCat;
	}

	public void setFeeCat(String feeCat) {
		this.feeCat = feeCat;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %.2f, %s", id, appdate, name, feeCal, feeCat);
	}
}
