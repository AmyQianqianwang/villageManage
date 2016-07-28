package com.hwadee.orm;

/**
 * DirectlyexecuteinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class DirectlyexecuteinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Directlyexecuteinfo directlyexecuteinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public DirectlyexecuteinfoAttachment() {
	}

	/** minimal constructor */
	public DirectlyexecuteinfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public DirectlyexecuteinfoAttachment(
			Directlyexecuteinfo directlyexecuteinfo, String attachmentName,
			String attachmentUrl) {
		this.directlyexecuteinfo = directlyexecuteinfo;
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

	public Directlyexecuteinfo getDirectlyexecuteinfo() {
		return this.directlyexecuteinfo;
	}

	public void setDirectlyexecuteinfo(Directlyexecuteinfo directlyexecuteinfo) {
		this.directlyexecuteinfo = directlyexecuteinfo;
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