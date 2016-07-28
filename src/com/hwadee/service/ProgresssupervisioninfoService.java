package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Progresssupervisioninfo;
import com.hwadee.orm.ProgresssupervisioninfoDAO;


/**
 * @TODO:进度检查业务层
 * @author Dong
 * @date 2014-7-21上午9:50:17
 */
public class ProgresssupervisioninfoService {

	/**
	 * @TODO:保存进度检查信息实例
	 * @author Dong 
	 * @date 2014-7-21上午9:52:12
	 */
	public static int save (Progresssupervisioninfo progresssupervisioninfo){
		int ok=0;
		ProgresssupervisioninfoDAO DAO=new ProgresssupervisioninfoDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(progresssupervisioninfo);
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
	 * @TODO:根据进度检查编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:33
	 */
	public static int delete(int progresssupervisioninfoID){
		int ok=0;
		ProgresssupervisioninfoDAO DAO=new ProgresssupervisioninfoDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			Progresssupervisioninfo progresssupervisioninfo=DAO.findById(progresssupervisioninfoID); 
			DAO.delete(progresssupervisioninfo);
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
	 * @TODO:获取全部进度坚持信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:56
	 */
	
	public static List<?> getAllProgressSupervisionInfo(){
		ProgresssupervisioninfoDAO DAO=new ProgresssupervisioninfoDAO();
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
	 * @TODO:更新比选情况
	 * @author Dong 
	 * @date 2014-7-21上午11:08:12
	 */
	public static int update(Progresssupervisioninfo progresssupervisioninfo){
		int ok=0;
		ProgresssupervisioninfoDAO DAO=new ProgresssupervisioninfoDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(progresssupervisioninfo);
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
