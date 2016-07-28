package com.hwadee.service;

import static com.hwadee.util.Constant.FAILD;
import static com.hwadee.util.Constant.OK;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.ImplementplanfundsbugetDAO;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;

public class ImplementplanfundsbugetService {

	public static int getFundsBugetInfoRowCount(String loc) {
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Session session = dao.getSession();
		String hql = "from Implementplanfundsbuget I where I.project.proStatus='"
				+ 3 + "'  and I.project.location.locId like '%" + loc + "%'";
		Query q = session.createQuery(hql);
		List<Implementplanfundsbuget> list = q.list();
		session.close();
		if (null == list || list.size() == 0) {
			return 0;
		}
		return list.size();
	}

	public static List<Implementplanfundsbuget> fundsBugetListByStatus(
			String loc, int pageSize, int nowPage, int status) {

		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Session session = dao.getSession();
		String hql = "from Implementplanfundsbuget I where I.project.proStatus='"
				+ status
				+ "'  and I.project.location.locId like '%"
				+ loc
				+ "%'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Implementplanfundsbuget> list = q.list();
		session.close();
		return list;
	}

	/**
	 * @TODO 保存
	 * @author GUO
	 * @data 2014-7-21上午10:56:24
	 * @param Ipfb
	 * @return 成功与否
	 */
	public static int save(Implementplanfundsbuget Ipfb) {
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Transaction t = dao.getSession().beginTransaction();
		try {
			dao.save(Ipfb);
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
	 * @TODO 删除
	 * @author GUO
	 * @data 2014-7-21上午11:01:17
	 * @param Ipfbid
	 * @return 成功与否
	 */
	public static int delete(int Ipfbid) {
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Transaction transaction = dao.getSession().beginTransaction();
		Implementplanfundsbuget voteinfo = dao.findById(Ipfbid);
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
	 * @TODO 更新
	 * @author GUO
	 * @data 2014-7-21上午11:03:48
	 * @param Ipfb
	 * @return 成功与否
	 */
	public static int update(Implementplanfundsbuget Ipfb) {
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Session session = dao.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(Ipfb);
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
	 * @TODO 获取所有原始投票信息
	 * @author GUO
	 * @data 2014-7-21上午11:06:00
	 * @return List
	 */
	public static List<?> getAllImplementplanfundsbuget() {
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		Session session = dao.getSession();
		String hql = "from Implementplanfundsbuget";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
}
