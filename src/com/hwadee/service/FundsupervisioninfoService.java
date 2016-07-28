package com.hwadee.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Fundsupervisioninfo;
import com.hwadee.orm.FundsupervisioninfoDAO;

/**
 * @TODO:经费检查情况业务层操作
 * @author Dong
 * @date 2014-7-21上午9:58:51
 */
public class FundsupervisioninfoService {
	/**
	 * @TODO:保存经费检查信息实例
	 * @author Dong 
	 * @date 2014-7-21上午9:52:12
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
	 * @TODO:根据经费检查编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:33
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
	 * @TODO:获取全部经费坚持信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:56
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
	 * @TODO:更新经费检查情况
	 * @author Dong 
	 * @date 2014-7-21上午11:08:12
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
