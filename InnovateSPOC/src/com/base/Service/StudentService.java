package com.base.Service;

import java.util.List;

import com.base.Po.groups;
import com.base.Po.studentList;

public interface StudentService {

	public int addStudent(String studentId, String studentName, String sex,
			String areason, String password, String caddress, String eaddress,
			String telephone, String qq, String enrollmentYear,String major, String gra,
			String emp,int gid);

	public studentList query_student(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue);

	public String deleteStudent(String str);
	
	public void updateStudent(String sid,String Sintroduce,String chinese_address,String english_address,String phone,String qq,String smajor,int gid, String gra, String smp);

	public List<groups> getGroup();

}
