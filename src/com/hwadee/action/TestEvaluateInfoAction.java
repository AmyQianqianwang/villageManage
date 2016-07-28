/**
 * @author: 詹亮名
 * @date: 2014-7-24下午4:55:49
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
 * 项目评测
 */
public class TestEvaluateInfoAction {
	
	private static final int PRO_STATUS = 13;	//处于该类中的项目均为处于项目测评环节
	private static final String PRO_TYPE = ""; //基础建设类和公共服务类都需要测评
	
	private List<Project> proList;
	/**
	 * 列出待评测的基建类项目
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:21
	 */
	public String list() {
		//按项目初始时间逆序
		String jumpPage 		= ""; 	// 跳转页码
		String intPageSize 		= ""; 	// 每页大小
		int intPageSizeValue 	= 20;	// 页大小
		int nowPage 			= 1;	// 当前页
		int intRowCount 		= 0;	// 总条数
		int intPageCount 		= 0;	// 页数
		
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
	
	 /**** 接收参数****/
	private String year;
	private String month;
	private String day;
	private String year1;
	private String month1;
	private String day1;
	private String pass; //评测结果
	private String warrantyPeriod; //保修年限
	private String teacceptName; //验收小组成员
	private String teacceptOpinion; //验收意见
	private String guaranteeMoney; //质保金额
	private String review; //满意度
	private String tableComment; //备注
	private User US; //放在session中的用户信息
	
	/***************************************/
	//文件上传相关对象
	private File[] file; //上传的文件
    private String[] fileFileName; //文件名称
    private String[] fileContentType; //文件类型
	/****************************************/
	private String today;
    
	/**
	 * 根据项目ID获取到待评测项目实体
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:16
	 */
	public String preAdd() {
		project = ProjectService.getProjectByID(proId);
		//根据proId获取对应的Commentinfo实体
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
	 * 保存并以结果，仍然的处于未评测状态，还可进行修改
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:13
	 */
	public String save() {
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
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
		
		//获取刚刚持久化的实体
		testEva = TestEvaluateInfoService.findByExample(testEva);
		
		//操作附件
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
					
					//将文件名和地址写入对应的附件表
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
	 * 添加评测情况，添加户立即进入下一阶段，不能再修改
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:10
	 */
	public String add() {
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
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
			ProjectService.updateProStatus(proId, 14);	//项目进入下一个状态（即项目评测阶段）
		}else {
			ProjectService.updateProStatus(proId, 15);	//项目进入下一个状态（即项目评测阶段）
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
		
		//获取刚刚持久化的实体
		testEva = TestEvaluateInfoService.findByExample(testEva);
		
		//操作附件
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
					
					//将文件名和地址写入对应的附件表
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
