package com.terrier.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.terrier.domain.Control_count_VO;
import com.terrier.domain.Dep_ctl_on_count_VO;
import com.terrier.domain.Dep_ctl_status_VO;
import com.terrier.persistence.S_mgt_DAO;

@Service
public class S_mgt_ServiceImpl implements S_mgt_Service {

	@Inject
	S_mgt_DAO dao;
	
	@Override
	public Control_count_VO control_count(String status) {
		return dao.control_count(status);
	}

	
	@Inject
	Dep_ctl_on_count_VO dep_on_count_vo;
	
	@Override
	public Dep_ctl_on_count_VO dep_ctl_on_count() {
		dep_on_count_vo.setEng_dep(dao.dep_ctl_on_count("기술"));
		dep_on_count_vo.setGa_dep(dao.dep_ctl_on_count("총무"));
		dep_on_count_vo.setHr_dep(dao.dep_ctl_on_count("인사"));
		dep_on_count_vo.setPro_dep(dao.dep_ctl_on_count("생산"));
		return dep_on_count_vo;
	}

	@Inject
	Dep_ctl_status_VO dep_status_vo;
	
	@Override
	public Control_count_VO dep_ctl_status(String department, String status) {
		dep_status_vo.setDepartment(department);
		dep_status_vo.setStatus(status);
		return dao.dep_ctl_status(dep_status_vo);
	}

}
