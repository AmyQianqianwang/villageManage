/**
 * @author: ղ����
 * @date: 2014-7-22����5:10:26
 */
package com.hwadee.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.hwadee.orm.Commentinfo;
import com.hwadee.orm.CommentinfoAttachment;
import com.hwadee.orm.Project;
import com.hwadee.orm.User;
import com.hwadee.service.CommentService;
import com.hwadee.service.CommentinfoAttachmentService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.UserService;
import com.hwadee.util.DealStr;
import com.hwadee.util.Tool;

/**
 * ������������Ŀ�������������
 */
public class CommentAction {
	
	private static final int PRO_STATUS = 12;	//���ڸ����е���Ŀ��Ϊ������Ŀ���黷��
	private static final String PRO_TYPE = "����������";
	
	
	private List<Project> proList;
	/**
	 * ���ҵ����д��ڴ�����״̬�Ĺ�����������Ŀ
	 * @return
	 * @author ղ����
	 * @date:2014-7-22����9:40:15
	 */
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
		
		int start = intPageSizeValue * (nowPage - 1);
		proList = proService.getProjectList(PRO_STATUS, PRO_TYPE, start, intPageSizeValue);
		intRowCount = proService.getProjectList(PRO_STATUS, PRO_TYPE, 0, 0).size();
		intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;
		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("intRowCount", intRowCount);
		request.setAttribute("intPageCount", intPageCount);
		request.setAttribute("intPageSize", intPageSizeValue);
		
		return "list_success";
	}
	
	private String proId;
	private Project project;
	private String cid; //�������id
	private Commentinfo commentinfo; //�Ѿ��������Ŀ��������޸�
	
	//����ǰ�˴���������
	private String quarter;	//����
	private String commentObject; //�������
	private String commentName;	//������Ա
	private String year;	//������
	private String month; //������
	private String day;	//������
	private String commentSituation; //�������
	private String review; //������
	private String tableComment; //��ע
	private User US; //����session�е��û���Ϣ
	
	/***************************************/
	//�ļ��ϴ���ض���
	private File[] file; //�ϴ����ļ�
    private String[] fileFileName; //�ļ�����
    private String[] fileContentType; //�ļ�����
	/****************************************/
    
    private CommentinfoAttachment cifAttachment;	//����
	
	/**
	 * ��������������ӻ�����������һ�׶Σ��������޸�
	 * @return
	 * @author ղ����
	 */
	public String add() {
		
		boolean isEdit = true;
		
		//��commentinfoΪnull�����ʾ����һ����¼�����Ϊ�޸ļ�¼
		if(cid.equals("")) {
			commentinfo = new Commentinfo();
			isEdit = false;
		}else {
			commentinfo = CommentService.findById(Integer.parseInt(cid));
			isEdit = true;
		}
		
		//Ϊ���������ֵ
		try {
			int quarterInt = Integer.parseInt(quarter);
			commentinfo.setQuarter(quarterInt);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "false";
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			commentinfo.setCommentTime(sdf.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		commentinfo.setCommentObject(commentObject);
		commentinfo.setCommentName(commentName);
		commentinfo.setCommentSituation(commentSituation);
		commentinfo.setTableComment(tableComment);
		commentinfo.setPaddingTime(new Date());
		commentinfo.setCicheckResult( review.equals("1")?true:false );
		Project pro = ProjectService.getProjectByID(proId);
		ProjectService.updateProStatus(proId, 13);	//��Ŀ������һ��״̬������Ŀ����׶Σ�
		commentinfo.setProject(pro);
		
		//���ǲ��ԣ�����¼���Ƽǵð�UserId������ʵ���û�id
//		commentinfo.setUser(UserService.getUserByID("cd00000011"));
//		commentinfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		commentinfo.setUser(US);
		commentinfo.setUnitName(US.getOffice());
		
		if (isEdit) {
			CommentService.update(commentinfo);
		}else {
			CommentService.save(commentinfo);
		}
		//��ȡ�ոճ־û���ʵ��
		commentinfo = CommentService.findByExample(commentinfo);
		
		//��������
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "false";
		}
		
		String path = request.getSession().getServletContext().getRealPath("/");
		path += "file" + File.separator + "projectLastStage" + File.separator;
		try {
			if (file != null) {
	            File savedir=new File(path);
	            if(!savedir.getParentFile().exists())
	                savedir.getParentFile().mkdirs();
	            for(int i=0;i<file.length;i++){
	                File savefile = new File(savedir, fileFileName[i]);
					FileUtils.copyFile(file[i], savefile);
					
					//���ļ����͵�ַд���Ӧ�ĸ�����
					CommentinfoAttachment commentinfoAtt = new CommentinfoAttachment();
					commentinfoAtt.setCommentinfo(commentinfo);
					commentinfoAtt.setAttachmentName(fileFileName[i]);
					commentinfoAtt.setAttachmentUrl(path + fileFileName[i]);
					
					CommentinfoAttachmentService.save(commentinfoAtt);
	            }
	        }
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
		return "add_success";
	}
	
	/**
	 * ���沢�Խ������Ȼ�Ĵ���δ����״̬���Կɽ����޸�
	 * @return
	 * @author ղ����
	 * @date:2014-7-23����8:43:52
	 */
	public String save() {
		
		boolean isEdit = true;
		
		//��commentinfoΪnull�����ʾ����һ����¼�����Ϊ�޸ļ�¼
		if(cid.equals("")) {
			commentinfo = new Commentinfo();
			isEdit = false;
		}else {
			commentinfo = CommentService.findById(Integer.parseInt(cid));
			isEdit = true;
		}
		
		//Ϊ���������ֵ
		try {
			int quarterInt = Integer.parseInt(quarter);
			commentinfo.setQuarter(quarterInt);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "false";
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			commentinfo.setCommentTime(sdf.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		commentinfo.setCommentObject(commentObject);
		commentinfo.setCommentName(commentName);
		commentinfo.setCommentSituation(commentSituation);
		commentinfo.setTableComment(tableComment);
		commentinfo.setPaddingTime(new Date());
		commentinfo.setCicheckResult( review.equals("1")?true:false );
		
		commentinfo.setProject(ProjectService.getProjectByID(proId));
		
		//���ǲ��ԣ�����¼���Ƽǵð�UserId������ʵ���û�id
		commentinfo.setUser(UserService.getUserByID("cd00000011"));
		commentinfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		commentinfo.setUser(US);
		commentinfo.setUnitName(US.getOffice());
		
		if (isEdit) {
			CommentService.update(commentinfo);
		}else {
			CommentService.save(commentinfo);
		}
		//��ȡ�ոճ־û���ʵ��
		commentinfo = CommentService.findByExample(commentinfo);
		
		//��������
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "false";
		}
		
		String path = request.getSession().getServletContext().getRealPath("/");
		path += "file" + File.separator + "projectLastStage" + File.separator;
		try {
			if (file != null) {
	            File savedir=new File(path);
	            if(!savedir.getParentFile().exists())
	                savedir.getParentFile().mkdirs();
	            for(int i=0;i<file.length;i++){
	                File savefile = new File(savedir, fileFileName[i]);
					FileUtils.copyFile(file[i], savefile);
					
					//���ļ����͵�ַд���Ӧ�ĸ�����
					CommentinfoAttachment commentinfoAtt = new CommentinfoAttachment();
					commentinfoAtt.setCommentinfo(commentinfo);
					commentinfoAtt.setAttachmentName(fileFileName[i]);
					commentinfoAtt.setAttachmentUrl(path + fileFileName[i]);
					
					CommentinfoAttachmentService.save(commentinfoAtt);
	            }
	        }
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
		return "save_success";
	}
	
	private String today;
	List<CommentinfoAttachment> ciaList; //�����б�
	/**
	 * ������ĿID��ȡ����Ŀʵ��
	 * @return
	 * @author ղ����
	 * @date:2014-7-22����9:46:22
	 */
	public String preAdd() {
		
		project = ProjectService.getProjectByID(proId);
		//����proId��ȡ��Ӧ��Commentinfoʵ��
		commentinfo = CommentService.getCommentinfoByProject(proId);
		
		Date date;
		if (commentinfo != null) {
			date = commentinfo.getCommentTime();
		}else {
			date = new Date();
		}
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		
		today = Tool.formatDate(new Date());
		
		return "preAdd";
	}
	
	/*******************************************
	 * getter and setter
	/*******************************************/
	public List<Project> getProList() {
		return proList;
	}

	public void setProList(List<Project> proList) {
		this.proList = proList;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Commentinfo getCommentinfo() {
		return commentinfo;
	}

	public void setCommentinfo(Commentinfo commentinfo) {
		this.commentinfo = commentinfo;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getCommentObject() {
		return commentObject;
	}

	public void setCommentObject(String commentObject) {
		this.commentObject = commentObject;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCommentSituation() {
		return commentSituation;
	}

	public void setCommentSituation(String commentSituation) {
		this.commentSituation = commentSituation;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public CommentinfoAttachment getCifAttachment() {
		return cifAttachment;
	}

	public void setCifAttachment(CommentinfoAttachment cifAttachment) {
		this.cifAttachment = cifAttachment;
	}

	public List<CommentinfoAttachment> getCiaList() {
		return ciaList;
	}

	public void setCiaList(List<CommentinfoAttachment> ciaList) {
		this.ciaList = ciaList;
	}

	public User getUS() {
		return US;
	}

	public void setUS(User uS) {
		US = uS;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
}
