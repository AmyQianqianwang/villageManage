package com.hwadee.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Fundsupervisioninfo;
import com.hwadee.orm.Location;
import com.hwadee.orm.Progresssupervisioninfo;
import com.hwadee.orm.Project;
import com.hwadee.orm.User;
import com.hwadee.service.FundsupervisioninfoService;
import com.hwadee.service.ProgresssupervisioninfoService;
import com.hwadee.service.ProjectService;
import com.hwadee.util.*;

/**
 * @TODO:监督检查阶段控制层操作
 * @author Dong
 * @date 2014-7-21下午1:32:20
 */
@SuppressWarnings("rawtypes")
public class SupervisionAction {
	/**
	 * 自定义反馈字符串
	 */
	private static final String PS_S_SUCCESS="OP_SUCCESS";
	private static final String PS_C_SUCCESS="OP_SUCCESS";
	private static final String FS_S_SUCCESS="OP_SUCCESS";
	private static final String FS_C_SUCCESS="OP_SUCCESS";
	
	private static final String JUMP_TO_PSL="JUMP_TO_PSL";
	private static final String JUMP_TO_FSL="JUMP_TO_FSL";
	
	private static final String JUMP_TO_PSI="JUMP_TO_PSI";
	private static final String JUMP_TO_FSI="JUMP_TO_FSI";
	
	
	private static final String DID_NOT_LOGIN="DID_NOT_LOGIN";
	private static final String BAD_REQUEST="BAD_REQUEST";
	private static final String FAILED="FAILED";
	
	/**
	 * REQUEST
	 */
	private final HttpServletRequest request=ServletActionContext.getRequest();
	private final User user=(User)request.getSession().getAttribute("US");
	
	
	/**
	 * 所需参数
	 */
	private String proID;
	private String userID;
	private String tableComment;
	private String paddingTime;
	private String unitName;
	
	private Date _paddingTime;
	
	/**
	 * for Progress
	 */
	private Set progresssupervisioninfoAttachments;
	private String psicheckResult;
	private String lastTime;
	private String lastProblem;
	private String lastProgress;
	private String midTime;
	private String midProblem;
	private String midProgress;
	private String primaryTime;
	private String primaryProblem;
	private String primaryProgress;
	private String psisupervisionName;
	
	private Date _lastTime;
	private Date _midTime;
	private Date _primaryTime;
	
	/**
	 * for Funds
	 */
	private float balance;
	private String fsino;
	private String fsisupervisionName;
	private Set fundsupervisioninfoAttachments;
	private String fsicheckResult;
	private String fsitime;
	private String costFund;
	
	private Date _fsitime;
	private float _costFund;
	private Integer _fsino;
	
////////////////////////////      ACTION响应             ///////////////

	public String savePSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return saveProgressSurpervisison(project);
	}
	
	public String saveFSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return saveFundsSurpervisision(project);
	}
	
	public String commitPSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		String result=saveProgressSurpervisison(project);
		if(!result.equals(SupervisionAction.PS_S_SUCCESS)){
			return result;
		}
		switch(ProjectService.updateProStatus(proID, Constant.PROJECT_FUNDS_SUPERVISION)){
		case 0:
			result=SupervisionAction.FAILED;
			break;
		case 1:
			result=SupervisionAction.PS_C_SUCCESS;
			break;
		default:
			result=SupervisionAction.BAD_REQUEST;
		}
		
		return result;
	}
	
	public String commitFSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		String result=saveFundsSurpervisision(project);
		
		switch(ProjectService.updateProStatus(proID, Constant.WAIT_COMMENT_OR_ACCPTION)){
		case 0:
			result=SupervisionAction.FAILED;
			break;
		case 1:
			result=SupervisionAction.FS_C_SUCCESS;
			break;
		default:
			result=SupervisionAction.BAD_REQUEST;
		}
		
		return result;
	}

	public String getPSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project,Constant.PROJECT_PROGRESS_SUPERVISION);
	}
	
	public String getFSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project,Constant.PROJECT_FUNDS_SUPERVISION);
	}
	
	public String getPSList(){
		return getListPage(false);
	}
	
	public String getFSList(){
		return getListPage(true);
	}
	
///////////////////////////       实现                           ///////////////
	/**
	 * @TODO:保存进度监督表
	 * @author Dong 
	 * @date 2014-7-22下午5:07:01
	 */
	private String saveProgressSurpervisison(Project project){
		if(!checkAvalid(project, user, Constant.PROJECT_PROGRESS_SUPERVISION)){
			return SupervisionAction.BAD_REQUEST;
		}
		
		paramConverterForPS();
		
		if(psisupervisionName==null
				|| primaryProgress==null
				|| primaryTime==null
				|| midProgress==null
				|| midTime==null
				|| lastProgress==null
				|| lastTime==null
				|| psicheckResult==null
				|| unitName==null
				|| paddingTime==null){
			return SupervisionAction.BAD_REQUEST;
		}
		
		/*
		 * watting for Attachment Part
		 */
		
		
		Progresssupervisioninfo psi=new Progresssupervisioninfo(user, project, 
				psisupervisionName, primaryProgress, primaryProblem, 
				_primaryTime, midProgress, midProblem, _midTime, lastProgress, 
				lastProblem, _lastTime, psicheckResult, unitName, _paddingTime, 
				tableComment, progresssupervisioninfoAttachments);
		
		
		Set set=project.getProgresssupervisioninfos();
		if(set!=null&&!set.isEmpty()){
			psi.setProgresssupervisioninfoId(
					((Progresssupervisioninfo)set.toArray()[0]).getProgresssupervisioninfoId()
					);
		}
		
		if(ProgresssupervisioninfoService.save(psi)==1){
			return SupervisionAction.PS_S_SUCCESS;
		}
		return SupervisionAction.FAILED;
	}
	
	private void paramConverterForPS(){
		paramConverterForPublic();
		try{
			_primaryTime=Tool.toDate(primaryTime);
		}catch(Exception e){}
		
		try{
			_midTime=Tool.toDate(midTime);
		}catch(Exception e){}
		
		try{
			_lastTime=Tool.toDate(lastTime);
		}catch(Exception e){}
	}
	
	/**
	 * @TODO:保存经费监督表
	 * @author Dong 
	 * @date 2014-7-22下午5:18:01
	 */
	private String saveFundsSurpervisision(Project project){
		if(!checkAvalid(project, user, Constant.PROJECT_FUNDS_SUPERVISION)){
			return SupervisionAction.BAD_REQUEST;
		}
		
		paramConverterForFS();
		
		if(psisupervisionName==null
				|| primaryProgress==null
				|| primaryTime==null
				|| midProgress==null
				|| midTime==null
				|| lastProgress==null
				|| lastTime==null
				|| psicheckResult==null
				|| unitName==null
				|| paddingTime==null){
			return SupervisionAction.BAD_REQUEST;
		}
		
		/*
		 * watting for Attachment Part
		 */
		
		Fundsupervisioninfo fsi=new Fundsupervisioninfo(user, project, 
				fsisupervisionName, _fsino, _fsitime, _costFund, balance, 
				fsicheckResult, unitName, _paddingTime, tableComment, 
				fundsupervisioninfoAttachments);
		if(FundsupervisioninfoService.save(fsi)==1){
			
			/**
			 * watting for update project status
			 */
			
			return SupervisionAction.FS_S_SUCCESS;
		}
		return SupervisionAction.FAILED;
	}
	
	private void paramConverterForFS(){
		paramConverterForPublic();
		try{
			_fsitime=Tool.toDate(fsitime);
		}catch(Exception e){}
		
		try{
			_costFund=Float.parseFloat(costFund);
		}catch(Exception e){
			_costFund=-1;
		}
		
		try{
			_fsino=Integer.parseInt(fsino);
		}catch(Exception e){
			_fsino=-1;
		}
	}
	
	private void paramConverterForPublic(){
		_paddingTime=Tool.toDateTime(paddingTime);
	}

	private String getInfoPage(Project project,int status){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		if(project==null){
			return BAD_REQUEST;
		}
		Object info;
		Set set=null;
		String SUCCESS_RETURN=BAD_REQUEST;
		if(status==Constant.PROJECT_PROGRESS_SUPERVISION){
			set=project.getProgresssupervisioninfos();
			if(set!=null&&!set.isEmpty()){
					info=(Progresssupervisioninfo)set.toArray()[0];
			}else{
				info=null;
			}
			SUCCESS_RETURN=JUMP_TO_PSI;
		}else if(status==Constant.PROJECT_FUNDS_SUPERVISION){
			set=project.getFundsupervisioninfos();
			if(set!=null&&!set.isEmpty()){
				info=(Fundsupervisioninfo)set.toArray()[0];
			}else{
				info=null;
			}
			SUCCESS_RETURN=JUMP_TO_FSI;
		}else{
			return BAD_REQUEST;
		}
		
		if(request!=null){
			request.setAttribute("PROJECT", project);
			request.setAttribute("INSTANCE", info);
			
			if(checkAvalid(project, user, status)){
				request.setAttribute("EDITABLE", "true");
			}else{
				request.setAttribute("EDITABLE", "false");
			}
			return SUCCESS_RETURN;
		}
		return BAD_REQUEST;
	}
	
	private String getListPage(boolean isFundSuper){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return FAILED;
		}
		
		final Log errLog = LogFactory.getLog(getClass());
		DealStr dealStr = new DealStr();
		
		String keyword 			= "";	// 关键字
		String jumpPage 		= ""; 	// 跳转页码
		String intPageSize 		= ""; 	// 每页大小
		int intPageSizeValue 	= 20;	// 页大小
		int nowPage 			= 1;	// 当前页
		int intRowCount 		= 0;	// 总条数
		int intPageCount 		= 0;	// 页数

		keyword = request.getParameter("keyword");
		keyword = keyword == null ? "" : dealStr.codeStringNoEncode(keyword);

		jumpPage = request.getParameter("jumpPage");
		jumpPage = jumpPage == null ? "1" : dealStr.codeStringNoEncode(jumpPage);

		intPageSize = request.getParameter("intPageSize");
		intPageSize = intPageSize == null ? "20" : dealStr.codeStringNoEncode(intPageSize);
		
		try {
			nowPage = Integer.parseInt(jumpPage);
			intPageSizeValue = Integer.parseInt(intPageSize);
		} catch (Exception ex) {
			nowPage = 1;
			intPageSizeValue = 50;
		}

		List<Project> dataList = null;
		try {
			String loc="510124";
			int pageSize=intPageSizeValue;
			if(isFundSuper){
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_FUNDS_SUPERVISION, null);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_FUNDS_SUPERVISION, null);
			}else{
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_PROGRESS_SUPERVISION, null);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_PROGRESS_SUPERVISION, null);
			}
			intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;

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
			return FAILED;
		}
		if(isFundSuper){
			return JUMP_TO_FSL;
		}else{
			return JUMP_TO_PSL;
		}
	}
	
	
////////////////////////////////     tools                 /////////////////	

	
	/**
	 * @TODO:检查项目当前是否可以被某用户填写某种监督检查情况信息
	 * @author Dong 
	 * @date 2014-7-22下午5:19:44
	 */
	private boolean checkAvalid(Project project,User user,int status){
		if(project==null||project.getProStatus()!=status){
			return false;
		}
		if(user!=null){
			Location userLoc=user.getLocation();
			Location proLoc=project.getLocation();
			if(userLoc==null
					||proLoc==null
					||!userLoc.getLocId().equals(proLoc.getLocId()
							)){
				return false;
			}
		}else{
			return false;
		}
		return true;
	}



////////////////////////////////     getters & setters     //////////////////
	
	
	/**
	 * @TODO: proID's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getProID() {
		return proID;
	}

	/**
	 * @TODO: proID's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setProID(String proID) {
		this.proID = proID;
	}

	/**
	 * @TODO: userID's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @TODO: userID's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @TODO: tableComment's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getTableComment() {
		return tableComment;
	}

	/**
	 * @TODO: tableComment's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	/**
	 * @TODO: paddingTime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPaddingTime() {
		return paddingTime;
	}

	/**
	 * @TODO: paddingTime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPaddingTime(String paddingTime) {
		this.paddingTime = paddingTime;
	}

	/**
	 * @TODO: unitName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @TODO: unitName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @TODO: progresssupervisioninfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public Set getProgresssupervisioninfoAttachments() {
		return progresssupervisioninfoAttachments;
	}

	/**
	 * @TODO: progresssupervisioninfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setProgresssupervisioninfoAttachments(
			Set progresssupervisioninfoAttachments) {
		this.progresssupervisioninfoAttachments = progresssupervisioninfoAttachments;
	}

	/**
	 * @TODO: psicheckResult's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPsicheckResult() {
		return psicheckResult;
	}

	/**
	 * @TODO: psicheckResult's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPsicheckResult(String psicheckResult) {
		this.psicheckResult = psicheckResult;
	}

	/**
	 * @TODO: lastTime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getLastTime() {
		return lastTime;
	}

	/**
	 * @TODO: lastTime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * @TODO: lastProblem's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getLastProblem() {
		return lastProblem;
	}

	/**
	 * @TODO: lastProblem's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setLastProblem(String lastProblem) {
		this.lastProblem = lastProblem;
	}

	/**
	 * @TODO: lastProgress's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getLastProgress() {
		return lastProgress;
	}

	/**
	 * @TODO: lastProgress's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setLastProgress(String lastProgress) {
		this.lastProgress = lastProgress;
	}

	/**
	 * @TODO: midTime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getMidTime() {
		return midTime;
	}

	/**
	 * @TODO: midTime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setMidTime(String midTime) {
		this.midTime = midTime;
	}

	/**
	 * @TODO: midProblem's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getMidProblem() {
		return midProblem;
	}

	/**
	 * @TODO: midProblem's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setMidProblem(String midProblem) {
		this.midProblem = midProblem;
	}

	/**
	 * @TODO: midProgress's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getMidProgress() {
		return midProgress;
	}

	/**
	 * @TODO: midProgress's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setMidProgress(String midProgress) {
		this.midProgress = midProgress;
	}

	/**
	 * @TODO: primaryTime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPrimaryTime() {
		return primaryTime;
	}

	/**
	 * @TODO: primaryTime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPrimaryTime(String primaryTime) {
		this.primaryTime = primaryTime;
	}

	/**
	 * @TODO: primaryProblem's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPrimaryProblem() {
		return primaryProblem;
	}

	/**
	 * @TODO: primaryProblem's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPrimaryProblem(String primaryProblem) {
		this.primaryProblem = primaryProblem;
	}

	/**
	 * @TODO: primaryProgress's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPrimaryProgress() {
		return primaryProgress;
	}

	/**
	 * @TODO: primaryProgress's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPrimaryProgress(String primaryProgress) {
		this.primaryProgress = primaryProgress;
	}

	/**
	 * @TODO: psisupervisionName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getPsisupervisionName() {
		return psisupervisionName;
	}

	/**
	 * @TODO: psisupervisionName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setPsisupervisionName(String psisupervisionName) {
		this.psisupervisionName = psisupervisionName;
	}

	/**
	 * @TODO: balance's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * @TODO: balance's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * @TODO: fsino's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getFsino() {
		return fsino;
	}

	/**
	 * @TODO: fsino's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setFsino(String fsino) {
		this.fsino = fsino;
	}

	/**
	 * @TODO: fsisupervisionName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getFsisupervisionName() {
		return fsisupervisionName;
	}

	/**
	 * @TODO: fsisupervisionName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setFsisupervisionName(String fsisupervisionName) {
		this.fsisupervisionName = fsisupervisionName;
	}

	/**
	 * @TODO: fundsupervisioninfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public Set getFundsupervisioninfoAttachments() {
		return fundsupervisioninfoAttachments;
	}

	/**
	 * @TODO: fundsupervisioninfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setFundsupervisioninfoAttachments(Set fundsupervisioninfoAttachments) {
		this.fundsupervisioninfoAttachments = fundsupervisioninfoAttachments;
	}

	/**
	 * @TODO: fsicheckResult's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getFsicheckResult() {
		return fsicheckResult;
	}

	/**
	 * @TODO: fsicheckResult's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setFsicheckResult(String fsicheckResult) {
		this.fsicheckResult = fsicheckResult;
	}

	/**
	 * @TODO: fsitime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getFsitime() {
		return fsitime;
	}

	/**
	 * @TODO: fsitime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setFsitime(String fsitime) {
		this.fsitime = fsitime;
	}

	/**
	 * @TODO: costFund's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public String getCostFund() {
		return costFund;
	}

	/**
	 * @TODO: costFund's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:39:00
	 */
	public void setCostFund(String costFund) {
		this.costFund = costFund;
	}
}
