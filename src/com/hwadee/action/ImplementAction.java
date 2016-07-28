package com.hwadee.action;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hwadee.orm.Compareselectinfo;
import com.hwadee.orm.Directlyexecuteinfo;
import com.hwadee.orm.Jobcompetitioninfo;
import com.hwadee.orm.Location;
import com.hwadee.orm.Project;
import com.hwadee.orm.Selfbuildinfo;
import com.hwadee.orm.User;
import com.hwadee.service.CompareselectinfoService;
import com.hwadee.service.DirectlyexecuteinfoService;
import com.hwadee.service.JobcompetitioninfoService;
import com.hwadee.service.ProjectService;
import com.hwadee.service.SelfbuildinfoService;

import com.hwadee.util.*;

/**
 * @TODO:实施阶段控制层操作
 * @author Dong
 * @date 2014-7-21下午1:33:10
 */
@SuppressWarnings("rawtypes")
public class ImplementAction {
	
	/**
	 * 标示当前阶段执行操作的常量
	 */
	private static final int ALL_METHOD=-1;
	private static final int JOB_COMPET=1;
	private static final int DIR_EXEC=2;
	private static final int COMP_SELECT=3;
	private static final int SELF_BUILD=4;
	private static final int INVALID=0;
	
	/**
	 * 自定义反馈字符串
	 */
	
	private static final String JC_S_SUCCESS="OP_SUCCESS";
	private static final String JC_C_SUCCESS="OP_SUCCESS";
	private static final String DE_S_SUCCESS="OP_SUCCESS";
	private static final String DE_C_SUCCESS="OP_SUCCESS";
	private static final String CS_S_SUCCESS="OP_SUCCESS";
	private static final String CS_C_SUCCESS="OP_SUCCESS";
	private static final String SB_S_SUCCESS="OP_SUCCESS";
	private static final String SB_C_SUCCESS="OP_SUCCESS";
	
	/*  | USEFUL | DO NOT DELETE  |
	private static final String JC_S_SUCCESS="JC_S_SUCCESS";
	private static final String JC_C_SUCCESS="JC_S_SUCCESS";
	private static final String DE_S_SUCCESS="DE_S_SUCCESS";
	private static final String DE_C_SUCCESS="DE_S_SUCCESS";
	private static final String CS_S_SUCCESS="CS_S_SUCCESS";
	private static final String CS_C_SUCCESS="CS_S_SUCCESS";
	private static final String SB_S_SUCCESS="SB_S_SUCCESS";
	private static final String SB_C_SUCCESS="SB_C_SUCCESS";*/
	
	private static final String JUMP_TO_LIST="JUMP_TO_LIST";
	private static final String JUMP_TO_JCL="JUMP_TO_LIST";
	private static final String JUMP_TO_DEL="JUMP_TO_LIST";
	private static final String JUMP_TO_CSL="JUMP_TO_LIST";
	private static final String JUMP_TO_SBL="JUMP_TO_LIST";
	
	
	private static final String JUMP_TO_JCI="JUMP_TO_JCI";
	private static final String JUMP_TO_DEI="JUMP_TO_DEI";
	private static final String JUMP_TO_CSI="JUMP_TO_CSI";
	private static final String JUMP_TO_SBI="JUMP_TO_SBI";
	
	
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
	private String unitName;	
	private String paddingTime;
	private String tableComment;
	
	private Date _paddingTime;
	
	/**
	 * for JobCompet
	 */
	private String jobName;
	private String jobPay;
	private String jobDescription;
	private String jobRequirement;
	private String peopleName;
	private String competitionTime;
	private String competitionResult;
	private String contractFunds;
	private String jcicheckResult;
	private Set jobcompetitioninfoAttachments;
	
	private float _jobPay=-1;
	private float _contractFunds=-1;
	private Date _competitionTime;
	
	/**
	 * for DirectExecute
	 */
	private String projectLeaderName;
	private String projectLeaderTel;
	private String projectSupervisionName;
	private String projectSupervisionTel;
	private Set directlyexecuteinfoAttachments;

	/**
	 * for CompareSelect
	 */
	private String csnumber;
	private String cscontractFunds;
	private String csresult;
	private String cscandidateName;
	private String cstime;
	private String csprojectSupervisionName;
	private Set compareselectinfoAttachments;
	
	private float _cscontractFunds;
	private Date _cstime;

	/**
	 * for SelfBuild
	 */
	private Set selfbuildinfoAttachments;
	private String writeTableName;
	private String sbmaterialsPurchaseTel;
	private String sbmaterialsPurchaseName;
	private String sbprojectLeaderTel;
	private String sbprojectLeaderName;

////////////////////////     ACTIONS      ////////////////////////////
	
	/**
	 * @TODO:保存竞岗情况的Action响应
	 * @author Dong 
	 * @date 2014-7-21下午1:47:58
	 */
	public String saveJCInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		//User user=UserService.getUserByID(userID);
		return saveJobCompetitionInfo(project, user);
	}
	
	/**
	 * @TODO:保存直接实施情况的Action响应
	 * @author Dong 
	 * @date 2014-7-21下午1:48:22
	 */
	public String saveDEInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return saveDirectlyExecteInfo(project, user);
	}
	
	/**
	 * @TODO:保存比选情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:52:55
	 */
	public String saveCSInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return saveCompareSelectInfo(project, user);
	}

	/**
	 * @TODO:保存自建情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:53:29
	 */
	public String saveSBInfo(){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		Project project=ProjectService.getProjectByID(proID);
		return saveSelfBuildInfo(project, user);
	}
	
	/**
	 * @TODO:提交竞岗情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:54:09
	 */
	public String commitJCInfo(){
		return commitInfo(ImplementAction.JOB_COMPET);
	}
	
	/**
	 * @TODO:提交直接实施情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:54:31
	 */
	public String commitDEInfo(){
		return commitInfo(ImplementAction.DIR_EXEC);
	}
	
	/**
	 * @TODO:提交比选情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:54:36
	 */
	public String commitCSInfo(){
		return commitInfo(ImplementAction.COMP_SELECT);
	}

	/**
	 * @TODO:提交自建情况的Action响应
	 * @author Dong 
	 * @date 2014-7-23上午9:54:41
	 */
	public String commitSBInfo(){
		return commitInfo(ImplementAction.SELF_BUILD);
	}
	
	public String getInfoPage(){
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project, ImplementAction.ALL_METHOD);
	}
	
	/**
	 * @TODO:获取竞岗信息详情页
	 * @author Dong 
	 * @date 2014-7-24下午4:18:53
	 */
	public String getJCPage(){
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project, ImplementAction.JOB_COMPET);
	}
	
	/**
	 * @TODO:获取直接实施信息详情页
	 * @author Dong 
	 * @date 2014-7-24下午4:19:21
	 */
	public String getDEPage(){
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project, ImplementAction.DIR_EXEC);
	}
	
	/**
	 * @TODO:获取比选信息详情页
	 * @author Dong 
	 * @date 2014-7-24下午4:19:27
	 */
	public String getCSPage(){
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project, ImplementAction.COMP_SELECT);
	}
	
	/**
	 * @TODO:获取自建信息详情页
	 * @author Dong 
	 * @date 2014-7-24下午4:19:32
	 */
	public String getSBPage(){
		Project project=ProjectService.getProjectByID(proID);
		return getInfoPage(project, ImplementAction.SELF_BUILD);
	}

	

	public String getList(){
		String result=getListPage(ImplementAction.ALL_METHOD);
		if(!result.equals(ImplementAction.JUMP_TO_LIST)){
			return result;
		}
		return ImplementAction.JUMP_TO_LIST;
	}
	
	public String getJCList(){
		String result=getListPage(ImplementAction.JOB_COMPET);
		if(!result.equals(ImplementAction.JUMP_TO_LIST)){
			return result;
		}
		return ImplementAction.JUMP_TO_JCL;
	}
	
	public String getDEList(){
		String result=getListPage(ImplementAction.DIR_EXEC);
		if(!result.equals(ImplementAction.JUMP_TO_LIST)){
			return result;
		}
		return ImplementAction.JUMP_TO_DEL;
	}
	
	public String getCSList(){
		String result=getListPage(ImplementAction.COMP_SELECT);
		if(!result.equals(ImplementAction.JUMP_TO_LIST)){
			return result;
		}
		return ImplementAction.JUMP_TO_CSL;
	}
	
	public String getSBList(){
		String result=getListPage(ImplementAction.SELF_BUILD);
		if(!result.equals(ImplementAction.JUMP_TO_LIST)){
			return result;
		}
		return ImplementAction.JUMP_TO_SBL;
	}
	
////////////////////////      具体实现                 ////////////////////////////
	/**
	 * @TODO:保存竞岗信息的实现
	 * @author Dong 
	 * @date 2014-7-23上午9:18:28
	 */
	private String saveJobCompetitionInfo(Project project,User user){
		if(!checkAvalid(project, user, ImplementAction.JOB_COMPET)){
			return BAD_REQUEST;
		}
		
		paramConverterForJC();
		
		if(jobName==null
				|| _jobPay==-1
				|| peopleName==null
				|| competitionTime==null
				|| _contractFunds==-1
				|| unitName==null
				|| paddingTime==null){
			return ImplementAction.BAD_REQUEST;
		}
		
		/*
		 * watting for Attachment part
		 */
		
		Jobcompetitioninfo jci=new Jobcompetitioninfo(user, 
				project, jobName, _jobPay, jobDescription, jobRequirement, 
				peopleName, _competitionTime, competitionResult, _contractFunds, 
				jcicheckResult, unitName, _paddingTime, tableComment, 
				jobcompetitioninfoAttachments);
		
		Set jciSet=project.getJobcompetitioninfos();
		if(jciSet!=null&&!jciSet.isEmpty()){
			jci.setJobcompetitioninfoId(
					((Jobcompetitioninfo)jciSet.toArray()[0]).getJobcompetitioninfoId()
					);
		}
		if(JobcompetitioninfoService.saveOrUpdate(jci)==1){			
			return ImplementAction.JC_S_SUCCESS;
		}
		return ImplementAction.FAILED;
		
	}

	/**
	 * @TODO:竞岗参数转换器
	 * @author Dong 
	 * @date 2014-7-23上午9:18:50
	 */
	private void paramConverterForJC(){
		paramConverterForPublic();
		
		try{
			_jobPay=Float.parseFloat(jobPay);
		}catch(Exception e){
			_jobPay=-1;
		}
		
		_competitionTime=Tool.toDate(competitionTime);
		
		try{
			_contractFunds=Float.parseFloat(contractFunds);
		}catch (Exception e) {
			_contractFunds=-1;
		}
	}
	
	
	/**
	 * @TODO:保存直接实施情况的实现
	 * @author Dong 
	 * @date 2014-7-23上午9:19:35
	 */
	private String saveDirectlyExecteInfo(Project project,User user){
		if(!checkAvalid(project, user, ImplementAction.DIR_EXEC)){
			return ImplementAction.BAD_REQUEST;
		}
		
		paramConverterForDE();
		
		if(projectLeaderName==null
				|| projectLeaderTel==null
				|| projectSupervisionName==null
				|| projectSupervisionTel==null
				|| unitName==null
				|| paddingTime==null){
			return ImplementAction.BAD_REQUEST;
		}
		
		
		/*
		 * watting for Attachment part
		 */
		
		Directlyexecuteinfo dei=new Directlyexecuteinfo(user, project, 
				projectLeaderName, projectLeaderTel, projectSupervisionName, 
				projectSupervisionTel, unitName, _paddingTime, tableComment, 
				directlyexecuteinfoAttachments);
		
		Set deiSet=project.getDirectlyexecuteinfos();
		if(deiSet!=null&&!deiSet.isEmpty()){
			dei.setDirectlyexecuteinfoId(
					((Directlyexecuteinfo)deiSet.toArray()[0]).getDirectlyexecuteinfoId()
					);
		}
		
		if(DirectlyexecuteinfoService.saveOrUpdate(dei)==1){
			
			/**
			 * watting for Update Project Status 
			 */
			
			return ImplementAction.DE_S_SUCCESS;
		}
		return ImplementAction.FAILED;
	}
	

	/**
	 * @TODO:直接实施参数转化器
	 * @author Dong 
	 * @date 2014-7-23上午9:55:34
	 */
	private void paramConverterForDE(){
		paramConverterForPublic();
	}
	
	/**
	 * @TODO:保存比选情况信息的方法
	 * @author Dong 
	 * @param csprojectSupervisionName 
	 * @date 2014-7-22下午3:34:07
	 */
	private String saveCompareSelectInfo(Project project,User user){
		if(!checkAvalid(project, user, ImplementAction.COMP_SELECT)){
			return ImplementAction.BAD_REQUEST;
		}
		
		paramConverterForCS();
		
		if( csnumber==null
				|| cscandidateName==null
				|| cstime==null
				|| csresult==null
				|| csprojectSupervisionName==null
				|| unitName==null
				|| paddingTime==null){
			return ImplementAction.BAD_REQUEST;
		}
		
		/*
		 * waitting for Attachment part 
		 */
		
		
		Compareselectinfo csi=new Compareselectinfo(user, project, 
				csnumber, cscandidateName, _cstime, csresult, _cscontractFunds, 
				csprojectSupervisionName, unitName, _paddingTime, tableComment, 
				compareselectinfoAttachments);
		
		Set csiSet=project.getDirectlyexecuteinfos();
		if(csiSet!=null&&!csiSet.isEmpty()){
			csi.setCompareselectinfoId(
					((Compareselectinfo)csiSet.toArray()[0]).getCompareselectinfoId()
					);
		}
		
		if(CompareselectinfoService.saveOrUpdate(csi)==1){
			
			/**
			 * watting for Update Project Status 
			 */
			
			return ImplementAction.CS_S_SUCCESS;
		}
		return ImplementAction.FAILED;
	}
	
	
	/**
	 * @TODO:比选参数转化器
	 * @author Dong 
	 * @date 2014-7-23上午9:56:02
	 */
	private void paramConverterForCS(){
		paramConverterForPublic();
		
		try{
			_cscontractFunds=Float.parseFloat(cscontractFunds);
		}catch(Exception e){
			_cscontractFunds=-1;
		}
		
		_cstime=Tool.toDate(cstime);
		
	}
	
	
	/**
	 * @TODO:保存自建情况信息的方法
	 * @author Dong 
	 * @date 2014-7-22下午3:34:29
	 */
	private String saveSelfBuildInfo(Project project,User user){
		if(!checkAvalid(project, user, ImplementAction.SELF_BUILD)){
			return ImplementAction.BAD_REQUEST;
		}
		
		paramConverterForSB();
		
		if(sbprojectLeaderName==null
				|| sbprojectLeaderTel==null
				|| sbmaterialsPurchaseName==null
				|| sbmaterialsPurchaseTel==null
				|| writeTableName==null
				|| unitName==null
				|| paddingTime==null){
			return ImplementAction.BAD_REQUEST;
		}
		
		/*
		 * waitting for Attachment part 
		 */
		
		Selfbuildinfo sbi=new Selfbuildinfo(user, project, sbprojectLeaderName, 
				sbprojectLeaderTel, sbmaterialsPurchaseName, sbmaterialsPurchaseTel, 
				writeTableName, unitName, _paddingTime, tableComment, 
				selfbuildinfoAttachments);
		
		Set sbiSet=project.getDirectlyexecuteinfos();
		if(sbiSet!=null&&!sbiSet.isEmpty()){
			sbi.setSelfbuildinfoId(
					((Selfbuildinfo)sbiSet.toArray()[0]).getSelfbuildinfoId()
					);
		}
		
		if(SelfbuildinfoService.saveOrUpdate(sbi)==1){
			
			/**
			 * watting for Update Project Status 
			 */
			
			return ImplementAction.SB_S_SUCCESS;
		}
		return ImplementAction.FAILED;
	}

	

	/**
	 * @TODO:自建参数转化器
	 * @author Dong 
	 * @date 2014-7-23上午9:56:36
	 */
	private void paramConverterForSB(){
		paramConverterForPublic();
	}
	

	/**
	 * @TODO:Requst 参数转换 公共业务部分
	 * @author Dong 
	 * @date 2014-7-22下午8:27:43
	 */
	private void paramConverterForPublic(){
		_paddingTime=Tool.toDateTime(paddingTime);
	}
	

	
	/**
	 * @TODO:提交情况信息方法
	 * @author Dong 
	 * @date 2014-7-23上午8:43:41
	 */
	private String commitInfo(int method){
		Project project=ProjectService.getProjectByID(proID);
		if(user==null){
			return DID_NOT_LOGIN;
		}
		
		String result="";
		switch(method){
		case ImplementAction.JOB_COMPET:			
			result=saveJobCompetitionInfo(project,user);
			break;
		case ImplementAction.DIR_EXEC:
			result=saveDirectlyExecteInfo(project, user);
			break;
		case ImplementAction.COMP_SELECT:
			result=saveCompareSelectInfo(project, user);
			break;
		case ImplementAction.SELF_BUILD:
			result=saveSelfBuildInfo(project, user);
			break;
		default:
			return ImplementAction.BAD_REQUEST;
		}
		if(!(
				result.equals(ImplementAction.JC_S_SUCCESS)||
				result.equals(ImplementAction.DE_S_SUCCESS)||
				result.equals(ImplementAction.CS_S_SUCCESS)||
				result.equals(ImplementAction.SB_S_SUCCESS)

				)){
			return result;
		}
		
		String proType=project.getProType();
		int newStatus=0;
		if(proType.equals(Constant.BASIC_DEVICES)){
			newStatus=Constant.PROJECT_PROGRESS_SUPERVISION;
		}else if(proType.equals(Constant.PUBLIC_SERVICE)){
			newStatus= Constant.PROJECT_FUNDS_SUPERVISION;
		}else{
			return ImplementAction.FAILED;
		}
		
		if(ProjectService.updateProStatus(proID,newStatus)==1){
			switch(method){
			case ImplementAction.JOB_COMPET:			
				return ImplementAction.JC_C_SUCCESS;
			case ImplementAction.DIR_EXEC:
				return ImplementAction.DE_C_SUCCESS;
			case ImplementAction.COMP_SELECT:
				return ImplementAction.CS_C_SUCCESS;
			case ImplementAction.SELF_BUILD:
				return ImplementAction.SB_C_SUCCESS;
			default:
				return ImplementAction.BAD_REQUEST;
			}
			//return C_SUCCESS;
		}
		return ImplementAction.FAILED;
	}

	/**
	 * @TODO:反馈列表方法
	 * @author Dong 
	 * @date 2014-7-24下午8:59:41
	 */
	private String getListPage(int kind){
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
			switch(kind){
			case ImplementAction.COMP_SELECT:
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_IMPLEMENT, Constant.COMPARE_SELECT);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_IMPLEMENT, Constant.COMPARE_SELECT);
				break;
			case ImplementAction.JOB_COMPET:
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_IMPLEMENT, Constant.JOB_COMPET);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_IMPLEMENT, Constant.JOB_COMPET);
				break;
			case ImplementAction.DIR_EXEC:
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_IMPLEMENT, Constant.DIR_EXEC);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_IMPLEMENT, Constant.DIR_EXEC);
				break;
			case ImplementAction.SELF_BUILD:
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_IMPLEMENT, Constant.SELF_BUILD);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_IMPLEMENT, Constant.SELF_BUILD);
				break;
			default:
				dataList=ProjectService.getProjectList(loc, pageSize, 
						nowPage, Constant.PROJECT_IMPLEMENT, null);
				intRowCount=ProjectService.getProjectListRowCount(loc, 
						Constant.PROJECT_IMPLEMENT, null);
			}
			intPageCount =(intRowCount + intPageSizeValue - 1) / intPageSizeValue;

			request.setAttribute("itemList", dataList);
			request.setAttribute("keyword", keyword);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("intRowCount", intRowCount);
			request.setAttribute("intPageCount", intPageCount);
			request.setAttribute("intPageSize", intPageSizeValue);
			switch(kind){
			case ImplementAction.COMP_SELECT:
				request.setAttribute("TITLE_STR", "实施阶段项目(比选类)列表");
				break;
			case ImplementAction.JOB_COMPET:
				request.setAttribute("TITLE_STR", "实施阶段项目(竞岗类)列表");
				break;
			case ImplementAction.DIR_EXEC:
				request.setAttribute("TITLE_STR","实施阶段项目(直接实施类)列表");
				break;
			case ImplementAction.SELF_BUILD:
				request.setAttribute("TITLE_STR", "实施阶段项目(自建类)列表");
				break;
			default:
				request.setAttribute("TITLE_STR", "实施阶段项目列表");
			}
		} catch (Exception e) {
			errLog.error("这是错误信息：", e);
			dataList = null;
			intRowCount = 0;
			intPageCount = 0;
			request.setAttribute("msg", "程序错误：" + e.getMessage());
			return FAILED;
		}
		return JUMP_TO_LIST;
	}
	
	
	private String getInfoPage(Project project,int impMethod){
		if(user==null){
			return DID_NOT_LOGIN;
		}
		if(project==null){
			return BAD_REQUEST;
		}
		Object info;
		Set set=null;
		if(impMethod==ImplementAction.ALL_METHOD){
			String method=project.getImpleMethod();
			if(method.equals(Constant.JOB_COMPET)){
				impMethod=ImplementAction.JOB_COMPET;
			}else if(method.equals(Constant.DIR_EXEC)){
				impMethod=ImplementAction.DIR_EXEC;
			}else if(method.equals(Constant.COMPARE_SELECT)){
				impMethod=ImplementAction.COMP_SELECT;
			}else if(method.equals(Constant.SELF_BUILD)){
				impMethod=ImplementAction.SELF_BUILD;
			}else{
				return BAD_REQUEST;
			}
		}
		switch(impMethod){
		case ImplementAction.JOB_COMPET:
			set=project.getJobcompetitioninfos();
			if(set!=null&&!set.isEmpty()){
				info=(Jobcompetitioninfo)set.toArray()[0];
			}else{
				info=null;
			}
			break;
		case ImplementAction.DIR_EXEC:
			set=project.getDirectlyexecuteinfos();
			if(set!=null&&!set.isEmpty()){
				info=(Directlyexecuteinfo)set.toArray()[0];
			}else{
				info=null;
			}
			break;
		case ImplementAction.COMP_SELECT:
			set=project.getCompareselectinfos();
			if(set!=null&&!set.isEmpty()){
				info=(Compareselectinfo)set.toArray()[0];
			}else{
				info=null;
			}
			break;
		case ImplementAction.SELF_BUILD:
			set=project.getSelfbuildinfos();
			if(set!=null&&!set.isEmpty()){
				info=(Selfbuildinfo)set.toArray()[0];
			}else{
				info=null;
			}
			break;
		default:
			return BAD_REQUEST;
		}
		
		if(request!=null){
			request.setAttribute("PROJECT", project);
			request.setAttribute("INSTANCE", info);
			
			if(checkAvalid(project, user, impMethod)){
				request.setAttribute("EDITABLE", "true");
			}else{
				request.setAttribute("EDITABLE", "false");
			}
			switch(impMethod){
			case ImplementAction.JOB_COMPET:
				return JUMP_TO_JCI;
			case ImplementAction.COMP_SELECT:
				return JUMP_TO_CSI;
			case ImplementAction.DIR_EXEC:
				return JUMP_TO_DEI;
			case ImplementAction.SELF_BUILD:
				return JUMP_TO_SBI;
			}
		}
		return BAD_REQUEST;
	}
	
	
////////////////////////////  TOOLS  ////////////////////////////////
	
	/**
	 * @TODO:检测项目实例是否在实施状态及采用哪种方式
	 * @author Dong 
	 * @date 2014-7-22下午3:28:12
	 */
	private int checkActionType(Project project){
		if(project!=null&&project.getProStatus()==Constant.PROJECT_IMPLEMENT){
			String method=project.getImpleMethod();
			if(method.equals(Constant.COMPARE_SELECT)){
				return ImplementAction.COMP_SELECT;
			}
			else if(method.equals(Constant.DIR_EXEC)){
				return ImplementAction.DIR_EXEC;
			}
			else if(method.equals(Constant.JOB_COMPET)){
				return ImplementAction.JOB_COMPET;
			}
			else if(method.equals(Constant.SELF_BUILD)){
				return ImplementAction.SELF_BUILD;
			}
			else{
				return ImplementAction.INVALID;
			}
		}
		return ImplementAction.INVALID;
	}
	
	/**
	 * @TODO:检查项目当前是否可以被某用户填写某种实施方法情况信息
	 * @author Dong 
	 * @date 2014-7-22下午4:29:24
	 */
	private boolean checkAvalid(Project project,User user,int method){
		if(project==null||checkActionType(project)!=method){
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

	
	
	
	
//////////////////////////////       getter & setter   ///////////////////////	
	
	/**
	 * getters & setters
	 */
	
	
	/**
	 * @TODO: ProID's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getProID() {
		return proID;
	}

	/**
	 * @TODO: proID's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setProID(String proID) {
		this.proID = proID;
	}

	/**
	 * @TODO: userID's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @TODO: userID's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @TODO: jobName's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @TODO: jobName's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @TODO: jobPay's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getJobPay() {
		return jobPay;
	}

	/**
	 * @TODO: jobPay's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJobPay(String jobPay) {
		this.jobPay = jobPay;
	}

	/**
	 * @TODO: jobDescription's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @TODO: jobDescription's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @TODO: jobRequirement's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getJobRequirement() {
		return jobRequirement;
	}

	/**
	 * @TODO: jobRequirement's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	/**
	 * @TODO: peopleName's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getPeopleName() {
		return peopleName;
	}

	/**
	 * @TODO: peopleName's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	/**
	 * @TODO: competitionTime's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getCompetitionTime() {
		return competitionTime;
	}

	/**
	 * @TODO: competitionTime's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setCompetitionTime(String competitionTime) {
		this.competitionTime = competitionTime;
	}

	/**
	 * @TODO: competitionResult's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getCompetitionResult() {
		return competitionResult;
	}

	/**
	 * @TODO: competitionResult's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setCompetitionResult(String competitionResult) {
		this.competitionResult = competitionResult;
	}

	/**
	 * @TODO: contractFunds's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getContractFunds() {
		return contractFunds;
	}

	/**
	 * @TODO: contractFunds's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setContractFunds(String contractFunds) {
		this.contractFunds = contractFunds;
	}

	/**
	 * @TODO: jcicheckResult's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getJcicheckResult() {
		return jcicheckResult;
	}

	/**
	 * @TODO: jcicheckResult's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJcicheckResult(String jcicheckResult) {
		this.jcicheckResult = jcicheckResult;
	}

	/**
	 * @TODO: unitName's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @TODO: unitName's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @TODO: paddingTime's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getPaddingTime() {
		return paddingTime;
	}

	/**
	 * @TODO: paddingTime's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setPaddingTime(String paddingTime) {
		this.paddingTime = paddingTime;
	}

	/**
	 * @TODO: tableComment's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public String getTableComment() {
		return tableComment;
	}

	/**
	 * @TODO: tableComment's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	/**
	 * @TODO: jobcompetitioninfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public Set getJobcompetitioninfoAttachments() {
		return jobcompetitioninfoAttachments;
	}

	/**
	 * @TODO: jobcompetitioninfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22
	 */
	public void setJobcompetitioninfoAttachments(Set jobcompetitioninfoAttachments) {
		this.jobcompetitioninfoAttachments = jobcompetitioninfoAttachments;
	}

	/**
	 * @TODO: projectLeaderName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getProjectLeaderName() {
		return projectLeaderName;
	}

	/**
	 * @TODO: projectLeaderName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setProjectLeaderName(String projectLeaderName) {
		this.projectLeaderName = projectLeaderName;
	}

	/**
	 * @TODO: projectLeaderTel's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getProjectLeaderTel() {
		return projectLeaderTel;
	}

	/**
	 * @TODO: projectLeaderTel's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setProjectLeaderTel(String projectLeaderTel) {
		this.projectLeaderTel = projectLeaderTel;
	}

	/**
	 * @TODO: projectSupervisionName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getProjectSupervisionName() {
		return projectSupervisionName;
	}

	/**
	 * @TODO: projectSupervisionName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setProjectSupervisionName(String projectSupervisionName) {
		this.projectSupervisionName = projectSupervisionName;
	}

	/**
	 * @TODO: projectSupervisionTel's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getProjectSupervisionTel() {
		return projectSupervisionTel;
	}

	/**
	 * @TODO: projectSupervisionTel's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setProjectSupervisionTel(String projectSupervisionTel) {
		this.projectSupervisionTel = projectSupervisionTel;
	}

	/**
	 * @TODO: directlyexecuteinfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public Set getDirectlyexecuteinfoAttachments() {
		return directlyexecuteinfoAttachments;
	}

	/**
	 * @TODO: directlyexecuteinfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setDirectlyexecuteinfoAttachments(Set directlyexecuteinfoAttachments) {
		this.directlyexecuteinfoAttachments = directlyexecuteinfoAttachments;
	}

	/**
	 * @TODO: csnumber's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCsnumber() {
		return csnumber;
	}

	/**
	 * @TODO: csnumber's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCsnumber(String csnumber) {
		this.csnumber = csnumber;
	}

	/**
	 * @TODO: cscontractFunds's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCscontractFunds() {
		return cscontractFunds;
	}

	/**
	 * @TODO: cscontractFunds's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCscontractFunds(String cscontractFunds) {
		this.cscontractFunds = cscontractFunds;
	}

	/**
	 * @TODO: csresult's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCsresult() {
		return csresult;
	}

	/**
	 * @TODO: csresult's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCsresult(String csresult) {
		this.csresult = csresult;
	}

	/**
	 * @TODO: cscandidateName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCscandidateName() {
		return cscandidateName;
	}

	/**
	 * @TODO: cscandidateName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCscandidateName(String cscandidateName) {
		this.cscandidateName = cscandidateName;
	}

	/**
	 * @TODO: cstime's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCstime() {
		return cstime;
	}

	/**
	 * @TODO: cstime's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCstime(String cstime) {
		this.cstime = cstime;
	}

	/**
	 * @TODO: csprojectSupervisionName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getCsprojectSupervisionName() {
		return csprojectSupervisionName;
	}

	/**
	 * @TODO: csprojectSupervisionName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCsprojectSupervisionName(String csprojectSupervisionName) {
		this.csprojectSupervisionName = csprojectSupervisionName;
	}

	/**
	 * @TODO: compareselectinfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public Set getCompareselectinfoAttachments() {
		return compareselectinfoAttachments;
	}

	/**
	 * @TODO: compareselectinfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setCompareselectinfoAttachments(Set compareselectinfoAttachments) {
		this.compareselectinfoAttachments = compareselectinfoAttachments;
	}

	/**
	 * @TODO: selfbuildinfoAttachments's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public Set getSelfbuildinfoAttachments() {
		return selfbuildinfoAttachments;
	}

	/**
	 * @TODO: selfbuildinfoAttachments's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setSelfbuildinfoAttachments(Set selfbuildinfoAttachments) {
		this.selfbuildinfoAttachments = selfbuildinfoAttachments;
	}

	/**
	 * @TODO: writeTableName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getWriteTableName() {
		return writeTableName;
	}

	/**
	 * @TODO: writeTableName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setWriteTableName(String writeTableName) {
		this.writeTableName = writeTableName;
	}

	/**
	 * @TODO: sbmaterialsPurchaseTel's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getSbmaterialsPurchaseTel() {
		return sbmaterialsPurchaseTel;
	}

	/**
	 * @TODO: sbmaterialsPurchaseTel's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setSbmaterialsPurchaseTel(String sbmaterialsPurchaseTel) {
		this.sbmaterialsPurchaseTel = sbmaterialsPurchaseTel;
	}

	/**
	 * @TODO: sbmaterialsPurchaseName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getSbmaterialsPurchaseName() {
		return sbmaterialsPurchaseName;
	}

	/**
	 * @TODO: sbmaterialsPurchaseName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setSbmaterialsPurchaseName(String sbmaterialsPurchaseName) {
		this.sbmaterialsPurchaseName = sbmaterialsPurchaseName;
	}

	/**
	 * @TODO: sbprojectLeaderTel's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getSbprojectLeaderTel() {
		return sbprojectLeaderTel;
	}

	/**
	 * @TODO: sbprojectLeaderTel's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setSbprojectLeaderTel(String sbprojectLeaderTel) {
		this.sbprojectLeaderTel = sbprojectLeaderTel;
	}

	/**
	 * @TODO: sbprojectLeaderName's getter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public String getSbprojectLeaderName() {
		return sbprojectLeaderName;
	}

	/**
	 * @TODO: sbprojectLeaderName's setter
	 * @author Dong
	 * @Date 2014-7-22下午5:37:18
	 */
	public void setSbprojectLeaderName(String sbprojectLeaderName) {
		this.sbprojectLeaderName = sbprojectLeaderName;
	}
}
