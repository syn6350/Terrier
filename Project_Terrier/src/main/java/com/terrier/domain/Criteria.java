package com.terrier.domain;

public class Criteria {
	
	//����¡ ó�� Ŭ����
	private int page;
	private int perPageNum;
	//����¡ ������ ���� ���۹�ȣ=(����¡��ȣ-1)*�������� �����ִ� ����..
	
	public Criteria()
	{
		this.page=1;
		this.perPageNum=10;//���������� 10���� [1]
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
