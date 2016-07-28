package com.hwadee.service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.hwadee.orm.ProAttachment;
import com.hwadee.orm.ProAttachmentDAO;
import static com.hwadee.util.Constant.*;

public class ProAttachmentService {

	/**
	 * @TODO ���� 
	 * @author GUO
	 * @data 2014-7-21����10:56:24
	 * @param proa
	 * @return �ɹ����
	 */
	public static int save(ProAttachment proa)
	{
		ProAttachmentDAO dao=new ProAttachmentDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(proa);
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
	 * @param proaid
	 * @return �ɹ����
	 */
	public static int delete(int proaid)
	{
		ProAttachmentDAO dao=new ProAttachmentDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		ProAttachment voteinfo=dao.findById(proaid);
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
	 * @param proa
	 * @return �ɹ����
	 */
	public static int update(ProAttachment proa)
	{
		ProAttachmentDAO dao=new ProAttachmentDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(proa);
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
	public static List<?> getAllProAttachment()
	{
		ProAttachmentDAO dao=new ProAttachmentDAO();
		Session session=dao.getSession();
		String hql = "from ProAttachment";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
}
