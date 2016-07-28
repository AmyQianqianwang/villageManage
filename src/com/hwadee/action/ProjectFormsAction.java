package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Project;
import com.hwadee.orm.User;
import com.hwadee.service.ProjectFormsService;
import com.hwadee.util.CreateXml;
import com.hwadee.util.DealStr;
import com.hwadee.util.Tool;

/**
  * @TODO: ͳ�Ʊ���
  * @author LUO-Administrator
  * @date 2014-7-22 ����11:17:49
 */
public class ProjectFormsAction {
	
	/**
	  * @TODO: ��ȡ�����Ŀ���ͨ�����ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-22 ����4:56:38
	 */
	public String projectVoteInfoList(){
		if(BlogAndRightsManage.blogSave("�����Ŀ���ͨ�����ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectvoteinfolist";
	}
	
	/**
	  * @TODO: ĳ�����Ŀ���ͨ���������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:06:03
	 */
	public String projectVoteInfoBar(){
		if(BlogAndRightsManage.blogSave("�����Ŀ���ͨ���������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		
		return "projectvoteinfobar";
	}
	
	/**
	  * @TODO: ����ؼ���Ŀ�������ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:06:44
	 */
	public String projectCountryClassifyList(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ�������ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectcountryclassifylist";
	}
	
	/**
	  * @TODO: ����ؼ���Ŀ�����������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:06:44
	 */
	public String projectCountryClassifyBar(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ�����������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "projectcountryclassifybar";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀ�����������ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:11:14
	 */
	public String projectCountryCheckedList(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ�����������ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectcountrycheckedlist";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀ���������������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:11:56
	 */
	public String projectCountryCheckedBar(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ���������������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "projectcountrycheckedbar";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀר���ʽ�ʹ�����ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:15:43
	 */
	public String projectCountrySpecialFundList(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀר���ʽ�ʹ�����ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectcountryspecialfundlist";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀר���ʽ�ʹ���������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:16:04
	 */
	public String projectCountrySpecialFundBar(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀר���ʽ�ʹ���������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "projectcountryspecialfundbar";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀ�ʽ�ʹ�����ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:17:29
	 */
	public String projectCountryFundList(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ�ʽ�ʹ�����ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectcountryfundlist";
	}
	
	/**
	  * @TODO: ĳ����ؼ���Ŀ�ʽ�ʹ���������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:17:52
	 */
	public String projectCountryFundBar(){
		if(BlogAndRightsManage.blogSave("����ؼ���Ŀ�ʽ�ʹ���������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "projectcountryfundbar";
	}
	
	/**
	  * @TODO: ĳ����ߴ�������Ŀ�ʽ����ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:21:18
	 */
	public String projectClassifyFundList(){
		if(BlogAndRightsManage.blogSave("����ߴ�������Ŀ�ʽ����ͳ��") == 0){
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
			dataList = ProjectFormsService.projectVoteInfolist("510124", 2014, intPageSizeValue, nowPage);
			intRowCount = ProjectFormsService.getProjectVoteInfoRowCount("510124", 2014);
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
		return "projectclassifyfundlist";
	}
	
	/**
	  * @TODO: ĳ����ߴ�������Ŀ�ʽ��������
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:21:41
	 */
	public String projectClassifyFundBar(){
		if(BlogAndRightsManage.blogSave("����ߴ�������Ŀ�ʽ��������") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "projectclassifyfundbar";
	}
	
	/**
	  * @TODO: �壨�ӣ��������ֲ�ͳ��
	  * @author LUO-Administrator
	  * @date 2014-7-23 ����10:22:42
	 */
	public String villageResidentCount(){
		if(BlogAndRightsManage.blogSave("�壨�ӣ��������ֲ�ͳ��") == 0){
			return "tologin";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String filepath = request.getSession().getServletContext().getRealPath("/") + "plugins/dataXml/";
		String dataurl = UUID.randomUUID().toString()+".xml";
		List<Object[]> data = new ArrayList<Object[]>();
		List<?> dataList = ProjectFormsService.getProjectVoteInfoBar("510124", 2014);
		for(int i = 0; i < dataList.size(); i++){
			Object[] ob = (Object[]) dataList.get(i);
			if(null != ob){
				ob[0] = Tool.getProjectStatusStringByID(Integer.valueOf(String.valueOf(ob[0])));
				data.add(ob);
			}
		}
		CreateXml createXml = new CreateXml();
		try {
			createXml.newXML(data,filepath+dataurl);
			request.setAttribute("dataurl", dataurl);
			request.setAttribute("itemList", data);
			request.setAttribute("size", data.size());
		}catch (Exception e) {
			return "error";
		}
		return "villageresidentcount";
	}
	
}
