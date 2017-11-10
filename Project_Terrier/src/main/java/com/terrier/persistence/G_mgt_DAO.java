package com.terrier.persistence;

import java.util.List;

import com.terrier.domain.Employee_VO;
import com.terrier.domain.G_Owner_VO;
import com.terrier.domain.G_mgt_log_VO;
import com.terrier.domain.GroupList_VO;
import com.terrier.domain.Group_VO;

public interface G_mgt_DAO {
	public List<GroupList_VO> group_list(String id) throws Exception;
	public List<Employee_VO> emp_list(G_Owner_VO vo) throws Exception;
	public List<Employee_VO> all_emp_list(G_Owner_VO vo)throws Exception;
	public int group_check(G_Owner_VO vo)throws Exception;
	public void group_delete(G_Owner_VO vo)throws Exception;
	public void group_update(List<Group_VO> vo)throws Exception;
	public void group_log(G_mgt_log_VO vo)throws Exception;//로그..생성
	public List<G_mgt_log_VO> group_log_list(String owner)throws Exception;//로그 조회

}
