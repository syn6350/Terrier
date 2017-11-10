package com.terrier.domain;

import java.util.Date;

public class R_mgt_read_VO {
	private String employee_num;
	private String title;
	private String file_exist;
	private String contents;
	private Date date;
	private int admit;
	
	
	
	@Override
	public String toString() {
		return "R_mgt_read_VO [employee_num=" + employee_num + ", title=" + title + ", file_exist=" + file_exist
				+ ", contents=" + contents + ", date=" + date + ", admit=" + admit + "]";
	}
	public String getEmployee_num() {
		return employee_num;
	}
	public void setEmployee_num(String employee_num) {
		this.employee_num = employee_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFile_exist() {
		return file_exist;
	}
	public void setFile_exist(String file_exist) {
		this.file_exist = file_exist;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAdmit() {
		return admit;
	}
	public void setAdmit(int admit) {
		this.admit = admit;
	}
	
	

	

	
}
