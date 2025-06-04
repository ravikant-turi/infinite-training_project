package com.java.jsf.main;


import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.jsf.dao.DoctorDaoImpl;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.Patient;
import com.java.jsf.model.Specialization;
import com.java.jsf.model.Status;

public class Main {
	
	public static void main(String[] args) {
		
		DoctorDaoImpl dao=new DoctorDaoImpl();
		System.out.println("Hello ");
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		
		Transaction trans = session.beginTransaction();
		
//		dao.SearchByDoctorID("HSkDS01");
		
		System.out.println(	dao.SearchByDoctorsID("HSkDS02").getLocation());
		
		
//		createData(session, trans);
		
//       createPatitentData();		
	}
	
	public static void createPatitentData() {

		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		
		Transaction trans = session.beginTransaction();
        Doctor doctor = (Doctor) session.get(Doctor.class, "HSkDS01");

		 Patient patient = new Patient();
         patient.setPatientId("PTH629");
         patient.setPatientName("Ravikant Sharma");
         patient.setDateOfBirth(Date.valueOf("1990-04-15"));
         patient.setDoctor(doctor);  // Set reference

         // 4. Save Patient
         session.save(patient);
         trans.commit();

         System.out.println("Patient inserted successfully!");
		
	}
	 public static void createData(Session session,Transaction trans) {
		 Doctor doctor=new Doctor();
		 doctor.setDoctorId("D002");
	        doctor.setDoctorName("Dr. John Smith");
	        doctor.setSpecialization(Specialization.HEART);
	        doctor.setLocation("New York");
	        doctor.setMobileNo("1234567890");
	        doctor.setIsStatus(Status.ACTIVE);
			session.save(doctor);
			trans.commit();
			
			System.out.println("created");
	  }

}
