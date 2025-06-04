package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.jsf.model.Patient;

public class PatientDaoImpl implements PatientDao {
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public Patient searchPatientId(String patientId) {
		
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    session = sessionFactory.openSession();

//	    Query query = session.createQuery("from Patient where patientId = :pid");
	    Query query = session.createQuery(
	            "from Patient p join fetch p.doctor where p.patientId = :pid"
	        );
	    query.setParameter("pid", patientId);

	    Patient patient = (Patient) query.uniqueResult();

	    session.close(); // good practice
	    return patient;
		}
	
	
	// Fetch patients by doctorId
    public List<Patient> getPatientsByDoctorId(String doctorId) {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Patient where doctor.doctorId = :doctorId");
        query.setParameter("doctorId", doctorId);
        return query.list();
    }
	

}
