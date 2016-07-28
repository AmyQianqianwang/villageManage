/**
 * @author: 詹亮名
 * @date: 2014-7-24下午5:07:15
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
 * 待验收项目（基础建设类）
 */
public class AcceptInfoAction {
	
	private static final int PRO_STATUS = 12;	//处于该类中的项目均为处于项目评议环节
	private static final String PRO_TYPE = "基础建设类";
	
	private List<Project> proList;
	/**
	 * 列出待验收的基建类项目
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
	private Acceptinfo acceptInfo; //验收实体
	 /**** 接收参数****/
	private String year;
	private String month;
	private String day;
	private String pass;	//是否通过
	private String review; //满意度
	private String acceptOpinion;	//验收意见
	private String restFund;	//剩余预算
	private String tableComment; //备注
	private String acceptName; //验收小组成员
	private String aid;	//验收id
	private User US; //放在session中的用户信息
	
	/***************************************/
	//文件上传相关对象
	private File[] file; //上传的文件
    private String[] fileFileName; //文件名称
    private String[] fileContentType; //文件类型
	/****************************************/
    private String today;
    
	/**
	 * 根据项目ID获取到待验收项目实体
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:16
	 */
	public String preAdd() {
		
		project = ProjectService.getProjectByID(proId);
		//根据proId获取对应的Commentinfo实体
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
	 * 保存并以结果，仍然的处于未验收状态，还可进行修改
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:13
	 */
	public String save() {
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
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
		
		//获取刚刚持久化的实体
		acceptInfo = AcceptInfoService.findByExample(acceptInfo);
		
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
	 * 添加验收情况，添加户立即进入下一阶段，不能再修改
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-24下午4:58:10
	 */
	public String add() {
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
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
		ProjectService.updateProStatus(proId, 13);	//项目进入下一个状态（即项目评测阶段）
		acceptInfo.setProject(pro);
		
		acceptInfo.setUser(UserService.getUserByID("cd00000011"));
		acceptInfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		
		if (isEdit) {
			AcceptInfoService.update(acceptInfo);
		}else {
			AcceptInfoService.save(acceptInfo);
		}
		
		//获取刚刚持久化的实体
		acceptInfo = AcceptInfoService.findByExample(acceptInfo);
		
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
