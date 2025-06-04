package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Patient;

public interface PatientDao {
	
	Patient searchPatientId(String patientId);
	List<Patient> getPatientsByDoctorId(String doctorId);
}
