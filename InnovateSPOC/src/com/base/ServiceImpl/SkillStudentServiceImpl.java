package com.base.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.Dao.SkillStudentDao;
import com.base.Service.SkillStudentService;

@Service("SkillStudentService")
public class SkillStudentServiceImpl implements SkillStudentService{

	@Autowired
	private SkillStudentDao skillStudentdao;
}
