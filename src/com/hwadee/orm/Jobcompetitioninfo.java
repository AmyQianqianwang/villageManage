package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Jobcompetitioninfo entity. @author MyEclipse Persistence Tools
 */

public class Jobcompetitioninfo implements java.io.Serializable {

	// Fields

	private Integer jobcompetitioninfoId;
	private User user;
	private Project project;
	private String jobName;
	private float jobPay;
	private String jobDescription;
	private String jobRequirement;
	private String peopleName;
	private Date competitionTime;
	private String competitionResult;
	private float contractFunds;
	private String jcicheckResult;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set jobcompetitioninfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Jobcompetitioninfo() {
	}

	/** minimal constructor */
	public Jobcompetitioninfo(User user, Project project, String jobName,
			float jobPay, String peopleName, Date competitionTime,
			float contractFunds, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.jobName = jobName;
		this.jobPay = jobPay;
		this.peopleName = peopleName;
		this.competitionTime = competitionTime;
		this.contractFunds = contractFunds;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Jobcompetitioninfo(User user, Project project, String jobName,
			float jobPay, String jobDescription, String jobRequirement,
			String peopleName, Date competitionTime, String competitionResult,
			float contractFunds, String jcicheckResult, String unitName,
			Date paddingTime, String tableComment,
			Set jobcompetitioninfoAttachments) {
		this.user = user;
		this.project = project;
		this.jobName = jobName;
		this.jobPay = jobPay;
		this.jobDescription = jobDescription;
		this.jobRequirement = jobRequirement;
		this.peopleName = peopleName;
		this.competitionTime = competitionTime;
		this.competitionResult = competitionResult;
		this.contractFunds = contractFunds;
		this.jcicheckResult = jcicheckResult;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.jobcompetitioninfoAttachments = jobcompetitioninfoAttachments;
	}

	// Property accessors

	public Integer getJobcompetitioninfoId() {
		return this.jobcompetitioninfoId;
	}

	public void setJobcompetitioninfoId(Integer jobcompetitioninfoId) {
		this.jobcompetitioninfoId = jobcompetitioninfoId;
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

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public float getJobPay() {
		return this.jobPay;
	}

	public void setJobPay(float jobPay) {
		this.jobPay = jobPay;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobRequirement() {
		return this.jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public String getPeopleName() {
		return this.peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public Date getCompetitionTime() {
		return this.competitionTime;
	}

	public void setCompetitionTime(Date competitionTime) {
		this.competitionTime = competitionTime;
	}

	public String getCompetitionResult() {
		return this.competitionResult;
	}

	public void setCompetitionResult(String competitionResult) {
		this.competitionResult = competitionResult;
	}

	public float getContractFunds() {
		return this.contractFunds;
	}

	public void setContractFunds(float contractFunds) {
		this.contractFunds = contractFunds;
	}

	public String getJcicheckResult() {
		return this.jcicheckResult;
	}

	public void setJcicheckResult(String jcicheckResult) {
		this.jcicheckResult = jcicheckResult;
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

	public Set getJobcompetitioninfoAttachments() {
		return this.jobcompetitioninfoAttachments;
	}

	public void setJobcompetitioninfoAttachments(
			Set jobcompetitioninfoAttachments) {
		this.jobcompetitioninfoAttachments = jobcompetitioninfoAttachments;
	}

}