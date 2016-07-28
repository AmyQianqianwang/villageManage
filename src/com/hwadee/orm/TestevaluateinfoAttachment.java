package com.hwadee.orm;

/**
 * TestevaluateinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class TestevaluateinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Testevaluateinfo testevaluateinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public TestevaluateinfoAttachment() {
	}

	/** minimal constructor */
	public TestevaluateinfoAttachment(String attachmentName,
			String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public TestevaluateinfoAttachment(Testevaluateinfo testevaluateinfo,
			String attachmentName, String attachmentUrl) {
		this.testevaluateinfo = testevaluateinfo;
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

	public Testevaluateinfo getTestevaluateinfo() {
		return this.testevaluateinfo;
	}

	public void setTestevaluateinfo(Testevaluateinfo testevaluateinfo) {
		this.testevaluateinfo = testevaluateinfo;
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