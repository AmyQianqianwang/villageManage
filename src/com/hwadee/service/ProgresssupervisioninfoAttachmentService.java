package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.ProgresssupervisioninfoAttachment;
import com.hwadee.orm.ProgresssupervisioninfoAttachmentDAO;


/**
 * @TODO:���ȼල�������ҵ������
 * @author Dong
 * @date 2014-7-21����1:13:42
 */
public class ProgresssupervisioninfoAttachmentService {
	/**
	 * @TODO:������ȼල�������ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
	 */
	public static int save (ProgresssupervisioninfoAttachment progresssupervisioninfoAttachment){
		int ok=0;
		ProgresssupervisioninfoAttachmentDAO DAO=new ProgresssupervisioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(progresssupervisioninfoAttachment);
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
	 * @TODO:���ݽ��ȼල����������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
	 */
	public static int delete(int progresssupervisioninfoAttachmentID){
		int ok=0;
		ProgresssupervisioninfoAttachmentDAO DAO=new ProgresssupervisioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			ProgresssupervisioninfoAttachment csia=DAO.findById(progresssupervisioninfoAttachmentID); 
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
	 * @TODO:���½��ȼල�������
	 * @author Dong 
	 * @date 2014-7-21����11:04:56
	 */
	public static int update (ProgresssupervisioninfoAttachment progresssupervisioninfoAttachment){
		int ok=0;
		ProgresssupervisioninfoAttachmentDAO DAO=new ProgresssupervisioninfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(progresssupervisioninfoAttachment);
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
