package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.CompareselectinfoAttachment;
import com.hwadee.orm.CompareselectinfoAttachmentDAO;

/**
 * @TODO:��ѡ�������ҵ����
 * @author Dong
 * @date 2014-7-21����10:10:16
 */
public class CompareselectinfoAttachmentService {
	/**
	 * @TODO:�����ѡ�������ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
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
	 * @TODO:���ݱ�ѡ����������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
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
	 * @TODO:���±�ѡ�������
	 * @author Dong 
	 * @date 2014-7-21����11:04:56
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
