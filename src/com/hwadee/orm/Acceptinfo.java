package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Acceptinfo entity. @author MyEclipse Persistence Tools
 */

public class Acceptinfo implements java.io.Serializable {

	// Fields

	private Integer acceptioninfoId;
	private User user;
	private Project project;
	private boolean acceptResult;
	private Date acceptTime;
	private String acceptName;
	private String acceptOpinion;
	private float restFund;
	private boolean aimassesEvaluateResult;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set acceptioninfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Acceptinfo() {
	}

	/** minimal constructor */
	public Acceptinfo(User user, Project project, boolean acceptResult,
			Date acceptTime, String acceptName, String acceptOpinion,
			float restFund, boolean aimassesEvaluateResult, String unitName,
			Date paddingTime) {
		this.user = user;
		this.project = project;
		this.acceptResult = acceptResult;
		this.acceptTime = acceptTime;
		this.acceptName = acceptName;
		this.acceptOpinion = acceptOpinion;
		this.restFund = restFund;
		this.aimassesEvaluateResult = aimassesEvaluateResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Acceptinfo(User user, Project project, boolean acceptResult,
			Date acceptTime, String acceptName, String acceptOpinion,
			float restFund, boolean aimassesEvaluateResult, String unitName,
			Date paddingTime, String tableComment, Set acceptioninfoAttachments) {
		this.user = user;
		this.project = project;
		this.acceptResult = acceptResult;
		this.acceptTime = acceptTime;
		this.acceptName = acceptName;
		this.acceptOpinion = acceptOpinion;
		this.restFund = restFund;
		this.aimassesEvaluateResult = aimassesEvaluateResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.acceptioninfoAttachments = acceptioninfoAttachments;
	}

	// Property accessors

	public Integer getAcceptioninfoId() {
		return this.acceptioninfoId;
	}

	public void setAcceptioninfoId(Integer acceptioninfoId) {
		this.acceptioninfoId = acceptioninfoId;
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

	public boolean getAcceptResult() {
		return this.acceptResult;
	}

	public void setAcceptResult(boolean acceptResult) {
		this.acceptResult = acceptResult;
	}

	public Date getAcceptTime() {
		return this.acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAcceptName() {
		return this.acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public String getAcceptOpinion() {
		return this.acceptOpinion;
	}

	public void setAcceptOpinion(String acceptOpinion) {
		this.acceptOpinion = acceptOpinion;
	}

	public float getRestFund() {
		return this.restFund;
	}

	public void setRestFund(float restFund) {
		this.restFund = restFund;
	}

	public boolean getAimassesEvaluateResult() {
		return this.aimassesEvaluateResult;
	}

	public void setAimassesEvaluateResult(boolean aimassesEvaluateResult) {
		this.aimassesEvaluateResult = aimassesEvaluateResult;
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

	public Set getAcceptioninfoAttachments() {
		return this.acceptioninfoAttachments;
	}

	public void setAcceptioninfoAttachments(Set acceptioninfoAttachments) {
		this.acceptioninfoAttachments = acceptioninfoAttachments;
	}

}