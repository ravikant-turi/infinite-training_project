package com.java.util;

import java.security.MessageDigest;

public class PasswordUtil {
	
	 public static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            
	            byte[] hashedBytes = md.digest(password.getBytes("UTF-8"));
	            
	            StringBuilder sb = new StringBuilder();
	            
	            for (byte b : hashedBytes) {
	            	
	                sb.append(String.format("%02x", b)); // convert byte to hex
	            }
	            return sb.toString();
	        } catch (Exception e) {
	            throw new RuntimeException("Error hashing password", e);
	        }
	    }

}