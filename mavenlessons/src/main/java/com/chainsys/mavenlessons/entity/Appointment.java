package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name = "APPOINTMENT_ID")
	private int id;
	@Column(name = "APPOINTMENT_DATE")
	private Date appointDate;
	@Column(name = "PATIENT_NAME")
	private String patientname;
	@Column(name = "FEES_COLLECTED")
	private float fees;
//	@Column(name = "DOC_ID")
//	private int docid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID" , nullable = false,
	insertable = false , updatable = false)
	@JsonIgnore
	private Doctor doctor;

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

//	public int getDocid() {
//		return docid;
//	}

//	public void setDocid(int docid) {
//		this.docid = docid;
//	}
	
	@Override
	public String toString() {
		return String.format("%d ,%s ,%s ,%.2f", id, appointDate,  patientname, fees);
	}
}
