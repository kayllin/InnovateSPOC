package com.base.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.base.Dao.StudentDao;
import com.base.Po.studentList;
import com.base.Po.students;
import com.base.utils.BaseUtils;
import com.base.utils.SqlConnectionUtils;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao{
	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public int addstudent(String studentId, String studentName, String sex,
			String areason, String password, String caddress, String eaddress,
			String telephone, String qq, String enrollmentYear,String major, String gra,
			String emp) {
		// TODO Auto-generated method stub
		int flag=0;
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		CallableStatement sp = null;
		try {
		    conn = (Connection) SessionFactoryUtils.getDataSource(
			    sessionFactory).getConnection();
		    sp = (CallableStatement) conn
					.prepareCall("{CALL innovatespoc.check_student(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			sp.setString(1, studentId);
			sp.setString(2, studentName);
			sp.setString(3, areason);
			sp.setString(4, sex);
			sp.setString(5, password);
			sp.setString(6, caddress);
			sp.setString(7, eaddress);
			sp.setString(8, telephone);
			sp.setString(9, qq);
			sp.setString(10, enrollmentYear);
			sp.setString(11, major);
			sp.setString(12, gra);
			sp.setString(13, emp);
			sp.execute();
		    flag = sp.getInt(14);
		    System.out.println(flag);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
		    SqlConnectionUtils.free(conn, ps, rs);
		}
		return flag;
	}
	
	//展示学生信息
	@Override
	public studentList query_student(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue) {
		// TODO Auto-generated method stub
		int recordsTotal = 0;
		Connection conn = null;
		CallableStatement sp = null;
		ResultSet rs = null;
		List<students> list = new ArrayList<students>();
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					sessionFactory).getConnection();
			sp = (CallableStatement) conn
					.prepareCall("{call innovatespoc.query_student(?,?,?,?,?,?)}");
			sp.setInt(1, size);
			sp.setInt(2, pageindex);
			sp.setString(3, columnName);
			sp.setString(4, orderDir);
			sp.setString(5, searchValue);
			sp.registerOutParameter(6, java.sql.Types.INTEGER);
			sp.execute();
			recordsTotal = sp.getInt(6);
			rs = sp.getResultSet();
			while (rs.next()) {
				students ch = new students();
				ch.setSid(rs.getString("id"));
				ch.setSname(rs.getString("name"));
				ch.setSex(rs.getString("sex"));
//				ch.setTeacher_introduce(rs.getString("teacher_introduce"));
//				ch.setPhoto_address(rs.getString("photo_address"));
				list.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlConnectionUtils.free(conn, sp, rs);
		}
		studentList ck = new studentList();
		ck.setRecordsTotal(recordsTotal);
		ck.setData(list);
		return ck;
	}

	//删除学生
	@Override
	public String deleteStudent(String str) {
		// TODO Auto-generated method stub
		int flag = 0;
		String message = null;
		Connection conn = null;
		CallableStatement sp = null;
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					sessionFactory).getConnection();
			sp = (CallableStatement) conn
					.prepareCall("{CALL innovatespoc.delete_student(?,?)}");
			sp.setString(1, str);
			sp.execute();
			flag = sp.getInt(2); 
			message=BaseUtils.getException(flag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnectionUtils.free(conn, sp, null);
		}
		return message;
	}

}