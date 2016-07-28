package com.hwadee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;

/**
  * @TODO: 统计报表
  * @author LUO-Administrator
  * @date 2014-7-22 上午11:37:54
 */
public class ProjectFormsService {
	
	/**
	  * @TODO: 项目状态大于5且不等于16的项目视为表决通过
	  * @author LUO-Administrator
	  * @date 2014-7-22 下午3:37:37
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> projectVoteInfolist(String loc, int year, int pageSize, int nowPage) {
		
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus > 5 and P.paddingTime like '%" + year + "%' and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Project> list = q.list();
		session.close();
		return list;
	}

	/**
	  * @TODO:获取已经表决的项目总数，用于分页 
	  * @author LUO-Administrator
	  * @date 2014-7-23 下午3:18:38
	 */
	@SuppressWarnings("unchecked")
	public static int getProjectVoteInfoRowCount(String loc, int year) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus > 5 and P.paddingTime like '%" + year + "%' and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	/**
	  * @TODO:已经表决的项目汇总，生成柱状图 
	  * @author LUO-Administrator
	  * @date 2014-7-23 下午3:19:24
	 */
	public static List<?> getProjectVoteInfoBar(String loc, int year) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="select P.proStatus, count(*) from Project P where P.proStatus > 5 and P.paddingTime like '%"+year+"%' and P.location.locId like '%"+loc+"%' group by P.proStatus";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
	public static void main(String[] args) {
//		List<Project> list = projectVoteInfolist("510124", 2014, 20, 1);
//		System.out.println(list.get(0).getPaddingTime());
//		System.out.println(list.size());
//		
//		System.out.println(getProjectVoteInfoRowCount("510124", 2014));
		
//		System.out.println(getProjectVoteInfoBar("510124", 2014).size());
//		List<Object[]> data = new ArrayList<Object[]>();
//		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
//		for(int i = 0; i < dataList.size(); i++){
//			Object[] ob = (Object[]) dataList.get(i);
//			if(null != ob){
//				ob[0] = Constant.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
//				data.add(ob);
//			}
//		}
//		System.out.println();
	}
}
