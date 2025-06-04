package com.java.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.dao.AdminDao;
import com.java.model.Admin;

public class AdminController {

	private Admin admin;
	private AdminDao admindao;

	public String signUp() {
		
		String result = admindao.signUp(admin);

		if (result == null) {
			
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));

		return "login"; 
	}

	public String signIn() {
		String result = admindao.signIn(String.valueOf(admin.getName()), String.valueOf(admin.getPasscode()));

		if ("valid".equals(result)) {
			return "message"; 
		} else if ("invalid".equals(result)) {
			
			return null;
		}

		
		return null;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminDao getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}

}
