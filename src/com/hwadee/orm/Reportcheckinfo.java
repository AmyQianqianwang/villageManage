package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reportcheckinfo entity. @author MyEclipse Persistence Tools
 */

public class Reportcheckinfo implements java.io.Serializable {

	// Fields

	private Integer reportcheckinfoId;
	private User user;
	private Project project;
	private String countryCheckResult;
	private String companyCheckResult;
	private String cityCheckResult;
	private boolean checkResult;
	private String writeTableName;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set reportcheckinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Reportcheckinfo() {
	}

	/** minimal constructor */
	public Reportcheckinfo(User user, Project project, String writeTableName,
			String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Reportcheckinfo(User user, Project project,
			String countryCheckResult, String companyCheckResult,
			String cityCheckResult, boolean checkResult, String writeTableName,
			String unitName, Date paddingTime, String tableComment,
			Set reportcheckinfoAttachments) {
		this.user = user;
		this.project = project;
		this.countryCheckResult = countryCheckResult;
		this.companyCheckResult = companyCheckResult;
		this.cityCheckResult = cityCheckResult;
		this.checkResult = checkResult;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.reportcheckinfoAttachments = reportcheckinfoAttachments;
	}

	// Property accessors

	public Integer getReportcheckinfoId() {
		return this.reportcheckinfoId;
	}

	public void setReportcheckinfoId(Integer reportcheckinfoId) {
		this.reportcheckinfoId = reportcheckinfoId;
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

	public String getCountryCheckResult() {
		return this.countryCheckResult;
	}

	public void setCountryCheckResult(String countryCheckResult) {
		this.countryCheckResult = countryCheckResult;
	}

	public String getCompanyCheckResult() {
		return this.companyCheckResult;
	}

	public void setCompanyCheckResult(String companyCheckResult) {
		this.companyCheckResult = companyCheckResult;
	}

	public String getCityCheckResult() {
		return this.cityCheckResult;
	}

	public void setCityCheckResult(String cityCheckResult) {
		this.cityCheckResult = cityCheckResult;
	}

	public boolean getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(boolean checkResult) {
		this.checkResult = checkResult;
	}

	public String getWriteTableName() {
		return this.writeTableName;
	}

	public void setWriteTableName(String writeTableName) {
		this.writeTableName = writeTableName;
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

	public Set getReportcheckinfoAttachments() {
		return this.reportcheckinfoAttachments;
	}

	public void setReportcheckinfoAttachments(Set reportcheckinfoAttachments) {
		this.reportcheckinfoAttachments = reportcheckinfoAttachments;
	}

}