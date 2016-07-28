package com.hwadee.service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.hwadee.orm.Completeeditioninfo;
import com.hwadee.orm.CompleteeditioninfoDAO;
import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.ImplementplanfundsbugetDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.ProjectvoteinfoDAO;

import static com.hwadee.util.Constant.*;
/**
 * 
 * @TODO 初选项目议事会修改完善情况业务逻辑
 * @author GUO
 * @date 2014-7-21上午11:29:37
 */
public class CompleteeditioninfoService {

	public static int getCompleteEditionRowCount(String loc) {
		CompleteeditioninfoDAO dao = new CompleteeditioninfoDAO();
		Session session = dao.getSession();
		String hql = "from Completeeditioninfo C where C.project.proStatus='"
				+ 4 + "'  and C.project.location.locId like '%" + loc + "%'";
		Query q = session.createQuery(hql);
		List<Completeeditioninfo> list = q.list();
		session.close();
		if (null == list || list.size() == 0) {
			return 0;
		}
		return list.size();
	}
	
	
	public static List<Completeeditioninfo> completeEditionListByStatus(
			String loc, int pageSize, int nowPage, int status) {

		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		CompleteeditioninfoDAO dao = new CompleteeditioninfoDAO();
		Session session = dao.getSession();
		String hql = "from Completeeditioninfo C where C.project.proStatus='"
				+ status
				+ "'  and C.project.location.locId like '%"
				+ loc
				+ "%'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Completeeditioninfo> list = q.list();
		session.close();
		return list;
	}
	
	
	/**
	 * @TODO 保存 
	 * @author GUO
	 * @data 2014-7-21上午10:56:24
	 * @param pvi
	 * @return 成功与否
	 */
	public static int save(Completeeditioninfo cei)
	{
		CompleteeditioninfoDAO dao=new CompleteeditioninfoDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(cei);
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
	 * @data 2014-7-21上午11:31:37
	 * @param pviid
	 * @return 
	 */
	public static int delete(int ceiid)
	{
		CompleteeditioninfoDAO dao=new CompleteeditioninfoDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		Completeeditioninfo editinfo=dao.findById(ceiid);
		try {
			dao.delete(editinfo);
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
	 * @data 2014-7-21上午11:36:38
	 * @param cei
	 * @return 成功与否 
	 */
	public static int update(Completeeditioninfo cei)
	{
		CompleteeditioninfoDAO dao=new CompleteeditioninfoDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(cei);
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
	 * @TODO  获取所有项目议事会修改完善情况信息
	 * @author GUO
	 * @data 2014-7-21上午11:38:34
	 * @return List
	 */
	public static List<?> getAllCompleteEditionInfo()
	{
		CompleteeditioninfoDAO dao=new CompleteeditioninfoDAO();
		Session session=dao.getSession();
		String hql = "from CompleteEditionInfo";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
}
