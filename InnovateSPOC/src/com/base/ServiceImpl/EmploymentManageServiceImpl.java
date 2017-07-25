/**
 * 
 */
package com.base.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.Dao.EmploymentManageDao;
import com.base.Po.employList;
import com.base.Service.EmploymentManageService;

@Service("EmploymentManageService")

/**
 * @author 鸡毛大大
 *
 */

public class EmploymentManageServiceImpl implements EmploymentManageService {
	@Autowired
	private EmploymentManageDao employmentdao;
	
	@Override
	public employList employment(int pageindex, int size, int order,
			String orderDir, String searchValue ) {
		String columnName = "";
		if(order == 0){
			columnName = "id";
		}else if (order == 1) {
		    columnName = "sid";
		} else if (order == 2) {
		    columnName = "company";
		} else if (order == 3) {
		    columnName = "workin";
		} else if (order == 4) {
		    columnName = "graduation_year";
		}
		employList list =  employmentdao.employment(pageindex, size,columnName,orderDir,searchValue );
		
		return list;
	}
	//增加就业管理信息
	@Override
	public String increaseEmpInfo(String str2) {
		// TODO Auto-generated method stub
		String message = employmentdao.increaseEmpInfo(str2);
		return message;
	}
	//删除就业管理信息
	@Override
	public String delInfo(String str) {		
		String message=employmentdao.delInfo(str);
		return message;
	
	}
	@Override
	public String updateEmpInfo(String sid, String company, String salary,
			String workin, String graduationYear, int excellence) {
		// TODO Auto-generated method stub
		String message = employmentdao.updateEmpInfo(sid,company,salary,workin,graduationYear,excellence);
		return message;
	}
}
