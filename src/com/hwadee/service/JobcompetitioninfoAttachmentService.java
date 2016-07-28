package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.JobcompetitioninfoAttachment;
import com.hwadee.orm.JobcompetitioninfoAttachmentDAO;

/**
 * @TODO:�����������ҵ������
 * @author Dong
 * @date 2014-7-21����1:07:41
 */
public class JobcompetitioninfoAttachmentService {
	/**
	 * @TODO:���澺���������ʵ��
	 * @author Dong 
	 * @date 2014-7-21����9:52:12
	 */
	public static int save (JobcompetitioninfoAttachment jobcompetitioninfoAttachment){
		int ok=0;
		JobcompetitioninfoAttachmentDAO DAO=new JobcompetitioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(jobcompetitioninfoAttachment);
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
	 * @TODO:���ݾ�������������ɾ����Ϣ
	 * @author Dong 
	 * @date 2014-7-21����9:52:33
	 */
	public static int delete(int jobcompetitioninfoAttachmentID){
		int ok=0;
		JobcompetitioninfoAttachmentDAO DAO=new JobcompetitioninfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			JobcompetitioninfoAttachment csia=DAO.findById(jobcompetitioninfoAttachmentID); 
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
	 * @TODO:���¾����������
	 * @author Dong 
	 * @date 2014-7-21����11:04:56
	 */
	public static int update (JobcompetitioninfoAttachment jobcompetitioninfoAttachment){
		int ok=0;
		JobcompetitioninfoAttachmentDAO DAO=new JobcompetitioninfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(jobcompetitioninfoAttachment);
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
