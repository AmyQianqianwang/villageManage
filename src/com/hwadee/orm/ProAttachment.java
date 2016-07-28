package com.hwadee.orm;

/**
 * ProAttachment entity. @author MyEclipse Persistence Tools
 */

public class ProAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Project project;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public ProAttachment() {
	}

	/** minimal constructor */
	public ProAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public ProAttachment(Project project, String attachmentName,
			String attachmentUrl) {
		this.project = project;
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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
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