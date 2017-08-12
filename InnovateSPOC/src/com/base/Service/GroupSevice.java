package com.base.Service;

import com.base.Po.Group_list;

public interface GroupSevice {
	
	public Group_list query_group(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue);
	
	public void updataGroup(String sid,String sname,int gid,String gname);
}
