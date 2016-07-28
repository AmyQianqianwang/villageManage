/**
 * @author: ղ����
 * @date: 2014-7-21����11:43:26
 */
package com.hwadee.service;


import org.hibernate.Transaction;

import com.hwadee.orm.Commentinfo;
import com.hwadee.orm.CommentinfoDAO;

/**
 * ����������Ŀ����
 */
public class CommentService {
	
	/**
	 * @TODO:���湫��������Ŀ�������
	 * @param id
	 * @return
	 * @author ղ����
	 */
	public static int save(Commentinfo commentinfo) {
		int ok = 0;
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		Transaction t = commentinfoDAO.getSession().beginTransaction();
		
		try {
			commentinfoDAO.save(commentinfo);
			t.commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			commentinfoDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:ɾ������������Ŀ�������
	 * @param id
	 * @author ղ����
	 */
	public static void delete(int id){
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		Transaction t = commentinfoDAO.getSession().beginTransaction();
		Commentinfo commentinfo = commentinfoDAO.findById(id);
		
		try {
			commentinfoDAO.delete(commentinfo);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			commentinfoDAO.getSession().close();
		}
	}
	
	/**
	 * @TODO:���¹���������Ŀ�������
	 * @param commentinfo
	 * @return
	 * @author ղ����
	 */
	public static Commentinfo update(Commentinfo commentinfo) {
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		Transaction t = commentinfoDAO.getSession().beginTransaction();
		Commentinfo commentinfoUpdate = new Commentinfo();
		
		try {
			commentinfoUpdate = commentinfoDAO.merge(commentinfo);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			commentinfoDAO.getSession().close();
		}
		return commentinfoUpdate;
	}
	
	/**
	 * ��������id�����Ӧ���������ʵ��
	 * @param id
	 * @return
	 * @author ղ����
	 */
	public static Commentinfo findById(int id) {
		
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		return commentinfoDAO.findById(id);
	}

	/**
	 * ����Project�������һ��������������Ŀʵ��
	 * @param project
	 * @return
	 * @author ղ����
	 * @date:2014-7-23����1:48:55
	 */
	public static Commentinfo getCommentinfoByProject(String proId) {
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		return commentinfoDAO.getCommentinfoByProject(proId);
	}
	
	public static Commentinfo findByExample(Commentinfo entity) {
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		return (Commentinfo) commentinfoDAO.findByExample(entity).get(0);
	}
}
