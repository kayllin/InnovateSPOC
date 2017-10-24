package com.base.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.base.Dao.HobbysDao;
import com.base.Po.hobbyList;
import com.base.Po.hobbys;
import com.base.utils.BaseUtils;
import com.base.utils.SqlConnectionUtils;

@Repository("HobbysDao")
public class HobbysDaoImpl implements HobbysDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addhobbys(String studentId, String hobby, String begin,
			String end, String description) {
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
					.prepareCall("{CALL innovatespoc.check_hobbys(?,?,?,?,?,?)}");
			sp.setString(1, studentId);
			sp.setString(2, hobby);
			sp.setString(3, begin);
			sp.setString(4, end);
			sp.setString(5, description);
			System.out.println(studentId);
			System.out.println(hobby);
			sp.execute();
		    flag = sp.getInt(6);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
		    SqlConnectionUtils.free(conn, ps, rs);
		}
		return flag;
	}

	@Override
	public hobbyList query_hobby(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue) {
		// TODO Auto-generated method stub
		int recordsTotal = 0;
		Connection conn = null;
		CallableStatement sp = null;
		ResultSet rs = null;
		List<hobbys> list = new ArrayList<hobbys>();
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					sessionFactory).getConnection();
			sp = (CallableStatement) conn
					.prepareCall("{call innovatespoc.query_hobbys(?,?,?,?,?,?)}");
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
				hobbys ch = new hobbys();
				ch.setId(Integer.parseInt(rs.getString("id")));
				ch.setSid(rs.getString("sid"));
				ch.setSname(rs.getString("sname"));
				ch.setHobby(rs.getString("hobby"));
				ch.setBegin_time(rs.getString("begin_time"));
				ch.setEnd_time(rs.getString("end_time"));
				ch.setHobby_description(rs.getString("hobby_description"));
				list.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlConnectionUtils.free(conn, sp, rs);
		}
		hobbyList ck = new hobbyList();
		ck.setRecordsTotal(recordsTotal);
		ck.setData(list);
		return ck;
	}

	//删除
	@Override
	public String delHobby(String str) {
		// TODO Auto-generated method stub
		int flag = 0;
		String message = null;
		Connection conn = null;
		CallableStatement sp = null;
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					sessionFactory).getConnection();
			sp = (CallableStatement) conn
					.prepareCall("{CALL innovatespoc.delete_hobbys(?,?)}");
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

	@Override
	public void updateHobby(int id, String begin, String end, String description) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
				    sessionFactory).getConnection();
			String sql = "update hobbys set begin_time=?,end_time=?,hobby_description=? where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, begin);
			pstmt.setString(2, end);
			pstmt.setString(3, description);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlConnectionUtils.free(conn, pstmt, rs);
		}
	}

	@Override
	public List<hobbys> get_hobbys(String sid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<hobbys> list =null;
		String hql ="from hobbys where sid=?";
		try {
	    	 Query query=session.createQuery(hql);
	    	 query.setString(0, sid);
	    	 list=query.list();
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public hobbyList query_Uhobby(String sid, Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue) {
		// TODO Auto-generated method stub
		int recordsTotal = 0;
		Connection conn = null;
		CallableStatement sp = null;
		ResultSet rs = null;
		List<hobbys> list = new ArrayList<hobbys>();
		try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					sessionFactory).getConnection();
			sp = (CallableStatement) conn
					.prepareCall("{call innovatespoc.query_SomeoneHobbys(?,?,?,?,?,?,?)}");
			sp.setString(1, sid);
			sp.setInt(2, size);
			sp.setInt(3, pageindex);
			sp.setString(4, columnName);
			sp.setString(5, orderDir);
			sp.setString(6, searchValue);
			sp.registerOutParameter(7, java.sql.Types.INTEGER);
			sp.execute();
			recordsTotal = sp.getInt(7);
			rs = sp.getResultSet();
			while (rs.next()) {
				hobbys ch = new hobbys();
				ch.setId(Integer.parseInt(rs.getString("id")));
				ch.setSid(rs.getString("sid"));
				ch.setSname(rs.getString("sname"));
				ch.setHobby(rs.getString("hobby"));
				ch.setBegin_time(rs.getString("begin_time"));
				ch.setEnd_time(rs.getString("end_time"));
				ch.setHobby_description(rs.getString("hobby_description"));
				list.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlConnectionUtils.free(conn, sp, rs);
		}
		hobbyList ck = new hobbyList();
		ck.setRecordsTotal(recordsTotal);
		ck.setData(list);
		return ck;
	}
}
