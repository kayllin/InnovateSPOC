package com.base.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.base.Dao.EmploymentManageDao;
import com.base.Po.employList;
import com.base.Po.employment;
import com.base.utils.BaseUtils;
import com.base.utils.SqlConnectionUtils;

@Repository("EmploymentManageDao")

public class EmploymentManageDaoImpl implements EmploymentManageDao {

	@Autowired
	    private SessionFactory sessionFactory;
	
	@Override
	public employList employment(int pageindex, int size, String columnName,
			String orderDir, String searchValue ) {
		
		employList  el = new employList();
		List<employment> list = new ArrayList<employment>();
		int recordsTotal = 0;
		Connection conn = null;
		CallableStatement sp = null;
		ResultSet rs = null;
		 try {
			conn = (Connection) SessionFactoryUtils.getDataSource(
					    sessionFactory).getConnection();
			 sp = (CallableStatement) conn
					    .prepareCall("{CALL innovatespoc.query_employment(?,?,?,?,?,?)}");
			 
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
			    employment ch = new employment();
			    ch.setId(rs.getInt("id"));
			    ch.setSid(rs.getString("sid"));
			    ch.setCompany(rs.getString("company"));
			    ch.setSalary(rs.getString("salary"));
			    ch.setWorkin(rs.getString("workin"));
			    ch.setGraduation_year(rs.getString("graduation_year"));
			    ch.setExcellence(rs.getString("excellence"));
			    list.add(ch);
			    }
			    System.out.println(list+"+aaaaaaaaaaaa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    SqlConnectionUtils.free(conn, sp, rs);
		}
		 el.setRecordsTotal(recordsTotal);
		 el.setData(list);
		 System.out.println(el+"+bbbbbbbbbbbbbbbbbb");
		return el;
	}
	
	// 向就业表employment中插入一条数据
	  public String increaseEmpInfo(String str2) {
		
		int flag;
		String message=null;
		Connection conn = null;
		CallableStatement sp = null;
		try {
		    conn = (Connection) SessionFactoryUtils.getDataSource(
			    sessionFactory).getConnection();
		    sp = (CallableStatement) conn
			    .prepareCall("{call baseweb.add_base(?,?)}");//待写
		    sp.setString(1, str2);	  
		    sp.execute();
		    flag=sp.getInt(2);	 
		    message=BaseUtils.getException(flag);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
		    SqlConnectionUtils.free(conn, sp, null);
		}
		return message;

	    }
	  
	  //实习基地维护中删除
	    @Override
	    public String delInfo(String str) {
		int flag;
		String message=null;
		Connection conn = null;
		CallableStatement sp = null;
		ResultSet rs = null;
		try {
		    conn = (Connection) SessionFactoryUtils.getDataSource(
			    sessionFactory).getConnection();
		    sp = (CallableStatement) conn
			    .prepareCall("{call baseweb.`delete_prabaseinfo`(?,?)}");//待写
		    sp.setString(1, str);
		    sp.execute();
		    flag=sp.getInt(2);
		    message=BaseUtils.getException(flag);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
		    SqlConnectionUtils.free(conn, sp, rs);
		}
		return message;

	    }
	    
	  //实习基地维护中修改
		@Override
		public String updateEmpInfo(String sid, String company, String salary,
				String workin, String graduationYear, int excellence) {
			int flag;
			
			String message=null;
			Connection conn = null;
			CallableStatement sp = null;
			try {
			    conn = (Connection) SessionFactoryUtils.getDataSource(
				    sessionFactory).getConnection();
			    sp = (CallableStatement) conn.prepareCall("{CALL innovatespoc.query_employment(?,?,?,?,?,?,?)}");//待写
			    sp.setString(1, sid);
			    sp.setString(2, company);
			    sp.setString(3, salary);
			    sp.setString(4, workin);
			    sp.setString(5, graduationYear);
			    sp.setInt(6, excellence);
			    
			    sp.execute();
			    flag=sp.getInt(7);
			    message=BaseUtils.getException(flag);
			} catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} finally {
			    SqlConnectionUtils.free(conn, sp, null);
			}
			return message;
		}
		
		
	}
	
	
		

