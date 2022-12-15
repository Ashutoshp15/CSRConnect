package com.hotelbooking.models;

import javax.persistence.*;

@Entity
public class Charity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String charityName;
	@Column
	private String charityCategory;
	@Column
	private String charityDescription;
	@Column
	private String charityContactInfo;
	
	public Charity() {}
	
	public Charity(int id, String charityName, String charityCategory, String charityDescription,
			String charityContactInfo) {
		super();
		this.id = id;
		this.charityName = charityName;
		this.charityCategory = charityCategory;
		this.charityDescription = charityDescription;
		this.charityContactInfo = charityContactInfo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCharityName() {
		return charityName;
	}
	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}
	public String getCharityCategory() {
		return charityCategory;
	}
	public void setCharityCategory(String charityCategory) {
		this.charityCategory = charityCategory;
	}

	public String getCharityDescription() {
		return charityDescription;
	}

	public void setCharityDescription(String charityDescription) {
		this.charityDescription = charityDescription;
	}

	public String getCharityContactInfo() {
		return charityContactInfo;
	}

	public void setCharityContactInfo(String charityContactInfo) {
		this.charityContactInfo = charityContactInfo;
	}

	@Override
	public String toString() {
		return "Charity [id=" + id + ", charityName=" + charityName + ", charityCategory=" + charityCategory
				+ ", charityDescription=" + charityDescription + ", charityContactInfo=" + charityContactInfo + "]";
	}
	
	


}
