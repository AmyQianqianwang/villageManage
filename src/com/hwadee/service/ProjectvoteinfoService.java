package com.hwadee.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.ProjectvoteinfoDAO;

import static com.hwadee.util.Constant.*;

/**
 * 
 * @TODO ԭʼ��Ŀ���ҵ���߼���
 * @author GUO
 * @date 2014-7-21����10:47:35
 */
public class ProjectvoteinfoService {

	/**
	 * 
	 * @TODO ��ȡ���м�¼����
	 * @author GUO
	 * @data 2014-7-24����4:46:40
	 * @param loc
	 * @return
	 */
	public static int getProjectVoteInfoRowCount(String loc, int pvType,
			int proStatus) {
		// TODO Auto-generated method stub
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		Session session = dao.getSession();
		String hql = "from Projectvoteinfo P where P.pvtype='" + pvType
				+ "'  and P.project.location.locId like '%" + loc + "%'"
				+ " and P.project.proStatus='" + proStatus + "'";
		Query q = session.createQuery(hql);
		List<Projectvoteinfo> list = q.list();
		session.close();
		if (null == list || list.size() == 0) {
			return 0;
		}
		return list.size();
	}

	/**
	 * @TODO ��ȡ�û���Ͻ��Χ�ڣ���Ŀ״̬Ϊԭʼ��ĿΪ����ļ�¼
	 * @author GUO
	 * @data 2014-7-24����4:41:50
	 * @param loc
	 * @param pageSize
	 * @param nowPage
	 * @return
	 */
	public static List<Projectvoteinfo> projectVoteInfoList(String loc,
			int pageSize, int nowPage, int pvType, int proStatus) {
		
		System.out.println(loc+" "+proStatus);
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ProjectvoteinfoDAO projectvoteinfoDAO = new ProjectvoteinfoDAO();
		Session session = projectvoteinfoDAO.getSession();
//		ProjectDAO dao=new ProjectDAO();
//		Session session=dao.getSession(); 
		String hql = "from Projectvoteinfo P where  P.project.location.locId like '%" + loc + "%'"
				+ " and P.project.proStatus='" + proStatus + "'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		
		//List<Projectvoteinfo> list = q.list();
		List<Projectvoteinfo> list=q.list();
		//System.out.println(list.size());
		session.close();
		return list;
	}

	/**
	 * @TODO ����
	 * @author GUO
	 * @data 2014-7-21����10:56:24
	 * @param pvi
	 * @return �ɹ����
	 */
	public static int save(Projectvoteinfo pvi) {
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		Transaction t = dao.getSession().beginTransaction();
		try {
			dao.save(pvi);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		} finally {
			dao.getSession().close();
		}
	}

	/**
	 * @TODO ɾ��
	 * @author GUO
	 * @data 2014-7-21����11:01:17
	 * @param pviid
	 * @return �ɹ����
	 */
	public static int delete(int pviid) {
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		Transaction transaction = dao.getSession().beginTransaction();
		Projectvoteinfo voteinfo = dao.findById(pviid);
		try {
			dao.delete(voteinfo);
			transaction.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return FAILD;
		} finally {
			dao.getSession().close();
		}
	}

	/**
	 * @TODO ����
	 * @author GUO
	 * @data 2014-7-21����11:03:48
	 * @param pvi
	 * @return �ɹ����
	 */
	public static int update(Projectvoteinfo pvi) {
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		Session session = dao.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(pvi);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		} finally {
			session.close();
		}

	}

	/**
	 * @TODO ��ȡ����ԭʼͶƱ��Ϣ
	 * @author GUO
	 * @data 2014-7-21����11:06:00
	 * @return List
	 */
	public static List<?> getAllProjectVoteInfo() {
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		Session session = dao.getSession();
		String hql = "from Projectvoteinfo";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}

}
