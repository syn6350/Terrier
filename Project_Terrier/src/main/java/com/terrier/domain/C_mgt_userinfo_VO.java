package com.terrier.domain;

public class C_mgt_userinfo_VO {
	private String active; //�����
	private String employee_num;//�����ȣ
	private String name;//�̸�
	private String rank;//����
	private String department;//�μ�
	private String date_of_birth;//�������
	private String address;//�ּ�
	private String telnum;//��ȭ��ȣ
	private String os;//OS
	private String manufacturer;//������
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getEmployee_num() {
		return employee_num;
	}
	public void setEmployee_num(String employee_num) {
		this.employee_num = employee_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "C_mgt_userinfo_VO [active=" + active + ", employee_num=" + employee_num + ", name=" + name + ", rank="
				+ rank + ", department=" + department + ", date_of_birth=" + date_of_birth + ", address=" + address
				+ ", telnum=" + telnum + ", os=" + os + ", Manufacturer=" + manufacturer + "]";
	}

	
}
