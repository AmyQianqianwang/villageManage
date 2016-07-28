/**
 * @author: ղ����
 * @date: 2014-7-24����12:54:17
 */
package com.hwadee.service;

import java.util.List;

import org.hibernate.Transaction;

import com.hwadee.orm.Commentinfo;
import com.hwadee.orm.CommentinfoAttachment;
import com.hwadee.orm.CommentinfoAttachmentDAO;

public class CommentinfoAttachmentService {
	
	/**
	 * ����
	 * @param entity
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����12:56:58
	 */
	public static int save(CommentinfoAttachment entity) {
		int ok = 0;
		CommentinfoAttachmentDAO cDAO = new CommentinfoAttachmentDAO();
		Transaction t = cDAO.getSession().beginTransaction();
		
		try {
			cDAO.save(entity);
			t.commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			cDAO.getSession().close();
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
		CommentinfoAttachmentDAO cDAO = new CommentinfoAttachmentDAO();
		Transaction t = cDAO.getSession().beginTransaction();
		CommentinfoAttachment entity = cDAO.findById(id);
		
		try {
			cDAO.delete(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			cDAO.getSession().close();
		}
	}
	
	public static CommentinfoAttachment update(CommentinfoAttachment entity) {
		CommentinfoAttachmentDAO cDAO = new CommentinfoAttachmentDAO();
		Transaction t = cDAO.getSession().beginTransaction();
		CommentinfoAttachment entityUpdate = new CommentinfoAttachment(); 
		
		try {
			entityUpdate = cDAO.merge(entity);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			cDAO.getSession().close();
		}
		return entityUpdate;
	}
}
