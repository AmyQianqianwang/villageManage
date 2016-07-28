package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.hwadee.orm.Location;
import com.hwadee.orm.LocationDAO;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Projectvoteinfo;
import com.hwadee.orm.User;
import com.hwadee.orm.UserDAO;
import com.hwadee.service.ProjectFormsService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.ProjectvoteinfoService;
import com.hwadee.util.DealStr;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;

public class ProjectAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String proID;
	public String proName;
	public String recTime;
	public String proType;
	public String proKind;
	public String proText;
	public String proSourse;
	public int familyCount;
	public String electTime;
	public String planEndTime;
	public String impleMethod;
	public String attachment;
	public String tableComment;
	public String typeSubmit;
	public Project project;

	//�涨��Ŀ���
	public String newProjectInfo()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("US");
		String loc=user.getLocation().getLocId();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
		java.util.Date date=new java.util.Date();  
		String strdate=sdf.format(date);
		loc=loc+strdate;
		int count=ProjectService.getTodayProjectInfoRowCount(strdate);
		String c=String.format("%03d",count+1);
		loc=loc+c;
		Project project=new Project();
		project.setProId(loc);
		request.setAttribute("project", project);
		return "input";
	}
	
	/**
	 * @TODO ������
	 * @author GUO
	 * @data 2014-7-22����8:49:41
	 * @return
	 */
	public String outString() {

		System.out.println(proSourse);
		return "input";
	}

	public String projectInfoList() {
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

		List<Project> dataList = null;
		//HttpServletRequest request=ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("US");
		String locidString=user.getLocation().getLocId().substring(0, 5);
		try {
			dataList = ProjectService.projectInfoListByStatus(locidString,
					intPageSizeValue, nowPage, 1);
			intRowCount = ProjectService.getProjectInfoRowCount(locidString);
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
		return "projectList";

	}

	public String showProjectInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ProjectDAO projectDAO = new ProjectDAO();
		project = projectDAO.findById(request.getParameter("proID"));
		request.setAttribute("project", project);

		return "input";
	}

	/**
	 * @TODO ������Ŀ�Ǽ���Ϣ��Ŀǰ��δ���ƣ�����δ��ȡ��λ���ƣ�δ��ʽ��ȡ����û�����Ŀ������Χ��δʵ�ָ����ϴ�����
	 * @author GUO
	 * @data 2014-7-22����8:48:33
	 * @return �ɹ�������ҳ�棬���򷵻����ڵ�ҳ��
	 */
	public String insertProjectInfo() {

		Project p = new Project();
		HttpServletRequest request=ServletActionContext.getRequest();
		//ProjectDAO projectDAO = new ProjectDAO();
		//Project project = projectDAO.findById(request.getParameter("projectProID"));
		// Ȩ�޿���
		User user = (User) request.getSession().getAttribute("US");
		if (user.getUserType() != 2) {
			System.out.println(user.getUserType());
			return "noright";
		}
		//������־
		BlogAndRightsManage.blogSave("ԭʼ��Ŀ�Ǽ�");
		
		
		p.setProId(proID);
		p.setProName(proName);
		Date rect = StringToDate(recTime);
		if (rect == null)
			return "input";
		else {
			p.setRecTime(rect);
			// System.out.println(p.getRecTime());
		}
		p.setProType(proType);
		p.setProKind(proKind);
		p.setProContext(proText);
		p.setProSource(proSourse);
		p.setFamilyCount(familyCount);
		Date electt = StringToDate(electTime);
		if (electt == null)
			return "input";
		else {
			p.setElectTime(electt);
		}
		Date planendt = StringToDate(planEndTime);
		if (planendt == null)
			return "input";
		else {
			p.setPlanEndTime(planendt);
		}
		p.setImpleMethod(impleMethod);
		if (typeSubmit.equals("sa"))
			p.setProStatus(1);
		else {
			p.setProStatus(2);
		}
		// ��λ������ʱ����
		p.setPaddingTime(new Date());
		p.setTableComment(tableComment);

		
		
		// ��û����ʽ��д�û�ID�͹�Ͻ��ΧID
//		UserDAO userDAO = new UserDAO();
//		User user = userDAO.findById("cd00000001");
		Location location = user.getLocation();
		p.setUser(user);
		p.setLocation(location);
		//Projectvoteinfo projectvoteinfo=new Projectvoteinfo(user, p, null, null, null, null, null, null, null, null, null, null);
	//	if(ProjectvoteinfoService.save(projectvoteinfo)!=1)
		//	return "error";
		if (ProjectService.save(p) == 1)
			return "success";
		else {
			return "input";
		}

	}

	/**
	 * @TODO �ַ���ת��Ϊ����
	 * @author GUO
	 * @data 2014-7-22����8:48:08
	 * @param strDate
	 * @return
	 */
	private Date StringToDate(String strDate) {
		Date date = new Date();
		// ע��format�ĸ�ʽҪ������String�ĸ�ʽ��ƥ��
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date = sdf.parse(strDate);
			// System.out.println(date.toString());
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {

		this.recTime = recTime;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getProKind() {
		return proKind;
	}

	public void setProKind(String proKind) {
		this.proKind = proKind;
	}

	public String getProText() {
		return proText;
	}

	public void setProText(String proText) {
		this.proText = proText;
	}

	public String getProSource() {
		return proSourse;
	}

	public void setProSource(String proSource) {
		this.proSourse = proSource;
	}

	public int getFamilyCount() {
		return familyCount;
	}

	public void setFamilyCount(int familyCount) {
		this.familyCount = familyCount;
	}

	public String getElectTime() {
		// System.out.println("get"+electTime);
		return electTime;
	}

	public void setElectTime(String electTime) {
		// System.out.println("set"+electTime);
		this.electTime = electTime;
	}

	public String getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getImpleMethod() {
		return impleMethod;
	}

	public void setImpleMethod(String impleMethod) {
		this.impleMethod = impleMethod;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
