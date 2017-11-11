package com.terrier.persistence;

import java.util.List;

import com.terrier.domain.Criteria;
import com.terrier.domain.Employee_VO;
import com.terrier.domain.L_mgt_controller_VO;
import com.terrier.domain.L_mgt_lf_log_VO;
import com.terrier.domain.L_mgt_lr_list_VO;

public interface L_mgt_DAO {
	public L_mgt_controller_VO info(String e_num)throws Exception;
	
	public List<Employee_VO> emp_list()throws Exception;//��� ����Ʈ
	public List<Employee_VO> emp_search_list(Employee_VO vo)throws Exception;//��� �˻� ����Ʈ
	public Employee_VO emp_dynamic(String emp_num)throws Exception;//���� html�� ���� �ش� ����� �˻�
	
	public String l_lf_date(String emp_num)throws Exception;//�α��� 5�� ������ �� ���� ��¥�� ������
	public List<L_mgt_lf_log_VO> l_lf_log(String l_lf_date, String employee_num)throws Exception;//���� ���� ��¥�� �ش��ϴ� �α׸� ������
	
	public void l_unlock(String employee_num)throws Exception; // �������
	public String l_camera_auth(String employee_num)throws Exception; // �νķ� ��ȸ
	
	public List<L_mgt_lr_list_VO> l_request_list(Criteria cri)throws Exception; // �н� ��û ����Ʈ
	public int l_request_count()throws Exception; // �н� ��û ����
	
	public List<L_mgt_lr_list_VO> l_request_list_search(Criteria cri, L_mgt_lr_list_VO vo)throws Exception; // �н� ��û ����Ʈ �˻�
	public int l_request_search_count(Criteria cri, L_mgt_lr_list_VO vo)throws Exception; // �н� ��û ����Ʈ �˻� ����
	public void l_loss_check(String bno)throws Exception; // Ȯ�� ������ ������û
}
