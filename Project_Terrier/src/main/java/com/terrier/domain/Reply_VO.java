package com.terrier.domain;

import java.util.Date;

public class Reply_VO {
	private int rno; // 댓글 번호
	private int paren_bo_no; // 부모 게시글 번호
	private int paren_re_no; // 부모 댓글 번호
	private String writer; // 작성자
	private String content; // 내용
	private Date regdate; // 날짜
	
	public Reply_VO() {
		
	}
	
	// 댓글 작성을 위해
	public Reply_VO(int paren_bo_no, String writer, String content) {
		this.paren_bo_no = paren_bo_no;
		this.writer = writer;
		this.content = content;
	}
	
	// 댓글의 댓글 작성을 위해
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
