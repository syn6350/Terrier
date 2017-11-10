package com.terrier.domain;

public class C_mgt_AppList_VO 
{
	private String name;//어플이름
	private String size;//사이즈
	private String version;//버전
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "C_mgt_AppList_VO [name=" + name + ", size=" + size + ", version=" + version + "]";
	}
	
	
}
