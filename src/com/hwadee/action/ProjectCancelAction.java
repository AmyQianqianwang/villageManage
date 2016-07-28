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
  * @TODO:��Ŀȡ�� 
  * @author LUO-Administrator
  * @date 2014-7-24 ����9:28:02
 */
public class ProjectCancelAction {
	
	/**
	  * @TODO:��Ŀȡ���б� 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����10:53:49
	 */
	public String cancelList(){
		if(BlogAndRightsManage.blogSave("�鿴��Ŀȡ���б�") == 0){
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
		
		String keyword 			= "";	// �ؼ���
		String jumpPage 		= ""; 	// ��תҳ��
		String intPageSize 		= ""; 	// ÿҳ��С
		int intPageSizeValue 	= 20;	// ҳ��С
		int nowPage 			= 1;	// ��ǰҳ
		int intRowCount 		= 0;	// ������
		int intPageCount 		= 0;	// ҳ��

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
			errLog.error("���Ǵ�����Ϣ��", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "�������" + e.getMessage());
			return "error";
		}
		return "cancellist";
	}
	
	/**
	  * @TODO:ȡ�� 
	  * @author LUO-Administrator
	  * @date 2014-7-24 ����10:54:27
	 */
	public String cancel(){
		if(BlogAndRightsManage.blogSave("ȡ����Ŀ") == 0){
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
