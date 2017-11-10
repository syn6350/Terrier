package com.terrier.domain;

public class G_Owner_VO {
	private String id;
	private String group_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	@Override
	public String toString() {
		return "G_Owner_VO [id=" + id + ", group_name=" + group_name + "]";
	}
}
