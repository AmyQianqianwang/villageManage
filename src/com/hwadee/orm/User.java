package com.hwadee.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private Location location;
	private String userName;
	private String userPwd;
	private Integer userType;
	private String office;
	private boolean userState;
	private Set projects = new HashSet(0);
	private Set progresssupervisioninfos = new HashSet(0);
	private Set selfbuildinfos = new HashSet(0);
	private Set acceptinfos = new HashSet(0);
	private Set fundsupervisioninfos = new HashSet(0);
	private Set blogs = new HashSet(0);
	private Set compareselectinfos = new HashSet(0);
	private Set jobcompetitioninfos = new HashSet(0);
	private Set completeeditioninfos = new HashSet(0);
	private Set testevaluateinfos = new HashSet(0);
	private Set directlyexecuteinfos = new HashSet(0);
	private Set reportcheckinfos = new HashSet(0);
	private Set pauseinfos = new HashSet(0);
	private Set projectvoteinfos = new HashSet(0);
	private Set commentinfos = new HashSet(0);
	private Set implementplanfundsbugets = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Location location, String userName, String userPwd,
			Integer userType, String office, boolean userState) {
		this.location = location;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.office = office;
		this.userState = userState;
	}

	/** full constructor */
	public User(Location location, String userName, String userPwd,
			Integer userType, String office, boolean userState, Set projects,
			Set progresssupervisioninfos, Set selfbuildinfos, Set acceptinfos,
			Set fundsupervisioninfos, Set blogs, Set compareselectinfos,
			Set jobcompetitioninfos, Set completeeditioninfos,
			Set testevaluateinfos, Set directlyexecuteinfos,
			Set reportcheckinfos, Set pauseinfos, Set projectvoteinfos,
			Set commentinfos, Set implementplanfundsbugets) {
		this.location = location;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.office = office;
		this.userState = userState;
		this.projects = projects;
		this.progresssupervisioninfos = progresssupervisioninfos;
		this.selfbuildinfos = selfbuildinfos;
		this.acceptinfos = acceptinfos;
		this.fundsupervisioninfos = fundsupervisioninfos;
		this.blogs = blogs;
		this.compareselectinfos = compareselectinfos;
		this.jobcompetitioninfos = jobcompetitioninfos;
		this.completeeditioninfos = completeeditioninfos;
		this.testevaluateinfos = testevaluateinfos;
		this.directlyexecuteinfos = directlyexecuteinfos;
		this.reportcheckinfos = reportcheckinfos;
		this.pauseinfos = pauseinfos;
		this.projectvoteinfos = projectvoteinfos;
		this.commentinfos = commentinfos;
		this.implementplanfundsbugets = implementplanfundsbugets;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public boolean getUserState() {
		return this.userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getProgresssupervisioninfos() {
		return this.progresssupervisioninfos;
	}

	public void setProgresssupervisioninfos(Set progresssupervisioninfos) {
		this.progresssupervisioninfos = progresssupervisioninfos;
	}

	public Set getSelfbuildinfos() {
		return this.selfbuildinfos;
	}

	public void setSelfbuildinfos(Set selfbuildinfos) {
		this.selfbuildinfos = selfbuildinfos;
	}

	public Set getAcceptinfos() {
		return this.acceptinfos;
	}

	public void setAcceptinfos(Set acceptinfos) {
		this.acceptinfos = acceptinfos;
	}

	public Set getFundsupervisioninfos() {
		return this.fundsupervisioninfos;
	}

	public void setFundsupervisioninfos(Set fundsupervisioninfos) {
		this.fundsupervisioninfos = fundsupervisioninfos;
	}

	public Set getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

	public Set getCompareselectinfos() {
		return this.compareselectinfos;
	}

	public void setCompareselectinfos(Set compareselectinfos) {
		this.compareselectinfos = compareselectinfos;
	}

	public Set getJobcompetitioninfos() {
		return this.jobcompetitioninfos;
	}

	public void setJobcompetitioninfos(Set jobcompetitioninfos) {
		this.jobcompetitioninfos = jobcompetitioninfos;
	}

	public Set getCompleteeditioninfos() {
		return this.completeeditioninfos;
	}

	public void setCompleteeditioninfos(Set completeeditioninfos) {
		this.completeeditioninfos = completeeditioninfos;
	}

	public Set getTestevaluateinfos() {
		return this.testevaluateinfos;
	}

	public void setTestevaluateinfos(Set testevaluateinfos) {
		this.testevaluateinfos = testevaluateinfos;
	}

	public Set getDirectlyexecuteinfos() {
		return this.directlyexecuteinfos;
	}

	public void setDirectlyexecuteinfos(Set directlyexecuteinfos) {
		this.directlyexecuteinfos = directlyexecuteinfos;
	}

	public Set getReportcheckinfos() {
		return this.reportcheckinfos;
	}

	public void setReportcheckinfos(Set reportcheckinfos) {
		this.reportcheckinfos = reportcheckinfos;
	}

	public Set getPauseinfos() {
		return this.pauseinfos;
	}

	public void setPauseinfos(Set pauseinfos) {
		this.pauseinfos = pauseinfos;
	}

	public Set getProjectvoteinfos() {
		return this.projectvoteinfos;
	}

	public void setProjectvoteinfos(Set projectvoteinfos) {
		this.projectvoteinfos = projectvoteinfos;
	}

	public Set getCommentinfos() {
		return this.commentinfos;
	}

	public void setCommentinfos(Set commentinfos) {
		this.commentinfos = commentinfos;
	}

	public Set getImplementplanfundsbugets() {
		return this.implementplanfundsbugets;
	}

	public void setImplementplanfundsbugets(Set implementplanfundsbugets) {
		this.implementplanfundsbugets = implementplanfundsbugets;
	}

}