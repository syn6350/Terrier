package com.terrier.domain;

import java.util.Date;

public class Reply_VO {
	private int rno; // ��� ��ȣ
	private int paren_bo_no; // �θ� �Խñ� ��ȣ
	private int paren_re_no; // �θ� ��� ��ȣ
	private String writer; // �ۼ���
	private String content; // ����
	private Date regdate; // ��¥
	
	public Reply_VO() {
		
	}
	
	// ��� �ۼ��� ����
	public Reply_VO(int paren_bo_no, String writer, String content) {
		this.paren_bo_no = paren_bo_no;
		this.writer = writer;
		this.content = content;
	}
	
	// ����� ��� �ۼ��� ����
	public Reply_VO(int paren_bo_no, int paren_re_no, String writer, String content) {
		this.paren_bo_no = paren_bo_no;
		this.paren_re_no = paren_re_no;
		this.writer = writer;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Reply_VO [rno=" + rno + ", paren_bo_no=" + paren_bo_no + ", paren_re_no=" + paren_re_no + ", writer="
				+ writer + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getParen_bo_no() {
		return paren_bo_no;
	}
	public void setParen_bo_no(int paren_bo_no) {
		this.paren_bo_no = paren_bo_no;
	}
	public int getParen_re_no() {
		return paren_re_no;
	}
	public void setParen_re_no(int paren_re_no) {
		this.paren_re_no = paren_re_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
