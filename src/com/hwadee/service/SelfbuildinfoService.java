package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Selfbuildinfo;
import com.hwadee.orm.SelfbuildinfoDAO;

/**
 * @TODO:自建情况业务层操作
 * @author Dong
 * @date 2014-7-21上午9:40:34
 */
public class SelfbuildinfoService {
	
	/**
	 * @TODO:保存自建信息实例
	 * @author Dong 
	 * @date 2014-7-21上午9:44:25
	 */
	public static int save(Selfbuildinfo selfbuildinfo){
		int ok=0;
		SelfbuildinfoDAO sbiDAO=new SelfbuildinfoDAO();
		Transaction t=sbiDAO.getSession().beginTransaction();
		try{
			sbiDAO.save(selfbuildinfo);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			sbiDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:根据自建信息编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:46:10
	 */
	public static int delete(int selfbuildinfoID){
		int ok=0;
		SelfbuildinfoDAO sbiDAO=new SelfbuildinfoDAO();
		Transaction t=sbiDAO.getSession().beginTransaction();
		try{
			Selfbuildinfo sbi=sbiDAO.findById(selfbuildinfoID);
			sbiDAO.delete(sbi);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			sbiDAO.getSession().close();
		}
		return ok;
	}
	
	public static List<?> getAllSelfBuildInfo(){
		SelfbuildinfoDAO sbiDAO=new SelfbuildinfoDAO();
		List<?> list=null;
		try{
			list=sbiDAO.findAll();
		}catch(Exception e){
			list=null;
		}finally{
			sbiDAO.getSession().close();
		}
		return list;
	}
	

	/**
	 * @TODO:更新比选情况
	 * @author Dong 
	 * @date 2014-7-21上午11:08:12
	 */
	public static int update(Selfbuildinfo selfbuildinfo){
		int ok=0;
		SelfbuildinfoDAO DAO=new SelfbuildinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(selfbuildinfo);
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
	 * @TODO:插入或更新自建信息
	 * @author Dong 
	 * @date 2014-7-24下午3:45:46
	 */
	public static int saveOrUpdate(Selfbuildinfo selfbuildinfo){
		int ok=0;
		SelfbuildinfoDAO DAO=new SelfbuildinfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.saveOrUpdate(selfbuildinfo);
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
