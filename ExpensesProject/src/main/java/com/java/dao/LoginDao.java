package com.java.dao;

import com.java.model.Login;

public interface LoginDao {

    String signUp(Login user);  // save new user

    String signIn(String name, String passcode); // check login credentials
}