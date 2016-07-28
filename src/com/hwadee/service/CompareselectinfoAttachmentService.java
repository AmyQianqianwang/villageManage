package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.CompareselectinfoAttachment;
import com.hwadee.orm.CompareselectinfoAttachmentDAO;

/**
 * @TODO:比选情况附件业操作
 * @author Dong
 * @date 2014-7-21上午10:10:16
 */
public class CompareselectinfoAttachmentService {
	/**
	 * @TODO:保存比选情况附件实例
	 * @author Dong 
	 * @date 2014-7-21上午9:52:12
	 */
	public static int save (CompareselectinfoAttachment compareselectinfoAttachment){
		int ok=0;
		CompareselectinfoAttachmentDAO DAO=new CompareselectinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(compareselectinfoAttachment);
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
	 * @TODO:根据比选情况附件编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:33
	 */
	public static int delete(int compareselectinfoAttachmentID){
		int ok=0;
		CompareselectinfoAttachmentDAO DAO=new CompareselectinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			CompareselectinfoAttachment csia=DAO.findById(compareselectinfoAttachmentID); 
			DAO.delete(csia);
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
	 * @TODO:更新比选情况附件
	 * @author Dong 
	 * @date 2014-7-21上午11:04:56
	 */
	public static int update (CompareselectinfoAttachment compareselectinfoAttachment){
		int ok=0;
		CompareselectinfoAttachmentDAO DAO=new CompareselectinfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(compareselectinfoAttachment);
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
