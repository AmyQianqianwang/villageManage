package com.hwadee.orm;

/**
 * ImplementplanfundsbugetAttachment entity. @author MyEclipse Persistence Tools
 */

public class ImplementplanfundsbugetAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Implementplanfundsbuget implementplanfundsbuget;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public ImplementplanfundsbugetAttachment() {
	}

	/** minimal constructor */
	public ImplementplanfundsbugetAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public ImplementplanfundsbugetAttachment(
			Implementplanfundsbuget implementplanfundsbuget,
			String attachmentName, String attachmentUrl) {
		this.implementplanfundsbuget = implementplanfundsbuget;
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

	public Implementplanfundsbuget getImplementplanfundsbuget() {
		return this.implementplanfundsbuget;
	}

	public void setImplementplanfundsbuget(
			Implementplanfundsbuget implementplanfundsbuget) {
		this.implementplanfundsbuget = implementplanfundsbuget;
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