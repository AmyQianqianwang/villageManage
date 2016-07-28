package com.hwadee.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


import com.hwadee.orm.ProjectvoteinfoAttachment;
import com.hwadee.orm.ProjectvoteinfoAttachmentDAO;

import static com.hwadee.util.Constant.*;

public class ProjectvoteinfoAttachmentService {

	/**
	 * @TODO ���� 
	 * @author GUO
	 * @data 2014-7-21����10:56:24
	 * @param pvia
	 * @return �ɹ����
	 */
	public static int save(ProjectvoteinfoAttachment pvia)
	{
		ProjectvoteinfoAttachmentDAO dao=new ProjectvoteinfoAttachmentDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(pvia);
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
	 * @param pviaid
	 * @return �ɹ����
	 */
	public static int delete(int pviaid)
	{
		ProjectvoteinfoAttachmentDAO dao=new ProjectvoteinfoAttachmentDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		ProjectvoteinfoAttachment voteinfo=dao.findById(pviaid);
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
	 * @param pvia
	 * @return �ɹ����
	 */
	public static int update(ProjectvoteinfoAttachment pvia)
	{
		ProjectvoteinfoAttachmentDAO dao=new ProjectvoteinfoAttachmentDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(pvia);
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
	public static List<?> getAllProjectvoteinfoAttachment()
	{
		ProjectvoteinfoAttachmentDAO dao=new ProjectvoteinfoAttachmentDAO();
		Session session=dao.getSession();
		String hql = "from ProjectvoteinfoAttachment";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
}
