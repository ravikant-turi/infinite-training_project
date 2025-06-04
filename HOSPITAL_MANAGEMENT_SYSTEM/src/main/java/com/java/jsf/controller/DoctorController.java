package com.java.jsf.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.jsf.dao.DoctorDao;
import com.java.jsf.model.Doctor;

public class DoctorController {
	
	private DoctorDao doctordao=null;
	
	private Doctor doctor=null;
	
	private List<Doctor> doctorlist=null;
	
	private String specialization="";
	
	private String doctorId="";
	
	
	
	

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	
	public List<Doctor> getDoctorlist() {
		return doctorlist;
	}

	public void setDoctorlist(List<Doctor> doctorlist) {
		this.doctorlist = doctorlist;
	}

	public DoctorDao getDoctordao() {
		return doctordao;
	}

	public void setDoctordao(DoctorDao doctordao) {
		this.doctordao = doctordao;
	}
	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String addDoctors(Doctor doctor) {
		return doctordao.addDoctor(doctor);
	}
	
	public List<Doctor> searchBySpecilization(String specialization) {
        doctorlist = doctordao.getDoctorListByDept(specialization);
        return doctorlist;
    }

    // ✅ Add this method for JSF page search button
	public String fetchDoctors() {
        this.doctorlist = searchBySpecilization(specialization);
        return null;
    }
	
	public String getDoctorById() {
		
		doctor=doctordao.SearchByDoctorsID(doctorId);
		
		if(doctor==null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No doctor with this doctorID: " + doctorId, null));
		}
		
		
			return "null";
		
	}

	public List<Doctor> showDoctorcontroler() {
		return doctordao.showDoctor();
	}

}
