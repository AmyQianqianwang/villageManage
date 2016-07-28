package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Testevaluateinfo entity. @author MyEclipse Persistence Tools
 */

public class Testevaluateinfo implements java.io.Serializable {

	// Fields

	private Integer testevaluateinfoId;
	private User user;
	private Project project;
	private boolean teresult;
	private Date tetime;
	private Date implementTime;
	private Integer warrantyPeriod;
	private String teacceptName;
	private String teacceptOpinion;
	private float guaranteeMoney;
	private boolean temassesEvaluateResult;
	private String writeTableName;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set testevaluateinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Testevaluateinfo() {
	}

	/** minimal constructor */
	public Testevaluateinfo(User user, Project project, Date tetime,
			Date implementTime, Integer warrantyPeriod, String teacceptName,
			String teacceptOpinion, float guaranteeMoney,
			String writeTableName, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.tetime = tetime;
		this.implementTime = implementTime;
		this.warrantyPeriod = warrantyPeriod;
		this.teacceptName = teacceptName;
		this.teacceptOpinion = teacceptOpinion;
		this.guaranteeMoney = guaranteeMoney;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Testevaluateinfo(User user, Project project, boolean teresult,
			Date tetime, Date implementTime, Integer warrantyPeriod,
			String teacceptName, String teacceptOpinion, float guaranteeMoney,
			boolean temassesEvaluateResult, String writeTableName,
			String unitName, Date paddingTime, String tableComment,
			Set testevaluateinfoAttachments) {
		this.user = user;
		this.project = project;
		this.teresult = teresult;
		this.tetime = tetime;
		this.implementTime = implementTime;
		this.warrantyPeriod = warrantyPeriod;
		this.teacceptName = teacceptName;
		this.teacceptOpinion = teacceptOpinion;
		this.guaranteeMoney = guaranteeMoney;
		this.temassesEvaluateResult = temassesEvaluateResult;
		this.writeTableName = writeTableName;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.testevaluateinfoAttachments = testevaluateinfoAttachments;
	}

	// Property accessors

	public Integer getTestevaluateinfoId() {
		return this.testevaluateinfoId;
	}

	public void setTestevaluateinfoId(Integer testevaluateinfoId) {
		this.testevaluateinfoId = testevaluateinfoId;
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

	public boolean getTeresult() {
		return this.teresult;
	}

	public void setTeresult(boolean teresult) {
		this.teresult = teresult;
	}

	public Date getTetime() {
		return this.tetime;
	}

	public void setTetime(Date tetime) {
		this.tetime = tetime;
	}

	public Date getImplementTime() {
		return this.implementTime;
	}

	public void setImplementTime(Date implementTime) {
		this.implementTime = implementTime;
	}

	public Integer getWarrantyPeriod() {
		return this.warrantyPeriod;
	}

	public void setWarrantyPeriod(Integer warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getTeacceptName() {
		return this.teacceptName;
	}

	public void setTeacceptName(String teacceptName) {
		this.teacceptName = teacceptName;
	}

	public String getTeacceptOpinion() {
		return this.teacceptOpinion;
	}

	public void setTeacceptOpinion(String teacceptOpinion) {
		this.teacceptOpinion = teacceptOpinion;
	}

	public float getGuaranteeMoney() {
		return this.guaranteeMoney;
	}

	public void setGuaranteeMoney(float guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}

	public boolean getTemassesEvaluateResult() {
		return this.temassesEvaluateResult;
	}

	public void setTemassesEvaluateResult(boolean temassesEvaluateResult) {
		this.temassesEvaluateResult = temassesEvaluateResult;
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

	public Set getTestevaluateinfoAttachments() {
		return this.testevaluateinfoAttachments;
	}

	public void setTestevaluateinfoAttachments(Set testevaluateinfoAttachments) {
		this.testevaluateinfoAttachments = testevaluateinfoAttachments;
	}

}