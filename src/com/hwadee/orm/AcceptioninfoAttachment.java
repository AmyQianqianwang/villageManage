package com.hwadee.orm;

/**
 * AcceptioninfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class AcceptioninfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Acceptinfo acceptinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public AcceptioninfoAttachment() {
	}

	/** minimal constructor */
	public AcceptioninfoAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public AcceptioninfoAttachment(Acceptinfo acceptinfo,
			String attachmentName, String attachmentUrl) {
		this.acceptinfo = acceptinfo;
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

	public Acceptinfo getAcceptinfo() {
		return this.acceptinfo;
	}

	public void setAcceptinfo(Acceptinfo acceptinfo) {
		this.acceptinfo = acceptinfo;
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