package com.base.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.Service.SkillStudentService;

@Controller("SkillStudentController")
@RequestMapping("/jsp")
public class SkillStudentController {

	@Autowired
	private SkillStudentService skillStudentService;
	
	@RequestMapping("query_skillstudent.do")
	public String query_skillstudent(){
		return null;
	}
}
