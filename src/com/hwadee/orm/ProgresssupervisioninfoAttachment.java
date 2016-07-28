package com.hwadee.orm;

/**
 * ProgresssupervisioninfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class ProgresssupervisioninfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Progresssupervisioninfo progresssupervisioninfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public ProgresssupervisioninfoAttachment() {
	}

	/** minimal constructor */
	public ProgresssupervisioninfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public ProgresssupervisioninfoAttachment(
			Progresssupervisioninfo progresssupervisioninfo,
			String attachmentName, String attachmentUrl) {
		this.progresssupervisioninfo = progresssupervisioninfo;
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

	public Progresssupervisioninfo getProgresssupervisioninfo() {
		return this.progresssupervisioninfo;
	}

	public void setProgresssupervisioninfo(
			Progresssupervisioninfo progresssupervisioninfo) {
		this.progresssupervisioninfo = progresssupervisioninfo;
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