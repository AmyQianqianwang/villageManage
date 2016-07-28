/**
 * @author: ղ����
 * @date: 2014-7-24����4:55:49
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

import com.hwadee.orm.Project;
import com.hwadee.orm.Testevaluateinfo;
import com.hwadee.orm.TestevaluateinfoAttachment;
import com.hwadee.orm.User;
import com.hwadee.service.ProjectService;
import com.hwadee.service.TestEvaluateInfoService;
import com.hwadee.service.TestevaluateinfoAttachmentService;
import com.hwadee.service.UserService;
import com.hwadee.util.DealStr;
import com.hwadee.util.Tool;

/**
 * ��Ŀ����
 */
public class TestEvaluateInfoAction {
	
	private static final int PRO_STATUS = 13;	//���ڸ����е���Ŀ��Ϊ������Ŀ��������
	private static final String PRO_TYPE = ""; //����������͹��������඼��Ҫ����
	
	private List<Project> proList;
	/**
	 * �г�������Ļ�������Ŀ
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
	private Testevaluateinfo testEva;
	private String tid;
	
	 /**** ���ղ���****/
	private String year;
	private String month;
	private String day;
	private String year1;
	private String month1;
	private String day1;
	private String pass; //������
	private String warrantyPeriod; //��������
	private String teacceptName; //����С���Ա
	private String teacceptOpinion; //�������
	private String guaranteeMoney; //�ʱ����
	private String review; //�����
	private String tableComment; //��ע
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
		testEva = TestEvaluateInfoService.getTestEvaByProject(proId);
		
		Date date;
		Date date2;
		if (testEva != null) {
			date = testEva.getTetime();
			date2 = testEva.getImplementTime();
		}else {
			date = new Date();
			date2 = new Date();
		}
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		Calendar cal1 = Calendar.getInstance(); 
		cal1.setTime(date2);
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		
		year1 = String.valueOf(cal1.get(Calendar.YEAR));
		month1 = String.valueOf(cal1.get(Calendar.MONTH) + 1);
		day1 = String.valueOf(cal1.get(Calendar.DAY_OF_MONTH));
		
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
		if(tid.equals("")) {
			testEva = new Testevaluateinfo();
			isEdit = false;
		}else {
			testEva = TestEvaluateInfoService.findById(Integer.parseInt(tid));
			isEdit = true;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			testEva.setTetime(sdf.parse(source));
			
			source = year1+"-"+month1+"-"+day1;
			testEva.setImplementTime(sdf.parse(source));
			
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		testEva.setTeresult(pass.equals("1")?true:false);
		testEva.setTemassesEvaluateResult(review.equals("1")?true:false);
		testEva.setPaddingTime(new Date());
		testEva.setGuaranteeMoney(Float.parseFloat(guaranteeMoney));
		testEva.setTableComment(tableComment);
		testEva.setWarrantyPeriod(Integer.parseInt(warrantyPeriod));
		testEva.setTeacceptName(teacceptName);
		testEva.setTeacceptOpinion(teacceptOpinion);
		
		testEva.setProject(ProjectService.getProjectByID(proId));
		
		testEva.setUser(UserService.getUserByID("cd00000011"));
		testEva.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		testEva.setWriteTableName(UserService.getUserByID("cd00000011").getUserName());
		
		if (isEdit) {
			TestEvaluateInfoService.update(testEva);
		}else {
			TestEvaluateInfoService.save(testEva);
		}
		
		//��ȡ�ոճ־û���ʵ��
		testEva = TestEvaluateInfoService.findByExample(testEva);
		
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
					TestevaluateinfoAttachment atestEvaAtt = new TestevaluateinfoAttachment();
					atestEvaAtt.setTestevaluateinfo(testEva);
					atestEvaAtt.setAttachmentName(fileFileName[i]);
					atestEvaAtt.setAttachmentUrl(path + fileFileName[i]);
					
					TestevaluateinfoAttachmentService.save(atestEvaAtt);
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
		if(tid.equals("")) {
			testEva = new Testevaluateinfo();
			isEdit = false;
		}else {
			testEva = TestEvaluateInfoService.findById(Integer.parseInt(tid));
			isEdit = true;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String source = year+"-"+month+"-"+day;
			testEva.setTetime(sdf.parse(source));
			
			source = year1+"-"+month1+"-"+day1;
			testEva.setImplementTime(sdf.parse(source));
			
		} catch (ParseException e) {
			e.printStackTrace();
			return "false";
		}
		
		testEva.setTeresult(pass.equals("1")?true:false);
		testEva.setTemassesEvaluateResult(review.equals("1")?true:false);
		testEva.setPaddingTime(new Date());
		testEva.setGuaranteeMoney(Float.parseFloat(guaranteeMoney));
		testEva.setTableComment(tableComment);
		testEva.setWarrantyPeriod(Integer.parseInt(warrantyPeriod));
		testEva.setTeacceptName(teacceptName);
		testEva.setTeacceptOpinion(teacceptOpinion);
		
		Project pro = ProjectService.getProjectByID(proId);
		if (pass.equals("1")) {
			ProjectService.updateProStatus(proId, 14);	//��Ŀ������һ��״̬������Ŀ����׶Σ�
		}else {
			ProjectService.updateProStatus(proId, 15);	//��Ŀ������һ��״̬������Ŀ����׶Σ�
		}
		
		testEva.setProject(pro);
		
		testEva.setUser(UserService.getUserByID("cd00000011"));
		testEva.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		testEva.setWriteTableName(UserService.getUserByID("cd00000011").getUserName());
		
		if (isEdit) {
			TestEvaluateInfoService.update(testEva);
		}else {
			TestEvaluateInfoService.save(testEva);
		}
		
		//��ȡ�ոճ־û���ʵ��
		testEva = TestEvaluateInfoService.findByExample(testEva);
		
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
					TestevaluateinfoAttachment atestEvaAtt = new TestevaluateinfoAttachment();
					atestEvaAtt.setTestevaluateinfo(testEva);
					atestEvaAtt.setAttachmentName(fileFileName[i]);
					atestEvaAtt.setAttachmentUrl(path + fileFileName[i]);
					
					TestevaluateinfoAttachmentService.save(atestEvaAtt);
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

	public Testevaluateinfo getTestEva() {
		return testEva;
	}

	public void setTestEva(Testevaluateinfo testEva) {
		this.testEva = testEva;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getMonth1() {
		return month1;
	}

	public void setMonth1(String month1) {
		this.month1 = month1;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getTeacceptName() {
		return teacceptName;
	}

	public void setTeacceptName(String teacceptName) {
		this.teacceptName = teacceptName;
	}

	public String getTeacceptOpinion() {
		return teacceptOpinion;
	}

	public void setTeacceptOpinion(String teacceptOpinion) {
		this.teacceptOpinion = teacceptOpinion;
	}

	public String getGuaranteeMoney() {
		return guaranteeMoney;
	}

	public void setGuaranteeMoney(String guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
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
}
