/**
 * 
 */
package com.base.Service;

import java.util.List;

import com.base.Po.project_work;
import com.base.Po.workList;



/**
 * @author 鸡毛大大
 *
 */
public interface ProjectWorkService {

	public workList projectwork(int pageindex, int size,int order,String orderDir,String searchValue);

	public int increaseWorkInfo(String groupName, String projectName,
			String projectIntroduce, String projectAddress,
			 String photoAddress, String workCategory,
			String express, String bestWork);

	public String delInfo(String str);

	public String updateWorkInfo(int pid,String gid, String projectName,
			String workCategory, String expression, String bestWork,
			String projectIntroduce);

	public List<project_work> getWork(); 

  
  
}
