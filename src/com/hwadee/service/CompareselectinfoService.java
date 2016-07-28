package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Compareselectinfo;
import com.hwadee.orm.CompareselectinfoDAO;

/**
 * @TODO:比选情况业务层操作
 * @author Dong
 * @date 2014-7-21上午9:28:59
 */
public class CompareselectinfoService {

	/**
	 * @TODO:保存比选按情况实例
	 * @author Dong 
	 * @date 2014-7-21上午9:30:41
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
	 * @TODO:根据比选情况编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:35:38
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
	 * @TODO:更新比选情况
	 * @author Dong 
	 * @date 2014-7-21上午11:08:12
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
	 * @TODO:插入或更新比选信息
	 * @author Dong 
	 * @date 2014-7-24下午3:47:22
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
