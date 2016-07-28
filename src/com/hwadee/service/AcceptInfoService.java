/**
 * @author: ղ����
 * @date: 2014-7-22����3:56:18
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.Acceptinfo;
import com.hwadee.orm.AcceptinfoDAO;

/**
 * ������������Ŀ�������
 */
public class AcceptInfoService {
	
	
	/**
	 * ����һ���������������
	 * @param entity
	 * @return
	 * @author ղ����
	 */
	public static int save(Acceptinfo entity) {
		int ok = 0;
		AcceptinfoDAO aDAO = new AcceptinfoDAO();
		Transaction t = aDAO.getSession().beginTransaction();
		
		try {
			aDAO.save(entity);
			t.commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			aDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * ɾ��һ���������������
	 * @param id
	 * @author ղ����
	 */
	public static void delete(int id){
		AcceptinfoDAO aDAO = new AcceptinfoDAO();
		Transaction t = aDAO.getSession().beginTransaction();
		Acceptinfo entity = aDAO.findById(id);
		
		try {
			aDAO.delete(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			aDAO.getSession().close();
		}
	}
	
	/**
	 * ����һ���������������
	 * @param entity
	 * @return
	 * @author ղ����
	 */
	public static Acceptinfo update(Acceptinfo entity) {
		AcceptinfoDAO aDao = new AcceptinfoDAO();
		Transaction t = aDao.getSession().beginTransaction();
		Acceptinfo entityUpdate = new Acceptinfo();
		
		try {
			entityUpdate = aDao.merge(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			aDao.getSession().close();
		}
		return entityUpdate;
	}
	
	/**
	 * ����һ���������������
	 * @param id
	 * @return
	 * @author ղ����
	 */
	public static Acceptinfo findById(int id) {
		return new AcceptinfoDAO().findById(id);
	}

	/**
	 * @param proId
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����7:21:47
	 */
	public static Acceptinfo getAcceptInfoByProject(String proId) {
		return new AcceptinfoDAO().getAcceptInfoByProject(proId);
	}

	/**
	 * @param acceptInfo
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����8:04:28
	 */
	public static Acceptinfo findByExample(Acceptinfo entity) {
		AcceptinfoDAO aDAO = new AcceptinfoDAO();
		return (Acceptinfo) aDAO.findByExample(entity).get(0);
	}
}
