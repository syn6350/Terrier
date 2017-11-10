package com.terrier.domain;

public class Location_emp_num_VO {
	String emp_num;
	int rank; // 현재위치인지 이전위치인지
	
	public Location_emp_num_VO(String emp_num,int rank) {
		this.emp_num = emp_num;
		this.rank = rank;
	}
	
	public String getEmp_num() {
		return emp_num;
	}
	public void setEmp_num(String emp_num) {
		this.emp_num = emp_num;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Location_emp_num_VO [emp_num=" + emp_num + ", rank=" + rank + "]";
	}

}
