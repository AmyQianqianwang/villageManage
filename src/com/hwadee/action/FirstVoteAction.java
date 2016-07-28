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

	private String pvType;// ͶƱ���ͣ�����ΪFIRST_VOTE����0
	private String voteTime; // ���ʱ��
	private int partCount; //
	private int supposeCount; // Ӧ������
	private int actualCount; // ʵ������
	private int attendCount; //
	private int totalCount; // ͶƱ����
	private int positiveCount; // �޳�Ʊ��
	private int negativeCount; // ����Ʊ��
	private int abstentionCount; // ��ȨƱ��
	private String result; // ������
	private String unitName;
	// private Date paddingTime;
	private String tableComment;
	private String typeSubmit; // ����or�ύ

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
	 * @TODO ��ʾ��ѡ�������б�
	 * @author GUO
	 * @data 2014-7-25����9:14:03
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

		String keyword = ""; // �ؼ���
		String jumpPage = ""; // ��תҳ��
		String intPageSize = ""; // ÿҳ��С
		int intPageSizeValue = 20; // ҳ��С
		int nowPage = 1; // ��ǰҳ
		int intRowCount = 0; // ������
		int intPageCount = 0; // ҳ��

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
			// System.out.println("action:������Ϣ��"+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "projectVoteList";
	}

	/**
	 * 
	 * @TODO ��ʾ��ѡ������Ŀ�б�
	 * @author GUO
	 * @data 2014-7-25����8:47:13
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

		String keyword = ""; // �ؼ���
		String jumpPage = ""; // ��תҳ��
		String intPageSize = ""; // ÿҳ��С
		int intPageSizeValue = 20; // ҳ��С
		int nowPage = 1; // ��ǰҳ
		int intRowCount = 0; // ������
		int intPageCount = 0; // ҳ��

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
			// System.out.println("action:������Ϣ��"+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "projectVoteList";

	}

	/**
	 * 
	 * @TODO ��ʾԭʼ��Ŀ�б�
	 * @author GUO
	 * @data 2014-7-25����8:46:36
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

		String keyword = ""; // �ؼ���
		String jumpPage = ""; // ��תҳ��
		String intPageSize = ""; // ÿҳ��С
		int intPageSizeValue = 20; // ҳ��С
		int nowPage = 1; // ��ǰҳ
		int intRowCount = 0; // ������
		int intPageCount = 0; // ҳ��

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
			// System.out.println("action:������Ϣ��"+intRowCount);
			intPageCount = (intRowCount + intPageSizeValue - 1)
					/ intPageSizeValue;

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
		return "projectVoteList";

	}

	/**
	 * @TODO ����ԭʼ��ĿͶƱ��Ϣ��Ŀǰ���ڵ����⣺û��ʵ�ָ���ѡ���ȡ��¼
	 * @author GUO
	 * @data 2014-7-23����8:14:38
	 * @return
	 */
	public String insertFirstVoteInfo() {
	

		// Ȩ�޿���
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// ������־
		BlogAndRightsManage.blogSave("ԭʼ��Ŀ���");

		// User user = project.getUser();

		Projectvoteinfo pvi = new Projectvoteinfo();
		// ����������ʱ�������⡣
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
			if (result.trim().equals("ͨ��")) {
				project.setProStatus(3);
				pvi.setResult(true);
			} else if (result.trim().equals("��ͨ��")) {
				pvi.setResult(false);
				project.setProStatus(-2);
			} else {
				System.out.println("�ޱ�����");
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
		
		// Ȩ�޿���
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// ������־
		BlogAndRightsManage.blogSave("��ѡ������Ŀ���");
		// User user = project.getUser();
		Projectvoteinfo pvi = new Projectvoteinfo();
		// ����������ʱ�������⡣
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
		// ��ѡ���ʱ��޲�����Ա��һ���������ѡ���/������鷽ʽ��ѡ�
		// ���ｫѡ��ʽ��Ϣ��ӵ�attendCount�ֶ���
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
			if (result.trim().equals("ͨ��")) {
				project.setProStatus(Constant.PRESELECTION_UNREPORT_COUNTRY);
				pvi.setResult(true);
			} else if (result.trim().equals("��ͨ��")) {
				pvi.setResult(false);
				project.setProStatus(-Constant.PRESELECTION_UNVOTED);
			} else {
				System.out.println("�ޱ�����");
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
		// Ȩ�޿���
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		// ������־
		BlogAndRightsManage.blogSave("��ѡ��������Ŀ���");
		// User user = project.getUser();
		Projectvoteinfo pvi = new Projectvoteinfo();
		// ����������ʱ�������⡣
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
		// ��ѡ�����ʱ�û�� ���������һ�ֶΣ����ݿ�����в�δ���Ϊ��Ϊ�գ�����Ĭ������Ϊ-1.
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
			if (result.trim().equals("ͨ��")) {
				project.setProStatus(Constant.PRESELECTION_UNREPORT_COUNTRY);
				pvi.setResult(true);
			} else if (result.trim().equals("��ͨ��")) {
				pvi.setResult(false);
				project.setProStatus(-Constant.PRESELECTION_UNVOTED);
			} else {
				System.out.println("�ޱ�����");
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
