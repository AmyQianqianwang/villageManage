package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Commentinfo entity. @author MyEclipse Persistence Tools
 */

public class Commentinfo implements java.io.Serializable {

	// Fields

	private Integer commentinfoId;
	private User user;
	private Project project;
	private Integer quarter;
	private String commentObject;
	private String commentName;
	private Date commentTime;
	private String commentSituation;
	private boolean cicheckResult;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set commentinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Commentinfo() {
	}

	/** minimal constructor */
	public Commentinfo(User user, Project project, Integer quarter,
			String commentObject, String commentName, Date commentTime,
			String commentSituation, boolean cicheckResult, String unitName,
			Date paddingTime) {
		this.user = user;
		this.project = project;
		this.quarter = quarter;
		this.commentObject = commentObject;
		this.commentName = commentName;
		this.commentTime = commentTime;
		this.commentSituation = commentSituation;
		this.cicheckResult = cicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Commentinfo(User user, Project project, Integer quarter,
			String commentObject, String commentName, Date commentTime,
			String commentSituation, boolean cicheckResult, String unitName,
			Date paddingTime, String tableComment, Set commentinfoAttachments) {
		this.user = user;
		this.project = project;
		this.quarter = quarter;
		this.commentObject = commentObject;
		this.commentName = commentName;
		this.commentTime = commentTime;
		this.commentSituation = commentSituation;
		this.cicheckResult = cicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.commentinfoAttachments = commentinfoAttachments;
	}

	// Property accessors

	public Integer getCommentinfoId() {
		return this.commentinfoId;
	}

	public void setCommentinfoId(Integer commentinfoId) {
		this.commentinfoId = commentinfoId;
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

	public Integer getQuarter() {
		return this.quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public String getCommentObject() {
		return this.commentObject;
	}

	public void setCommentObject(String commentObject) {
		this.commentObject = commentObject;
	}

	public String getCommentName() {
		return this.commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentSituation() {
		return this.commentSituation;
	}

	public void setCommentSituation(String commentSituation) {
		this.commentSituation = commentSituation;
	}

	public boolean getCicheckResult() {
		return this.cicheckResult;
	}

	public void setCicheckResult(boolean cicheckResult) {
		this.cicheckResult = cicheckResult;
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

	public Set getCommentinfoAttachments() {
		return this.commentinfoAttachments;
	}

	public void setCommentinfoAttachments(Set commentinfoAttachments) {
		this.commentinfoAttachments = commentinfoAttachments;
	}

}