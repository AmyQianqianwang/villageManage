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

import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.ProjectvoteinfoDAO;
import com.hwadee.orm.User;
import com.hwadee.orm.UserDAO;
import com.hwadee.service.ProjectService;
import com.hwadee.service.ProjectvoteinfoService;
import com.hwadee.util.Constant;
import com.hwadee.util.DealStr;
import com.hwadee.util.Tool;

public class FirstVoteAction {

	private String pvType;// 投票类型，这里为FIRST_VOTE，即0
	private String voteTime; // 表决时间
	private int partCount; //
	private int supposeCount; // 应到人数
	private int actualCount; // 实到人数
	private int attendCount; //
	private int totalCount; // 投票总数
	private int positiveCount; // 赞成票数
	private int negativeCount; // 反对票数
	private int abstentionCount; // 弃权票数
	private String result; // 表决结果
	private String unitName;
	// private Date paddingTime;
	private String tableComment;
	private String typeSubmit; // 保存or提交

	public String IntoVote() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Projectvoteinfo pvInfo = dao.findById(Integer.valueOf(request
				.getParameter("projectVoteInfoId")));

		if (pvInfo.getPvtype().equals(0)) {
			// System.out.println("firstvote");
			return "inputFirstVote";
		}

		else if (pvInfo.getPvtype().equals(1)) {
			// System.out.println("secondmeltvote");
			return "inputSecondMeltVote";
		}

		else if (pvInfo.getPvtype().equals(2)) {
			// System.out.println("secondvote");
			return "inputSecondVote";
		}

		else {
			return "error";
		}
	}

	@SuppressWarnings("unchecked")
	public String showProjectVoteInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectvoteinfoDAO dao = new ProjectvoteinfoDAO();
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Projectvoteinfo pvInfo = dao.findById(Integer.valueOf(request
				.getParameter("projectVoteInfoId")));
		request.setAttribute("projectVoteInfo", pvInfo);
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Project p = pvInfo.getProject();
		Set<Implementplanfundsbuget> s = p.getImplementplanfundsbugets();
		Iterator<Implementplanfundsbuget> it = s.iterator();
		request.setAttribute("ipfbInfo", it.next());
		// System.out.println(it.next().getTotalFund());

		if (pvInfo.getPvtype().equals(0)) {
			// System.out.println("firstvote");
			return "inputFirstVote";
		}

		else if (pvInfo.getPvtype().equals(1)) {
			// System.out.println("secondmeltvote");
			return "inputSecondMeltVote";
		}

		else if (pvInfo.getPvtype().equals(2)) {
			// System.out.println("secondvote");
			return "inputSecondVote";
		}

		else {
			return "error";
		}
	}

	/*
	 * public static void main(String[] args) { ProjectvoteinfoDAO dao = new
	 * ProjectvoteinfoDAO(); //
	 * System.out.println(Integer.valueOf(request.getParameter
	 * ("projectVoteInfoId"))); Projectvoteinfo pvInfo =
	 * dao.findById(Integer.valueOf("3")); Project p=pvInfo.getProject();
	 * Set<Implementplanfundsbuget> s=p.getImplementplanfundsbugets();
	 * System.out.println(s.isEmpty()); Iterator<Implementplanfundsbuget> it =
	 * s.iterator(); System.out.println(it.next().getTotalFund()); }
	 */

	/**
	 * 
	 * @TODO 显示初选非融资列表
	 * @author GUO
	 * @data 2014-7-25上午9:14:03
	 * @return
	 */
	public String SecondVoteInfoList() {

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

		List<Projectvoteinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		try {
			dataList = ProjectvoteinfoService.projectVoteInfoList(locidString,
					intPageSizeValue, nowPage, 2, 5);
			intRowCount = ProjectvoteinfoService.getProjectVoteInfoRowCount(
					locidString, 2, 5);
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
		return "projectVoteList";
	}

	/**
	 * 
	 * @TODO 显示初选融资项目列表
	 * @author GUO
	 * @data 2014-7-25上午8:47:13
	 * @return
	 */
	public String SecondMeltVoteInfoList() {
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

		List<Projectvoteinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		try {
			dataList = ProjectvoteinfoService.projectVoteInfoList(locidString,
					intPageSizeValue, nowPage, 1, 5);
			intRowCount = ProjectvoteinfoService.getProjectVoteInfoRowCount(
					locidString, 1, 5);
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
		return "projectVoteList";

	}

	/**
	 * 
	 * @TODO 显示原始项目列表
	 * @author GUO
	 * @data 2014-7-25上午8:46:36
	 * @return
	 */
	public String firstVoteInfoList() {
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

		List<Projectvoteinfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
	//	System.out.println(locidString);
		try {
			dataList = ProjectvoteinfoService.projectVoteInfoList(locidString,
					intPageSizeValue, nowPage, 0, 2);
			intRowCount = ProjectvoteinfoService.getProjectVoteInfoRowCount(
					locidString, 0, 2);
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
		return "projectVoteList";

	}

	/**
	 * @TODO 插入原始项目投票信息，目前存在的问题：没有实现根据选择读取记录
	 * @author GUO
	 * @data 2014-7-23上午8:14:38
	 * @return
	 */
	public String insertFirstVoteInfo() {
	

		// 权限控制
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// 操作日志
		BlogAndRightsManage.blogSave("原始项目表决");

		// User user = project.getUser();

		Projectvoteinfo pvi = new Projectvoteinfo();
		// 设置类型暂时出现问题。
		pvi.setPvtype(Constant.FIRST_VOTE);

		Date votet = Tool.StringToDate(voteTime);
		if (votet == null)
			return "input";
		else {
			pvi.setVoteTime(votet);
		}
		pvi.setPartCount(partCount);
		pvi.setSupposeCount(supposeCount);
		pvi.setActualCount(actualCount);
		pvi.setAttendCount(attendCount);
		pvi.setTotalCount(totalCount);
		pvi.setPositiveCount(positiveCount);
		pvi.setNegativeCount(negativeCount);
		pvi.setAbstentionCount(abstentionCount);
		if (typeSubmit.equals("sa"))
			project.setProStatus(2);
		else if (typeSubmit.equals("su")) {
			try {
				tableComment = new String(tableComment.getBytes("ISO-8859-1"),
						"UTF-8");
				result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "error";
			}
			// System.out.println(result);
			if (result.trim().equals("通过")) {
				project.setProStatus(3);
				pvi.setResult(true);
			} else if (result.trim().equals("不通过")) {
				pvi.setResult(false);
				project.setProStatus(-2);
			} else {
				System.out.println("无表决结果");
				return "input";
			}
		}

		pvi.setPaddingTime(new Date());
		pvi.setTableComment(tableComment);
		pvi.setProject(project);
		pvi.setUser(user);
		if (ProjectvoteinfoService.save(pvi) == Constant.OK)
			return "success";
		else {
			return "input";
		}
	}

	public String insertSecondMeltVoteInfo() {
		
		// 权限控制
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// 操作日志
		BlogAndRightsManage.blogSave("初选融资项目表决");
		// User user = project.getUser();
		Projectvoteinfo pvi = new Projectvoteinfo();
		// 设置类型暂时出现问题。
		pvi.setPvtype(Constant.SECOND_MELT_VOTE);
		Date votet = Tool.StringToDate(voteTime);
		if (votet == null)
			return "input";
		else {
			pvi.setVoteTime(votet);
		}
		pvi.setPartCount(actualCount);
		pvi.setSupposeCount(supposeCount);
		pvi.setActualCount(actualCount);
		// 初选融资表并无参与人员这一项，但它多了选择村/居民会议方式的选项，
		// 这里将选择方式信息添加到attendCount字段中
		pvi.setAttendCount(attendCount);
		pvi.setTotalCount(totalCount);
		pvi.setPositiveCount(positiveCount);
		pvi.setNegativeCount(negativeCount);
		pvi.setAbstentionCount(abstentionCount);
		if (typeSubmit.equals("sa"))
			project.setProStatus(Constant.PRESELECTION_UNVOTED);
		else if (typeSubmit.equals("su")) {
			try {
				tableComment = new String(tableComment.getBytes("ISO-8859-1"),
						"UTF-8");
				result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "error";
			}
			// System.out.println(result);
			if (result.trim().equals("通过")) {
				project.setProStatus(Constant.PRESELECTION_UNREPORT_COUNTRY);
				pvi.setResult(true);
			} else if (result.trim().equals("不通过")) {
				pvi.setResult(false);
				project.setProStatus(-Constant.PRESELECTION_UNVOTED);
			} else {
				System.out.println("无表决结果");
				return "input";
			}
		}

		pvi.setPaddingTime(new Date());
		pvi.setTableComment(tableComment);
		pvi.setProject(project);
		pvi.setUser(user);
		if (ProjectvoteinfoService.save(pvi) == Constant.OK)
			return "success";
		else {
			return "input";
		}
	}

	public String insertSecondVoteInfo() {
//		ProjectDAO projectDAO = new ProjectDAO();
//		Project project = projectDAO.findById("51012410200220131001000");
		// 权限控制
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// 操作日志
		BlogAndRightsManage.blogSave("初选非融资项目表决");
		// User user = project.getUser();
		Projectvoteinfo pvi = new Projectvoteinfo();
		// 设置类型暂时出现问题。
		pvi.setPvtype(Constant.SECOND_VOTE);
		Date votet = Tool.StringToDate(voteTime);
		if (votet == null)
			return "input";
		else {
			pvi.setVoteTime(votet);
		}
		pvi.setPartCount(actualCount);
		pvi.setSupposeCount(supposeCount);
		pvi.setActualCount(actualCount);
		// 初选非融资表没有 与会人数这一字段，数据库设计中并未设计为可为空，这里默认设置为-1.
		pvi.setAttendCount(-1);
		pvi.setTotalCount(totalCount);
		pvi.setPositiveCount(positiveCount);
		pvi.setNegativeCount(negativeCount);
		pvi.setAbstentionCount(abstentionCount);
		if (typeSubmit.equals("sa"))
			project.setProStatus(Constant.PRESELECTION_UNVOTED);
		else if (typeSubmit.equals("su")) {
			try {
				tableComment = new String(tableComment.getBytes("ISO-8859-1"),
						"UTF-8");
				result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "error";
			}
			// System.out.println(result);
			if (result.trim().equals("通过")) {
				project.setProStatus(Constant.PRESELECTION_UNREPORT_COUNTRY);
				pvi.setResult(true);
			} else if (result.trim().equals("不通过")) {
				pvi.setResult(false);
				project.setProStatus(-Constant.PRESELECTION_UNVOTED);
			} else {
				System.out.println("无表决结果");
				return "input";
			}
		}

		pvi.setPaddingTime(new Date());
		pvi.setTableComment(tableComment);
		pvi.setProject(project);
		pvi.setUser(user);
		if (ProjectvoteinfoService.save(pvi) == Constant.OK)
			return "success";
		else {
			return "input";
		}
	}

	public String getTypeSubmit() {
		return typeSubmit;
	}

	public void setTypeSubmit(String typeSubmit) {
		this.typeSubmit = typeSubmit;
	}

	public String getPvType() {
		return pvType;
	}

	public void setPvType(String pvType) {
		this.pvType = pvType;
	}

	public String getVoteTime() {
		return voteTime;
	}

	public void setVoteTime(String voteTime) {
		this.voteTime = voteTime;
	}

	public int getPartCount() {
		return partCount;
	}

	public void setPartCount(int partCount) {
		this.partCount = partCount;
	}

	public int getSupposeCount() {
		return supposeCount;
	}

	public void setSupposeCount(int supposeCount) {
		this.supposeCount = supposeCount;
	}

	public int getActualCount() {
		return actualCount;
	}

	public void setActualCount(int actualCount) {
		this.actualCount = actualCount;
	}

	public int getAttendCount() {
		return attendCount;
	}

	public void setAttendCount(int attendCount) {
		this.attendCount = attendCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPositiveCount() {
		return positiveCount;
	}

	public void setPositiveCount(int positiveCount) {
		this.positiveCount = positiveCount;
	}

	public int getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(int negativeCount) {
		this.negativeCount = negativeCount;
	}

	public int getAbstentionCount() {
		return abstentionCount;
	}

	public void setAbstentionCount(int abstentionCount) {
		this.abstentionCount = abstentionCount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}
