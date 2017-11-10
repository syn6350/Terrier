package com.terrier.persistence;

import java.util.List;

import com.terrier.domain.Control_count_VO;
import com.terrier.domain.Dep_ctl_status_VO;

public interface S_mgt_DAO {
	public Control_count_VO control_count(String status);
	public int dep_ctl_on_count(String department);
	public Control_count_VO dep_ctl_status(Dep_ctl_status_VO vo);
}
