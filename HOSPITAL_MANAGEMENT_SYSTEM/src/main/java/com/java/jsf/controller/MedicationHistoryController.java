package com.java.jsf.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.jsf.dao.MedicationHistoryDao;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;

public class MedicationHistoryController {
	
	private MedicationHistoryDao medicationHistoryDao;
	
	private MedicationHistory medicationHistory;
	
	private List<MedicationHistory> medicationHistoryList;
	
	private Patient patient;
	
	private Doctor doctor;
	
	public String getPatientId() {
		return patientId;
	}





	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}





	private String patientId;
	
	
	
	
	
	
	
	
	public Doctor getDoctor() {
		return doctor;
	}





	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}





	public List<MedicationHistory> getMedicationHistoryList() {
		return medicationHistoryList;
	}





	public void setMedicationHistoryList(List<MedicationHistory> medicationHistoryList) {
		this.medicationHistoryList = medicationHistoryList;
	}





	public Patient getPatient() {
		return patient;
	}





	public void setPatient(Patient patient) {
		this.patient = patient;
	}





	public MedicationHistoryDao getMedicationHistoryDao() {
		return medicationHistoryDao;
	}





	public void setMedicationHistoryDao(MedicationHistoryDao medicationHistoryDao) {
		this.medicationHistoryDao = medicationHistoryDao;
	}





	public MedicationHistory getMedicationHistory() {
		return medicationHistory;
	}





	public void setMedicationHistory(MedicationHistory medicationHistory) {
		this.medicationHistory = medicationHistory;
	}





	public String addMedicalHistoryController() {
		
		return medicationHistoryDao.addMedicalHistory(medicationHistory);
	}
	
	public String getPatientMedicalHistoryByPatientIdController() {
		
		medicationHistoryList=medicationHistoryDao.getPatientMedicalHistoryByPatientId(patientId);
		
		if(medicationHistory==null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No MedicalHistory with this patientId: " + patientId, null));
		}
		
		return "medicalHistoryByPatientId";
		
		
	}
	
	

}
