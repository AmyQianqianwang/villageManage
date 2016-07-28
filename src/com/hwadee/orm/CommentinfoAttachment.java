package com.hwadee.orm;

/**
 * CommentinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class CommentinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Commentinfo commentinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public CommentinfoAttachment() {
	}

	/** minimal constructor */
	public CommentinfoAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public CommentinfoAttachment(Commentinfo commentinfo,
			String attachmentName, String attachmentUrl) {
		this.commentinfo = commentinfo;
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

	public Commentinfo getCommentinfo() {
		return this.commentinfo;
	}

	public void setCommentinfo(Commentinfo commentinfo) {
		this.commentinfo = commentinfo;
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