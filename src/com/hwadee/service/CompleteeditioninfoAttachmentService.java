package com.hwadee.service;

import static com.hwadee.util.Constant.FAILD;
import static com.hwadee.util.Constant.OK;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.CompleteeditioninfoAttachment;
import com.hwadee.orm.CompleteeditioninfoAttachmentDAO;

public class CompleteeditioninfoAttachmentService {

	/**
	 * @TODO ���� 
	 * @author GUO
	 * @data 2014-7-21����10:56:24
	 * @param ceia
	 * @return �ɹ����
	 */
	public static int save(CompleteeditioninfoAttachment ceia)
	{
		CompleteeditioninfoAttachmentDAO dao=new CompleteeditioninfoAttachmentDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(ceia);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		}
		finally{
			dao.getSession().close();
		}
	}
	
	/**
	 * @TODO ɾ�� 
	 * @author GUO
	 * @data 2014-7-21����11:01:17
	 * @param ceiaid
	 * @return �ɹ����
	 */
	public static int delete(int ceiaid)
	{
		CompleteeditioninfoAttachmentDAO dao=new CompleteeditioninfoAttachmentDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		CompleteeditioninfoAttachment voteinfo=dao.findById(ceiaid);
		try {
			dao.delete(voteinfo);
			transaction.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return FAILD;
		}
		finally{
			dao.getSession().close();
		}
	}
	
	/**
	 * @TODO ����
	 * @author GUO
	 * @data 2014-7-21����11:03:48
	 * @param ceia
	 * @return �ɹ����
	 */
	public static int update(CompleteeditioninfoAttachment ceia)
	{
		CompleteeditioninfoAttachmentDAO dao=new CompleteeditioninfoAttachmentDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(ceia);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		}
		finally
		{
			session.close();
		}
		
	}
	
	/**
	 * @TODO ��ȡ����ԭʼͶƱ��Ϣ 
	 * @author GUO
	 * @data 2014-7-21����11:06:00
	 * @return List
	 */
	public static List<?> getAllCompleteeditioninfoAttachment()
	{
		CompleteeditioninfoAttachmentDAO dao=new CompleteeditioninfoAttachmentDAO();
		Session session=dao.getSession();
		String hql = "from CompleteeditioninfoAttachment";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
}
