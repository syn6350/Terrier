package com.terrier.service;

import java.util.List;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.L_mgt_controller_VO;
import com.terrier.domain.L_mgt_lf_log_VO;

public interface L_mgt_Service {
	public L_mgt_controller_VO info(String e_num)throws Exception;
	
	public List<Employee_VO> emp_list()throws Exception; // 단말 관리 - 사원 리스트 출력
	public List<Employee_VO> emp_search_list(Employee_VO vo)throws Exception; // 단말 관리 - 사원 검색
	public Employee_VO emp_dynamic(String emp_num)throws Exception;//동적 html을 위한 해당 사원만 검색
	
	public String l_lf_date(String emp_num)throws Exception;//로그인 5번 실패한 그 날의 날짜를 가져옴
	public List<L_mgt_lf_log_VO> l_lf_log(String l_lf_date, String employee_num)throws Exception;//위의 값의 날짜에 해당하는 로그를 가져옴
	
	public void l_unlock(String employee_num)throws Exception; // 잠금해제
	public String l_camera_auth(String employee_num)throws Exception; // 인식률 조회
}
