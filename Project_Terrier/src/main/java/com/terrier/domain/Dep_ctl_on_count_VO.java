package com.terrier.domain;

public class Dep_ctl_on_count_VO {
	private int hr_dep; // 인사부 
	private int eng_dep; // 기술
	private int ga_dep; // 총무
	private int pro_dep; // 생상

	@Override
	public String toString() {
		return "Dep_ctl_on_count_VO [hr_dep=" + hr_dep + ", eng_dep=" + eng_dep + ", ga_dep=" + ga_dep + ", pro_dep="
				+ pro_dep + "]";
	}
	public int getHr_dep() {
		return hr_dep;
	}
	public void setHr_dep(int hr_dep) {
		this.hr_dep = hr_dep;
	}
	public int getEng_dep() {
		return eng_dep;
	}
	public void setEng_dep(int eng_dep) {
		this.eng_dep = eng_dep;
	}
	public int getGa_dep() {
		return ga_dep;
	}
	public void setGa_dep(int ga_dep) {
		this.ga_dep = ga_dep;
	}
	public int getPro_dep() {
		return pro_dep;
	}
	public void setPro_dep(int pro_dep) {
		this.pro_dep = pro_dep;
	}
}
