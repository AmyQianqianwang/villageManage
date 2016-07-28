/**
 * @author: 詹亮名
 * @date: 2014-7-24下午9:46:37
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.TestevaluateinfoAttachment;
import com.hwadee.orm.TestevaluateinfoAttachmentDAO;

public class TestevaluateinfoAttachmentService {
	/**
	 * 保存
	 * @param entity
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午12:56:58
	 */
	public static int save(TestevaluateinfoAttachment entity) {
		int ok = 0;
		TestevaluateinfoAttachmentDAO tDAO = new TestevaluateinfoAttachmentDAO();
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
	 * 删除
	 * @param id
	 * @author 詹亮名
	 * @date:2014-7-24下午12:58:28
	 */
	public static void delete(int id){
		TestevaluateinfoAttachmentDAO tDAO = new TestevaluateinfoAttachmentDAO();
		Transaction t = tDAO.getSession().beginTransaction();
		TestevaluateinfoAttachment entity = tDAO.findById(id);
		
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
	 * 更新
	 * @param entity
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午8:12:20
	 */
	public static TestevaluateinfoAttachment update(TestevaluateinfoAttachment entity) {
		TestevaluateinfoAttachmentDAO tDAO = new TestevaluateinfoAttachmentDAO();
		Transaction t = tDAO.getSession().beginTransaction();
		TestevaluateinfoAttachment entityUpdate = new TestevaluateinfoAttachment(); 
		
		try {
			entityUpdate = tDAO.merge(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			tDAO.getSession().close();
		}
		return entityUpdate;
	}
}
