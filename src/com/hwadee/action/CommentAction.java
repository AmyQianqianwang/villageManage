/**
 * @author: 詹亮名
 * @date: 2014-7-22下午5:10:26
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
 * 公共服务类项目评议情况控制类
 */
public class CommentAction {
	
	private static final int PRO_STATUS = 12;	//处于该类中的项目均为处于项目评议环节
	private static final String PRO_TYPE = "公共服务类";
	
	
	private List<Project> proList;
	/**
	 * 查找到所有处于待评议状态的公共服务类项目
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-22下午9:40:15
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
	private String cid; //评议情况id
	private Commentinfo commentinfo; //已经保存的项目情况，供修改
	
	//接受前端传来的数据
	private String quarter;	//季度
	private String commentObject; //评议对象
	private String commentName;	//评议人员
	private String year;	//评议年
	private String month; //评议月
	private String day;	//评议日
	private String commentSituation; //评议情况
	private String review; //评议结果
	private String tableComment; //备注
	private User US; //放在session中的用户信息
	
	/***************************************/
	//文件上传相关对象
	private File[] file; //上传的文件
    private String[] fileFileName; //文件名称
    private String[] fileContentType; //文件类型
	/****************************************/
    
    private CommentinfoAttachment cifAttachment;	//附件
	
	/**
	 * 添加评议情况，添加户立即进入下一阶段，不能再修改
	 * @return
	 * @author 詹亮名
	 */
	public String add() {
		
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
		if(cid.equals("")) {
			commentinfo = new Commentinfo();
			isEdit = false;
		}else {
			commentinfo = CommentService.findById(Integer.parseInt(cid));
			isEdit = true;
		}
		
		//为评议情况赋值
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
		ProjectService.updateProStatus(proId, 13);	//项目进入下一个状态（即项目评测阶段）
		commentinfo.setProject(pro);
		
		//这是测试，待登录完善记得把UserId换会真实的用户id
//		commentinfo.setUser(UserService.getUserByID("cd00000011"));
//		commentinfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		commentinfo.setUser(US);
		commentinfo.setUnitName(US.getOffice());
		
		if (isEdit) {
			CommentService.update(commentinfo);
		}else {
			CommentService.save(commentinfo);
		}
		//获取刚刚持久化的实体
		commentinfo = CommentService.findByExample(commentinfo);
		
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
	 * 保存并以结果，仍然的处于未评议状态，仍可进行修改
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-23上午8:43:52
	 */
	public String save() {
		
		boolean isEdit = true;
		
		//若commentinfo为null，则表示新增一条记录，否侧为修改记录
		if(cid.equals("")) {
			commentinfo = new Commentinfo();
			isEdit = false;
		}else {
			commentinfo = CommentService.findById(Integer.parseInt(cid));
			isEdit = true;
		}
		
		//为评议情况赋值
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
		
		//这是测试，待登录完善记得把UserId换会真实的用户id
		commentinfo.setUser(UserService.getUserByID("cd00000011"));
		commentinfo.setUnitName(UserService.getUserByID("cd00000011").getOffice());
		commentinfo.setUser(US);
		commentinfo.setUnitName(US.getOffice());
		
		if (isEdit) {
			CommentService.update(commentinfo);
		}else {
			CommentService.save(commentinfo);
		}
		//获取刚刚持久化的实体
		commentinfo = CommentService.findByExample(commentinfo);
		
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
	List<CommentinfoAttachment> ciaList; //附件列表
	/**
	 * 根据项目ID获取到项目实体
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-22下午9:46:22
	 */
	public String preAdd() {
		
		project = ProjectService.getProjectByID(proId);
		//根据proId获取对应的Commentinfo实体
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
