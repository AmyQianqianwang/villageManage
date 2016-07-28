package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Completeeditioninfo entity. @author MyEclipse Persistence Tools
 */

public class Completeeditioninfo implements java.io.Serializable {

	// Fields

	private Integer completeeditioninfoId;
	private User user;
	private Project project;
	private boolean needEdit;
	private String editContext;
	private boolean goIntoVote;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set completeeditioninfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Completeeditioninfo() {
	}

	/** minimal constructor */
	public Completeeditioninfo(User user, Project project, boolean needEdit,
			String editContext, boolean goIntoVote, String unitName,
			Date paddingTime) {
		this.user = user;
		this.project = project;
		this.needEdit = needEdit;
		this.editContext = editContext;
		this.goIntoVote = goIntoVote;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Completeeditioninfo(User user, Project project, boolean needEdit,
			String editContext, boolean goIntoVote, String unitName,
			Date paddingTime, String tableComment,
			Set completeeditioninfoAttachments) {
		this.user = user;
		this.project = project;
		this.needEdit = needEdit;
		this.editContext = editContext;
		this.goIntoVote = goIntoVote;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.completeeditioninfoAttachments = completeeditioninfoAttachments;
	}

	// Property accessors

	public Integer getCompleteeditioninfoId() {
		return this.completeeditioninfoId;
	}

	public void setCompleteeditioninfoId(Integer completeeditioninfoId) {
		this.completeeditioninfoId = completeeditioninfoId;
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

	public boolean getNeedEdit() {
		return this.needEdit;
	}

	public void setNeedEdit(boolean needEdit) {
		this.needEdit = needEdit;
	}

	public String getEditContext() {
		return this.editContext;
	}

	public void setEditContext(String editContext) {
		this.editContext = editContext;
	}

	public boolean getGoIntoVote() {
		return this.goIntoVote;
	}

	public void setGoIntoVote(boolean goIntoVote) {
		this.goIntoVote = goIntoVote;
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

	public Set getCompleteeditioninfoAttachments() {
		return this.completeeditioninfoAttachments;
	}

	public void setCompleteeditioninfoAttachments(
			Set completeeditioninfoAttachments) {
		this.completeeditioninfoAttachments = completeeditioninfoAttachments;
	}

}