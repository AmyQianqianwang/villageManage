/**
 * @author: 詹亮名
 * @date: 2014-7-22下午3:56:18
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.Acceptinfo;
import com.hwadee.orm.AcceptinfoDAO;

/**
 * 基础建设类项目验收情况
 */
public class AcceptInfoService {
	
	
	/**
	 * 保存一条基建类验收情况
	 * @param entity
	 * @return
	 * @author 詹亮名
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
	 * 删除一条基建类验收情况
	 * @param id
	 * @author 詹亮名
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
	 * 更新一条基建类验收情况
	 * @param entity
	 * @return
	 * @author 詹亮名
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
	 * 返回一条基建类验收情况
	 * @param id
	 * @return
	 * @author 詹亮名
	 */
	public static Acceptinfo findById(int id) {
		return new AcceptinfoDAO().findById(id);
	}

	/**
	 * @param proId
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午7:21:47
	 */
	public static Acceptinfo getAcceptInfoByProject(String proId) {
		return new AcceptinfoDAO().getAcceptInfoByProject(proId);
	}

	/**
	 * @param acceptInfo
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午8:04:28
	 */
	public static Acceptinfo findByExample(Acceptinfo entity) {
		AcceptinfoDAO aDAO = new AcceptinfoDAO();
		return (Acceptinfo) aDAO.findByExample(entity).get(0);
	}
}
