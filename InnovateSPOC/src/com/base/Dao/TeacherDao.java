package com.base.Dao;

import java.util.List;

import com.base.Po.teacherList;
import com.base.Po.teachers;

public interface TeacherDao {
    /**
     * 用户名username 密码：password
     * 
     * @param username
     * @param password
     * @return
     */
	public int addTeacher(String teacherId,String teacherName,String sex,String Areason,String password,String filename,int gid,String position);

	public teacherList query_teacher(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue);

	public int CheckteacherId(int teacherId);

	public String deleteTeacher(String str);

	public void updateteacher(String tid, String tintroduce, int gid,String photo,String position);

	public List<teachers> getTeacher(int gid);

	public List<teachers> getTeacher(String tid);
}
