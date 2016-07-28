package com.hwadee.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */

public class Location implements java.io.Serializable {

	// Fields

	private String locId;
	private String cityName;
	private String countryName;
	private String townName;
	private String villageName;
	private Integer peopleCount;
	private String summary;
	private Set projects = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** full constructor */
	public Location(String cityName, String countryName, String townName,
			String villageName, Integer peopleCount, String summary,
			Set projects, Set users) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.townName = townName;
		this.villageName = villageName;
		this.peopleCount = peopleCount;
		this.summary = summary;
		this.projects = projects;
		this.users = users;
	}

	// Property accessors

	public String getLocId() {
		return this.locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getVillageName() {
		return this.villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Integer getPeopleCount() {
		return this.peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}