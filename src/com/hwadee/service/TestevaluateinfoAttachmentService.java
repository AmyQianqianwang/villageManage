/**
 * @author: ղ����
 * @date: 2014-7-24����9:46:37
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.TestevaluateinfoAttachment;
import com.hwadee.orm.TestevaluateinfoAttachmentDAO;

public class TestevaluateinfoAttachmentService {
	/**
	 * ����
	 * @param entity
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����12:56:58
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
	 * ɾ��
	 * @param id
	 * @author ղ����
	 * @date:2014-7-24����12:58:28
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
	 * ����
	 * @param entity
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����8:12:20
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
