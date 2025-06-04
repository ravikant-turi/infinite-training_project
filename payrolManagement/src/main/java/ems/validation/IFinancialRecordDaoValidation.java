package ems.validation;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import ems.dao.IFinancialRecordDao;
import ems.dao.ItaxDao;
import ems.daoimpl.IFinancialRecordDaoImpl;
import ems.daoimpl.ItaxDaoImpl;
import ems.exception.IFnancialRecordException;
import ems.model.FinancialRecord;
import ems.model.Tax;

public class IFinancialRecordDaoValidation {
	static Tax tax;
	static ItaxDao taxdao;
	static FinancialRecord financialRecord;
    static IFinancialRecordDao iFinancialRecordDao;
	static {
		tax = new Tax();
		taxdao = new ItaxDaoImpl();
		financialRecord=new  FinancialRecord();
		iFinancialRecordDao=new IFinancialRecordDaoImpl();
	}

	public String AddFinancialRecordDaoVal(int empId, String description, Double amount, String recordType)
			throws SQLException {
		
		return iFinancialRecordDao.AddFinancialRecordDao(empId, description, amount, recordType);

	}



    public FinancialRecord getFinanacialRecordByIdDaoVal(int recordId) throws SQLException, IFnancialRecordException{
	    return iFinancialRecordDao.getFinanacialRecordByIdDao(recordId);
    }


    public List<FinancialRecord> GetFinancialRecordsForEmployeeDaoVal(int empId) throws SQLException{
	    return iFinancialRecordDao.GetFinancialRecordsForEmployeeDao(empId);
    }


    public List<FinancialRecord> GetFinancialRecordsForDateDaoVal(Date date) throws SQLException{
	  return iFinancialRecordDao.GetFinancialRecordsForDateDao(date);
     }


}
