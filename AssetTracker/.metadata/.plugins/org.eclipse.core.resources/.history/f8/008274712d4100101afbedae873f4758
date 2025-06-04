package com.java.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.dao.UserDao;
import com.java.model.User;


public class UserController {

    private User user ;
    private UserDao userDao ;

    public String signUp() {
        String result = userDao.signUp(user);

        if (result == null) {
            // Validation messages already added inside DAO
            return null;
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
        user = new User(); // reset form
        return "login"; // navigate to login.xhtml
    }

    public String signIn() {
        String result = userDao.signIn(String.valueOf(user.getName()), String.valueOf(user.getPasscode()));

        if ("valid".equals(result)) {
            return "message"; // navigate to welcome.xhtml
        } else if ("invalid".equals(result)) {
            // Error message already added in DAO
            return null;
        }

        // result == null means validation failed
        return null;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

    
    
    
}

