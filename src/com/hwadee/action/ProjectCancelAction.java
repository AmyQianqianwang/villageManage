package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.User;
import com.hwadee.service.ProjectCancelService;
import com.hwadee.service.ProjectService;
import com.hwadee.util.DealStr;

/**
  * @TODO:项目取消 
  * @author LUO-Administrator
  * @date 2014-7-24 下午9:28:02
 */
public class ProjectCancelAction {
	
	/**
	  * @TODO:项目取消列表 
	  * @author LUO-Administrator
	  * @date 2014-7-24 下午10:53:49
	 */
	public String cancelList(){
		if(BlogAndRightsManage.blogSave("查看项目取消列表") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
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

		List<Project> dataList = null;
		try {
			dataList = ProjectCancelService.projectCancelInfolist("510124", intPageSizeValue, nowPage);
			intRowCount = ProjectCancelService.getProjectCancelInfoRowCount("510124");
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
		return "cancellist";
	}
	
	/**
	  * @TODO:取消 
	  * @author LUO-Administrator
	  * @date 2014-7-24 下午10:54:27
	 */
	public String cancel(){
		if(BlogAndRightsManage.blogSave("取消项目") == 0){
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
		if(us.getUserType() > 3){
			return "noright";
		}
		
		DealStr dealStr = new DealStr();
		
		String id = "";

		id = request.getParameter("id");
		id = id == null ? "" : dealStr.codeStringNoEncode(id);
		
		if("".equals(id)){
			return "error";
		}else{
			try {
				id = new String(id.getBytes("ISO-8859-1"), "utf-8");
				ProjectDAO projectDAO = new ProjectDAO();
				Project project = projectDAO.findById(id);
				project.setProStatus(16);
				int ok = ProjectService.update(project);
				if(ok == 0){
					return "error";
				}
			} catch (Exception e) {
				return "error";
			}
		}
		return "cancelsuccess";
	}
}
