package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Location;
import com.hwadee.orm.LocationDAO;

public class LocationService {
	
	/**
	  * @TODO: �޸ĵ���ſ���Ϣ
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����5:09:15
	 */
	public static int update(Location location){
		int ok = 0;
		LocationDAO locationDAO = new LocationDAO();
		Session session = locationDAO.getSession();
		Transaction t = session.beginTransaction();
		try{
			session.saveOrUpdate(location);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			session.close();
		}
		return ok;
	}
	
}
