package com.java.daoImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.dao.LoginDao;
import com.java.model.Login;
import com.java.util.HibernateUtil;

public class  LoginDaoImpl implements LoginDao {

	@Override
	public String signUp(Login user) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean valid = true;

		if (isEmpty(user.getName())) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name is required", null));
			valid = false;
		}

		if (isEmpty(user.getPasscode())) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passcode is required", null));
			valid = false;
		}

		if (isEmpty(user.getEmail())) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is required", null));
			valid = false;
		}

		if (!valid) {
			return null; // prevent save if any field is empty
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		System.out.println("signUp is called");

		return "User Registered Successfully";
	}

	@Override
	public String signIn(String name, String passcode) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean valid = true;

		if (isEmpty(name)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username is required", null));
			valid = false;
		}

		if (isEmpty(passcode)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password is required", null));
			valid = false;
		}

		if (!valid) {
			return null;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Login where name = :name and passcode = :passcode");
		query.setParameter("name", name);
		query.setParameter("passcode", passcode);

		Login result = (Login) query.uniqueResult();
		session.close();

		if (result != null) {
			return "valid";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
			return "invalid";
		}
	}

	private boolean isEmpty(Object value) {
		return value == null || value.toString().trim().isEmpty();
	}

}
