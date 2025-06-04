package com.java.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.dao.LoginDao;
import com.java.model.Login;


public class LoginController {

    private Login login ;
    private LoginDao loginDao ;

    public String signUp() {
        String result = loginDao.signUp(login);

        if (result == null) {
            // Validation messages already added inside DAO
            return null;
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
        login = new Login(); // reset form
        return "login"; // navigate to login.xhtml
    }

    public String signIn() {
        String result = loginDao.signIn(String.valueOf(login.getName()), String.valueOf(login.getPasscode()));

        if ("valid".equals(result)) {
            return "message"; // navigate to welcome.xhtml
        } else if ("invalid".equals(result)) {
            // Error message already added in DAO
            return null;
        }

        // result == null means validation failed
        return null;
    }

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

    
    
    
}

