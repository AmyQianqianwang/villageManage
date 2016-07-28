package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Blog;
import com.hwadee.orm.User;
import com.hwadee.service.LogService;
import com.hwadee.util.DealStr;

public class BlogAndRightsManage {
	
	/**
	  * @TODO:日志保存
	  * 输入：日志字符串，注意不超过20个字符
	  * 输出： 0：没有登录
	  * 	 1：保存日志失败
	  * 	 2：保存日志成功 
	  * @author xu-Administrator
	  * @date 2014-7-25 上午9:24:25
	 */
	public static int blogSave(String blogStr){
		int ok = 0;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("US");
		if(null == user){
			return ok;									// 返回0，没有登录
		}
		Blog blog = new Blog();
		blog.setOpName(blogStr);
		blog.setUser(user);
		Date date = new Date();
		blog.setOpTime(date);
		if(LogService.save(blog) == 0){
			ok = 1;
		}else{
			ok = 2;
		}
		return ok;
	}
	
	/**
	  * @TODO: 日志列表
	  * @author LUO-Administrator
	  * @date 2014-7-25 下午1:09:07
	 */
	public String blogList(){
		if(BlogAndRightsManage.blogSave("日志列表") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		
		// 权限控制
		User us = (User) request.getSession().getAttribute("US");
		if(us.getUserType() != 1){
			return "noright";
		}
		
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();
		
		String keyword 			= "";	// 关键字
		String jumpPage 		= ""; 	// 跳转页码
		String intPageSize 		= ""; 	// 每页大小
		int intPageSizeValue 	= 20;	// 页大小
		int nowPage 			= 1;	// 当前页
		int intRowCount 		= 0;	// 总条数
		int intPageCount 		= 0;	// 页数

		keyword = request.getParameter("keyword");
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
			intPageSizeValue = 50;
		}

		List<Blog> dataList = null;
		try {
			dataList = LogService.blogList(keyword, intPageSizeValue, nowPage);
			intRowCount = LogService.blogListRowCount(keyword);
			
			intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;

			request.setAttribute("itemList", dataList);
			request.setAttribute("keyword", keyword);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("intRowCount", intRowCount);
			request.setAttribute("intPageCount", intPageCount);
			request.setAttribute("intPageSize", intPageSizeValue);
		} catch (Exception e) {
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "bloglist";
	}
	
}
