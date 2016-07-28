package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementplanfundsbuget entity. @author MyEclipse Persistence Tools
 */

public class Implementplanfundsbuget implements java.io.Serializable {

	// Fields

	private Integer implementplanfundsbugetId;
	private User user;
	private Project project;
	private String implePlan;
	private float specialFund;
	private float selfFund;
	private float meltFund;
	private Integer maturities;
	private float otherFund;
	private float totalFund;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set implementplanfundsbugetAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Implementplanfundsbuget() {
	}

	/** minimal constructor */
	public Implementplanfundsbuget(User user, Project project,
			String implePlan, float specialFund, float selfFund,
			float meltFund, Integer maturities, float otherFund,
			float totalFund, String unitName, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.implePlan = implePlan;
		this.specialFund = specialFund;
		this.selfFund = selfFund;
		this.meltFund = meltFund;
		this.maturities = maturities;
		this.otherFund = otherFund;
		this.totalFund = totalFund;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Implementplanfundsbuget(User user, Project project,
			String implePlan, float specialFund, float selfFund,
			float meltFund, Integer maturities, float otherFund,
			float totalFund, String unitName, Date paddingTime,
			String tableComment, Set implementplanfundsbugetAttachments) {
		this.user = user;
		this.project = project;
		this.implePlan = implePlan;
		this.specialFund = specialFund;
		this.selfFund = selfFund;
		this.meltFund = meltFund;
		this.maturities = maturities;
		this.otherFund = otherFund;
		this.totalFund = totalFund;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.implementplanfundsbugetAttachments = implementplanfundsbugetAttachments;
	}

	// Property accessors

	public Integer getImplementplanfundsbugetId() {
		return this.implementplanfundsbugetId;
	}

	public void setImplementplanfundsbugetId(Integer implementplanfundsbugetId) {
		this.implementplanfundsbugetId = implementplanfundsbugetId;
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

	public String getImplePlan() {
		return this.implePlan;
	}

	public void setImplePlan(String implePlan) {
		this.implePlan = implePlan;
	}

	public float getSpecialFund() {
		return this.specialFund;
	}

	public void setSpecialFund(float specialFund) {
		this.specialFund = specialFund;
	}

	public float getSelfFund() {
		return this.selfFund;
	}

	public void setSelfFund(float selfFund) {
		this.selfFund = selfFund;
	}

	public float getMeltFund() {
		return this.meltFund;
	}

	public void setMeltFund(float meltFund) {
		this.meltFund = meltFund;
	}

	public Integer getMaturities() {
		return this.maturities;
	}

	public void setMaturities(Integer maturities) {
		this.maturities = maturities;
	}

	public float getOtherFund() {
		return this.otherFund;
	}

	public void setOtherFund(float otherFund) {
		this.otherFund = otherFund;
	}

	public float getTotalFund() {
		return this.totalFund;
	}

	public void setTotalFund(float totalFund) {
		this.totalFund = totalFund;
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

	public Set getImplementplanfundsbugetAttachments() {
		return this.implementplanfundsbugetAttachments;
	}

	public void setImplementplanfundsbugetAttachments(
			Set implementplanfundsbugetAttachments) {
		this.implementplanfundsbugetAttachments = implementplanfundsbugetAttachments;
	}

}