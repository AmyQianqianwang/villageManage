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
	 * @TODO 保存 
	 * @author GUO
	 * @data 2014-7-21上午10:56:24
	 * @param ceia
	 * @return 成功与否
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
	 * @TODO 删除 
	 * @author GUO
	 * @data 2014-7-21上午11:01:17
	 * @param ceiaid
	 * @return 成功与否
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
	 * @TODO 更新
	 * @author GUO
	 * @data 2014-7-21上午11:03:48
	 * @param ceia
	 * @return 成功与否
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
	 * @TODO 获取所有原始投票信息 
	 * @author GUO
	 * @data 2014-7-21上午11:06:00
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
