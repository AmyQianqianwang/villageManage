package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Directlyexecuteinfo entity. @author MyEclipse Persistence Tools
 */

public class Directlyexecuteinfo implements java.io.Serializable {

	// Fields

	private Integer directlyexecuteinfoId;
	private User user;
	private Project project;
	private String projectLeaderName;
	private String projectLeaderTel;
	private String projectSupervisionName;
	private String projectSupervisionTel;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set directlyexecuteinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Directlyexecuteinfo() {
	}

	/** minimal constructor */
	public Directlyexecuteinfo(User user, Project project,
			String projectLeaderName, String projectLeaderTel,
			String projectSupervisionName, String projectSupervisionTel,
			String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.projectLeaderName = projectLeaderName;
		this.projectLeaderTel = projectLeaderTel;
		this.projectSupervisionName = projectSupervisionName;
		this.projectSupervisionTel = projectSupervisionTel;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Directlyexecuteinfo(User user, Project project,
			String projectLeaderName, String projectLeaderTel,
			String projectSupervisionName, String projectSupervisionTel,
			String unitName, Date paddingTime, String tableComment,
			Set directlyexecuteinfoAttachments) {
		this.user = user;
		this.project = project;
		this.projectLeaderName = projectLeaderName;
		this.projectLeaderTel = projectLeaderTel;
		this.projectSupervisionName = projectSupervisionName;
		this.projectSupervisionTel = projectSupervisionTel;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.directlyexecuteinfoAttachments = directlyexecuteinfoAttachments;
	}

	// Property accessors

	public Integer getDirectlyexecuteinfoId() {
		return this.directlyexecuteinfoId;
	}

	public void setDirectlyexecuteinfoId(Integer directlyexecuteinfoId) {
		this.directlyexecuteinfoId = directlyexecuteinfoId;
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

	public String getProjectLeaderName() {
		return this.projectLeaderName;
	}

	public void setProjectLeaderName(String projectLeaderName) {
		this.projectLeaderName = projectLeaderName;
	}

	public String getProjectLeaderTel() {
		return this.projectLeaderTel;
	}

	public void setProjectLeaderTel(String projectLeaderTel) {
		this.projectLeaderTel = projectLeaderTel;
	}

	public String getProjectSupervisionName() {
		return this.projectSupervisionName;
	}

	public void setProjectSupervisionName(String projectSupervisionName) {
		this.projectSupervisionName = projectSupervisionName;
	}

	public String getProjectSupervisionTel() {
		return this.projectSupervisionTel;
	}

	public void setProjectSupervisionTel(String projectSupervisionTel) {
		this.projectSupervisionTel = projectSupervisionTel;
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

	public Set getDirectlyexecuteinfoAttachments() {
		return this.directlyexecuteinfoAttachments;
	}

	public void setDirectlyexecuteinfoAttachments(
			Set directlyexecuteinfoAttachments) {
		this.directlyexecuteinfoAttachments = directlyexecuteinfoAttachments;
	}

}