package com.terrier.domain;

public class User_VO 
{
	private String id;//���̵�
	private String pw;//��й�ȣ
	private int auth; //����
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
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	@Override
	public String toString() {
		return "User_VO [id=" + id + ", pw=" + pw + ", auth=" + auth + "]";
	}
	
}
