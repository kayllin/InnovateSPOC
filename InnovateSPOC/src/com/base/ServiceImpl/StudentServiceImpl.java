package com.base.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.Dao.StudentDao;
import com.base.Po.studentList;
import com.base.Service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentDao studentdao;
	
	@Override
	public int addStudent(String studentId, String studentName, String sex,
			String areason, String password, String caddress, String eaddress,
			String telephone, String qq, String enrollmentYear,String major, String gra,
			String emp) {
		int flag = studentdao.addstudent(studentId,studentName,sex,areason,password,caddress,eaddress,telephone,qq,enrollmentYear,major,gra,emp);
		return flag;
	}

	@Override
	public studentList query_student(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue) {
		// TODO Auto-generated method stub
		String columnName = "";
		if (order == 1) {
		    columnName = "id";
		} else if (order == 2) {
		    columnName = "name";
		} else if (order == 3) {
		    columnName = "sex";
		}
		studentList list = studentdao.query_student(size,
			pageindex, columnName, orderDir, searchValue);
		return list;
	}

	@Override
	public String deleteStudent(String str) {
		// TODO Auto-generated method stub
		String message= studentdao.deleteStudent(str);
		return message;
	}

	@Override
	public void updateStudent(String sid, String Sintroduce,
			String chinese_address, String english_address, String phone,
			String qq, String smajor) {
		// TODO Auto-generated method stub
		studentdao.updateStudent(sid, Sintroduce, chinese_address, english_address, phone, qq, smajor);
	}
}