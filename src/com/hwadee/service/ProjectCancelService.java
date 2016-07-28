package com.hwadee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;

/**
  * @TODO:项目取消 
  * @author LUO-Administrator
  * @date 2014-7-24 下午10:59:47
 */
public class ProjectCancelService {
	
	/**
	  * @TODO: 取消项目列表
	  * @author LUO-Administrator
	  * @date 2014-7-24 下午11:00:13
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> projectCancelInfolist(String loc, int pageSize, int nowPage) {
		
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where (P.proStatus = 16 or P.proStatus <= 0) and P.location.locId like '%"+ loc +"%' order by P.proId desc";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Project> list = q.list();
		session.close();
		return list;
	}

	/**
	  * @TODO:取消项目总数 
	  * @author LUO-Administrator
	  * @date 2014-7-24 下午11:02:26
	 */
	@SuppressWarnings("unchecked")
	public static int getProjectCancelInfoRowCount(String loc) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where (P.proStatus = 16 or P.proStatus <= 0) and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	public static void main(String[] args) {
		System.out.println(getProjectCancelInfoRowCount("510124"));
	}
}
