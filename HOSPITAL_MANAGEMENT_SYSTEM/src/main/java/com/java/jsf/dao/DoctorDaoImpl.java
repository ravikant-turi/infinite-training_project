package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Specialization;
import com.java.jsf.model.Status;
import com.java.jsf.util.SessionHelper;

public class DoctorDaoImpl implements DoctorDao {

	SessionFactory sf;

	Session session;

	@Override
	public String addDoctor(Doctor doctor) {
		sf = new Configuration().configure().buildSessionFactory();

		session = sf.openSession();

		// Generate custom doctorId
		String generatedID = generateDoctorID(session);
		doctor.setDoctorId(generatedID);
		doctor.setIsStatus(Status.ACTIVE); // default status

		Transaction tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		session.close();
		return "DoctorMenu.jsp?faces-redirect=true";	}

	private String generateDoctorID(Session session) {
		// Ensure uniqueness by appending count
		Query query = session.createQuery("select count(d) from Doctor d");
		long count = (long) query.uniqueResult();

		// You can customize prefix and pattern as needed
		String prefix = "HSk";
		String uniquePart = String.format("DS%02d", count + 1); // DS01, DS02, etc.

		return prefix + uniquePart; // e.g., HSkDS01
	}

	@Override
	public List<Doctor> showDoctor() {
		sf = new Configuration().configure().buildSessionFactory();

		session = sf.openSession();
		Query query = session.getNamedQuery("showDoctors");
		List<Doctor> doclist = query.list();
		return doclist;
	}

	public List<Doctor> getDoctorListByDept(String specialization) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		cr.add(Restrictions.eq("specialization", Specialization.valueOf(specialization)));
		List<Doctor> doctorList = cr.list();
		return doctorList;
	}
//	public List<Doctor> getDoctorListByDept(String specialization) {
//	    SessionFactory sf = SessionHelper.getConnection();
//	    Session session = sf.openSession();
//	    Criteria cr = session.createCriteria(Doctor.class);
//	    cr.add(Restrictions.eq("specialization", Specialization.valueOf(specialization)));
//	    List<Doctor> doctorList = cr.list();
//	    return doctorList;
//	}

	
	public Doctor SearchByDoctorID(String doctorId) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Doctor doctor = (Doctor) session.get(Doctor.class, doctorId);

		return doctor;
	}
	@Override
	public Doctor SearchByDoctorsID(String doctorId) {
		sf = new Configuration().configure().buildSessionFactory();

 // Get the session factory
		Session session = null;
		Doctor doctor = null;

		try {
			session = sf.openSession(); // Open a session

			// Fetch the doctor using the provided ID
			doctor = (Doctor) session.get(Doctor.class, doctorId);

			// Check if doctor is found
			if (doctor == null) {
				System.out.println("Doctor not found for ID: " + doctorId);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Log any exceptions
		} finally {
			if (session != null) {
				session.close(); // Always close the session to free up resources
			}
		}

		return doctor;
	}

}
