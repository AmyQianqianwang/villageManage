package com.hwadee.orm;

/**
 * ProjectvoteinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class ProjectvoteinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Projectvoteinfo projectvoteinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public ProjectvoteinfoAttachment() {
	}

	/** minimal constructor */
	public ProjectvoteinfoAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public ProjectvoteinfoAttachment(Projectvoteinfo projectvoteinfo,
			String attachmentName, String attachmentUrl) {
		this.projectvoteinfo = projectvoteinfo;
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

	public Projectvoteinfo getProjectvoteinfo() {
		return this.projectvoteinfo;
	}

	public void setProjectvoteinfo(Projectvoteinfo projectvoteinfo) {
		this.projectvoteinfo = projectvoteinfo;
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