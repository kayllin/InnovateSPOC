package com.base.Dao;

import java.util.List;

import com.base.Po.groups;
import com.base.Po.studentList;
import com.base.Po.students;

public interface StudentDao {

	public int addstudent(String studentId, String studentName, String sex,
			String areason, String password,int sorder, String caddress, String eaddress,
			String telephone, String qq, String enrollmentYear,String major, String gra,
			String emp,String filename,int gid);

	public studentList query_student(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue);

	public String deleteStudent(String str);

	public void updateStudent(String sid, String Sintroduce,
			String chinese_address, String english_address, String phone,
			String qq, String smajor, int gid, String gra, String emp,String photo,int sorder);

	public List<groups> getGroup();
	
	public List<students> get_UIstudent();

	public List<students> get_Pstudent(int gid);
	
	public List<students> getStudents(String sid);

	public List<students> get_3Dstudent();

	public List<students> get_CGstudent();

	public List<students> getStudentByPid(int gid);
}
