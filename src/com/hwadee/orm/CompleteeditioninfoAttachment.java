package com.hwadee.orm;

/**
 * CompleteeditioninfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class CompleteeditioninfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Completeeditioninfo completeeditioninfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public CompleteeditioninfoAttachment() {
	}

	/** minimal constructor */
	public CompleteeditioninfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public CompleteeditioninfoAttachment(
			Completeeditioninfo completeeditioninfo, String attachmentName,
			String attachmentUrl) {
		this.completeeditioninfo = completeeditioninfo;
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

	public Completeeditioninfo getCompleteeditioninfo() {
		return this.completeeditioninfo;
	}

	public void setCompleteeditioninfo(Completeeditioninfo completeeditioninfo) {
		this.completeeditioninfo = completeeditioninfo;
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