package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project implements java.io.Serializable {

	// Fields

	private String proId;
	private User user;
	private Location location;
	private String proName;
	private Date recTime;
	private String proType;
	private String proKind;
	private String proContext;
	private String proSource;
	private Integer familyCount;
	private Date electTime;
	private Date planEndTime;
	private String impleMethod;
	private Integer proStatus;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set directlyexecuteinfos = new HashSet(0);
	private Set selfbuildinfos = new HashSet(0);
	private Set acceptinfos = new HashSet(0);
	private Set projectvoteinfos = new HashSet(0);
	private Set implementplanfundsbugets = new HashSet(0);
	private Set testevaluateinfos = new HashSet(0);
	private Set compareselectinfos = new HashSet(0);
	private Set pauseinfos = new HashSet(0);
	private Set jobcompetitioninfos = new HashSet(0);
	private Set proAttachments = new HashSet(0);
	private Set completeeditioninfos = new HashSet(0);
	private Set reportcheckinfos = new HashSet(0);
	private Set commentinfos = new HashSet(0);
	private Set fundsupervisioninfos = new HashSet(0);
	private Set progresssupervisioninfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(User user, Location location, String proName, Date recTime,
			String proType, String proKind, String proContext,
			String proSource, Integer familyCount, Date electTime,
			Date planEndTime, String impleMethod, Integer proStatus,
			Date paddingTime) {
		this.user = user;
		this.location = location;
		this.proName = proName;
		this.recTime = recTime;
		this.proType = proType;
		this.proKind = proKind;
		this.proContext = proContext;
		this.proSource = proSource;
		this.familyCount = familyCount;
		this.electTime = electTime;
		this.planEndTime = planEndTime;
		this.impleMethod = impleMethod;
		this.proStatus = proStatus;
		this.paddingTime = paddingTime;
		
	}

	/** full constructor */
	public Project(User user, Location location, String proName, Date recTime,
			String proType, String proKind, String proContext,
			String proSource, Integer familyCount, Date electTime,
			Date planEndTime, String impleMethod, Integer proStatus,
			String unitName, Date paddingTime, String tableComment,
			Set directlyexecuteinfos, Set selfbuildinfos, Set acceptinfos,
			Set projectvoteinfos, Set implementplanfundsbugets,
			Set testevaluateinfos, Set compareselectinfos, Set pauseinfos,
			Set jobcompetitioninfos, Set proAttachments,
			Set completeeditioninfos, Set reportcheckinfos, Set commentinfos,
			Set fundsupervisioninfos, Set progresssupervisioninfos) {
		this.user = user;
		this.location = location;
		this.proName = proName;
		this.recTime = recTime;
		this.proType = proType;
		this.proKind = proKind;
		this.proContext = proContext;
		this.proSource = proSource;
		this.familyCount = familyCount;
		this.electTime = electTime;
		this.planEndTime = planEndTime;
		this.impleMethod = impleMethod;
		this.proStatus = proStatus;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.directlyexecuteinfos = directlyexecuteinfos;
		this.selfbuildinfos = selfbuildinfos;
		this.acceptinfos = acceptinfos;
		this.projectvoteinfos = projectvoteinfos;
		this.implementplanfundsbugets = implementplanfundsbugets;
		this.testevaluateinfos = testevaluateinfos;
		this.compareselectinfos = compareselectinfos;
		this.pauseinfos = pauseinfos;
		this.jobcompetitioninfos = jobcompetitioninfos;
		this.proAttachments = proAttachments;
		this.completeeditioninfos = completeeditioninfos;
		this.reportcheckinfos = reportcheckinfos;
		this.commentinfos = commentinfos;
		this.fundsupervisioninfos = fundsupervisioninfos;
		this.progresssupervisioninfos = progresssupervisioninfos;
	}

	// Property accessors

	public String getProId() {
		return this.proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Date getRecTime() {
		return this.recTime;
	}

	public void setRecTime(Date recTime) {
		this.recTime = recTime;
	}

	public String getProType() {
		return this.proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getProKind() {
		return this.proKind;
	}

	public void setProKind(String proKind) {
		this.proKind = proKind;
	}

	public String getProContext() {
		return this.proContext;
	}

	public void setProContext(String proContext) {
		this.proContext = proContext;
	}

	public String getProSource() {
		return this.proSource;
	}

	public void setProSource(String proSource) {
		this.proSource = proSource;
	}

	public Integer getFamilyCount() {
		return this.familyCount;
	}

	public void setFamilyCount(Integer familyCount) {
		this.familyCount = familyCount;
	}

	public Date getElectTime() {
		return this.electTime;
	}

	public void setElectTime(Date electTime) {
		this.electTime = electTime;
	}

	public Date getPlanEndTime() {
		return this.planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getImpleMethod() {
		return this.impleMethod;
	}

	public void setImpleMethod(String impleMethod) {
		this.impleMethod = impleMethod;
	}

	public Integer getProStatus() {
		return this.proStatus;
	}

	public void setProStatus(Integer proStatus) {
		this.proStatus = proStatus;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Date getPaddingTime() {
		return this.paddingTime;
	}

	public void setPaddingTime(Date paddingTime) {
		this.paddingTime = paddingTime;
	}

	public String getTableComment() {
		return this.tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public Set getDirectlyexecuteinfos() {
		return this.directlyexecuteinfos;
	}

	public void setDirectlyexecuteinfos(Set directlyexecuteinfos) {
		this.directlyexecuteinfos = directlyexecuteinfos;
	}

	public Set getSelfbuildinfos() {
		return this.selfbuildinfos;
	}

	public void setSelfbuildinfos(Set selfbuildinfos) {
		this.selfbuildinfos = selfbuildinfos;
	}

	public Set getAcceptinfos() {
		return this.acceptinfos;
	}

	public void setAcceptinfos(Set acceptinfos) {
		this.acceptinfos = acceptinfos;
	}

	public Set getProjectvoteinfos() {
		return this.projectvoteinfos;
	}

	public void setProjectvoteinfos(Set projectvoteinfos) {
		this.projectvoteinfos = projectvoteinfos;
	}

	public Set getImplementplanfundsbugets() {
		return this.implementplanfundsbugets;
	}

	public void setImplementplanfundsbugets(Set implementplanfundsbugets) {
		this.implementplanfundsbugets = implementplanfundsbugets;
	}

	public Set getTestevaluateinfos() {
		return this.testevaluateinfos;
	}

	public void setTestevaluateinfos(Set testevaluateinfos) {
		this.testevaluateinfos = testevaluateinfos;
	}

	public Set getCompareselectinfos() {
		return this.compareselectinfos;
	}

	public void setCompareselectinfos(Set compareselectinfos) {
		this.compareselectinfos = compareselectinfos;
	}

	public Set getPauseinfos() {
		return this.pauseinfos;
	}

	public void setPauseinfos(Set pauseinfos) {
		this.pauseinfos = pauseinfos;
	}

	public Set getJobcompetitioninfos() {
		return this.jobcompetitioninfos;
	}

	public void setJobcompetitioninfos(Set jobcompetitioninfos) {
		this.jobcompetitioninfos = jobcompetitioninfos;
	}

	public Set getProAttachments() {
		return this.proAttachments;
	}

	public void setProAttachments(Set proAttachments) {
		this.proAttachments = proAttachments;
	}

	public Set getCompleteeditioninfos() {
		return this.completeeditioninfos;
	}

	public void setCompleteeditioninfos(Set completeeditioninfos) {
		this.completeeditioninfos = completeeditioninfos;
	}

	public Set getReportcheckinfos() {
		return this.reportcheckinfos;
	}

	public void setReportcheckinfos(Set reportcheckinfos) {
		this.reportcheckinfos = reportcheckinfos;
	}

	public Set getCommentinfos() {
		return this.commentinfos;
	}

	public void setCommentinfos(Set commentinfos) {
		this.commentinfos = commentinfos;
	}

	public Set getFundsupervisioninfos() {
		return this.fundsupervisioninfos;
	}

	public void setFundsupervisioninfos(Set fundsupervisioninfos) {
		this.fundsupervisioninfos = fundsupervisioninfos;
	}

	public Set getProgresssupervisioninfos() {
		return this.progresssupervisioninfos;
	}

	public void setProgresssupervisioninfos(Set progresssupervisioninfos) {
		this.progresssupervisioninfos = progresssupervisioninfos;
	}

}