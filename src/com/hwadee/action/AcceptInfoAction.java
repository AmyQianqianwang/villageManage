/**
 * @author: ղ����
 * @date: 2014-7-24����5:07:15
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

import com.hwadee.orm.Acceptinfo;
import com.hwadee.orm.AcceptioninfoAttachment;
import com.hwadee.orm.Project;
import com.hwadee.orm.User;
import com.hwadee.service.AcceptInfoService;
import com.hwadee.service.AcceptioninfoAttachmentService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.UserService;
import com.hwadee.util.DealStr;
import com.hwadee.util.Tool;

/**
 * ��������Ŀ�����������ࣩ
 */
public class AcceptInfoAction {
	
	private static final int PRO_STATUS = 12;	//���ڸ����е���Ŀ��Ϊ������Ŀ���黷��
	private static final String PRO_TYPE = "����������";
	
	private List<Project> proList;
	/**
	 * �г������յĻ�������Ŀ
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����4:58:21
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
	private Acceptinfo acceptInfo; //����ʵ��
	 /**** ���ղ���****/
	private String year;
	private String month;
	private String day;
	private String pass;	//�Ƿ�ͨ��
	private String review; //�����
	private String acceptOpinion;	//�������
	private String restFund;	//ʣ��Ԥ��
	private String tableComment; //��ע
	private String acceptName; //����С���Ա
	private String aid;	//����id
	private User US; //����session�е��û���Ϣ
	
	/***************************************/
	//�ļ��ϴ���ض���
	private File[] file; //�ϴ����ļ�
    private String[] fileFileName; //�ļ�����
    private String[] fileContentType; //�ļ�����
	/****************************************/
    private String today;
    
	/**
	 * ������ĿID��ȡ����������Ŀʵ��
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����4:58:16
	 */
	public String preAdd() {
		
		project = ProjectService.getProjectByID(proId);
		//����proId��ȡ��Ӧ��Commentinfoʵ��
		acceptInfo = AcceptInfoService.getAcceptInfoByProject(proId);
		
		Date date;
		if (acceptInfo != null) {
			date = acceptInfo.getAcceptTime();
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
	
	/**
	 * ���沢�Խ������Ȼ�Ĵ���δ����״̬�����ɽ����޸�
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����4:58:13
	 */
	public String save() {
		boolean isEdit = true;
		
		//��commentinfoΪnull�����ʾ����һ����¼�����Ϊ�޸ļ�¼
		if(aid.equals("")) {
			acceptInfo = new Acceptinfo();
			isEdit = false;
		}else {
			acceptInfo = AcceptInfoService.findById(Integer.parseInt(aid));
			isEdit = true;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			acceptInfo.setAcceptTime(sdf.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		acceptInfo.setAcceptResult(pass.equals("1")?true:false);
		acceptInfo.setAimassesEvaluateResult(review.equals("1")?true:false);
		acceptInfo.setAcceptName(acceptName);
		acceptInfo.setAcceptOpinion(acceptOpinion);
		acceptInfo.setPaddingTime(new Date());
		acceptInfo.setRestFund(Float.parseFloat(restFund));
		acceptInfo.setTableComment(tableComment);
		acceptInfo.setProject(ProjectService.getProjectByID(proId));
		
		acceptInfo.setUser(UserService.getUserByID("cd00000011"));
		acceptInfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		
		if (isEdit) {
			AcceptInfoService.update(acceptInfo);
		}else {
			AcceptInfoService.save(acceptInfo);
		}
		
		//��ȡ�ոճ־û���ʵ��
		acceptInfo = AcceptInfoService.findByExample(acceptInfo);
		
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
					AcceptioninfoAttachment acceptinfoAtt = new AcceptioninfoAttachment();
					acceptinfoAtt.setAcceptinfo(acceptInfo);
					acceptinfoAtt.setAttachmentName(fileFileName[i]);
					acceptinfoAtt.setAttachmentUrl(path + fileFileName[i]);
					
					AcceptioninfoAttachmentService.save(acceptinfoAtt);
	            }
	        }
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
		return "save_success";
	}
	
	/**
	 * ��������������ӻ�����������һ�׶Σ��������޸�
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����4:58:10
	 */
	public String add() {
		boolean isEdit = true;
		
		//��commentinfoΪnull�����ʾ����һ����¼�����Ϊ�޸ļ�¼
		if(aid.equals("")) {
			acceptInfo = new Acceptinfo();
			isEdit = false;
		}else {
			acceptInfo = AcceptInfoService.findById(Integer.parseInt(aid));
			isEdit = true;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			acceptInfo.setAcceptTime(sdf.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		acceptInfo.setAcceptResult(pass.equals("1")?true:false);
		acceptInfo.setAimassesEvaluateResult(review.equals("1")?true:false);
		acceptInfo.setAcceptName(acceptName);
		acceptInfo.setAcceptOpinion(acceptOpinion);
		acceptInfo.setPaddingTime(new Date());
		acceptInfo.setRestFund(Float.parseFloat(restFund));
		acceptInfo.setTableComment(tableComment);
		
		Project pro = ProjectService.getProjectByID(proId);
		ProjectService.updateProStatus(proId, 13);	//��Ŀ������һ��״̬������Ŀ����׶Σ�
		acceptInfo.setProject(pro);
		
		acceptInfo.setUser(UserService.getUserByID("cd00000011"));
		acceptInfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		
		if (isEdit) {
			AcceptInfoService.update(acceptInfo);
		}else {
			AcceptInfoService.save(acceptInfo);
		}
		
		//��ȡ�ոճ־û���ʵ��
		acceptInfo = AcceptInfoService.findByExample(acceptInfo);
		
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
					AcceptioninfoAttachment acceptinfoAtt = new AcceptioninfoAttachment();
					acceptinfoAtt.setAcceptinfo(acceptInfo);
					acceptinfoAtt.setAttachmentName(fileFileName[i]);
					acceptinfoAtt.setAttachmentUrl(path + fileFileName[i]);
					
					AcceptioninfoAttachmentService.save(acceptinfoAtt);
	            }
	        }
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
		return "add_success";
	}

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

	public Acceptinfo getAcceptInfo() {
		return acceptInfo;
	}

	public void setAcceptInfo(Acceptinfo acceptInfo) {
		this.acceptInfo = acceptInfo;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getAcceptOpinion() {
		return acceptOpinion;
	}

	public void setAcceptOpinion(String acceptOpinion) {
		this.acceptOpinion = acceptOpinion;
	}

	public String getRestFund() {
		return restFund;
	}

	public void setRestFund(String restFund) {
		this.restFund = restFund;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}
}
