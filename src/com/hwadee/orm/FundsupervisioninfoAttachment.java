package com.hwadee.orm;

/**
 * FundsupervisioninfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class FundsupervisioninfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Fundsupervisioninfo fundsupervisioninfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public FundsupervisioninfoAttachment() {
	}

	/** minimal constructor */
	public FundsupervisioninfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public FundsupervisioninfoAttachment(
			Fundsupervisioninfo fundsupervisioninfo, String attachmentName,
			String attachmentUrl) {
		this.fundsupervisioninfo = fundsupervisioninfo;
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

	public Fundsupervisioninfo getFundsupervisioninfo() {
		return this.fundsupervisioninfo;
	}

	public void setFundsupervisioninfo(Fundsupervisioninfo fundsupervisioninfo) {
		this.fundsupervisioninfo = fundsupervisioninfo;
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