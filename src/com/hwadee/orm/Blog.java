package com.hwadee.orm;

import java.util.Date;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private User user;
	private String opName;
	private Date opTime;
	private String blogComment;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** minimal constructor */
	public Blog(User user, String opName, Date opTime) {
		this.user = user;
		this.opName = opName;
		this.opTime = opTime;
	}

	/** full constructor */
	public Blog(User user, String opName, Date opTime, String blogComment) {
		this.user = user;
		this.opName = opName;
		this.opTime = opTime;
		this.blogComment = blogComment;
	}

	// Property accessors

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOpName() {
		return this.opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getBlogComment() {
		return this.blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}

}