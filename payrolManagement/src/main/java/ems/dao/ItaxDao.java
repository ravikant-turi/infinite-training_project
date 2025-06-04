package ems.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

import ems.exception.EmployeeException;
import ems.exception.ItaxException;
import ems.model.Tax;

public interface ItaxDao {

//	CalculateTax(employeeId, taxYear)
//	• GetTaxById(taxId)
//	• GetTaxesForEmployee(employeeId)
//	• GetTaxesForYear(taxYear)
	
	public double calculateTaxDao(int empId, int taxYear) throws SQLException, EmployeeException, ItaxException;

	public Tax getTaxByIdDao(int taxId) throws SQLException, ItaxException;

	public List<Tax> getTaxesForEmployeeDao(int employeeId) throws SQLException;

	public List<Tax> getTaxesForYearDao(int year) throws SQLException;

}
