package com.hwadee.orm;

/**
 * CompareselectinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class CompareselectinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Compareselectinfo compareselectinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public CompareselectinfoAttachment() {
	}

	/** minimal constructor */
	public CompareselectinfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public CompareselectinfoAttachment(Compareselectinfo compareselectinfo,
			String attachmentName, String attachmentUrl) {
		this.compareselectinfo = compareselectinfo;
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

	public Compareselectinfo getCompareselectinfo() {
		return this.compareselectinfo;
	}

	public void setCompareselectinfo(Compareselectinfo compareselectinfo) {
		this.compareselectinfo = compareselectinfo;
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