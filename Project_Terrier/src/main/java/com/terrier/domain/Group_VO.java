package com.terrier.domain;

public class Group_VO {
	private String group_name;
	private String employee_num;
	private String group_owner;
	
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getEmployee_num() {
		return employee_num;
	}
	public void setEmployee_num(String employee_num) {
		this.employee_num = employee_num;
	}
	public String getGroup_owner() {
		return group_owner;
	}
	public void setGroup_owner(String group_owner) {
		this.group_owner = group_owner;
	}
	@Override
	public String toString() {
		return "Group_VO [group_name=" + group_name + ", employee_num=" + employee_num + ", group_owner=" + group_owner
				+ "]";
	}
	
}
