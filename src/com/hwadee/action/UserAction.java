package com.hwadee.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Location;
import com.hwadee.orm.LocationDAO;
import com.hwadee.orm.User;
import com.hwadee.service.UserService;
import com.hwadee.util.DealStr;

public class UserAction {
	
	private String user_name;
	private String user_password;
	
	/**
	  * @TODO:�û���¼ 
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����3:07:19
	 */
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		DealStr dealStr = new DealStr();
		user_name = user_name == null ? "" : dealStr.codeStringNoEncode(user_name);
		user_password = user_password == null ? "" : dealStr.codeStringNoEncode(user_password);
		User user = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		PrintWriter out = null;
		try {
			user = UserService.checkLogin(user_name, user_password);
			out = response.getWriter();
			String str = "";
			if (user != null){
				session.setAttribute("US", user);
				BlogAndRightsManage.blogSave("�û���¼");
				str = "{ \"result\" : \"1\" }";		//��¼�ɹ�ʱ�ַ�������1
			} else {
				str = "{ \"result\" : \"0\" }";		//��¼ʧ��ʱ�ַ�������0
			}
			out.println(str);
		} catch (Exception e) {
			out.println("�����ڲ�����");
		} finally{
			out.flush();
			out.close();
		}
		return "login_success";
	}
	
	/**
	  * @TODO: ע����¼
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����5:13:51
	 */
	public String Logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		BlogAndRightsManage.blogSave("�û�ע��");
		session.invalidate();
		return "logoutSuccess";
	}
	
	/**
	  * @TODO: �û��б�
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����1:59:43
	 */
	public String userList(){
		if(BlogAndRightsManage.blogSave("�鿴�û��б�") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		// Ȩ�޿���
		User user = (User) request.getSession().getAttribute("US");
		if(user.getUserType() != 1){
			return "noright";
		}
		
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();
		
		String keyword 			= "";	// �ؼ���
		String jumpPage 		= ""; 	// ��תҳ��
		String intPageSize 		= ""; 	// ÿҳ��С
		int intPageSizeValue 	= 20;	// ҳ��С
		int nowPage 			= 1;	// ��ǰҳ
		int intRowCount 		= 0;	// ������
		int intPageCount 		= 0;	// ҳ��

		keyword = request.getParameter("keyword");
		try {
			if(null != keyword){
				keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			keyword = "";
		}
		keyword = keyword == null ? "" : dealStr.codeStringNoEncode(keyword);

		jumpPage = request.getParameter("jumpPage");
		jumpPage = jumpPage == null ? "1" : dealStr.codeStringNoEncode(jumpPage);

		intPageSize = request.getParameter("intPageSize");
		intPageSize = intPageSize == null ? "20" : dealStr.codeStringNoEncode(intPageSize);
		
		try {
			nowPage = Integer.parseInt(jumpPage);
			intPageSizeValue = Integer.parseInt(intPageSize);
		} catch (Exception ex) {
			nowPage = 1;
			intPageSizeValue = 20;
		}

		List<User> dataList = null;
		try {
			dataList = UserService.userList(keyword, intPageSizeValue, nowPage);
			intRowCount = UserService.getUserRowCount(keyword);
			
			intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;

			request.setAttribute("itemList", dataList);
			request.setAttribute("keyword", keyword);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("intRowCount", intRowCount);
			request.setAttribute("intPageCount", intPageCount);
			request.setAttribute("intPageSize", intPageSizeValue);
		} catch (Exception e) {
			errLog.error("���Ǵ�����Ϣ��", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "�������" + e.getMessage());
			return "error";
		}
		return "userlist";
	}
	
	/**
	  * @TODO:�����û� 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����10:37:47
	 */
	public String addUser(){
		if(BlogAndRightsManage.blogSave("����û�") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		// Ȩ�޿���
		User us = (User) request.getSession().getAttribute("US");
		if(us.getUserType() != 1){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String username = "";
		String usercity = "";
		String usercountry = "";
		String usertown = "";
		String uservillage = "";
		String password = "";
		String passwordagain = "";
		String usertype = "";
		String useroffice = "";
		String userstate = "";
		
		username = request.getParameter("username");
		username = username == null ? "" : dealStr.codeStringNoEncode(username);
		
		usercity = request.getParameter("usercity");
		usercity = usercity == null ? "" : dealStr.codeStringNoEncode(usercity);
		
		usercountry = request.getParameter("usercountry");
		usercountry = usercountry == null ? "" : dealStr.codeStringNoEncode(usercountry);
		
		usertown = request.getParameter("usertown");
		usertown = usertown == null ? "" : dealStr.codeStringNoEncode(usertown);
		
		uservillage = request.getParameter("uservillage");
		uservillage = uservillage == null ? "" : dealStr.codeStringNoEncode(uservillage);
		
		password = request.getParameter("password");
		password = password == null ? "" : dealStr.codeStringNoEncode(password);
		
		passwordagain = request.getParameter("passwordagain");
		passwordagain = passwordagain == null ? "" : dealStr.codeStringNoEncode(passwordagain);
		
		usertype = request.getParameter("usertype");
		usertype = usertype == null ? "2" : dealStr.codeStringNoEncode(usertype);
		
		useroffice = request.getParameter("useroffice");
		useroffice = useroffice == null ? "" : dealStr.codeStringNoEncode(useroffice);
		
		userstate = request.getParameter("userstate");
		userstate = userstate == null ? "0" : dealStr.codeStringNoEncode(userstate);
		
		if(!password.equals(passwordagain)){
			request.setAttribute("error", "������������벻��ͬ");
			return "addfailure";
		}
		
		try{
			User user = new User();
			String last = UserService.getLastRow();
			int num = Integer.valueOf(last.substring(2)) + 1;
			int num_o = 8 - String.valueOf(num).length();
			String s = "cd";
			for(int i=0; i<num_o; i++){
				s += "0";
			}
			s += num;
			
			user.setUserId(s);
			user.setUserName(username);
			user.setUserPwd(password);
			user.setUserState((userstate.equals("1"))?true:false);
			user.setUserType(Integer.valueOf(usertype));
			user.setOffice(useroffice);
			
			String loc = "";
			if(!"".equals(uservillage)){
				loc = uservillage;
			}else if(!"".equals(usertown)){
				loc = usertown;
			}else if(!"".equals(usercountry)){
				loc = usercountry;
			}else{
				loc = usercity;
			}
			
			LocationDAO locationDAO = new LocationDAO();
			Location location = locationDAO.findById(loc);
			user.setLocation(location);
			UserService.save(user);
		}catch (Exception e) {
			request.setAttribute("error", "��������ʱ�������������ԣ�");
			return "addfailure";
		}
		return "addsuccess";
	}
	
	public String toEditUser(){
		if(BlogAndRightsManage.blogSave("��ת���༭�û�") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		// Ȩ�޿���
		User us = (User) request.getSession().getAttribute("US");
		if(us.getUserType() != 1){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String id = "";

		try {
			id = new String(id.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		id = request.getParameter("id");
		id = id == null ? "" : dealStr.codeStringNoEncode(id);
		
		User user = UserService.getUserByID(id);
		request.setAttribute("user", user);
		request.setAttribute("id", id);
		
		return "toedituser";
	}
	
	public String editUser(){
		if(BlogAndRightsManage.blogSave("�༭�û�") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		// Ȩ�޿���
		User us = (User) request.getSession().getAttribute("US");
		if(us.getUserType() != 1){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String id = "";
		String username = "";
		String usercity = "";
		String usercountry = "";
		String usertown = "";
		String uservillage = "";
		String password = "";
		String passwordagain = "";
		String usertype = "";
		String useroffice = "";
		String userstate = "";
		
		id = request.getParameter("id");
		id = id == null ? "" : dealStr.codeStringNoEncode(id);
		
		username = request.getParameter("username");
		username = username == null ? "" : dealStr.codeStringNoEncode(username);
		
		usercity = request.getParameter("usercity");
		usercity = usercity == null ? "" : dealStr.codeStringNoEncode(usercity);
		
		usercountry = request.getParameter("usercountry");
		usercountry = usercountry == null ? "" : dealStr.codeStringNoEncode(usercountry);
		
		usertown = request.getParameter("usertown");
		usertown = usertown == null ? "" : dealStr.codeStringNoEncode(usertown);
		
		uservillage = request.getParameter("uservillage");
		uservillage = uservillage == null ? "" : dealStr.codeStringNoEncode(uservillage);
		
		password = request.getParameter("password");
		password = password == null ? "" : dealStr.codeStringNoEncode(password);
		
		passwordagain = request.getParameter("passwordagain");
		passwordagain = passwordagain == null ? "" : dealStr.codeStringNoEncode(passwordagain);
		
		usertype = request.getParameter("usertype");
		usertype = usertype == null ? "2" : dealStr.codeStringNoEncode(usertype);
		
		useroffice = request.getParameter("useroffice");
		useroffice = useroffice == null ? "" : dealStr.codeStringNoEncode(useroffice);
		
		userstate = request.getParameter("userstate");
		userstate = userstate == null ? "0" : dealStr.codeStringNoEncode(userstate);
		
		if(!password.equals(passwordagain)){
			request.setAttribute("error", "������������벻��ͬ");
			request.setAttribute("id", id);
			return "editfailure";
		}

		try{
			User user = UserService.getUserByID(id);
			
			user.setUserName(username);
			user.setUserPwd(password);
			user.setUserState((userstate.equals("1"))?true:false);
			user.setUserType(Integer.valueOf(usertype));
			user.setOffice(useroffice);
			
			String loc = "";
			if(!"".equals(uservillage)){
				loc = uservillage;
			}else if(!"".equals(usertown)){
				loc = usertown;
			}else if(!"".equals(usercountry)){
				loc = usercountry;
			}else{
				loc = usercity;
			}
			LocationDAO locationDAO = new LocationDAO();
			Location location = locationDAO.findById(loc);
			user.setLocation(location);
			
			if(UserService.update(user) == 0){
				request.setAttribute("error", "��������ʱ�������������ԣ�");
				return "editfailure";
			}
		}catch (Exception e) {
			request.setAttribute("error", "��������ʱ�������������ԣ�");
			return "editfailure";
		}
		return "editsuccess";
	}
	
	public String deleteUser(){
		if(BlogAndRightsManage.blogSave("ɾ���û�") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		// Ȩ�޿���
		User us = (User) request.getSession().getAttribute("US");
		if(us.getUserType() != 1){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String id = "";

		try {
			id = new String(id.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		id = request.getParameter("id");
		id = id == null ? "" : dealStr.codeStringNoEncode(id);
		
		int ok = UserService.delete(id);
		if(ok == 0){
			return "error";
		}
		return "deletesuccess";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
}
