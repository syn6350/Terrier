package com.terrier.domain;

public class GroupList_VO {
	private String group_name;
	private String group_rows;
	@Override
	public String toString() {
		return "GroupList_VO [group_name=" + group_name + ", group_rows=" + group_rows + "]";
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_rows() {
		return group_rows;
	}
	public void setGroup_rows(String group_rows) {
		this.group_rows = group_rows;
	}
}
