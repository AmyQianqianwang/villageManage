package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Selfbuildinfo entity. @author MyEclipse Persistence Tools
 */

public class Selfbuildinfo implements java.io.Serializable {

	// Fields

	private Integer selfbuildinfoId;
	private User user;
	private Project project;
	private String sbprojectLeaderName;
	private String sbprojectLeaderTel;
	private String sbmaterialsPurchaseName;
	private String sbmaterialsPurchaseTel;
	private String writeTableName;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set selfbuildinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Selfbuildinfo() {
	}

	/** minimal constructor */
	public Selfbuildinfo(User user, Project project,
			String sbprojectLeaderName, String sbprojectLeaderTel,
			String sbmaterialsPurchaseName, String sbmaterialsPurchaseTel,
			String writeTableName, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.sbprojectLeaderName = sbprojectLeaderName;
		this.sbprojectLeaderTel = sbprojectLeaderTel;
		this.sbmaterialsPurchaseName = sbmaterialsPurchaseName;
		this.sbmaterialsPurchaseTel = sbmaterialsPurchaseTel;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Selfbuildinfo(User user, Project project,
			String sbprojectLeaderName, String sbprojectLeaderTel,
			String sbmaterialsPurchaseName, String sbmaterialsPurchaseTel,
			String writeTableName, String unitName, Date paddingTime,
			String tableComment, Set selfbuildinfoAttachments) {
		this.user = user;
		this.project = project;
		this.sbprojectLeaderName = sbprojectLeaderName;
		this.sbprojectLeaderTel = sbprojectLeaderTel;
		this.sbmaterialsPurchaseName = sbmaterialsPurchaseName;
		this.sbmaterialsPurchaseTel = sbmaterialsPurchaseTel;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.selfbuildinfoAttachments = selfbuildinfoAttachments;
	}

	// Property accessors

	public Integer getSelfbuildinfoId() {
		return this.selfbuildinfoId;
	}

	public void setSelfbuildinfoId(Integer selfbuildinfoId) {
		this.selfbuildinfoId = selfbuildinfoId;
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

	public String getSbprojectLeaderName() {
		return this.sbprojectLeaderName;
	}

	public void setSbprojectLeaderName(String sbprojectLeaderName) {
		this.sbprojectLeaderName = sbprojectLeaderName;
	}

	public String getSbprojectLeaderTel() {
		return this.sbprojectLeaderTel;
	}

	public void setSbprojectLeaderTel(String sbprojectLeaderTel) {
		this.sbprojectLeaderTel = sbprojectLeaderTel;
	}

	public String getSbmaterialsPurchaseName() {
		return this.sbmaterialsPurchaseName;
	}

	public void setSbmaterialsPurchaseName(String sbmaterialsPurchaseName) {
		this.sbmaterialsPurchaseName = sbmaterialsPurchaseName;
	}

	public String getSbmaterialsPurchaseTel() {
		return this.sbmaterialsPurchaseTel;
	}

	public void setSbmaterialsPurchaseTel(String sbmaterialsPurchaseTel) {
		this.sbmaterialsPurchaseTel = sbmaterialsPurchaseTel;
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

	public Set getSelfbuildinfoAttachments() {
		return this.selfbuildinfoAttachments;
	}

	public void setSelfbuildinfoAttachments(Set selfbuildinfoAttachments) {
		this.selfbuildinfoAttachments = selfbuildinfoAttachments;
	}

}