package com.base.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.Po.studentList;
import com.base.Po.students;
import com.base.Service.StudentService;

@Controller("StudentmanageController")
@RequestMapping("/jsp")
public class StudentmanageController {

	@Autowired
    private StudentService studentService;
	
	//增加学生信息
		@RequestMapping("/addstudent.do")
		public String addstudent(HttpServletRequest request,
			    HttpServletResponse response, HttpSession session){
			String studentId = request.getParameter("studentId");
			String studentName = request.getParameter("studentName");
			String sex = request.getParameter("sex");
			String Areason = request.getParameter("Areason");
			String password = request.getParameter("password");
			String Caddress = request.getParameter("Caddress");
			String Eaddress = request.getParameter("Eaddress");
			String telephone = request.getParameter("telephone");
			String qq = request.getParameter("qq");
			String EnrollmentYear = request.getParameter("EnrollmentYear");
			String major = request.getParameter("major");
			String gra = request.getParameter("gra");
			String emp = request.getParameter("emp");			
//			String photo = request.getParameter("file");
			int flag = studentService.addStudent(studentId,studentName,sex,Areason,password,Caddress,Eaddress,telephone,qq,EnrollmentYear,major,gra,emp);
			request.setAttribute("flag", flag);
			return "studentManage";
		}
		
		// 展示学生信息
	    @RequestMapping("/query_student.do")
	    public String query_student(HttpServletRequest request,
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
		List<students> list = new ArrayList<students>();
		studentList pr = null;
		pr = studentService.query_student(size, pageindex, order,
			orderDir, searchValue);
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
		
	// 删除学生
	@RequestMapping("/delstudent.do")
	public String deleteStudent(HttpServletRequest request,
			HttpServletResponse response) {
		String str = request.getParameter("deletstr");
		String message = studentService.deleteStudent(str);
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

	//修改学生信息
	@RequestMapping("updatestudent.do")
	public String updateStudent(HttpServletRequest request,
			HttpServletResponse response){
		String sid = request.getParameter("sid");
		String Sintroduce = request.getParameter("Sintroduce");
		String chinese_address = request.getParameter("chinese_address");
		String english_address = request.getParameter("english_address");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String smajor = request.getParameter("smajor");
		studentService.updateStudent(sid, Sintroduce, chinese_address, english_address, phone, qq, smajor);
		return "studentManage";
		
	}
	
}
