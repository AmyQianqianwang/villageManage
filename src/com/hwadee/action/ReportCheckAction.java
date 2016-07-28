package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Completeeditioninfo;
import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.ProjectvoteinfoDAO;
import com.hwadee.orm.Reportcheckinfo;
import com.hwadee.orm.ReportcheckinfoDAO;
import com.hwadee.orm.User;
import com.hwadee.service.CompleteeditioninfoService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.ReportcheckinfoService;
import com.hwadee.util.Constant;
import com.hwadee.util.DealStr;

public class ReportCheckAction {

	public String countryCheckResult;
	public String companyCheckResult;
	public String cityCheckResult;
	public String CheckResult;
	public String tableComment;
	public String typeSubmit;

	public String showReportCheckInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ReportcheckinfoDAO dao = new ReportcheckinfoDAO();
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Reportcheckinfo rcInfo = dao.findById(Integer.valueOf(request
				.getParameter("reportCheckInfo")));
		Project p = rcInfo.getProject();
		Set<Implementplanfundsbuget> s = p.getImplementplanfundsbugets();
		Iterator<Implementplanfundsbuget> it = s.iterator();
		request.setAttribute("rcInfo", rcInfo);
		request.setAttribute("ipfbInfo", it.next());
		// System.out.println(it.next().getTotalFund());
		return "input";
	}

	public String CityCheckInfoList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();

		String keyword = ""; // 关键字
		String jumpPage = ""; // 跳转页码
		String intPageSize = ""; // 每页大小
		int intPageSizeValue = 20; // 页大小
		int nowPage = 1; // 当前页
		int intRowCount = 0; // 总条数
		int intPageCount = 0; // 页数

		keyword = request.getParameter("keyword");
		keyword = keyword == null ? "" : dealStr.codeStringNoEncode(keyword);

		jumpPage = request.getParameter("jumpPage");
		jumpPage = jumpPage == null ? "1" : dealStr
				.codeStringNoEncode(jumpPage);

		intPageSize = request.getParameter("intPageSize");
		intPageSize = intPageSize == null ? "20" : dealStr
				.codeStringNoEncode(intPageSize);

		try {
			nowPage = Integer.parseInt(jumpPage);
			intPageSizeValue = Integer.parseInt(intPageSize);
		} catch (Exception ex) {
			nowPage = 1;
			intPageSizeValue = 50;
		}

		List<Reportcheckinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId();
		try {
			dataList = ReportcheckinfoService.countyCheckInfoListByStatus(
					locidString, intPageSizeValue, nowPage, 8);
			intRowCount = ReportcheckinfoService.getCountyCheckRowCount(
					locidString, 8);
			// System.out.println("action:共有消息："+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "ReportCheckList";
	}

	public String CompanyCheckInfoList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();

		String keyword = ""; // 关键字
		String jumpPage = ""; // 跳转页码
		String intPageSize = ""; // 每页大小
		int intPageSizeValue = 20; // 页大小
		int nowPage = 1; // 当前页
		int intRowCount = 0; // 总条数
		int intPageCount = 0; // 页数

		keyword = request.getParameter("keyword");
		keyword = keyword == null ? "" : dealStr.codeStringNoEncode(keyword);

		jumpPage = request.getParameter("jumpPage");
		jumpPage = jumpPage == null ? "1" : dealStr
				.codeStringNoEncode(jumpPage);

		intPageSize = request.getParameter("intPageSize");
		intPageSize = intPageSize == null ? "20" : dealStr
				.codeStringNoEncode(intPageSize);

		try {
			nowPage = Integer.parseInt(jumpPage);
			intPageSizeValue = Integer.parseInt(intPageSize);
		} catch (Exception ex) {
			nowPage = 1;
			intPageSizeValue = 50;
		}

		List<Reportcheckinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId();
		try {
			dataList = ReportcheckinfoService.countyCheckInfoListByStatus(
					locidString, intPageSizeValue, nowPage, 7);
			intRowCount = ReportcheckinfoService.getCountyCheckRowCount(
					locidString, 7);
			// System.out.println("action:共有消息："+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "ReportCheckList";
	}

	public String CountyCheckInfoList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();

		String keyword = ""; // 关键字
		String jumpPage = ""; // 跳转页码
		String intPageSize = ""; // 每页大小
		int intPageSizeValue = 20; // 页大小
		int nowPage = 1; // 当前页
		int intRowCount = 0; // 总条数
		int intPageCount = 0; // 页数

		keyword = request.getParameter("keyword");
		keyword = keyword == null ? "" : dealStr.codeStringNoEncode(keyword);

		jumpPage = request.getParameter("jumpPage");
		jumpPage = jumpPage == null ? "1" : dealStr
				.codeStringNoEncode(jumpPage);

		intPageSize = request.getParameter("intPageSize");
		intPageSize = intPageSize == null ? "20" : dealStr
				.codeStringNoEncode(intPageSize);

		try {
			nowPage = Integer.parseInt(jumpPage);
			intPageSizeValue = Integer.parseInt(intPageSize);
		} catch (Exception ex) {
			nowPage = 1;
			intPageSizeValue = 50;
		}

		List<Reportcheckinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		//System.out.println(locidString).substring(0, 5);
		try {
			dataList = ReportcheckinfoService.countyCheckInfoListByStatus(
					locidString, intPageSizeValue, nowPage, 6);
			intRowCount = ReportcheckinfoService.getCountyCheckRowCount(
					locidString, 6);
			// System.out.println("action:共有消息："+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "ReportCheckList";
	}

	public String insertCheckInfo() {
		// 权限控制
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 6||user.getUserType()!=7||user.getUserType()!=8) {
			return "noright";
		}
		// 操作日志
		BlogAndRightsManage.blogSave("项目审核");
		// User user=project.getUser();

		Reportcheckinfo rci = new Reportcheckinfo();
		try {
			countryCheckResult = new String(
					countryCheckResult.getBytes("ISO-8859-1"), "UTF-8");
			companyCheckResult = new String(
					companyCheckResult.getBytes("ISO-8859-1"), "UTF-8");
			cityCheckResult = new String(
					cityCheckResult.getBytes("ISO-8859-1"), "UTF-8");
			CheckResult = new String(CheckResult.getBytes("ISO-8859-1"),
					"UTF-8");
			tableComment = new String(tableComment.getBytes("ISO-8859-1"),
					"UTF-8");
			typeSubmit = new String(typeSubmit.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		rci.setCountryCheckResult(countryCheckResult);
		rci.setCompanyCheckResult(companyCheckResult);
		rci.setCityCheckResult(cityCheckResult);
		if (CheckResult.trim().equals("通过"))
			rci.setCheckResult(true);
		else if (CheckResult.trim().equals("不通过")) {
			rci.setCheckResult(false);
		} else {
			System.out.println("审核结果出错");
			return "error";
		}
		rci.setWriteTableName(user.getUserName());
		//rci.setUnitName("四川省成都市华迪实训公司集团");
		rci.setUnitName(project.getUnitName());
		rci.setPaddingTime(new Date());
		rci.setTableComment(tableComment);
		int nowstatus = project.getProStatus();
		if (typeSubmit.trim().equals("sb"))// 驳回
			project.setProStatus(nowstatus - 1);
		else if (typeSubmit.trim().equals("su")) // 提交
		{
			if (nowstatus != Constant.PRESELECTION_UNREPORT_CITY)
				project.setProStatus(nowstatus + 1);
			else {
				boolean rciResult = rci.getCheckResult();
				if (rciResult) {
					project.setProStatus(nowstatus + 1);
				} else {
					project.setProStatus(-nowstatus);
				}
			}

		}
		rci.setProject(project);
		rci.setUser(user);
		if (ReportcheckinfoService.save(rci) == Constant.OK)
			return "success";
		else {
			return "input";
		}

	}

	public String getCountryCheckResult() {
		return countryCheckResult;
	}

	public void setCountryCheckResult(String countryCheckResult) {
		this.countryCheckResult = countryCheckResult;
	}

	public String getCompanyCheckResult() {
		return companyCheckResult;
	}

	public void setCompanyCheckResult(String companyCheckResult) {
		this.companyCheckResult = companyCheckResult;
	}

	public String getCityCheckResult() {
		return cityCheckResult;
	}

	public void setCityCheckResult(String cityCheckResult) {
		this.cityCheckResult = cityCheckResult;
	}

	public String getCheckResult() {
		return CheckResult;
	}

	public void setCheckResult(String checkResult) {
		CheckResult = checkResult;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTypeSubmit() {
		return typeSubmit;
	}

	public void setTypeSubmit(String typeSubmit) {
		this.typeSubmit = typeSubmit;
	}

}
