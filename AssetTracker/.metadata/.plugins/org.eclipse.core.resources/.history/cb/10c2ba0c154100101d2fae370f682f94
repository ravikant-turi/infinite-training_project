package com.java.daoImpl;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.java.dao.AssetDao;
import com.java.model.Asset;
import com.java.util.HibernateUtil;

public class AssetDaoImpl implements AssetDao{
	
	Session session;
	Transaction tx;
	
	@Override
	public String addAsset(Asset asset) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(asset);
		tx.commit();
		session.close();
		return "Assest Added Successfully";
	}

	@Override
	public List<Asset> showAsset() {
	    Session session = null;
	    Transaction tx = null;
	    List<Asset> assetlist = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();

	        Query q = session.createQuery("from Asset");
	        assetlist = q.list();

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }
	    return assetlist;
	}




	@Override
	public List<Asset> showAssetbyEmpId() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String searchAsset() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
