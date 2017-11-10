package com.terrier.domain;

import java.util.Date;

public class Board_VO {

	private Integer bno;//페이지번호
	private String title;//제목
	private String content;//내용
	private String writer;//작성자
	private Date regdate; //작성시간
	private Integer viewcnt;//조회수
	private Integer replycnt; //댓글 수
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Integer getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(Integer replycnt) {
		this.replycnt = replycnt;
	}
	
}
