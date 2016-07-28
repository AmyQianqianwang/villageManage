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
  * @TODO: 统计报表
  * @author LUO-Administrator
  * @date 2014-7-22 上午11:17:49
 */
public class ProjectFormsAction {
	
	/**
	  * @TODO: 获取年度项目表决通过情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-22 下午4:56:38
	 */
	public String projectVoteInfoList(){
		if(BlogAndRightsManage.blogSave("年度项目表决通过情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectvoteinfolist";
	}
	
	/**
	  * @TODO: 某年度项目表决通过情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:06:03
	 */
	public String projectVoteInfoBar(){
		if(BlogAndRightsManage.blogSave("年度项目表决通过情况汇总") == 0){
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
	  * @TODO: 年度县级项目分类情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:06:44
	 */
	public String projectCountryClassifyList(){
		if(BlogAndRightsManage.blogSave("年度县级项目分类情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectcountryclassifylist";
	}
	
	/**
	  * @TODO: 年度县级项目分类情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:06:44
	 */
	public String projectCountryClassifyBar(){
		if(BlogAndRightsManage.blogSave("年度县级项目分类情况汇总") == 0){
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
	  * @TODO: 某年度县级项目验收评议情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:11:14
	 */
	public String projectCountryCheckedList(){
		if(BlogAndRightsManage.blogSave("年度县级项目验收评议情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectcountrycheckedlist";
	}
	
	/**
	  * @TODO: 某年度县级项目验收评议情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:11:56
	 */
	public String projectCountryCheckedBar(){
		if(BlogAndRightsManage.blogSave("年度县级项目验收评议情况汇总") == 0){
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
	  * @TODO: 某年度县级项目专项资金使用情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:15:43
	 */
	public String projectCountrySpecialFundList(){
		if(BlogAndRightsManage.blogSave("年度县级项目专项资金使用情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectcountryspecialfundlist";
	}
	
	/**
	  * @TODO: 某年度县级项目专项资金使用情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:16:04
	 */
	public String projectCountrySpecialFundBar(){
		if(BlogAndRightsManage.blogSave("年度县级项目专项资金使用情况汇总") == 0){
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
	  * @TODO: 某年度县级项目资金使用情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:17:29
	 */
	public String projectCountryFundList(){
		if(BlogAndRightsManage.blogSave("年度县级项目资金使用情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectcountryfundlist";
	}
	
	/**
	  * @TODO: 某年度县级项目资金使用情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:17:52
	 */
	public String projectCountryFundBar(){
		if(BlogAndRightsManage.blogSave("年度县级项目资金使用情况汇总") == 0){
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
	  * @TODO: 某年度七大种类项目资金情况统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:21:18
	 */
	public String projectClassifyFundList(){
		if(BlogAndRightsManage.blogSave("年度七大种类项目资金情况统计") == 0){
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
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return "error";
		}
		return "projectclassifyfundlist";
	}
	
	/**
	  * @TODO: 某年度七大种类项目资金情况汇总
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:21:41
	 */
	public String projectClassifyFundBar(){
		if(BlogAndRightsManage.blogSave("年度七大种类项目资金情况汇总") == 0){
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
	  * @TODO: 村（居）民数量分布统计
	  * @author LUO-Administrator
	  * @date 2014-7-23 上午10:22:42
	 */
	public String villageResidentCount(){
		if(BlogAndRightsManage.blogSave("村（居）民数量分布统计") == 0){
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
