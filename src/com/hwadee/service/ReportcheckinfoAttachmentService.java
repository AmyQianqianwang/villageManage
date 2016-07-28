package com.hwadee.service;

import static com.hwadee.util.Constant.FAILD;
import static com.hwadee.util.Constant.OK;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.ReportcheckinfoAttachment;
import com.hwadee.orm.ReportcheckinfoAttachmentDAO;

public class ReportcheckinfoAttachmentService {

	/**
	 * @TODO 保存 
	 * @author GUO
	 * @data 2014-7-21上午10:56:24
	 * @param rcia
	 * @return 成功与否
	 */
	public static int save(ReportcheckinfoAttachment rcia)
	{
		ReportcheckinfoAttachmentDAO dao=new ReportcheckinfoAttachmentDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(rcia);
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
	 * @param rciaid
	 * @return 成功与否
	 */
	public static int delete(int rciaid)
	{
		ReportcheckinfoAttachmentDAO dao=new ReportcheckinfoAttachmentDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		ReportcheckinfoAttachment voteinfo=dao.findById(rciaid);
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
	 * @param rcia
	 * @return 成功与否
	 */
	public static int update(ReportcheckinfoAttachment rcia)
	{
		ReportcheckinfoAttachmentDAO dao=new ReportcheckinfoAttachmentDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(rcia);
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
	public static List<?> getAllReportcheckinfoAttachment()
	{
		ReportcheckinfoAttachmentDAO dao=new ReportcheckinfoAttachmentDAO();
		Session session=dao.getSession();
		String hql = "from ReportcheckinfoAttachment";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
}
