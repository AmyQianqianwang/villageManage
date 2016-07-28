package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Compareselectinfo;
import com.hwadee.orm.CompareselectinfoDAO;

/**
 * @TODO:��ѡ���ҵ������
 * @author Dong
 * @date 2014-7-21����9:28:59
 */
public class CompareselectinfoService {

	/**
	 * @TODO:�����ѡ�����ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:30:41
	 */
	public static int save(Compareselectinfo compareselectinfo){
		int ok=0;
		CompareselectinfoDAO csiDAO=new CompareselectinfoDAO();
		Transaction t=csiDAO.getSession().beginTransaction();
		try{
			csiDAO.save(compareselectinfo);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			csiDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:���ݱ�ѡ������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:35:38
	 */
	public static int delete(int compareselectinfoID){
		int ok=0;
		CompareselectinfoDAO csiDAO=new CompareselectinfoDAO();
		Transaction t=csiDAO.getSession().beginTransaction();
		try{
			Compareselectinfo csi=csiDAO.findById(compareselectinfoID);
			csiDAO.delete(csi);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			csiDAO.getSession().close();
		}
		return ok;
	}
	
	public static List<?> getAll(){
		CompareselectinfoDAO csiDAO=new CompareselectinfoDAO();
		List<?> list=null;
		try{
			list=csiDAO.findAll();
		}catch(Exception e){
			list=null;
		}finally{
			csiDAO.getSession().close();
		}
		return list;
	}
	
	/**
	 * @TODO:���±�ѡ���
	 * @author Dong 
	 * @date 2014-7-21����11:08:12
	 */
	public static int update(Compareselectinfo compareselectinfo){
		int ok=0;
		CompareselectinfoDAO DAO=new CompareselectinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(compareselectinfo);
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
	 * @TODO:�������±�ѡ��Ϣ
	 * @author Dong 
	 * @date 2014-7-24����3:47:22
	 */
	public static int saveOrUpdate(Compareselectinfo compareselectinfo){
		int ok=0;
		CompareselectinfoDAO DAO=new CompareselectinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.saveOrUpdate(compareselectinfo);
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
