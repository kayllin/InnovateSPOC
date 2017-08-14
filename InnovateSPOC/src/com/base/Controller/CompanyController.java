package com.base.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.base.Po.Company;
import com.base.Po.CompanyList;
import com.base.Po.studentList;
import com.base.Po.students;
import com.base.Service.CompanyService;

@Controller("CompanyController")
@RequestMapping("/jsp")
public class CompanyController {
	
	private CompanyService companyservice;
	
	//增加
	@RequestMapping("/addCompant.do")
	public String addCompant(HttpServletRequest request,
		    HttpServletResponse response, HttpSession session){
		
		String title=request.getParameter("title");
		String photo=request.getParameter("photo");
		
		int flag=companyservice.addCompany(title, photo);
		request.setAttribute("flag", flag);
		return "communication_company";
	}
	
	//查看
	@RequestMapping("/quertCompany.do")
	public String quertCompany(HttpServletRequest request,
		    HttpServletResponse response) {
		String searchValue = request.getParameter("search[value]");
		if (searchValue.equals("")) {
		    searchValue = null;
		}
		// 获取当前页面的传输几条记录
		Integer size = Integer.parseInt(request.getParameter("length"));
		// 数据起始位置
		Integer startIndex = Integer.parseInt(request.getParameter("start"));
		Integer draw = Integer.parseInt(request.getParameter("draw"));
//		int order = Integer.valueOf(request.getParameter("order[0][column]"));// 排序的列号
		int order = 1;
		// String orderDir = request.getParameter("order[0][dir]");//
		// 排序的顺序asc or
		String orderDir = "desc"; // // desc
		// 通过计算求出当前页面为第几页
		Integer pageindex = (startIndex / size + 1);
		int recordsTotal = 0;
		List<Company> list = new ArrayList<Company>();
		CompanyList pr = null;
		pr = companyservice.query_company(size, pageindex, order, orderDir, searchValue);
		list = pr.getData();
		recordsTotal = pr.getRecordsTotal();
		JSONObject getObj = new JSONObject();
		getObj.put("draw", draw);
		getObj.put("recordsFiltered", recordsTotal);
		getObj.put("recordsTotal", recordsTotal);
		getObj.put("data", list);
		response.setContentType("text/html;charset=UTF-8");
		try {
		    response.getWriter().print(getObj.toString());
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		return null;
	}
	
	//删除
	@RequestMapping("/delCompany.do")
	public String delCompany(HttpServletRequest request,
			HttpServletResponse response) {
		String str = request.getParameter("deletstr");
		String message = companyservice.deleteCompany(str);
		if (message.equals("success")) {
			message = "操作成功";
		} else if (message.equals("fail")) {
			message = "操作失败";
		}
		JSONObject getObj = new JSONObject();
		getObj.put("str", message);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(getObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/updateCompany.do")
	public String updateCompany(HttpServletRequest request,
			HttpServletResponse response){
		String title = request.getParameter("title");
		String photo = request.getParameter("photo");
		companyservice.updateCompany(title, photo);
		return "communication_company";
	}
}
