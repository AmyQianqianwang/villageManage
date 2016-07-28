package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Completeeditioninfo;
import com.hwadee.orm.CompleteeditioninfoDAO;
import com.hwadee.orm.Implementplanfundsbuget;
import com.hwadee.orm.ImplementplanfundsbugetDAO;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.User;
import com.hwadee.service.CompleteeditioninfoService;
import com.hwadee.service.ProjectvoteinfoService;
import com.hwadee.util.Constant;
import com.hwadee.util.DealStr;

public class CompleteEditionAction {

	// private boolean ifEdition;
	private String ifedition;
	private String editContext;
	// private boolean ifvote;
	private String ifvote;
	private String unitName;
	private String tableComment;
	private String typeSubmit;

	public String showCompleteEditionInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		CompleteeditioninfoDAO dao = new CompleteeditioninfoDAO();
		// System.out.println(Integer.valueOf(request.getParameter("projectVoteInfoId")));
		Completeeditioninfo ceInfo = dao.findById(Integer.valueOf(request
				.getParameter("completeEditionInfoId")));
		request.setAttribute("ceInfo", ceInfo);
		return "input";
	}

	public String completeEditionList() {
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

		List<Completeeditioninfo> dataList = null;
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		try {
			dataList = CompleteeditioninfoService.completeEditionListByStatus(
					locidString, intPageSizeValue, nowPage, 4);
			intRowCount = CompleteeditioninfoService
					.getCompleteEditionRowCount(locidString);
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
		return "completeEditionList";
	}

	/**
	 * 
	 * @TODO ����������Ϣ��δ��ɵĹ�����:δ��ʽ ����ID��ȡ��Ŀ��
	 * @author GUO
	 * @data 2014-7-23����1:13:07
	 * @return
	 */
	public String insertCompleteEditionInfo() {
//		ProjectDAO projectDAO = new ProjectDAO();
//		// δ��ʽ ����ID��ȡ��Ŀ
//		Project project = projectDAO.findById("51012410200220131001000");
//		// Ȩ�޿���
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.findById(request.getParameter("projectProID"));
		// Ȩ�޿���
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			return "noright";
		}
		//������־
		BlogAndRightsManage.blogSave("�޸�����");
		

		try {
			ifedition = new String(ifedition.getBytes("ISO-8859-1"), "UTF-8");
			editContext = new String(editContext.getBytes("ISO-8859-1"),
					"UTF-8");
			ifvote = new String(ifvote.getBytes("ISO-8859-1"), "UTF-8");
			tableComment = new String(tableComment.getBytes("ISO-8859-1"),
					"UTF-8");
			// result = new String(result.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}

		// �޸���Ŀ״̬
		if (typeSubmit.trim().equals("sa"))
			project.setProStatus(Constant.PRESELECTION_UNCOMPLETE);
		else if (typeSubmit.trim().equals("su")) {
			System.out.println(ifvote);
			if (ifvote.trim().equals("��"))
				project.setProStatus(Constant.PRESELECTION_UNVOTED);
			else if (ifvote.trim().equals("��")) {
				project.setProStatus(-Constant.PRESELECTION_UNCOMPLETE);
			} else {
				System.out.println("�ı���Ŀ״̬����");
				return "input";
			}
		}

		Completeeditioninfo cei = new Completeeditioninfo();
		cei.setProject(project);
		cei.setUser(user);
		// System.out.println(ifedition);
		if (ifedition.trim().equals("��"))
			cei.setNeedEdit(true);
		else if (ifedition.trim().equals("��"))
			cei.setNeedEdit(false);
		else {
			System.out.println("�Ƿ���������Ϣ����");
			return "input";
		}
		cei.setEditContext(editContext);

		if (ifvote.trim().equals("��"))
			cei.setGoIntoVote(true);
		else if (ifvote.trim().equals("��"))
			cei.setGoIntoVote(false);
		else {
			System.out.println("�Ƿ����������");
			return "input";
		}

		//cei.setUnitName("�Ĵ�ʡ�ɶ��л���ʵѵ��˾����");
		cei.setUnitName(project.getUnitName());
		cei.setPaddingTime(new Date());
		cei.setTableComment(tableComment);
		if (CompleteeditioninfoService.save(cei) == Constant.OK)
			return "success";
		else {
			return "input";
		}
	}

	public String getIfedition() {
		return ifedition;
	}

	public void setIfedition(String ifedition) {
		this.ifedition = ifedition;
	}

	public String getEditContext() {
		return editContext;
	}

	public void setEditContext(String editContext) {
		this.editContext = editContext;
	}

	public String getIfvote() {
		return ifvote;
	}

	public void setIfvote(String ifvote) {
		this.ifvote = ifvote;
		// System.out.println("set" + this.ifvote);
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

	public String getTypeSubmit() {
		return typeSubmit;
	}

	public void setTypeSubmit(String typeSubmit) {
		this.typeSubmit = typeSubmit;
	}

}
