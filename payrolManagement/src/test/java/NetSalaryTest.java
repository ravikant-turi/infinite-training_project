//package EmployeeManagement.EmployeeManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ems.daoimpl.IpayrollDaoImpl;

public class NetSalaryTest {

   private	IpayrollDaoImpl ipayrolldao;
	
	@Test
	public void testNetSalaryGeneration() {
		
		ipayrolldao=new IpayrollDaoImpl();
		
		Double basicSalary = 60000.0;

		Double overtimePay = 1000.0;

		Double deduction = basicSalary * 0.1;
		
		int days=30;
		
		assertEquals(55000.0, ipayrolldao.calculateNetSalary(basicSalary, overtimePay, deduction,days));
	}
	
}
