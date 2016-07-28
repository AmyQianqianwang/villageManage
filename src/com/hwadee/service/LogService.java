package com.hwadee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Blog;
import com.hwadee.orm.BlogDAO;

public class LogService {
	
	/**
	  * @TODO: 保存日志 
	  * @author LUO-Administrator
	  * @date 2014-7-25 上午9:02:46
	 */
	public static int save(Blog blog){
		int ok = 0;
		BlogDAO blogDAO = new BlogDAO();
		Transaction t = blogDAO.getSession().beginTransaction();
		try{
			blogDAO.save(blog);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			blogDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	  * @TODO:日志列表分页 
	  * @author LUO-Administrator
	  * @date 2014-7-25 下午1:19:29
	 */
	@SuppressWarnings("unchecked")
	public static List<Blog> blogList(String keyword,int pageSize, int nowPage) {
		
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		BlogDAO blogDAO = new BlogDAO();
		Session session = blogDAO.getSession();
		String hql="from Blog B where B.user.userName like '%"+keyword+"%' order by B.opTime desc";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Blog> list = q.list();
		session.close();
		return list;
	}

	/**
	  * @TODO:日志列表总数 
	  * @author LUO-Administrator
	  * @date 2014-7-25 下午1:19:54
	 */
	@SuppressWarnings("unchecked")
	public static int blogListRowCount(String keyword) {
		BlogDAO blogDAO = new BlogDAO();
		Session session = blogDAO.getSession();
		String hql="from Blog B where B.user.userName like '%"+keyword+"%'";
		Query q = session.createQuery(hql);
		List<Blog> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	public static void main(String[] args) {
		blogList("",20,1);
		System.out.println(blogListRowCount("测试"));
	}
}
