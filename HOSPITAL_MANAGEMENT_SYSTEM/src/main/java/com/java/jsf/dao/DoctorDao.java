package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Doctor;

public interface DoctorDao {

	String addDoctor(Doctor doctor);

	List<Doctor> showDoctor();

	List<Doctor> getDoctorListByDept(String specialization);

	Doctor SearchByDoctorsID(String doctorId);
}
