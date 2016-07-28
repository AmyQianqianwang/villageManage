/**
 * @author: ղ����
 * @date: 2014-7-21����2:31:10
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.Acceptinfo;
import com.hwadee.orm.AcceptinfoDAO;
import com.hwadee.orm.Testevaluateinfo;
import com.hwadee.orm.TestevaluateinfoDAO;

/**
 * ��Ŀ�������
 */
public class TestEvaluateInfoService {
	
	/**
	 * ������Ŀ�������
	 * @param entity
	 * @return
	 * @author ղ����
	 */
	public static int save(Testevaluateinfo entity) {
		int ok = 0;
		TestevaluateinfoDAO tDAO = new TestevaluateinfoDAO();
		Transaction t = tDAO.getSession().beginTransaction();
		
		try {
			tDAO.save(entity);
			t.commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			tDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * ɾ��һ���������
	 * @param id
	 * @author ղ����
	 */
	public static void delete(int id){
		TestevaluateinfoDAO tDAO = new TestevaluateinfoDAO();
		Transaction t = tDAO.getSession().beginTransaction();
		Testevaluateinfo entity = tDAO.findById(id);
		
		try {
			tDAO.delete(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			tDAO.getSession().close();
		}
	}
	
	/**
	 * ������Ŀ�������
	 * @param entity
	 * @return
	 * @author ղ����
	 */
	public static Testevaluateinfo update(Testevaluateinfo entity) {
		TestevaluateinfoDAO tDao = new TestevaluateinfoDAO();
		Transaction t = tDao.getSession().beginTransaction();
		Testevaluateinfo entityUpdate = new Testevaluateinfo();
		
		try {
			entityUpdate = tDao.merge(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			tDao.getSession().close();
		}
		return entityUpdate;
	}
	
	/**
	 * ����һ���������
	 * @param id
	 * @return
	 * @author ղ����
	 */
	public static Testevaluateinfo findById(int id) {
		
		return new TestevaluateinfoDAO().findById(id);
	}

	/**
	 * @param proId
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����9:19:42
	 */
	public static Testevaluateinfo getTestEvaByProject(String proId) {
		return new TestevaluateinfoDAO().getTestEvaByProject(proId);
	}

	/**
	 * @param testEva
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����9:42:51
	 */
	public static Testevaluateinfo findByExample(Testevaluateinfo testEva) {
		TestevaluateinfoDAO tDAO = new TestevaluateinfoDAO();
		return (Testevaluateinfo) tDAO.findByExample(testEva).get(0);
	}
}
