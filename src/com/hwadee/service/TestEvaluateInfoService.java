/**
 * @author: 詹亮名
 * @date: 2014-7-21下午2:31:10
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.Acceptinfo;
import com.hwadee.orm.AcceptinfoDAO;
import com.hwadee.orm.Testevaluateinfo;
import com.hwadee.orm.TestevaluateinfoDAO;

/**
 * 项目测评情况
 */
public class TestEvaluateInfoService {
	
	/**
	 * 保存项目测评情况
	 * @param entity
	 * @return
	 * @author 詹亮名
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
	 * 删除一条测评情况
	 * @param id
	 * @author 詹亮名
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
	 * 更新项目测评情况
	 * @param entity
	 * @return
	 * @author 詹亮名
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
	 * 返回一条测评情况
	 * @param id
	 * @return
	 * @author 詹亮名
	 */
	public static Testevaluateinfo findById(int id) {
		
		return new TestevaluateinfoDAO().findById(id);
	}

	/**
	 * @param proId
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午9:19:42
	 */
	public static Testevaluateinfo getTestEvaByProject(String proId) {
		return new TestevaluateinfoDAO().getTestEvaByProject(proId);
	}

	/**
	 * @param testEva
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午9:42:51
	 */
	public static Testevaluateinfo findByExample(Testevaluateinfo testEva) {
		TestevaluateinfoDAO tDAO = new TestevaluateinfoDAO();
		return (Testevaluateinfo) tDAO.findByExample(testEva).get(0);
	}
}
