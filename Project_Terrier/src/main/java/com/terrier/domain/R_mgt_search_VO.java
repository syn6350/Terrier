package com.terrier.domain;


public class R_mgt_search_VO {
	private String title;
	private String employee_num;
	private String department;
	private String rank;
	private String name;
	private String date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmployee_num() {
		return employee_num;
	}
	public void setEmployee_num(String employee_num) {
		this.employee_num = employee_num;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "R_mgt_search_VO [title=" + title + ", employee_num=" + employee_num + ", department=" + department
				+ ", rank=" + rank + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
