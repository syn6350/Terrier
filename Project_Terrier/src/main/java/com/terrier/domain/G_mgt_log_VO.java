package com.terrier.domain;

public class G_mgt_log_VO 
{//그룹제어 로그 기록을 위한vo
	private String group_name;//이름
	private String group_owner;//오너
	private String group_con;//제어정보
	private String group_active;//on,off
	private String reg;//시간정보
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_owner() {
		return group_owner;
	}
	public void setGroup_owner(String group_owner) {
		this.group_owner = group_owner;
	}
	public String getGroup_con() {
		return group_con;
	}
	public void setGroup_con(String group_con) {
		this.group_con = group_con;
	}
	public String getGroup_active() {
		return group_active;
	}
	public void setGroup_active(String group_active) {
		this.group_active = group_active;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	@Override
	public String toString() {
		return "G_mgt_log_VO [group_name=" + group_name + ", group_owner=" + group_owner + ", group_con=" + group_con
				+ ", group_active=" + group_active + ", reg=" + reg + "]";
	}
	
	

	
	
}
