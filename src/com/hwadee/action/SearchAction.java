/**
 * @author: ղ����
 * @date: 2014-7-25����10:41:55
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
	
//	private static final int PRO_STATUS_PASSED = 14;	//��ͨ���������Ŀ
//	private static final int PRO_STATUS_FAIL = 15;	//��δͨ���������Ŀ

	List<Project> proList;
	
	private String selType; //��ѯ���
	private String selValue; //��ѯ�ؼ���
	
	public String search() {
		
		String jumpPage 		= ""; 	// ��תҳ��
		String intPageSize 		= ""; 	// ÿҳ��С
		int intPageSizeValue 	= 20;	// ҳ��С
		int nowPage 			= 1;	// ��ǰҳ
		int intRowCount 		= 0;	// ������
		int intPageCount 		= 0;	// ҳ��
		
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
		//ͨ������Ŀ
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

	//�ڲ��࣬ʵ��list����(Collections.sort() �� List ����)
	class ComparatorPro implements Comparator<Project>{

		public int compare(Project p1, Project p2) {
			return p2.getRecTime().compareTo(p1.getRecTime());
		}
		
	}
}
