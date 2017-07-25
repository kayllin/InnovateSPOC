package com.base.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.hibernate.hql.internal.ast.tree.IntoClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.base.Po.employList;
import com.base.Service.EmploymentManageService;
 


@Controller("EmploymentManageController")
@RequestMapping("/jsp")
//就业信息管理控制层
public class EmploymentManageController {
		@Autowired
	  private EmploymentManageService employmentmanageservice;
	
	  
	 //获取就业数据信息
	@RequestMapping("/sendEmployinfo.do")
	 public String sendEmployinfo(HttpServletRequest request,
			    HttpServletResponse response, ModelMap map) {
					
		Integer size = Integer.parseInt(request.getParameter("length"));
		Integer startIndex = Integer.parseInt(request.getParameter("start"));
		Integer draw = Integer.parseInt(request.getParameter("draw"));
		int order = Integer.valueOf(request.getParameter("order[0][column]"));
		String orderDir = request.getParameter("order[0][dir]");
		String searchValue = request.getParameter("search[value]");
		if (searchValue.equals("")) {
		    searchValue = null;
		}
		Integer pageindex = (startIndex / size + 1);
		employList str =  new employList();
		str = null;
		str = employmentmanageservice.employment(pageindex, size, order, orderDir,searchValue);
		JSONObject getObj = new JSONObject();
		getObj.put("draw", draw);
		getObj.put("recordsFiltered", str.getRecordsTotal());
		getObj.put("recordsTotal", str.getRecordsTotal());
		getObj.put("data", str.getData());
		response.setContentType("text/html;charset=UTF-8");

		try {
		    response.getWriter().print(getObj.toString());
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		
		
		return null;
		
		
	}
	
	// 增加就业信息记录
    @RequestMapping("/increaseEmpInfo.do")
    public String increaseEmpInfo(HttpServletRequest request,
    	    HttpServletResponse response, ModelMap map) {
    	/*Cookie[] cookies = request.getCookies();// 获得所有cookie对象
    	for (Cookie co : cookies) {
    	    if (co.getName().equals("username")) {
    		String userid = co.getValue();*/

    		/*------参数2-----------*/
    		String str2 = "";
    		String stuName = request.getParameter("stuName");// 学生id
    		String companyName = request.getParameter("companyName");// 所在公司
    		String wage = request.getParameter("wage");// 年薪
    		String work = request.getParameter("work");// 从事工作
    		String graduateYear = request.getParameter("graduateYear");// 毕业年份
    		 

    		str2 += "('" + stuName + "','" + companyName + "'," + wage + ",'"
    			+ work + "'," + graduateYear +  ")";

    		String message=employmentmanageservice.increaseEmpInfo(str2);
    		request.setAttribute("index", message);
    		String str=(String) request.getAttribute("index");
    		response.setContentType("text/html;charset=UTF-8");
    	/*    }
    	}*/
    	return "employmentManage";
        }
    
    //删除就业信息记录(批量)
    @RequestMapping("/delEmpinfo.do")
    public String delBaseinfo(HttpServletRequest request,
	    HttpServletResponse response, ModelMap map) {
	String str = request.getParameter("recordstr");

	String message=employmentmanageservice.delInfo(str);
	if(message.equals("success")){
	    message="操作成功";
	}else if(message.equals("fail")){
	    message="操作失败";
	}
	JSONObject getObj = new JSONObject();
	getObj.put("flag", message);

	response.setContentType("text/html;charset=UTF-8");

	try {
	    response.getWriter().print(getObj.toString());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }
    
 // 修改实习基地信息
    @RequestMapping("/updateBaseInfo.do")
    public String updateBaseInfo(HttpServletRequest request,
	    HttpServletResponse response, ModelMap map) {
	String sid = request.getParameter("sid");
	String company=request.getParameter("company");
	if(company.equals("")){
		company=null;
	}
	String salary=  request.getParameter("salary");
	if(salary.equals("")){
		salary=null;
	}
	String workin =request.getParameter("workin");
	if(workin.equals("")){
		workin=null;
	}
	String graduationYear =request.getParameter("graduationYear");
	if(graduationYear.equals("")){
		graduationYear=null;
	}
	int excellence =Integer.valueOf(request.getParameter("excellence"));

	String message=employmentmanageservice.updateEmpInfo(sid,company,salary,workin,graduationYear,excellence);
	if(message=="success"){
	    message="操作成功";
	}else if(message=="fail"){
	    message="操作失败";
	}
	JSONObject getObj = new JSONObject();
	getObj.put("flag", message);

	response.setContentType("text/html;charset=UTF-8");

	try {
	    response.getWriter().print(getObj.toString());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }
}
