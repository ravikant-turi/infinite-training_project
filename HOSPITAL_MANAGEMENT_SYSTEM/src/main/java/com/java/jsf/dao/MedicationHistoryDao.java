package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.MedicationHistory;

public interface MedicationHistoryDao {
	
	// Method to add a new medical history entry
    String addMedicalHistory(MedicationHistory medicationHistory);

    // Method to retrieve medical history for a given patient ID
    List<MedicationHistory >getPatientMedicalHistoryByPatientId(String patientId);

    // Method to get a list of all medication histories
    List<MedicationHistory> getAllMedicationHistories();

}
