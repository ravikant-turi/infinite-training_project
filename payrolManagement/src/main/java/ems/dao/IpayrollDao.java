package ems.dao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import ems.exception.EmployeeException;
import ems.exception.ItaxException;
import ems.exception.PayrollException;
import ems.model.Payroll;
public interface IpayrollDao {
	
	
//	GeneratePayroll(employeeId, startDate, endDate)
	String GeneratePayrollDao(int employeeId,Date startDate,Date endDate) throws SQLException, EmployeeException, ItaxException;
	
	
//	• GetPayrollById(payrollId)
	 Payroll GetPayrollByIdDao(int payrollId) throws SQLException, PayrollException;
	 
	 
//	• GetPayrollsForEmployee(employeeId)
	List<Payroll> GetPayrollsForEmployeeDao(int employeeID) throws SQLException;
	
	
//	• GetPayrollsForPeriod(startDate, endDate)
	List<Payroll> GetPayrollsForPeriodDao(Date startDate, Date endDate) throws SQLException;
	
	
	 
}
