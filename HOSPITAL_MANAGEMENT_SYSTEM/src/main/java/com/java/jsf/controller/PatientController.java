package com.java.jsf.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.jsf.dao.PatientDao;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.Patient;

public class PatientController {
	
	
	private PatientDao patientdao;
	
	private Patient patient;
	
    private List<Patient> patientsByDoctor;
    
    
    private Doctor doctor;
	
	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Patient> getPatientsByDoctor() {
		return patientsByDoctor;
	}

	public void setPatientsByDoctor(List<Patient> patientsByDoctor) {
		this.patientsByDoctor = patientsByDoctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientDao getPatientdao() {
		return patientdao;
	}

	public void setPatientdao(PatientDao patientdao) {
		this.patientdao = patientdao;
	}
	
	public String getPatientById(String patientId) {
		
		patient= patientdao.searchPatientId(patientId);
		
		if(patient==null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No patient is available with patientId: " + patientId, null));
		}
		return null;
		
	}
	
    public String showPatientsByDoctorId(String doctorId) {
    	patientsByDoctor = patientdao.getPatientsByDoctorId(doctorId);
        
        if(patientsByDoctor.size()==0) {
        	return "notFoundError";
        }
        return "ShowPatientsByDoctor";  
    }
	

}
