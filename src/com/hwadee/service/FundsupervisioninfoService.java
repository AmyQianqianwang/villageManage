package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Fundsupervisioninfo;
import com.hwadee.orm.FundsupervisioninfoDAO;

/**
 * @TODO:���Ѽ�����ҵ������
 * @author Dong
 * @date 2014-7-21����9:58:51
 */
public class FundsupervisioninfoService {
	/**
	 * @TODO:���澭�Ѽ����Ϣʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
	 */
	public static int save (Fundsupervisioninfo fundsupervisioninfo){
		int ok=0;
		FundsupervisioninfoDAO DAO=new FundsupervisioninfoDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(fundsupervisioninfo);
			t.commit();
			ok=1;
		} catch (Exception e) {
			t.rollback();
			ok=0;
		}finally{
			DAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:���ݾ��Ѽ����ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
	 */
	public static int delete(int fundsupervisioninfoID){
		int ok=0;
		FundsupervisioninfoDAO DAO=new FundsupervisioninfoDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			Fundsupervisioninfo fsi=DAO.findById(fundsupervisioninfoID); 
			DAO.delete(fsi);
			t.commit();
			ok=1;
		} catch (Exception e) {
			t.rollback();
			ok=0;
		}finally{
			DAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:��ȡȫ�����Ѽ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:56
	 */
	
	public static List<?> getAllFundsupervisioninfo(){
		FundsupervisioninfoDAO DAO=new FundsupervisioninfoDAO();
		List<?> list=null;
		try{
			list=DAO.findAll();
		}catch(Exception e){
			list=null;
		}finally{
			DAO.getSession().close();
		}
		return list;
	}
	
	/**
	 * @TODO:���¾��Ѽ�����
	 * @author Dong 
	 * @date 2014-7-21����11:08:12
	 */
	public static int update(Fundsupervisioninfo fundsupervisioninfo){
		int ok=0;
		FundsupervisioninfoDAO DAO=new FundsupervisioninfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(fundsupervisioninfo);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			s.close();
		}
		return ok;
	}
}
