package com.terrier.domain;

// table �� : tbl_employee
/*employee_num;
String department;
String rank;
String phone;
String name;
String active;*/

public class Employee_VO {
	private String employee_num;
	private String department;//������null�� ������� �ʿ伺������ jsp���� ������null�� �ƴ϶� ���۰� null�� �νĸ���;
	private String rank;
	private String phone;//������null�� ������� �ʿ伺������ jsp���� ������null�� �ƴ϶� ���۰� null�� �νĸ���;
	private String name;//������null�� ������� �ʿ伺������ jsp���� ������null�� �ƴ϶� ���۰� null�� �νĸ���;
	private String active;
	
	@Override
	public String toString() {
		return "Employee_VO [employee_num=" + employee_num + ", department=" + department + ", rank=" + rank
				+ ", phone=" + phone + ", name=" + name + ", active=" + active + "]";
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
		
}
