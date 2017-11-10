package com.terrier.domain;

import java.util.List;

public class Test_VO {
	List<String> idDevice_history;

	public List<String> getIdDevice_history() {
		return idDevice_history;
	}

	public void setIdDevice_history(List<String> idDevice_history) {
		this.idDevice_history = idDevice_history;
	}

	@Override
	public String toString() {
		return "Test_VO [idDevice_history=" + idDevice_history + "]";
	}
}
