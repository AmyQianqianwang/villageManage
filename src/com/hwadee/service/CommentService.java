/**
 * @author: 詹亮名
 * @date: 2014-7-21上午11:43:26
 */
package com.hwadee.service;


import org.hibernate.Transaction;

import com.hwadee.orm.Commentinfo;
import com.hwadee.orm.CommentinfoDAO;

/**
 * 公共服务项目评议
 */
public class CommentService {
	
	/**
	 * @TODO:保存公共服务项目评议情况
	 * @param id
	 * @return
	 * @author 詹亮名
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
	 * @TODO:删除公共服务项目评议情况
	 * @param id
	 * @author 詹亮名
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
	 * @TODO:更新公共服务项目评议情况
	 * @param commentinfo
	 * @return
	 * @author 詹亮名
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
	 * 根据评议id获得相应的评议情况实体
	 * @param id
	 * @return
	 * @author 詹亮名
	 */
	public static Commentinfo findById(int id) {
		
		CommentinfoDAO commentinfoDAO = new CommentinfoDAO();
		return commentinfoDAO.findById(id);
	}

	/**
	 * 根据Project对象查找一个关联的评议项目实体
	 * @param project
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-23下午1:48:55
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
