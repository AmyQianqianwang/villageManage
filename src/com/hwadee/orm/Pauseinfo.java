package com.hwadee.orm;

import java.util.Date;

/**
 * Pauseinfo entity. @author MyEclipse Persistence Tools
 */

public class Pauseinfo implements java.io.Serializable {

	// Fields

	private Integer pauseId;
	private User user;
	private Project project;
	private Date eiimplementTime;
	private String pauseReason;
	private String proponent;
	private Date pauseTime;
	private String reasonDescription;
	private String handlingSuggestion;
	private String unitName;
	private Date paddingTime;
	private String tableComment;

	// Constructors

	/** default constructor */
	public Pauseinfo() {
	}

	/** minimal constructor */
	public Pauseinfo(User user, Project project, Date eiimplementTime,
			Date pauseTime, String reasonDescription,
			String handlingSuggestion, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.eiimplementTime = eiimplementTime;
		this.pauseTime = pauseTime;
		this.reasonDescription = reasonDescription;
		this.handlingSuggestion = handlingSuggestion;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Pauseinfo(User user, Project project, Date eiimplementTime,
			String pauseReason, String proponent, Date pauseTime,
			String reasonDescription, String handlingSuggestion,
			String unitName, Date paddingTime, String tableComment) {
		this.user = user;
		this.project = project;
		this.eiimplementTime = eiimplementTime;
		this.pauseReason = pauseReason;
		this.proponent = proponent;
		this.pauseTime = pauseTime;
		this.reasonDescription = reasonDescription;
		this.handlingSuggestion = handlingSuggestion;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
	}

	// Property accessors

	public Integer getPauseId() {
		return this.pauseId;
	}

	public void setPauseId(Integer pauseId) {
		this.pauseId = pauseId;
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

	public Date getEiimplementTime() {
		return this.eiimplementTime;
	}

	public void setEiimplementTime(Date eiimplementTime) {
		this.eiimplementTime = eiimplementTime;
	}

	public String getPauseReason() {
		return this.pauseReason;
	}

	public void setPauseReason(String pauseReason) {
		this.pauseReason = pauseReason;
	}

	public String getProponent() {
		return this.proponent;
	}

	public void setProponent(String proponent) {
		this.proponent = proponent;
	}

	public Date getPauseTime() {
		return this.pauseTime;
	}

	public void setPauseTime(Date pauseTime) {
		this.pauseTime = pauseTime;
	}

	public String getReasonDescription() {
		return this.reasonDescription;
	}

	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}

	public String getHandlingSuggestion() {
		return this.handlingSuggestion;
	}

	public void setHandlingSuggestion(String handlingSuggestion) {
		this.handlingSuggestion = handlingSuggestion;
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

}