package com.base.Dao;

import com.base.Po.studentList;

public interface StudentDao {

	public int addstudent(String studentId, String studentName, String sex,
			String areason, String password, String caddress, String eaddress,
			String telephone, String qq, String enrollmentYear,String major, String gra,
			String emp);

	public studentList query_student(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue);

	public String deleteStudent(String str);

	public void updateStudent(String sid, String Sintroduce,
			String chinese_address, String english_address, String phone,
			String qq, String smajor);
}
