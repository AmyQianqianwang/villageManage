package com.hwadee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hwadee.orm.User;
import com.hwadee.orm.UserDAO;

/**
  * @TODO: Userҵ���߼������
  * @author LUO-Administrator
  * @date 2014-7-20 ����8:33:02
 */
public class UserService {
	
	/**
	  * @TODO: �����û�ʵ��
	  * @author LUO-Administrator
	  * @date 2014-7-20 ����7:22:28
	 */
	public static int save(User user){
		int ok = 0;
		UserDAO userDAO = new UserDAO();
		Transaction t = userDAO.getSession().beginTransaction();
		try{
			userDAO.save(user);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			userDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	  * @TODO: �����û�IDɾ���û�
	  * @author LUO-Administrator
	  * @date 2014-7-20 ����7:24:53
	 */
	public static int delete(String userID){
		int ok = 0;
		UserDAO userDAO = new UserDAO();
		Transaction t = userDAO.getSession().beginTransaction();
		User user = userDAO.findById(userID);
		try{
			userDAO.delete(user);
			t.commit();
			ok = 1;
		}catch (Exception e) {
			t.rollback();
			ok = 0;
		}finally{
			userDAO.getSession().close();
		}
		return ok;
	}
	
	/**
	  * @TODO: ��ȡ�û��б����ڷ�ҳ
	  * @author LUO-Administrator
	  * @date 2014-7-20 ����8:04:42
	 */
	public static List<?> getAllUser(){
		UserDAO userDAO = new UserDAO();
		Session session = userDAO.getSession();
		String hql = "from User";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}
	
	/**
	 * @TODO:����ID��ȡָ���û�ʵ��
	 * @author Dong 
	 * @date 2014-7-22����3:40:07
	 */
	public static User getUserByID(String userID){
		UserDAO userDAO = new UserDAO();
		User user = null;
		try{
			user = userDAO.findById(userID);
		}catch (Exception e) {
			user=null;
		}finally{
			userDAO.getSession().close();
		}
		return user;
	}

	/**
	  * @TODO: ��ȡ�û��б���ҳ
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����3:16:25
	 */
	@SuppressWarnings("unchecked")
	public static List<User> userList(String string, int pageSize, int nowPage) {
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		UserDAO userDAO = new UserDAO();
		Session session = userDAO.getSession();
		String hql="from User U where (U.userName like '%"+string+"%' or U.userType like '%"+string+"%') order by U.userId desc";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<User> list = q.list();
		session.close();
		return list;
	}

	/**
	  * @TODO: ��ȡ�û�������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����3:16:33
	 */
	@SuppressWarnings("unchecked")
	public static int getUserRowCount(String string) {
		UserDAO userDAO = new UserDAO();
		Session session = userDAO.getSession();
		String hql="from User U where (U.userName like '%"+string+"%' or U.userType like '%"+string+"%')";
		Query q = session.createQuery(hql);
		List<User> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	/**
	  * @TODO: ��ȡ���һ���û����� 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����12:12:51
	 */
	@SuppressWarnings("unchecked")
	public static String getLastRow() {
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.findAll();
		if(null == list){
			return "cd00000000";
		}
		return list.get(list.size()-1).getUserId();
	}
	
	/**
	  * @TODO:�����û����� 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����12:13:19
	 */
	public static int update(User user) {
		int ok = 0;
		UserDAO userDAO = new UserDAO();
		Session session = userDAO.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			t.commit();
			ok = 1;
		} catch (Exception e) {
			t.rollback();
			ok = 0;
		} finally {
			session.close();
		}
		return ok;
	}
	
	/**
	  * @TODO:����û���¼ 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����5:21:55
	 */
	@SuppressWarnings("unchecked")
	public static User checkLogin(String user_name, String user_password) {
		UserDAO userDAO = new UserDAO();
		Session session = userDAO.getSession();
		String hql="from User U where U.userName = :username and U.userPwd = :pwd";
		Query q = session.createQuery(hql);
		q.setString("username", user_name);
		q.setString("pwd", user_password);
		List<User> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	public static void main(String[] args) {
//		User user = new User();
//		LocationDAO dao = new LocationDAO();
//		Location lo = dao.findById("510124102003");
//		
//		user.setUserId("cd00000005");
//		user.setLocation(lo);
//		user.setUserName("����");
//		user.setUserPwd("777");
//		user.setUserState(true);
//		user.setUserType(1);
//		user.setOffice("�弶ίԱ��");
//		save(user);
//		
//		UserDAO dao2 = new UserDAO();
//		System.out.println(
//		dao2.findById("cd00000001").getUserName());
		
//		System.out.println(getAllUser().size());
		
//		System.out.println(userList("����", 20, 1).size());
//		System.out.println(getUserRowCount(""));
		
//		System.out.println(Integer.valueOf(getLastRow().substring(2)));
		
//		String last = UserService.getLastRow();
//		int num = Integer.valueOf(last.substring(2)) + 1;
//		int num_o = 8 - String.valueOf(num).length();
//		String s = "cd";
//		for(int i=0; i<num_o; i++){
//			s += "0";
//		}
//		s += num;
//		System.out.println(s);
		
//		User user = getUserByID("cd00000051");
//		System.out.println(user.getUserName());
		
//		System.out.println(checkLogin("�޻���","admin123").getOffice());
	}
}
