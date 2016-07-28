package com.hwadee.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.hwadee.orm.Location;
import com.hwadee.orm.User;
import com.hwadee.service.LocationService;
import com.hwadee.util.DealStr;

public class VillageMessage {
	
	/**
	  * @TODO:��ҳ�ſ���Ϣ 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����4:10:33
	 */
	public String index(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("US");
		if(null == user){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			String str = "����û�е�¼�����¼��";
			try{
				PrintWriter out = response.getWriter();
				out.write("<script>alert('" + str + "');</script>");
				out.write("<script>window.location.href='login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e1) {
				return "error";
			}
		}
		Location location = user.getLocation();
		request.setAttribute("location", location);
		return "index";
	}
	
	/**
	  * @TODO: ��ת���༭�ſ���Ϣ 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����4:10:54
	 */
	public String toEdit(){
		if(BlogAndRightsManage.blogSave("��ת���༭�ſ�") == 0){
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
		if(us.getUserType() != 1 || us.getUserType() != 2){
			return "noright";
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("US");
		if(null == user){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			String str = "����û�е�¼�����¼��";
			try{
				PrintWriter out = response.getWriter();
				out.write("<script>alert('" + str + "');</script>");
				out.write("<script>window.location.href='login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e1) {
				return "error";
			}
		}
		Location location = user.getLocation();
		request.setAttribute("location", location);
		return "toedit";
	}
	
	/**
	  * @TODO:�ύ��ſ���Ϣ 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����4:11:36
	 */
	public String edit(){
		if(BlogAndRightsManage.blogSave("�༭�ſ�") == 0){
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
		if(us.getUserType() != 1 || us.getUserType() != 2){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String pCount = "";
		String villagemessage = "";

		pCount = request.getParameter("pCount");
		pCount = pCount == null ? "" : dealStr.codeStringNoEncode(pCount);
		
		villagemessage = request.getParameter("villagemessage");
		villagemessage = villagemessage == null ? "" : dealStr.codeStringNoEncode(villagemessage);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("US");
		
		if(null == user){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			String str = "����û�е�¼�����¼��";
			try{
				PrintWriter out = response.getWriter();
				out.write("<script>alert('" + str + "');</script>");
				out.write("<script>window.location.href='login.jsp';</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e1) {
				return "error";
			}
		}
		Location location = user.getLocation();
		try{
			location.setPeopleCount(Integer.valueOf(pCount));
			location.setSummary(villagemessage);
			LocationService.update(location);
		}catch (Exception e) {
			return "error";
		}
		user.setLocation(location);
		session.setAttribute("US", user);
		return "edit";
	}
}
