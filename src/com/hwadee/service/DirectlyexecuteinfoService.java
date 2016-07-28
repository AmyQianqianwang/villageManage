package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Directlyexecuteinfo;
import com.hwadee.orm.DirectlyexecuteinfoDAO;;
/**
 * @TODO:直接实施情况业务层操作
 * @author Dong
 * @date 2014-7-21上午9:07:19
 */
public class DirectlyexecuteinfoService {
	
	/**
	 * @TODO:保存直接实施情况实例
	 * @author Dong 
	 * @date 2014-7-21上午9:08:33
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
	 * @TODO:根据实施情况编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:14:33
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
	 * @TODO:获取所有直接实施情况信息
	 * @author Dong 
	 * @date 2014-7-21上午9:19:56
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
	 * @TODO:更新直接实施情况
	 * @author Dong 
	 * @date 2014-7-21上午11:08:12
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
	 * @TODO:插入或更直接实施信息
	 * @author Dong 
	 * @date 2014-7-24下午4:28:36
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
