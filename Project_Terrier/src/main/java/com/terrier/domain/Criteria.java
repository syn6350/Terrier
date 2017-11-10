package com.terrier.domain;

public class Criteria {
	
	//페이징 처리 클래스
	private int page;
	private int perPageNum;
	//페이징 나누기 공식 시작번호=(페이징번호-1)*페이지당 보여주는 갯수..
	
	public Criteria()
	{
		this.page=1;
		this.perPageNum=10;//한페이지당 10개식 [1]
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0)
		{
			this.page=1;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100)
		{
			this.perPageNum=10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	 // method for MyBatis SQL Mapper -
	  public int getPageStart() {

	    return (this.page - 1) * perPageNum;
	  }

	  // method for MyBatis SQL Mapper
	  public int getPerPageNum() {

	    return this.perPageNum;
	  }

	
}
