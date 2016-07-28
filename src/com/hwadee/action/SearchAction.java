/**
 * @author: 詹亮名
 * @date: 2014-7-25上午10:41:55
 */
package com.hwadee.action;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Project;
import com.hwadee.service.ProjectService;
import com.hwadee.util.DealStr;

public class SearchAction {
	
//	private static final int PRO_STATUS_PASSED = 14;	//已通过评测的项目
//	private static final int PRO_STATUS_FAIL = 15;	//已未通过评测的项目

	List<Project> proList;
	
	private String selType; //查询类别
	private String selValue; //查询关键字
	
	public String search() {
		
		String jumpPage 		= ""; 	// 跳转页码
		String intPageSize 		= ""; 	// 每页大小
		int intPageSizeValue 	= 20;	// 页大小
		int nowPage 			= 1;	// 当前页
		int intRowCount 		= 0;	// 总条数
		int intPageCount 		= 0;	// 页数
		
		DealStr dealStr = new DealStr();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
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
		
		ProjectService proService = new ProjectService();

		if (selType == null) {
			selType = "proId";
		}
		if (selValue == null) {
			selValue = "";
		}
		
		int start = intPageSizeValue * (nowPage - 1);
		//通过的项目
		proList = proService.search(selType, selValue, start , intPageSizeValue);
		intRowCount = proService.search(selType, selValue, 0, 0).size();
		intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;
		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("intRowCount", intRowCount);
		request.setAttribute("intPageCount", intPageCount);
		request.setAttribute("intPageSize", intPageSizeValue);
		
		return "search_success";
	}
	
	public List<Project> getProList() {
		return proList;
	}

	public void setProList(List<Project> proList) {
		this.proList = proList;
	}

	public String getSelType() {
		return selType;
	}

	public void setSelType(String selType) {
		this.selType = selType;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	//内部类，实现list排序(Collections.sort() 对 List 排序)
	class ComparatorPro implements Comparator<Project>{

		public int compare(Project p1, Project p2) {
			return p2.getRecTime().compareTo(p1.getRecTime());
		}
		
	}
}
