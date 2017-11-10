package com.terrier.dto;

public class User_DTO 
{
	private String id;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "Usuer_DTO [id=" + id + ", pw=" + pw + "]";
	}
	
}
