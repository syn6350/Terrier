package com.terrier.service;

import java.util.List;

import com.terrier.domain.C_mgt_AppList_VO;
import com.terrier.domain.C_mgt_AppLog_VO;
import com.terrier.domain.C_mgt_Gps_VO;
import com.terrier.domain.C_mgt_controller_VO;
import com.terrier.domain.C_mgt_userinfo_VO;
import com.terrier.domain.Employee_VO;
import com.terrier.domain.Location_emp_num_VO;

public interface D_mgt_Service {
	public List<Employee_VO> emp_list()throws Exception; // �ܸ� ���� - ��� ����Ʈ ���
	public List<Employee_VO> emp_search_list(Employee_VO vo)throws Exception; // �ܸ� ���� - ��� �˻�
	public C_mgt_userinfo_VO info(String e_num)throws Exception;//c_mgt ��������� ���
	public C_mgt_controller_VO controller(String e_num)throws Exception;//c_mgt ��Ʈ������
	public List<C_mgt_AppList_VO> applist(String e_num)throws Exception;//c_mgt ���ø���ũ
	public List<C_mgt_AppLog_VO> applog(String emp_num) throws Exception;//c_mgt ���÷α�
	public C_mgt_Gps_VO gps(Location_emp_num_VO vo)throws Exception;//����� ��ġ����
}
