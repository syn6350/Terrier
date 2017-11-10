package com.terrier.domain;

public class C_mgt_AppLog_VO 
{
	private String history;
	private String type;
	private String data_Time;
	
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	public String getData_Time() {
		return data_Time;
	}
	public void setData_Time(String data_Time) {
		this.data_Time = data_Time;
	}
	@Override
	public String toString() {
		return "C_mgt_AppLog_VO [history=" + history + ", type=" + type + ", Data=" + data_Time + "]";
	}
	
}
