package com.base.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.Dao.HobbysDao;

@Repository("HobbysDao")
public class HobbysDaoImpl implements HobbysDao{

	@Autowired
	private SessionFactory sessionFactory;
}
