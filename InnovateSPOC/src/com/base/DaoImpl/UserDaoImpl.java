package com.base.DaoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.Dao.UserDao;
import com.base.Po.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean login(String username, String password) {
	Session session = sessionFactory.openSession();
	String hql = "from User where username=? and password=?";
	boolean flag = false;

	try {
	    Query query = session.createQuery(hql);
	    query.setString(0, username);
	    query.setString(1, password);
	    User ui = (User) query.uniqueResult();
	    if (ui != null) {
		flag = true;
	    }

	} catch (Exception e) {
	    System.out.println(e);
	} finally {
	    session.close();
	}
	return flag;
    }

}
