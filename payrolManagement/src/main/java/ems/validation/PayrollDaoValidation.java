package ems.validation;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import ems.dao.EmployeeDao;
import ems.dao.IpayrollDao;
import ems.daoimpl.EmployeeDaoImpl;
import ems.daoimpl.IpayrollDaoImpl;
import ems.exception.EmployeeException;
import ems.exception.ItaxException;
import ems.exception.PayrollException;
import ems.model.Payroll;

public class PayrollDaoValidation {
	static EmployeeDao employeedao;
	static IpayrollDao payrollDao;
	static StringBuilder sb;

	static {
		employeedao = new EmployeeDaoImpl();
		payrollDao=new  IpayrollDaoImpl();
		sb=new StringBuilder();
	}
	
	
	public String GeneratePayrollDaoVal(int employeeId,Date startDate,Date endDate) throws SQLException, EmployeeException, ItaxException{
		
		return payrollDao.GeneratePayrollDao(employeeId, startDate, endDate);
	}
	
	
	public Payroll GetPayrollByIdDaoVal(int payrollId) throws SQLException, PayrollException{
		 return payrollDao.GetPayrollByIdDao(payrollId);
	 }
	 
	 
	public List<Payroll> GetPayrollsForEmployeeDaoVal(int employeeID) throws SQLException{
		return payrollDao.GetPayrollsForEmployeeDao(employeeID);
	}
	 
	
	public List<Payroll> GetPayrollsForPeriodDaoVal(Date startDate, Date endDate) throws SQLException{
		return payrollDao.GetPayrollsForPeriodDao(startDate, endDate);
	}
	
}
