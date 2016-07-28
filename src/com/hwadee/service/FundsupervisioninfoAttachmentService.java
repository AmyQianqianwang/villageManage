package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.FundsupervisioninfoAttachment;
import com.hwadee.orm.FundsupervisioninfoAttachmentDAO;

/**
 * @TODO:经费检查情况附件业务层操作
 * @author Dong
 * @date 2014-7-21下午1:11:26
 */
public class FundsupervisioninfoAttachmentService {
	/**
	 * @TODO:保存经费检查情况附件实例
	 * @author Dong 
	 * @date 2014-7-21上午9:52:12
	 */
	public static int save (FundsupervisioninfoAttachment fundsupervisioninfoAttachment){
		int ok=0;
		FundsupervisioninfoAttachmentDAO DAO=new FundsupervisioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(fundsupervisioninfoAttachment);
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
	 * @TODO:根据经费检查情况附件编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:33
	 */
	public static int delete(int fundsupervisioninfoAttachmentID){
		int ok=0;
		FundsupervisioninfoAttachmentDAO DAO=new FundsupervisioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			FundsupervisioninfoAttachment csia=DAO.findById(fundsupervisioninfoAttachmentID); 
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
	 * @TODO:更新经费检查情况附件
	 * @author Dong 
	 * @date 2014-7-21上午11:04:56
	 */
	public static int update (FundsupervisioninfoAttachment fundsupervisioninfoAttachment){
		int ok=0;
		FundsupervisioninfoAttachmentDAO DAO=new FundsupervisioninfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(fundsupervisioninfoAttachment);
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
