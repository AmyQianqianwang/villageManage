package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Directlyexecuteinfo;
import com.hwadee.orm.DirectlyexecuteinfoDAO;;
/**
 * @TODO:ֱ��ʵʩ���ҵ������
 * @author Dong
 * @date 2014-7-21����9:07:19
 */
public class DirectlyexecuteinfoService {
	
	/**
	 * @TODO:����ֱ��ʵʩ���ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:08:33
	 */
	public static int save(Directlyexecuteinfo directlyexecuteinfo){
		int ok=0;
		DirectlyexecuteinfoDAO deiDAO=new DirectlyexecuteinfoDAO();
		Transaction t=deiDAO.getSession().beginTransaction();
		try{
			deiDAO.save(directlyexecuteinfo);
			t.commit();
			ok=1;
		}catch (Exception e){
			t.rollback();
			ok=0;
		}finally{
			deiDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:����ʵʩ������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:14:33
	 */
	public static int delete(int directlyexecuteinfoID){
		int ok=0;
		DirectlyexecuteinfoDAO deiDAO=new DirectlyexecuteinfoDAO();
		Transaction t=deiDAO.getSession().beginTransaction();
		try{
			Directlyexecuteinfo dei=deiDAO.findById(directlyexecuteinfoID);
			deiDAO.delete(dei);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			deiDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:��ȡ����ֱ��ʵʩ�����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:19:56
	 */
	public static List<?> getAllDirectlyExecuteInfo(){
		DirectlyexecuteinfoDAO deiDAO=new DirectlyexecuteinfoDAO();
		List<?> list=null;
		try{
			list=deiDAO.findAll();
		}catch(Exception e){
			list=null;
		}finally{
			deiDAO.getSession().close();
		}
		return list;
	}
	
	/**
	 * @TODO:����ֱ��ʵʩ���
	 * @author Dong 
	 * @date 2014-7-21����11:08:12
	 */
	public static int update(Directlyexecuteinfo directlyexecuteinfo){
		int ok=0;
		DirectlyexecuteinfoDAO DAO=new DirectlyexecuteinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(directlyexecuteinfo);
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
	 * @TODO:������ֱ��ʵʩ��Ϣ
	 * @author Dong 
	 * @date 2014-7-24����4:28:36
	 */
	public static int saveOrUpdate(Directlyexecuteinfo directlyexecuteinfo){
		int ok=0;
		DirectlyexecuteinfoDAO DAO=new DirectlyexecuteinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.saveOrUpdate(directlyexecuteinfo);
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
