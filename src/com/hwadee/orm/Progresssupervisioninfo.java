package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Progresssupervisioninfo entity. @author MyEclipse Persistence Tools
 */

public class Progresssupervisioninfo implements java.io.Serializable {

	// Fields

	private Integer progresssupervisioninfoId;
	private User user;
	private Project project;
	private String psisupervisionName;
	private String primaryProgress;
	private String primaryProblem;
	private Date primaryTime;
	private String midProgress;
	private String midProblem;
	private Date midTime;
	private String lastProgress;
	private String lastProblem;
	private Date lastTime;
	private String psicheckResult;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set progresssupervisioninfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Progresssupervisioninfo() {
	}

	/** minimal constructor */
	public Progresssupervisioninfo(User user, Project project,
			String psisupervisionName, String primaryProgress,
			Date primaryTime, String midProgress, Date midTime,
			String lastProgress, Date lastTime, String psicheckResult,
			String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.psisupervisionName = psisupervisionName;
		this.primaryProgress = primaryProgress;
		this.primaryTime = primaryTime;
		this.midProgress = midProgress;
		this.midTime = midTime;
		this.lastProgress = lastProgress;
		this.lastTime = lastTime;
		this.psicheckResult = psicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Progresssupervisioninfo(User user, Project project,
			String psisupervisionName, String primaryProgress,
			String primaryProblem, Date primaryTime, String midProgress,
			String midProblem, Date midTime, String lastProgress,
			String lastProblem, Date lastTime, String psicheckResult,
			String unitName, Date paddingTime, String tableComment,
			Set progresssupervisioninfoAttachments) {
		this.user = user;
		this.project = project;
		this.psisupervisionName = psisupervisionName;
		this.primaryProgress = primaryProgress;
		this.primaryProblem = primaryProblem;
		this.primaryTime = primaryTime;
		this.midProgress = midProgress;
		this.midProblem = midProblem;
		this.midTime = midTime;
		this.lastProgress = lastProgress;
		this.lastProblem = lastProblem;
		this.lastTime = lastTime;
		this.psicheckResult = psicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.progresssupervisioninfoAttachments = progresssupervisioninfoAttachments;
	}

	// Property accessors

	public Integer getProgresssupervisioninfoId() {
		return this.progresssupervisioninfoId;
	}

	public void setProgresssupervisioninfoId(Integer progresssupervisioninfoId) {
		this.progresssupervisioninfoId = progresssupervisioninfoId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getPsisupervisionName() {
		return this.psisupervisionName;
	}

	public void setPsisupervisionName(String psisupervisionName) {
		this.psisupervisionName = psisupervisionName;
	}

	public String getPrimaryProgress() {
		return this.primaryProgress;
	}

	public void setPrimaryProgress(String primaryProgress) {
		this.primaryProgress = primaryProgress;
	}

	public String getPrimaryProblem() {
		return this.primaryProblem;
	}

	public void setPrimaryProblem(String primaryProblem) {
		this.primaryProblem = primaryProblem;
	}

	public Date getPrimaryTime() {
		return this.primaryTime;
	}

	public void setPrimaryTime(Date primaryTime) {
		this.primaryTime = primaryTime;
	}

	public String getMidProgress() {
		return this.midProgress;
	}

	public void setMidProgress(String midProgress) {
		this.midProgress = midProgress;
	}

	public String getMidProblem() {
		return this.midProblem;
	}

	public void setMidProblem(String midProblem) {
		this.midProblem = midProblem;
	}

	public Date getMidTime() {
		return this.midTime;
	}

	public void setMidTime(Date midTime) {
		this.midTime = midTime;
	}

	public String getLastProgress() {
		return this.lastProgress;
	}

	public void setLastProgress(String lastProgress) {
		this.lastProgress = lastProgress;
	}

	public String getLastProblem() {
		return this.lastProblem;
	}

	public void setLastProblem(String lastProblem) {
		this.lastProblem = lastProblem;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getPsicheckResult() {
		return this.psicheckResult;
	}

	public void setPsicheckResult(String psicheckResult) {
		this.psicheckResult = psicheckResult;
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

	public Set getProgresssupervisioninfoAttachments() {
		return this.progresssupervisioninfoAttachments;
	}

	public void setProgresssupervisioninfoAttachments(
			Set progresssupervisioninfoAttachments) {
		this.progresssupervisioninfoAttachments = progresssupervisioninfoAttachments;
	}

}