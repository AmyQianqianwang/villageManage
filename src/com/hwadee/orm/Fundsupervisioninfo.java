package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Fundsupervisioninfo entity. @author MyEclipse Persistence Tools
 */

public class Fundsupervisioninfo implements java.io.Serializable {

	// Fields

	private Integer fundsupervisioninfoId;
	private User user;
	private Project project;
	private String fsisupervisionName;
	private Integer fsino;
	private Date fsitime;
	private float costFund;
	private float balance;
	private String fsicheckResult;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set fundsupervisioninfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Fundsupervisioninfo() {
	}

	/** minimal constructor */
	public Fundsupervisioninfo(User user, Project project,
			String fsisupervisionName, Integer fsino, Date fsitime,
			float costFund, float balance, String fsicheckResult,
			String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.fsisupervisionName = fsisupervisionName;
		this.fsino = fsino;
		this.fsitime = fsitime;
		this.costFund = costFund;
		this.balance = balance;
		this.fsicheckResult = fsicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Fundsupervisioninfo(User user, Project project,
			String fsisupervisionName, Integer fsino, Date fsitime,
			float costFund, float balance, String fsicheckResult,
			String unitName, Date paddingTime, String tableComment,
			Set fundsupervisioninfoAttachments) {
		this.user = user;
		this.project = project;
		this.fsisupervisionName = fsisupervisionName;
		this.fsino = fsino;
		this.fsitime = fsitime;
		this.costFund = costFund;
		this.balance = balance;
		this.fsicheckResult = fsicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.fundsupervisioninfoAttachments = fundsupervisioninfoAttachments;
	}

	// Property accessors

	public Integer getFundsupervisioninfoId() {
		return this.fundsupervisioninfoId;
	}

	public void setFundsupervisioninfoId(Integer fundsupervisioninfoId) {
		this.fundsupervisioninfoId = fundsupervisioninfoId;
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

	public String getFsisupervisionName() {
		return this.fsisupervisionName;
	}

	public void setFsisupervisionName(String fsisupervisionName) {
		this.fsisupervisionName = fsisupervisionName;
	}

	public Integer getFsino() {
		return this.fsino;
	}

	public void setFsino(Integer fsino) {
		this.fsino = fsino;
	}

	public Date getFsitime() {
		return this.fsitime;
	}

	public void setFsitime(Date fsitime) {
		this.fsitime = fsitime;
	}

	public float getCostFund() {
		return this.costFund;
	}

	public void setCostFund(float costFund) {
		this.costFund = costFund;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getFsicheckResult() {
		return this.fsicheckResult;
	}

	public void setFsicheckResult(String fsicheckResult) {
		this.fsicheckResult = fsicheckResult;
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

	public Set getFundsupervisioninfoAttachments() {
		return this.fundsupervisioninfoAttachments;
	}

	public void setFundsupervisioninfoAttachments(
			Set fundsupervisioninfoAttachments) {
		this.fundsupervisioninfoAttachments = fundsupervisioninfoAttachments;
	}

}