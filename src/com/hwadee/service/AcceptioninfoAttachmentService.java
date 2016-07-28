/**
 * @author: ղ����
 * @date: 2014-7-24����8:08:58
 */
package com.hwadee.service;

import org.hibernate.Transaction;

import com.hwadee.orm.AcceptioninfoAttachment;
import com.hwadee.orm.AcceptioninfoAttachmentDAO;

public class AcceptioninfoAttachmentService {
	/**
	 * ����
	 * @param entity
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����12:56:58
	 */
	public static int save(AcceptioninfoAttachment entity) {
		int ok = 0;
		AcceptioninfoAttachmentDAO aDAO = new AcceptioninfoAttachmentDAO();
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
	 * ɾ��
	 * @param id
	 * @author ղ����
	 * @date:2014-7-24����12:58:28
	 */
	public static void delete(int id){
		AcceptioninfoAttachmentDAO aDAO = new AcceptioninfoAttachmentDAO();
		Transaction t = aDAO.getSession().beginTransaction();
		AcceptioninfoAttachment entity = aDAO.findById(id);
		
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
	 * ����
	 * @param entity
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����8:12:20
	 */
	public static AcceptioninfoAttachment update(AcceptioninfoAttachment entity) {
		AcceptioninfoAttachmentDAO aDAO = new AcceptioninfoAttachmentDAO();
		Transaction t = aDAO.getSession().beginTransaction();
		AcceptioninfoAttachment entityUpdate = new AcceptioninfoAttachment(); 
		
		try {
			entityUpdate = aDAO.merge(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			aDAO.getSession().close();
		}
		return entityUpdate;
	}
}
