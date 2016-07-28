package com.hwadee.orm;

/**
 * ReportcheckinfoAttachment entity. @author MyEclipse Persistence Tools
 */

public class ReportcheckinfoAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Reportcheckinfo reportcheckinfo;
	private String attachmentName;
	private String attachmentUrl;

	// Constructors

	/** default constructor */
	public ReportcheckinfoAttachment() {
	}

	/** minimal constructor */
	public ReportcheckinfoAttachment(String attachmentName, String attachmentUrl) {
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
	}

	/** full constructor */
	public ReportcheckinfoAttachment(Reportcheckinfo reportcheckinfo,
			String attachmentName, String attachmentUrl) {
		this.reportcheckinfo = reportcheckinfo;
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

	public Reportcheckinfo getReportcheckinfo() {
		return this.reportcheckinfo;
	}

	public void setReportcheckinfo(Reportcheckinfo reportcheckinfo) {
		this.reportcheckinfo = reportcheckinfo;
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