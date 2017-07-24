package com.base.Service;

import com.base.Po.teacherList;

public interface TeacherService {
    /**
     * 用户名username 密码：password
     * 
     * @param username
     * @param password
     * @return
     */
    public int addTeacher(String teacherId,String teacherName,String sex,String Areason,String password);

	public teacherList query_teacher(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue);

	public int CheckteacherId(int teacherId);

	public String deleteTeacher(String str);

	public void updateTeacher(String teacherName, String Areason, String password);

	public void updateteacher(String tid, String tintroduce);
}