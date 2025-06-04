package ems.validation;

import java.sql.SQLException;
import java.util.List;

import ems.dao.ItaxDao;
import ems.daoimpl.ItaxDaoImpl;
import ems.exception.EmployeeException;
import ems.exception.ItaxException;
import ems.model.Tax;

public class TaxDaoValidation {
	
	static Tax tax;
	static ItaxDao taxdao;
	
	static {
		tax=new Tax();
		taxdao=new ItaxDaoImpl();
	}
	
	public double calculateTaxDaoVal(int empId, int taxYear) throws SQLException, EmployeeException, ItaxException {
		return taxdao.calculateTaxDao(empId, taxYear);
	}
	
	public Tax getTaxByIdDaoVal(int taxId) throws SQLException, ItaxException{
		return taxdao.getTaxByIdDao(taxId);
	}

	public List<Tax> getTaxesForEmployeeDaoVal(int employeeId) throws SQLException{
		return taxdao.getTaxesForEmployeeDao(employeeId);
	}

	public List<Tax> getTaxesForYearDaoVal(int year) throws SQLException{
		return taxdao.getTaxesForEmployeeDao(year);
	}


}
