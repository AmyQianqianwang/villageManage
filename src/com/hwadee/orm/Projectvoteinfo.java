package com.hwadee.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projectvoteinfo entity. @author MyEclipse Persistence Tools
 */

public class Projectvoteinfo implements java.io.Serializable {

	// Fields

	private Integer projectvoteinfoId;
	private User user;
	private Project project;
	private Integer pvtype;
	private Date voteTime;
	private Integer partCount;
	private Integer supposeCount;
	private Integer actualCount;
	private Integer attendCount;
	private Integer totalCount;
	private Integer positiveCount;
	private Integer negativeCount;
	private Integer abstentionCount;
	private boolean result;
	private String unitName;
	private Date paddingTime;
	private String tableComment;
	private Set projectvoteinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Projectvoteinfo() {
	}

	/** minimal constructor */
	public Projectvoteinfo(User user, Project project, Date voteTime,
			Integer partCount, Integer supposeCount, Integer actualCount,
			Integer attendCount, Integer totalCount, Integer positiveCount,
			Integer negativeCount, Integer abstentionCount, Date paddingTime) {
		this.user = user;
		this.project = project;
		this.voteTime = voteTime;
		this.partCount = partCount;
		this.supposeCount = supposeCount;
		this.actualCount = actualCount;
		this.attendCount = attendCount;
		this.totalCount = totalCount;
		this.positiveCount = positiveCount;
		this.negativeCount = negativeCount;
		this.abstentionCount = abstentionCount;
		this.paddingTime = paddingTime;
	}

	/** full constructor */
	public Projectvoteinfo(User user, Project project, Integer pvtype,
			Date voteTime, Integer partCount, Integer supposeCount,
			Integer actualCount, Integer attendCount, Integer totalCount,
			Integer positiveCount, Integer negativeCount,
			Integer abstentionCount, boolean result, String unitName,
			Date paddingTime, String tableComment,
			Set projectvoteinfoAttachments) {
		this.user = user;
		this.project = project;
		this.pvtype = pvtype;
		this.voteTime = voteTime;
		this.partCount = partCount;
		this.supposeCount = supposeCount;
		this.actualCount = actualCount;
		this.attendCount = attendCount;
		this.totalCount = totalCount;
		this.positiveCount = positiveCount;
		this.negativeCount = negativeCount;
		this.abstentionCount = abstentionCount;
		this.result = result;
		this.unitName = unitName;
		this.paddingTime = paddingTime;
		this.tableComment = tableComment;
		this.projectvoteinfoAttachments = projectvoteinfoAttachments;
	}

	// Property accessors

	public Integer getProjectvoteinfoId() {
		return this.projectvoteinfoId;
	}

	public void setProjectvoteinfoId(Integer projectvoteinfoId) {
		this.projectvoteinfoId = projectvoteinfoId;
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

	public Integer getPvtype() {
		return this.pvtype;
	}

	public void setPvtype(Integer pvtype) {
		this.pvtype = pvtype;
	}

	public Date getVoteTime() {
		return this.voteTime;
	}

	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}

	public Integer getPartCount() {
		return this.partCount;
	}

	public void setPartCount(Integer partCount) {
		this.partCount = partCount;
	}

	public Integer getSupposeCount() {
		return this.supposeCount;
	}

	public void setSupposeCount(Integer supposeCount) {
		this.supposeCount = supposeCount;
	}

	public Integer getActualCount() {
		return this.actualCount;
	}

	public void setActualCount(Integer actualCount) {
		this.actualCount = actualCount;
	}

	public Integer getAttendCount() {
		return this.attendCount;
	}

	public void setAttendCount(Integer attendCount) {
		this.attendCount = attendCount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPositiveCount() {
		return this.positiveCount;
	}

	public void setPositiveCount(Integer positiveCount) {
		this.positiveCount = positiveCount;
	}

	public Integer getNegativeCount() {
		return this.negativeCount;
	}

	public void setNegativeCount(Integer negativeCount) {
		this.negativeCount = negativeCount;
	}

	public Integer getAbstentionCount() {
		return this.abstentionCount;
	}

	public void setAbstentionCount(Integer abstentionCount) {
		this.abstentionCount = abstentionCount;
	}

	public boolean getResult() {
		return this.result;
	}

	public void setResult(boolean result) {
		this.result = result;
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

	public Set getProjectvoteinfoAttachments() {
		return this.projectvoteinfoAttachments;
	}

	public void setProjectvoteinfoAttachments(Set projectvoteinfoAttachments) {
		this.projectvoteinfoAttachments = projectvoteinfoAttachments;
	}

}