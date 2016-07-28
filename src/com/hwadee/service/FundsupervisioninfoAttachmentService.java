package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.FundsupervisioninfoAttachment;
import com.hwadee.orm.FundsupervisioninfoAttachmentDAO;

/**
 * @TODO:���Ѽ���������ҵ������
 * @author Dong
 * @date 2014-7-21����1:11:26
 */
public class FundsupervisioninfoAttachmentService {
	/**
	 * @TODO:���澭�Ѽ���������ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
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
	 * @TODO:���ݾ��Ѽ������������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
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
	 * @TODO:���¾��Ѽ���������
	 * @author Dong 
	 * @date 2014-7-21����11:04:56
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
