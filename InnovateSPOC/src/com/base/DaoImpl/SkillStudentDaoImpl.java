package com.base.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.Dao.SkillStudentDao;

@Repository("SkillStudentDao")
public class SkillStudentDaoImpl implements SkillStudentDao{

	@Autowired
	private SessionFactory sessionFactory;
}
