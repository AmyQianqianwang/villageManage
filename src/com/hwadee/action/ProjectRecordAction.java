/**
 * @author: ղ����
 * @date: 2014-7-25����8:35:48
 */
package com.hwadee.action;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Project;
import com.hwadee.service.ProjectService;
import com.hwadee.util.DealStr;

public class ProjectRecordAction {
	
//	private static final int PRO_STATUS_PASSED = 14;	//��ͨ���������Ŀ
//	private static final int PRO_STATUS_FAIL = 15;	//��δͨ���������Ŀ
//	private static final String PRO_TYPE = "";	//���ǻ���������͹���������
	
	private String selType; //��ѯ���
	private String selValue; //��ѯ�ؼ���
	
	/**
	 * �����ѹ鵵����Ŀ������ͨ����δͨ����Ŀ
	 * @return
	 * @author ղ����
	 * @date:2014-7-25����8:44:24
	 */
	List<Project> proList;
	
	public String list() {
		
		//����Ŀ��ʼʱ������
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
		
		//ͨ������Ŀ
		int start = intPageSizeValue * (nowPage - 1);
		setProList(proService.getProjectListForRecord(selType, selValue, start, intPageSizeValue));
		intRowCount = proService.getProjectListForRecord(selType, selValue, 0, 0).size();
		intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;
		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("intRowCount", intRowCount);
		request.setAttribute("intPageCount", intPageCount);
		request.setAttribute("intPageSize", intPageSizeValue);
		
		return "list_success";
		
	}

//	/**
//	 * ��ѯ
//	 * @return
//	 * @author ղ����
//	 * @date:2014-7-25����9:50:30
//	 */
//	public String search() {
//		ProjectService proService = new ProjectService();
//		//ͨ������Ŀ
//		proList = proService.search(PRO_STATUS_PASSED, selType, selValue, 0, 0);
//		//δͨ������Ŀ
//		proList.addAll(proService.search(PRO_STATUS_FAIL, selType, selValue, 0, 0));
//		//����Ŀ��ʼʱ������
//		Collections.sort(proList, new ComparatorPro());
//		
//		return "search_success";
//	}
	
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
