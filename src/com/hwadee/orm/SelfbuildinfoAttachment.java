package com.hwadee.orm;

/**
 * SelfbuildinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class SelfbuildinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Selfbuildinfo selfbuildinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public SelfbuildinfoAttachment() {
	}

	/** minimal constructor */
	public SelfbuildinfoAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public SelfbuildinfoAttachment(Selfbuildinfo selfbuildinfo,
			String attachmentName, String attachmentUrl) {
		this.selfbuildinfo = selfbuildinfo;
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

	public Selfbuildinfo getSelfbuildinfo() {
		return this.selfbuildinfo;
	}

	public void setSelfbuildinfo(Selfbuildinfo selfbuildinfo) {
		this.selfbuildinfo = selfbuildinfo;
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