package com.terrier.domain;

import java.util.Date;

public class R_mgt_list_VO {
	private int bno;
	private String title;
	private String employee_num;
	private String department;
	private String rank;
	private String name;
	private Date date;
	private int admit;
	
	
	
	@Override
	public String toString() {
		return "R_mgt_list_VO [bno=" + bno + ", title=" + title + ", employee_num=" + employee_num + ", department="
				+ department + ", rank=" + rank + ", name=" + name + ", date=" + date + ", admit=" + admit + "]";
	}
	public int getAdmit() {
		return admit;
	}
	public void setAdmit(int admit) {
		this.admit = admit;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
