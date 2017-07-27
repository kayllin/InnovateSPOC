package com.base.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.Service.HobbysService;

@Controller("HobbysController")
@RequestMapping("/jsp")
public class HobbysController {

	@Autowired
	private HobbysService hobbysService;
	
	@RequestMapping("query_hobbys.do")
	public String query_hobbys(){
		return null;
	}
}
