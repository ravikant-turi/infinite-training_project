package com.java.model;

import lombok.Data;

@Data
public class Accounts {
	
	private int accountNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private double amount;
	private String cheqFacil;
	private String accountType;

}
