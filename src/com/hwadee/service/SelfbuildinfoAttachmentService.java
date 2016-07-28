package com.hwadee.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.SelfbuildinfoAttachment;
import com.hwadee.orm.SelfbuildinfoAttachmentDAO;

/**
 * @TODO:自建项目附件业务层操作
 * @author Dong
 * @date 2014-7-21下午1:20:06
 */
public class SelfbuildinfoAttachmentService {
	/**
	 * @TODO:保存比选情况附件实例
	 * @author Dong 
	 * @date 2014-7-21上午9:52:12
	 */
	public static int save (SelfbuildinfoAttachment selfbuildinfoAttachment){
		int ok=0;
		SelfbuildinfoAttachmentDAO DAO=new SelfbuildinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			DAO.save(selfbuildinfoAttachment);
			t.commit();
			ok=1;
		} catch (Exception e) {
			t.rollback();
			ok=0;
		}finally{
			DAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:根据比选情况附件编号删除信息
	 * @author Dong 
	 * @date 2014-7-21上午9:52:33
	 */
	public static int delete(int selfbuildinfoAttachmentID){
		int ok=0;
		SelfbuildinfoAttachmentDAO DAO=new SelfbuildinfoAttachmentDAO();
		Transaction t=DAO.getSession().beginTransaction();
		
		try {
			SelfbuildinfoAttachment csia=DAO.findById(selfbuildinfoAttachmentID); 
			DAO.delete(csia);
			t.commit();
			ok=1;
		} catch (Exception e) {
			t.rollback();
			ok=0;
		}finally{
			DAO.getSession().close();
		}
		return ok;
	}
	
	/**
	 * @TODO:更新比选情况附件
	 * @author Dong 
	 * @date 2014-7-21上午11:04:56
	 */
	public static int update (SelfbuildinfoAttachment selfbuildinfoAttachment){
		int ok=0;
		SelfbuildinfoAttachmentDAO DAO=new SelfbuildinfoAttachmentDAO();
		Session s=DAO.getSession();
		Transaction t=s.beginTransaction();
		try{
			s.update(selfbuildinfoAttachment);
			t.commit();
			ok=1;
		}catch(Exception e){
			t.rollback();
			ok=0;
		}finally{
			s.close();
		}
		return ok;
	}
}
