package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.DirectlyexecuteinfoAttachment;
import com.hwadee.orm.DirectlyexecuteinfoAttachmentDAO;

/**
 * @TODO:ֱ��ʵʩ�������ҵ������
 * @author Dong
 * @date 2014-7-21����11:22:38
 */
public class DirectlyexecuteinfoAttachmentService {
	/**
	 * @TODO:����ֱ��ʵʩ�������ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
	 */
	public static int save (DirectlyexecuteinfoAttachment directlyexecuteinfoAttachment){
		int ok=0;
		DirectlyexecuteinfoAttachmentDAO DAO=new DirectlyexecuteinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(directlyexecuteinfoAttachment);
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
	 * @TODO:����ֱ��ʵʩ����������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
	 */
	public static int delete(int directlyexecuteinfoAttachmentID){
		int ok=0;
		DirectlyexecuteinfoAttachmentDAO DAO=new DirectlyexecuteinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DirectlyexecuteinfoAttachment csia=DAO.findById(directlyexecuteinfoAttachmentID); 
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
	 * @TODO:����ֱ��ʵʩ�������
	 * @author Dong 
	 * @date 2014-7-21����11:04:56
	 */
	public static int update (DirectlyexecuteinfoAttachment directlyexecuteinfoAttachment){
		int ok=0;
		DirectlyexecuteinfoAttachmentDAO DAO=new DirectlyexecuteinfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(directlyexecuteinfoAttachment);
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
