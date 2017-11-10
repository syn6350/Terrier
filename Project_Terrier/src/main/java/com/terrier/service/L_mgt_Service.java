package com.terrier.service;

import java.util.List;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.L_mgt_controller_VO;
import com.terrier.domain.L_mgt_lf_log_VO;

public interface L_mgt_Service {
	public L_mgt_controller_VO info(String e_num)throws Exception;
	
	public List<Employee_VO> emp_list()throws Exception; // �ܸ� ���� - ��� ����Ʈ ���
	public List<Employee_VO> emp_search_list(Employee_VO vo)throws Exception; // �ܸ� ���� - ��� �˻�
	public Employee_VO emp_dynamic(String emp_num)throws Exception;//���� html�� ���� �ش� ����� �˻�
	
	public String l_lf_date(String emp_num)throws Exception;//�α��� 5�� ������ �� ���� ��¥�� ������
	public List<L_mgt_lf_log_VO> l_lf_log(String l_lf_date, String employee_num)throws Exception;//���� ���� ��¥�� �ش��ϴ� �α׸� ������
	
	public void l_unlock(String employee_num)throws Exception; // �������
	public String l_camera_auth(String employee_num)throws Exception; // �νķ� ��ȸ
}
