package com.java.jsf;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl implements UserDao {

	static SessionFactory sessionFactory;
	Session session;

	static {
		sessionFactory = SessionHelper.getConnection();
	}
	private int adminId = 2;
	private int groupId;
	private List<GroupMembers> allUsersOfAGroup;
	private double advanceCollected;
	private double totalExpenditure;
	private List<KeyValues> getPayUser;
	private List<KeyValues> giveUser;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public List<GroupMembers> getAllUsersOfAGroup() {
		return allUsersOfAGroup;
	}

	public void setAllUsersOfAGroup(List<GroupMembers> allUsersOfAGroup) {
		this.allUsersOfAGroup = allUsersOfAGroup;
	}

	public List<KeyValues> getGetPayUser() {
		return getPayUser;
	}

	public void setGetPayUser(List<KeyValues> getPayUser) {
		this.getPayUser = getPayUser;
	}

	public List<KeyValues> getGiveUser() {
		return giveUser;
	}

	public void setGiveUser(List<KeyValues> giveUser) {
		this.giveUser = giveUser;
	}

	public double getAdvanceCollected() {
		return advanceCollected;
	}

	public void setAdvanceCollected(double advanceCollected) {
		this.advanceCollected = advanceCollected;
	}

	public double getTotalExpenditure() {
		return totalExpenditure;
	}

	public void setTotalExpenditure(double totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String addUserDao(Users user) {
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(user);
		trans.commit();
		return "User Added...";
	}

	@Override
	public List<Users> showUserDao() {
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		return cr.list();
	}

	@Override
	public String addGroup(TravelGroup travelGroup) {
		System.out.println(travelGroup);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(travelGroup);
		trans.commit();
		System.out.println("Got");
		return "Travel Group Added...";
	}

	@Override
	public String addGroupMembers(GroupMembers groupMember) {
		groupMember.setGmId(2);
		System.out.println(groupMember);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(groupMember);
		trans.commit();
		return "Group Member Added...";
	}

	public String settlement(int grpId) {
		session = sessionFactory.openSession();

		// Get adminId
		Criteria cr1 = session.createCriteria(TravelGroup.class);
		cr1.add(Restrictions.eq("groupId", grpId));
		TravelGroup travelGroup = (TravelGroup) cr1.uniqueResult();
		this.adminId = travelGroup.getCreatedBy();

		// Get all members of the group
		Criteria cr = session.createCriteria(GroupMembers.class);
		cr.add(Restrictions.eq("groupId", grpId));
		this.allUsersOfAGroup = cr.list();

		// Total advance collected
		cr.setProjection(Projections.sum("amountCollected"));
		Double amount = (Double) cr.uniqueResult();
		this.advanceCollected = amount != null ? amount : 0.0;

		// Total member count
		cr = session.createCriteria(GroupMembers.class);
		cr.add(Restrictions.eq("groupId", grpId));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();

		// Total expenditure
		cr = session.createCriteria(DailyExpenses.class);
		cr.add(Restrictions.eq("groupId", grpId));
		cr.setProjection(Projections.sum("amount"));
		Double totalExp = (Double) cr.uniqueResult();
		this.totalExpenditure = totalExp != null ? totalExp : 0.0;

		double perHeadShare = totalExpenditure / count;

		// Amount paid by each user
		cr = session.createCriteria(DailyExpenses.class);
		cr.add(Restrictions.eq("groupId", grpId));
		cr.setProjection(
				Projections.projectionList().add(Projections.groupProperty("paidBy")).add(Projections.sum("amount")));

		List<Object[]> result = cr.list();
		Map<Integer, Double> paidByMap = new Hashtable<>();
		for (Object[] row : result) {
			paidByMap.put((Integer) row[0], (Double) row[1]);
		}

		getPayUser = new ArrayList<>();
		giveUser = new ArrayList<>();

		for (GroupMembers gm : allUsersOfAGroup) {
			int userId = gm.getUserId();
			double paid = paidByMap.getOrDefault(userId, 0.0);
			double net = paid - perHeadShare;

			if (net > 0) {
				getPayUser.add(new KeyValues(userId, Math.round(net * 100.0) / 100.0));
			} else if (net < 0) {
				giveUser.add(new KeyValues(userId, Math.round(Math.abs(net) * 100.0) / 100.0));
			}
		}

		return "settlementResult";
	}

	@Override
	public String addDailyExpenses(DailyExpenses dailyExpenses) {
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(dailyExpenses);
		trans.commit();
		return "Expense Recorded...";
	}

	@Override
	public List<DailyExpenses> showAllExpenses(int groupId) {
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(DailyExpenses.class);
		cr.add(Restrictions.eq("groupId", groupId));
		List<DailyExpenses> dailyExpenses = cr.list();
		return dailyExpenses;
	}

}
