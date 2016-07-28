package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.avalon.framework.activity.Suspendable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.ImplementplanfundsbugetDAO;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.ProjectvoteinfoDAO;
import com.hwadee.orm.User;
import com.hwadee.service.ImplementplanfundsbugetService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.ProjectvoteinfoService;
import com.hwadee.util.Constant;
import com.hwadee.util.DealStr;

public class FundsBugetAction {

	private String proID;
	private String implePlan;
	private float specialFund;
	private float selfFund;
	private float meltFund;
	private int maturities;
	private float otherFund;
	private float totalFund;
	private String tableComment;
	private String typeSubmit;
	private String unitName;

	// private String userID;

	public String showFundsBugetInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ImplementplanfundsbugetDAO dao = new ImplementplanfundsbugetDAO();
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Implementplanfundsbuget ipfbInfo = dao.findById(Integer.valueOf(request
				.getParameter("fundsBugetInfoId")));
		request.setAttribute("ipfbInfo", ipfbInfo);
		return "input";
	}

	public String fundsBugetInfoList() {
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

		List<Implementplanfundsbuget> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		try {
			dataList = ImplementplanfundsbugetService.fundsBugetListByStatus(
					locidString, intPageSizeValue, nowPage, 3);
			intRowCount = ImplementplanfundsbugetService
					.getFundsBugetInfoRowCount(locidString);
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
		return "fundsBugetList";
	}

	/**
	 * 
	 * @TODO 插入资金预算信息，还没完成的功能有:正式获取用户，正式获取项目编号，正式获取单位名称。
	 * @author GUO
	 * @data 2014-7-23上午11:14:16
	 * @return
	 */
	public String insertFundsBugetInfo() {
//		ProjectDAO projectDAO = new ProjectDAO();
//		// id暂时固定
//		Project project = projectDAO.findById("51012410200220131001000");
//		// 权限控制
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// 操作日志
		BlogAndRightsManage.blogSave("实施计划及资金预算");
		//User user = project.getUser();

		if (typeSubmit.trim().equals("sa"))
			project.setProStatus(3);
		else if (typeSubmit.trim().equals("su"))
			project.setProStatus(4);
		else {
			System.out.println("提交和保存出现问题");
			return "error";
		}

		Implementplanfundsbuget ipfb = new Implementplanfundsbuget();
		ipfb.setProject(project);
		ipfb.setUser(user);
		try {
			implePlan = new String(implePlan.getBytes("ISO-8859-1"), "UTF-8");
			tableComment = new String(tableComment.getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
		ipfb.setImplePlan(implePlan);
		ipfb.setSpecialFund(specialFund);
		ipfb.setSelfFund(selfFund);
		ipfb.setMeltFund(meltFund);
		ipfb.setMaturities(maturities);
		ipfb.setOtherFund(otherFund);
		ipfb.setTotalFund(totalFund);
		// 暂时没正式获取单位名称
		//ipfb.setUnitName("四");
		ipfb.setUnitName(project.getUnitName());
		ipfb.setPaddingTime(new Date());
		ipfb.setTableComment(tableComment);
		if (ImplementplanfundsbugetService.save(ipfb) == Constant.OK)
			return "success";
		else
			return "input";
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getTypeSubmit() {
		return typeSubmit;
	}

	public void setTypeSubmit(String typeSubmit) {
		this.typeSubmit = typeSubmit;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getImplePlan() {
		return implePlan;
	}

	public void setImplePlan(String implePlan) {
		this.implePlan = implePlan;
	}

	public float getSpecialFund() {
		return specialFund;
	}

	public void setSpecialFund(float specialFund) {
		this.specialFund = specialFund;
	}

	public float getSelfFund() {
		return selfFund;
	}

	public void setSelfFund(float selfFund) {
		this.selfFund = selfFund;
	}

	public float getMeltFund() {
		return meltFund;
	}

	public void setMeltFund(float meltFund) {
		this.meltFund = meltFund;
	}

	public int getMaturities() {
		return maturities;
	}

	public void setMaturities(int maturities) {
		this.maturities = maturities;
	}

	public float getOtherFund() {
		return otherFund;
	}

	public void setOtherFund(float otherFund) {
		this.otherFund = otherFund;
	}

	public float getTotalFund() {
		return totalFund;
	}

	public void setTotalFund(float totalFund) {
		this.totalFund = totalFund;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}
