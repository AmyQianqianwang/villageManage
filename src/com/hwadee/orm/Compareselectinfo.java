package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compareselectinfo entity. @author MyEclipse Persistence Tools
 */

public class Compareselectinfo implements java.io.Serializable {

	// Fields

	private Integer compareselectinfoId;
	private User user;
	private Project project;
	private String csnumber;
	private String cscandidateName;
	private Date cstime;
	private String csresult;
	private float cscontractFunds;
	private String csprojectSupervisionName;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set compareselectinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Compareselectinfo() {
	}

	/** minimal constructor */
	public Compareselectinfo(User user, Project project, String csnumber,
			String cscandidateName, Date cstime, String csresult,
			String csprojectSupervisionName, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.csnumber = csnumber;
		this.cscandidateName = cscandidateName;
		this.cstime = cstime;
		this.csresult = csresult;
		this.csprojectSupervisionName = csprojectSupervisionName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Compareselectinfo(User user, Project project, String csnumber,
			String cscandidateName, Date cstime, String csresult,
			float cscontractFunds, String csprojectSupervisionName,
			String unitName, Date paddingTime, String tableComment,
			Set compareselectinfoAttachments) {
		this.user = user;
		this.project = project;
		this.csnumber = csnumber;
		this.cscandidateName = cscandidateName;
		this.cstime = cstime;
		this.csresult = csresult;
		this.cscontractFunds = cscontractFunds;
		this.csprojectSupervisionName = csprojectSupervisionName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.compareselectinfoAttachments = compareselectinfoAttachments;
	}

	// Property accessors

	public Integer getCompareselectinfoId() {
		return this.compareselectinfoId;
	}

	public void setCompareselectinfoId(Integer compareselectinfoId) {
		this.compareselectinfoId = compareselectinfoId;
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

	public String getCsnumber() {
		return this.csnumber;
	}

	public void setCsnumber(String csnumber) {
		this.csnumber = csnumber;
	}

	public String getCscandidateName() {
		return this.cscandidateName;
	}

	public void setCscandidateName(String cscandidateName) {
		this.cscandidateName = cscandidateName;
	}

	public Date getCstime() {
		return this.cstime;
	}

	public void setCstime(Date cstime) {
		this.cstime = cstime;
	}

	public String getCsresult() {
		return this.csresult;
	}

	public void setCsresult(String csresult) {
		this.csresult = csresult;
	}

	public float getCscontractFunds() {
		return this.cscontractFunds;
	}

	public void setCscontractFunds(float cscontractFunds) {
		this.cscontractFunds = cscontractFunds;
	}

	public String getCsprojectSupervisionName() {
		return this.csprojectSupervisionName;
	}

	public void setCsprojectSupervisionName(String csprojectSupervisionName) {
		this.csprojectSupervisionName = csprojectSupervisionName;
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

	public Set getCompareselectinfoAttachments() {
		return this.compareselectinfoAttachments;
	}

	public void setCompareselectinfoAttachments(Set compareselectinfoAttachments) {
		this.compareselectinfoAttachments = compareselectinfoAttachments;
	}

}