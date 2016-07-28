package com.hwadee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Jobcompetitioninfo;
import com.hwadee.orm.JobcompetitioninfoDAO;

/**
 * @TODO:JbComptitionInfo��ҵ���߼�����
 * @author Dong
 * @date 2014-7-21����8:56:02
 */
public class JobcompetitioninfoService {
	
	/**
	 * @TODO:���澺����Ϣʵ��
	 * @author Dong 
	 * @date 2014-7-21����8:56:21
	 */
	public static int save (Jobcompetitioninfo jobcompetitioninfo){
		int ok = 0;
		JobcompetitioninfoDAO jciDAO = new JobcompetitioninfoDAO();
		Transaction t = jciDAO.getSession().beginTransaction();
		try{
			jciDAO.save(jobcompetitioninfo);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			jciDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:���ݾ���������ɾ��
	 * @author Dong 
	 * @date 2014-7-21����8:59:34
	 */
	public static int delete (int jobcompetitioninfoID){
		int ok = 0;
		JobcompetitioninfoDAO jciDAO = new JobcompetitioninfoDAO();
		Transaction t = jciDAO.getSession().beginTransaction();
		Jobcompetitioninfo jobcompetitioninfo = jciDAO.findById(jobcompetitioninfoID);
		try{
			jciDAO.delete(jobcompetitioninfo);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			jciDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:��ȡ���о��������Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:04:17
	 */
	public static List<?> getAllJobCompetitionInfo(){
		JobcompetitioninfoDAO jciDAO = new JobcompetitioninfoDAO();
		Session session = jciDAO.getSession();
		String hql = "from Jobcompetitioninfo";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
	/**
	 * @TODO:���¾������
	 * @author Dong 
	 * @date 2014-7-21����11:08:12
	 */
	public static int update(Jobcompetitioninfo jobcompetitioninfo){
		int ok=0;
		JobcompetitioninfoDAO DAO=new JobcompetitioninfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(jobcompetitioninfo);
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
	
	/**
	 * @TODO:�������¾�����Ϣ
	 * @author Dong 
	 * @date 2014-7-24����4:27:23
	 */
	public static int saveOrUpdate(Jobcompetitioninfo jobcompetitioninfo){
		int ok = 0;
		JobcompetitioninfoDAO jciDAO = new JobcompetitioninfoDAO();
		Session s=jciDAO.getSession();
		Transaction t = s.beginTransaction();
		try{
			s.saveOrUpdate(jobcompetitioninfo);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			s.close();
		}
		return ok;
	}
}
