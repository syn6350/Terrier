package com.terrier.service;

import com.terrier.domain.Control_count_VO;
import com.terrier.domain.Dep_ctl_on_count_VO;
import com.terrier.domain.Dep_ctl_status_VO;

public interface S_mgt_Service {
	public Control_count_VO control_count(String status);
	public Dep_ctl_on_count_VO dep_ctl_on_count();
	public Control_count_VO dep_ctl_status(String department, String status);
}
