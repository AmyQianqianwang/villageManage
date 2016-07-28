package com.hwadee.orm;

/**
 * JobcompetitioninfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class JobcompetitioninfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Jobcompetitioninfo jobcompetitioninfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public JobcompetitioninfoAttachment() {
	}

	/** minimal constructor */
	public JobcompetitioninfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public JobcompetitioninfoAttachment(Jobcompetitioninfo jobcompetitioninfo,
			String attachmentName, String attachmentUrl) {
		this.jobcompetitioninfo = jobcompetitioninfo;
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	// Property accessors

	public Integer getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Jobcompetitioninfo getJobcompetitioninfo() {
		return this.jobcompetitioninfo;
	}

	public void setJobcompetitioninfo(Jobcompetitioninfo jobcompetitioninfo) {
		this.jobcompetitioninfo = jobcompetitioninfo;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentUrl() {
		return this.attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

}